package com.opentpi.qa.feedback.service;

import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.model.Branch;

import java.util.List;
import java.util.Map;

public interface BranchService {
	
    /**
	 * @description 根据主键查询
	 * @author Abruzzi
	 * @param id
	 * @return Branch
	 */
    Branch getBranch(int id);

    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param Branch
	 * @return PageInfo<Branch>
	 */
    PageInfo<Branch> listByParam(Map<String, Object> params);
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Branch>
	 */
    List<Branch> listByMap(Map<String, Object> params);

    /**
	 * @description 分支机构登录
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return Users
	 */
	Branch userLogin(Map<String, Object> params);

}
