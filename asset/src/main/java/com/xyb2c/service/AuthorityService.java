package com.xyb2c.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xyb2c.pojo.Authority;
import com.xyb2c.pojo.AuthorityExample;

public interface AuthorityService {
	/**
	 * 根据用户ID获取 用户拥有角色所拥有的权限
	 * 
	 * @param id
	 * @return
	 */
	List<Authority> getAuthority(String id);
/**
 * 根据菜单ID获取权限
 * @param example
 * @return
 */
	List<Authority> getAuthorityByMenu(AuthorityExample example);
/**
 * 根据菜单ID,角色ID获取权限
 * @param id
 * @param menuId
 * @return
 */
	List<Authority> getRoleAuthority(String id, String menuId);
/**
 * 判断角色权限是否存在,true为不存在
 * @param rid
 * @param aid
 * @return
 */
	boolean getAuthority(String rid, String aid);
/**
 * 保存角色权限
 * @param rid
 * @param aid
 */
	void saveAuthority(String rid, String aid);
/**
 * 删除角色权限
 * @param rid
 * @param aid
 */
	void deleteAuthority(String rid, String aid);
/**
 * 根据菜单ID,用户ID获取权限
 * @param uid
 * @param menuId
 * @return
 */
	List<Authority> getUserAuthority(String uid, String menuId);

	/**
	 * 判断用户权限是否存在,true为不存在
	 * 
	 * @param uid
	 * @param aid
	 * @return
	 */
	boolean userAuthorityExist(@Param("uid") String uid, @Param("aid") String aid);

	/**
	 * 保存用户指定权限
	 * 
	 * @param uid
	 * @param aid
	 */
	void saveUserAuthority(@Param("uid") String uid, @Param("aid") String aid);

	/**
	 * 删除用户指定权限
	 * 
	 * @param uid
	 * @param aid
	 */
	void deleteUserAuthority(@Param("uid") String uid, @Param("aid") String aid);

	/**
	 * 根据角色ID获取权限
	 * 
	 * @param rid
	 * @return
	 */
	List<Authority> getAuthorityByRoleId(String rid);

	/**
	 * 根据用户ID获取权限
	 * 
	 * @param uid
	 * @return
	 */
	List<Authority> getAuthorityByWorkerId(String uid);

}
