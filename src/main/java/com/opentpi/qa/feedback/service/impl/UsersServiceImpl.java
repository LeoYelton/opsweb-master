package com.opentpi.qa.feedback.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.dao.UsersMapper;
import com.opentpi.qa.feedback.model.Users;
import com.opentpi.qa.feedback.service.UsersService;
import com.opentpi.util.MapUtil;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;
	
	/**
	 * @description 删除
	 * @author Abruzzi
	 * @param ids
	 * @return String
	 */
	@Override
	public String delUsers(int[] ids, String serNo) throws Exception {
		try {
			int count = 0;
			for (int i = 0; i < ids.length; i++) {
				count += usersMapper.delUsers(ids[i]);
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
	 * @param Users
	 * @return String
	 */
    @Override
    public String addUsers(Users record) throws Exception {
    	try {
			Integer i = usersMapper.addUsers(record);
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
	 * @param Users
	 * @return String
	 */
    @Override
    public String updateUsers(Users record) throws Exception {
	    try {
	    	Integer i = usersMapper.updateUsers(record);
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
	 * @return Users
	 */
    @Override
    public Users getUsers(int id){
    	return usersMapper.getUsers(id);
    }

    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return PageInfo<Users>
	 */
    @Override
    public PageInfo<Users> listByParam(Map<String, Object> params){
    	PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("pageSize").toString()));
    	List<Users> list = usersMapper.listByParam(params);
    	return new PageInfo<>(list);
    }
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Users>
	 */
    @Override
    public List<Users> listByMap(Map<String, Object> params){
    	List<Users> list = usersMapper.listByParam(params);
    	return list;
    }
    
    /**
	 * @description 管理员登录
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return Users
	 */
    @Override
    public Users userLogin(Map<String, Object> params) {
    	//参数安全处理
    	String userName = MapUtil.getMapString(params, "userName");
    	String password = MapUtil.getMapString(params, "password");
    	//安全封装登陆查询
    	Map<String, Object> query = new HashMap<>();
    	query.put("userName", userName);
    	query.put("password", password);
    	Users users = usersMapper.login(query);
    	return users;
    }
}
