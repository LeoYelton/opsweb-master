package com.opentpi.qa.feedback.dao;

import java.util.List;
import java.util.Map;

import com.opentpi.qa.feedback.model.Record;


public interface RecordMapper {

	/**
	 * @description 删除
	 * @author Abruzzi 
	 */
	int delRecord(int id);
	
	/**
	 * @description 新增
	 * @author Abruzzi 
	 */
    int addRecord(Record record);
    
    /**
	 * @description 修改
	 * @author Abruzzi 
	 */
    int updateRecord(Record record);
    
    /**
	 * @description 根据主键查询
	 * @author Abruzzi 
	 */
    Record getRecord(int id);

    /**
	 * @description 根据条件查询
	 * @author Abruzzi 
	 */
    List<Record> listByParam(Map<String, Object> params);
    
}
