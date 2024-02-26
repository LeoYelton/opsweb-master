package com.opentpi.qa.feedback.service;

import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.model.FeedBackTask;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface FeedBackTaskService {
	
	/**
	 * @description 新增
	 * @author Abruzzi
	 * @param FeedBackTask
	 * @return String
	 */
    String addFeedBackTask(FeedBackTask record) throws Exception;
    
    /**
	 * @description 修改
	 * @author Abruzzi
	 * @param FeedBackTask
	 * @return String
	 */
    String updateFeedBackTask(FeedBackTask record) throws Exception;
    
    /**
	 * @description 根据主键查询
	 * @author Abruzzi
	 * @param id
	 * @return Task
	 */
    FeedBackTask getFeedBackTask(int id);

    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param FeedBackTask
	 * @return PageInfo<Task>
	 */
    PageInfo<FeedBackTask> listByParam(Map<String, Object> params);
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Task>
	 */
    List<FeedBackTask> listByMap(Map<String, Object> params);

    /**
	 * @description 上传文件
	 * @param files data
	 * @return Map<String,Object>
	 * @throws IOException 
	 */
	String fileUpload(CommonsMultipartFile file, String fileType, FeedBackTask feedBackTask);

}
