package com.opentpi.qa.feedback.dao;

import java.util.List;
import java.util.Map;

import com.opentpi.qa.feedback.model.Branch;

public interface BranchMapper {

	/**
	 * @description 删除
	 * @author Abruzzi 
	 */
	int delBranch(int id);
	
	/**
	 * @description 新增
	 * @author Abruzzi 
	 */
    int addBranch(Branch record);
    
    /**
	 * @description 修改
	 * @author Abruzzi 
	 */
    int updateBranch(Branch record);
    
    /**
	 * @description 根据主键查询
	 * @author Abruzzi 
	 */
    Branch getBranch(int id);

    /**
	 * @description 根据条件查询
	 * @author Abruzzi 
	 */
    List<Branch> listByParam(Map<String, Object> params);
    
    /**
     * @description 分支机构登陆
     * @author Abruzzi
     */
    Branch login(Map<String, Object> params);
}
