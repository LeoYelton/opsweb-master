package com.opentpi.qa.feedback.service;

import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.model.Users;

import java.util.List;
import java.util.Map;


public interface UsersService {
	
	/**
	 * @description 删除
	 * @author Abruzzi
	 * @param ids
	 * @return String
	 */
	String delUsers(int[] ids, String serNo) throws Exception;
	
	/**
	 * @description 新增
	 * @author Abruzzi
	 * @param Users
	 * @return String
	 */
    String addUsers(Users record) throws Exception;
    
    /**
	 * @description 修改
	 * @author Abruzzi
	 * @param Users
	 * @return String
	 */
    String updateUsers(Users record) throws Exception;
    
    /**
	 * @description 根据主键查询
	 * @author Abruzzi
	 * @param id
	 * @return Users
	 */
    Users getUsers(int id);

    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param Users
	 * @return PageInfo<Users>
	 */
    PageInfo<Users> listByParam(Map<String, Object> params);
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Users>
	 */
    List<Users> listByMap(Map<String, Object> params);

    /**
	 * @description 管理员登录
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return Users
	 */
	Users userLogin(Map<String, Object> params);

}
