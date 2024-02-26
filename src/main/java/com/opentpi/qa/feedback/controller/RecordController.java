package com.opentpi.qa.feedback.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.model.Record;
import com.opentpi.qa.feedback.service.RecordService;


@Controller
public class RecordController {

	private static final Logger log = LoggerFactory.getLogger(RecordController.class);
	
	@Autowired
	private RecordService recordService;
	
	/**
	 * @description 删除
	 * @author Abruzzi
	 * @param String[] dataIds
	 * @return Map<String, Object>
	 */
	@RequestMapping("/record/delRecord")
	@ResponseBody
	public Map<String, Object> delRecord(@RequestParam Map<String, Object> params){
		Map<String,Object> resMap = new HashMap<>();
		try {
			String serNo = params.get("serNo").toString();
			String[] dataIdsStr = params.get("dataIds").toString().split(",");
			int[] dataIds = new int[dataIdsStr.length];
			for (int i = 0; i < dataIdsStr.length; i++) {
				dataIds[i] = Integer.parseInt(dataIdsStr[i]);
			}
			String rm = recordService.delRecord(dataIds, serNo);
			resMap.put("result", rm);
		} catch (Exception e) {
			log.error("删除失败，ID为："+params.get("dataIds"),e);
			resMap.put("result",e.getMessage());
		}
		return resMap; 
	}
	
	/**
	 * @description 新增
	 * @author Abruzzi
	 * @param Record record
	 * @return Map<String, Object>
	 */
	@RequestMapping("/record/addRecord")
	@ResponseBody
    public Map<String, Object> addRecord(@ModelAttribute Record record){
    	Map<String,Object> resMap = new HashMap<>();
		try {
			String rm = recordService.addRecord(record);
			resMap.put("result", rm);
		} catch (Exception e) {
		
			resMap.put("result",e.getMessage());
		}
		return resMap; 
    }
    
    /**
	 * @description 修改
	 * @author Abruzzi
	 * @param Record record
	 * @return Map<String, Object>
	 */
    @RequestMapping("/record/updateRecord")
	@ResponseBody
    public Map<String, Object> updateRecord(@ModelAttribute Record record){
    	Map<String,Object> resMap = new HashMap<>();
		try {
			String rm = recordService.updateRecord(record);
			resMap.put("result", rm);
		} catch (Exception e) {
			
			resMap.put("result",e.getMessage());
		}
		return resMap;
    }
    
    /**
	 * @description 根据主键查询
	 * @author Abruzzi
	 * @param id
	 * @return Map<String, Object>
	 */
    @RequestMapping("/record/getRecord")
	@ResponseBody
    public Map<String, Object> getRecord(int id){
    	Map<String,Object> resMap = new HashMap<String,Object>();
    	Record record = recordService.getRecord(id);
    	resMap.put("rows", record);
	    return resMap;
    }
    
    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param Record record
	 * @return Map<String, Object>
	 */
    @RequestMapping("/record/listByParam")
	@ResponseBody
    public Map<String, Object> listByParam(@RequestParam Map<String, Object> params){
    	Map<String,Object> resMap = new HashMap<>();
		PageInfo<Record> dataList = recordService.listByParam(params); 
		resMap.put("total", dataList.getTotal());
		resMap.put("rows", dataList.getList());
	    return resMap;
    }
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Record>
	 */
    @RequestMapping("/record/listByMap")
	@ResponseBody
    public Map<String, Object> listByMap(@RequestParam Map<String, Object> params){
    	Map<String,Object> resMap = new HashMap<>();
    	List<Record> list = recordService.listByMap(params);
    	resMap.put("rows", list);
	    return resMap;
    }
}
