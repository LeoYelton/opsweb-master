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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.model.FeedBackTask;
import com.opentpi.qa.feedback.service.FeedBackTaskService;
import com.opentpi.qa.feedback.service.RecordService;

@Controller
public class FeedBackTaskController {

	private static final Logger log = LoggerFactory.getLogger(FeedBackTaskController.class);
	
	@Autowired
	private FeedBackTaskService feedBackTaskService;
	
	@Autowired
	private RecordService recordService;
	
	/**
	 * @description 新增
	 * @author Abruzzi
	 * @param FeedBackTask record
	 * @return Map<String, Object>
	 */
	@RequestMapping("/feedBackTask/addFeedBackTask")
	@ResponseBody
    public Map<String, Object> addFeedBackTask(@ModelAttribute FeedBackTask record){
    	Map<String,Object> resMap = new HashMap<>();
		try {
			String rm = feedBackTaskService.addFeedBackTask(record);
			//任务新增成功
			if (rm.equals("success")) {
				recordService.createRecordByTask(record);
			}
			resMap.put("result", rm);
		} catch (Exception e) {
			
			resMap.put("result",e.getMessage());
		}
		return resMap; 
    }
    
    /**
	 * @description 修改
	 * @author Abruzzi
	 * @param FeedBackTask record
	 * @return Map<String, Object>
	 */
    @RequestMapping("/feedBackTask/updateFeedBackTask")
	@ResponseBody
    public Map<String, Object> updateFeedBackTask(@ModelAttribute FeedBackTask record){
    	Map<String,Object> resMap = new HashMap<>();
		try {
			String rm = feedBackTaskService.updateFeedBackTask(record);
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
    @RequestMapping("/feedBackTask/getFeedBackTask")
	@ResponseBody
    public Map<String, Object> getFeedBackTask(int id){
    	Map<String,Object> resMap = new HashMap<String,Object>();
    	FeedBackTask record = feedBackTaskService.getFeedBackTask(id);
    	resMap.put("rows", record);
	    return resMap;
    }
    
    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param FeedBackTask record
	 * @return Map<String, Object>
	 */
    @RequestMapping("/feedBackTask/listByParam")
	@ResponseBody
    public Map<String, Object> listByParam(@RequestParam Map<String, Object> params){
    	Map<String,Object> resMap = new HashMap<>();
		PageInfo<FeedBackTask> dataList = feedBackTaskService.listByParam(params); 
		resMap.put("total", dataList.getTotal());
		resMap.put("rows", dataList.getList());
	    return resMap;
    }
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Task>
	 */
    @RequestMapping("/feedBackTask/listByMap")
	@ResponseBody
    public Map<String, Object> listByMap(@RequestParam Map<String, Object> params){
    	Map<String,Object> resMap = new HashMap<>();
    	List<FeedBackTask> list = feedBackTaskService.listByMap(params);
    	resMap.put("rows", list);
	    return resMap;
    }
    
    /**
	 * @description 上传文件
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Task>
	 */
    @RequestMapping("/feedBackTask/uploadFile")
	@ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("file") CommonsMultipartFile file,
    		@RequestParam String fileType, @ModelAttribute FeedBackTask feedBackTask){
    	Map<String,Object> resMap = new HashMap<>();
    	String fileJson = feedBackTaskService.fileUpload(file, fileType, feedBackTask);
    	resMap.put("fileJson", fileJson);
	    return resMap;
    }
}
