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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.model.Branch;
import com.opentpi.qa.feedback.service.BranchService;
import com.opentpi.util.TokenUtil;

@Controller
public class BranchController {

	private static final Logger log = LoggerFactory.getLogger(BranchController.class);
	
	@Autowired
	private BranchService branchService;

    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param Branch record
	 * @return Map<String, Object>
	 */
    @RequestMapping("/branch/listByParam")
	@ResponseBody
    public Map<String, Object> listByParam(@RequestParam Map<String, Object> params){
    	Map<String,Object> resMap = new HashMap<>();
		PageInfo<Branch> dataList = branchService.listByParam(params); 
		resMap.put("total", dataList.getTotal());
		resMap.put("rows", dataList.getList());
	    return resMap;
    }
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Branch>
	 */
    @RequestMapping("/branch/listByMap")
	@ResponseBody
    public Map<String, Object> listByMap(@RequestParam Map<String, Object> params){
    	Map<String,Object> resMap = new HashMap<>();
    	List<Branch> list = branchService.listByMap(params);
    	resMap.put("rows", list);
	    return resMap;
    }
    
    /**
	 * @description 管理系统用户登录
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Users>
	 */
    @RequestMapping("/branch/userLogin")
	@ResponseBody
    public Map<String, Object> userLogin(@RequestParam Map<String, Object> params, 
    		HttpServletRequest request, HttpServletResponse response){
    	Map<String,Object> resMap = new HashMap<>();
    	//查询用户
    	Branch branch = branchService.userLogin(params);
    	
    	if (branch == null) {
    		resMap.put("result", "用户名或密码错误");
    		return resMap;
    	}
    	
    	//生成Token
		String token = TokenUtil.generateValue();
		
		//把用户信息存入session
		request.getSession().setAttribute("branchId", branch.getBranchNo());
		request.getSession().setAttribute("branchName", branch.getBranchName());
		request.getSession().setAttribute("tokenSess", token);
		//把token保存到cookie中
		Cookie cookie = new Cookie("token", token);
		cookie.setMaxAge(3600);
		cookie.setSecure(false);
		response.addCookie(cookie);
		
		resMap.put("branch", branch);
		resMap.put("result", "success");
	    return resMap;
    }
}
