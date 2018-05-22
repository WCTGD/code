package com.xyb2c.dao;

import com.xyb2c.pojo.Authority;
import com.xyb2c.pojo.AuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorityMapper {
	int countByExample(AuthorityExample example);

	int deleteByExample(AuthorityExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Authority record);

	int insertSelective(Authority record);

	List<Authority> selectByExample(AuthorityExample example);

	Authority selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Authority record, @Param("example") AuthorityExample example);

	int updateByExample(@Param("record") Authority record, @Param("example") AuthorityExample example);

	int updateByPrimaryKeySelective(Authority record);

	int updateByPrimaryKey(Authority record);

	/**
	 * 根据用户ID获取 用户拥有角色所拥有的权限
	 * 
	 * @param id
	 * @return
	 */
	List<Authority> getAuthority(String id);

	/**
	 * 根据菜单ID,角色ID获取权限
	 * 
	 * @param id
	 * @param menuId
	 * @return
	 */
	List<Authority> getRoleAuthority(@Param("id") String id, @Param("menuId") String menuId);

	/**
	 * 判断角色权限是否存在
	 * 
	 * @param rid
	 * @param aid
	 * @return
	 */
	Authority AuthorityExist(@Param("rid") String rid, @Param("aid") String aid);

	/**
	 * 保存角色权限
	 * 
	 * @param rid
	 * @param aid
	 */
	void save(@Param("rid") String rid, @Param("aid") String aid);

	/**
	 * 删除角色权限
	 * 
	 * @param rid
	 * @param aid
	 */
	void delete(@Param("rid") String rid, @Param("aid") String aid);

	/**
	 * 根据菜单ID,用户ID获取权限
	 * 
	 * @param uid
	 * @param menuId
	 * @return
	 */
	List<Authority> getUserAuthority(@Param("uid") String uid, @Param("menuId") String menuId);

	/**
	 * 判断用户权限是否存在
	 * 
	 * @param uid
	 * @param aid
	 * @return
	 */
	Authority userAuthorityExist(@Param("uid") String uid, @Param("aid") String aid);

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