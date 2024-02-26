package com.opentpi.qa.feedback.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.opentpi.qa.feedback.model.Users;

public interface UsersMapper {

	/**
	 * @description 删除
	 * @author Abruzzi 
	 */
	int delUsers(int id);
	
	/**
	 * @description 新增
	 * @author Abruzzi 
	 */
    int addUsers(Users record);
    
    /**
	 * @description 修改
	 * @author Abruzzi 
	 */
    int updateUsers(Users record);
    
    /**
	 * @description 根据主键查询
	 * @author Abruzzi 
	 */
    Users getUsers(int id);

    /**
	 * @description 根据条件查询
	 * @author Abruzzi 
	 */
    List<Users> listByParam(Map<String, Object> params);

    /**
     * @description 管理员登录
     * @author Abruzzi 
     */
    Users login(Map<String, Object> params);
    

    /**
     * If using simple sql, we can use annotation. Such as @Select @Update.
     * If using ${username}, application will send a error.
     */
    @Select("select * from users where username = #{username}")
    Users findByUserName(@Param("username") String username);

    @Select("select * from users where username = '${username}'")
    List<Users> findByUserNameVuln01(@Param("username") String username);

    List<Users> findByUserNameVuln02(String username);
    
    List<Users> findByUserNameVuln03(@Param("order") String order);

    Users findById(Integer id);

    Users OrderByUsername();

}
