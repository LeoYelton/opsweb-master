package com.opentpi.qa.feedback.dao;

import java.util.List;
import java.util.Map;

import com.opentpi.qa.feedback.model.FeedBackTask;


public interface FeedBackTaskMapper {

	/**
	 * @description 删除
	 * @author Abruzzi 
	 */
	int delFeedBackTask(int id);
	
	/**
	 * @description 新增
	 * @author Abruzzi 
	 */
    int addFeedBackTask(FeedBackTask record);
    
    /**
	 * @description 修改
	 * @author Abruzzi 
	 */
    int updateFeedBackTask(FeedBackTask record);
    
    /**
	 * @description 根据主键查询
	 * @author Abruzzi 
	 */
    FeedBackTask getFeedBackTask(int id);

    /**
	 * @description 根据条件查询
	 * @author Abruzzi 
	 */
    List<FeedBackTask> listByParam(Map<String, Object> params);
    
}
