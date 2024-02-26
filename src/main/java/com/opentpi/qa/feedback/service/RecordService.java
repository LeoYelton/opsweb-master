package com.opentpi.qa.feedback.service;

import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.model.FeedBackTask;
import com.opentpi.qa.feedback.model.Record;

import java.util.List;
import java.util.Map;


public interface RecordService {
	
	/**
	 * @description 删除
	 * @author Abruzzi
	 * @param ids
	 * @return String
	 */
	String delRecord(int[] ids, String serNo) throws Exception;
	
	/**
	 * @description 新增
	 * @author Abruzzi
	 * @param Record
	 * @return String
	 */
    String addRecord(Record record) throws Exception;
    
    /**
	 * @description 修改
	 * @author Abruzzi
	 * @param Record
	 * @return String
	 */
    String updateRecord(Record record) throws Exception;
    
    /**
	 * @description 根据主键查询
	 * @author Abruzzi
	 * @param id
	 * @return Record
	 */
    Record getRecord(int id);

    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param Record
	 * @return PageInfo<Record>
	 */
    PageInfo<Record> listByParam(Map<String, Object> params);
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Record>
	 */
    List<Record> listByMap(Map<String, Object> params);

    /**
	 * @description 根据任务创建对应的填报记录
	 * @author Abruzzi
	 * @param FeedBackTask
	 * @return String
	 */
	String createRecordByTask(FeedBackTask feedBackTask);
    
}
