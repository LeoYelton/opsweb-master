package com.opentpi.qa.feedback.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.dao.BranchMapper;
import com.opentpi.qa.feedback.dao.RecordMapper;
import com.opentpi.qa.feedback.model.Branch;
import com.opentpi.qa.feedback.model.FeedBackTask;
import com.opentpi.qa.feedback.model.Record;
import com.opentpi.qa.feedback.service.RecordService;
import com.opentpi.util.DateUtil;


@Service("recordService")
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordMapper recordMapper;
	@Autowired
	private BranchMapper branchMapper;

	/**
	 * @description 删除
	 * @author Abruzzi
	 * @param ids
	 * @return String
	 */
	@Override
	public String delRecord(int[] ids, String serNo) throws Exception {
		try {
			int count = 0;
			for (int i = 0; i < ids.length; i++) {
				count += recordMapper.delRecord(ids[i]);
			}
			if(ids.length == count){
				return "success";
			}else {
				return "删除失败！";
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/**
	 * @description 新增
	 * @author Abruzzi
	 * @param Record
	 * @return String
	 */
    @Override
    public String addRecord(Record record) throws Exception {
    	try {
			Integer i = recordMapper.addRecord(record);
			if (i > 0) {
				return "success";
			}else {
				return "新增失败！";
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
    }
    
    /**
	 * @description 修改
	 * @author Abruzzi
	 * @param Record
	 * @return String
	 */
    @Override
    public String updateRecord(Record record) throws Exception {
	    try {
	    	Integer i = recordMapper.updateRecord(record);
	    	if (i > 0) {
				return "success";
			}else {
				return "修改失败！";
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
    }
    
    /**
	 * @description 根据主键查询
	 * @author Abruzzi
	 * @param id
	 * @return Record
	 */
    @Override
    public Record getRecord(int id){
    	return recordMapper.getRecord(id);
    }

    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return PageInfo<Record>
	 */
    @Override
    public PageInfo<Record> listByParam(Map<String, Object> params){
    	PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("pageSize").toString()));
    	List<Record> list = recordMapper.listByParam(params);
    	return new PageInfo<>(list);
    }
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Record>
	 */
    @Override
    public List<Record> listByMap(Map<String, Object> params){
    	List<Record> list = recordMapper.listByParam(params);
    	return list;
    }
    
    /**
	 * @description 根据任务创建对应的填报记录
	 * @author Abruzzi
	 * @param FeedBackTask
	 * @return String
	 */
    @Override
    public String createRecordByTask(FeedBackTask feedBackTask) {
    	//新增任务的同时，给参与机构添加需要填报的任务
		String joinBranch = feedBackTask.getJoinBranch();
		String[] joinBranchArr = null;
		if (joinBranch != null && !joinBranch.isEmpty()) {
			joinBranchArr = joinBranch.split(",");
		}
		for (String branchId : joinBranchArr) {
			//根据营业部ID查询分支机构信息
			Branch branch = branchMapper.getBranch(Integer.parseInt(branchId));
			Record record = new Record();
			record.setBranchId(branch.getBranchNo());//分支机构ID
			record.setTaskId(feedBackTask.getDataId());//关联任务ID
			record.setTaskState(0);//未开始
			record.setCreateTime(DateUtil.getCurrentDateAll());//创建时间
			recordMapper.addRecord(record);
		}
		return "success";
    }
}
