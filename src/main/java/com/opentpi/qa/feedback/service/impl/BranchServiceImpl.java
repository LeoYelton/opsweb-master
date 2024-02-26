package com.opentpi.qa.feedback.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opentpi.qa.feedback.dao.BranchMapper;
import com.opentpi.qa.feedback.model.Branch;
import com.opentpi.qa.feedback.service.BranchService;
import com.opentpi.util.MapUtil;


@Service("branchService")
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchMapper branchMapper;
	
	
    /**
	 * @description 根据主键查询
	 * @author Abruzzi
	 * @param id
	 * @return Branch
	 */
    @Override
    public Branch getBranch(int id){
    	return branchMapper.getBranch(id);
    }

    /**
	 * @description 根据条件查询（分页）
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return PageInfo<Branch>
	 */
    @Override
    public PageInfo<Branch> listByParam(Map<String, Object> params){
    	PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("pageSize").toString()));
    	List<Branch> list = branchMapper.listByParam(params);
    	return new PageInfo<>(list);
    }
    
    /**
	 * @description 根据条件查询
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return List<Branch>
	 */
    @Override
    public List<Branch> listByMap(Map<String, Object> params){
    	List<Branch> list = branchMapper.listByParam(params);
    	return list;
    }
    
    /**
	 * @description 分支机构登录
	 * @author Abruzzi
	 * @param Map<String, Object>
	 * @return Users
	 */
    @Override
    public Branch userLogin(Map<String, Object> params) {
    	//参数安全处理
    	String userName = MapUtil.getMapString(params, "userName");
    	String password = MapUtil.getMapString(params, "password");
    	//安全封装登陆查询
    	Map<String, Object> query = new HashMap<>();
    	query.put("branchNo", userName);
    	query.put("password", password);
    	Branch users = branchMapper.login(query);
    	return users;
    }
}
