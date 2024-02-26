package com.opentpi.qa.feedback.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.model.Users;
import com.opentpi.qa.feedback.service.UsersService;
import com.opentpi.util.TokenUtil;

@Controller
public class UsersController {

	private static final Logger log = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private UsersService usersService;
	
	
	
	/**
	 * @description 新增
	 * @author Abruzzi
	 * @param Users record
	 * @return Map<String, Object>
	 */
	@RequestMapping("/users/addUsers")
	@ResponseBody
    public Map<String, Object> addUsers(@ModelAttribute Users record){
    	Map<String,Object> resMap = new HashMap<>();
		try {
			String rm = usersService.addUsers(record);
			resMap.put("result", rm);
		} catch (Exception e) {
			
			resMap.put("result",e.getMessage());
		}
		return resMap; 
    }
    
    /**
	 * @description 修改
	 * @author Abruzzi
	 * @param Users record
	 * @return Map<String, Object>
	 */
    @RequestMapping("/users/updateUsers")
	@ResponseBody
    public Map<String, Object> updateUsers(@ModelAttribute Users record){
    	Map<String,Object> resMap = new HashMap<>();
		try {
			String rm = usersService.updateUsers(record);
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
    @RequestMapping("/users/getUsers")
	@ResponseBody
    public Map<String, Object> getUsers(int id){
    	Map<String,Object> resMap = new HashMap<String,Object>();
    	Users record = usersService.getUsers(id);
    	resMap.put("rows", record);
	    return resMap;
    }
    
    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param Users record
	 * @return Map<String, Object>
	 */
    @RequestMapping("/users/listByParam")
	@ResponseBody
    public Map<String, Object> listByParam(@RequestParam Map<String, Object> params){
    	Map<String,Object> resMap = new HashMap<>();
		PageInfo<Users> dataList = usersService.listByParam(params); 
		resMap.put("total", dataList.getTotal());
		resMap.put("rows", dataList.getList());
	    return resMap;
    }
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Users>
	 */
    @RequestMapping("/users/listByMap")
	@ResponseBody
    public Map<String, Object> listByMap(@RequestParam Map<String, Object> params){
    	Map<String,Object> resMap = new HashMap<>();
    	List<Users> list = usersService.listByMap(params);
    	resMap.put("rows", list);
	    return resMap;
    }
    
    /**
	 * @description 管理系统用户登录
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Users>
	 */
    @PostMapping("/users/userLogin")
	@ResponseBody
    public Map<String, Object> userLogin(@RequestParam Map<String, Object> params, 
    		HttpServletRequest request, HttpServletResponse response){
    	Map<String,Object> resMap = new HashMap<>();
    	//查询用户
    	Users user = usersService.userLogin(params);

    	if (user == null) {
    		resMap.put("result", "用户名或密码错误");
    		return resMap;
    	}

    	//生成Token
		String token = TokenUtil.generateValue();
		
		//把用户信息存入session
		request.getSession().setAttribute("userId", user.getDataId());
		request.getSession().setAttribute("userName", user.getUserName());
		request.getSession().setAttribute("tokenSess", token);
		//把token保存到cookie中
		Cookie cookie = new Cookie("token", token);
		cookie.setMaxAge(3600);
		cookie.setSecure(false);
		response.addCookie(cookie);
		
		resMap.put("user", user);
		resMap.put("result", "success");
	    return resMap;
    }
}
