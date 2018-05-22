package com.xyb2c.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyb2c.dao.AuthorityMapper;
import com.xyb2c.pojo.Authority;
import com.xyb2c.pojo.AuthorityExample;
import com.xyb2c.service.AuthorityService;

@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	private AuthorityMapper dao;

	@Override
	public List<Authority> getAuthority(String id) {
		return dao.getAuthority(id);
	}

	@Override
	public List<Authority> getAuthorityByMenu(AuthorityExample example) {
		return dao.selectByExample(example);
	}

	@Override
	public List<Authority> getRoleAuthority(String id, String menuId) {
		return dao.getRoleAuthority(id, menuId);
	}

	@Override
	public boolean getAuthority(String rid, String aid) {
		Authority a = dao.AuthorityExist(rid, aid);
		if (a == null) {
			return false;
		}
		return true;
	}

	@Override
	public void saveAuthority(String rid, String aid) {
		dao.save(rid, aid);
	}

	@Override
	public void deleteAuthority(String rid, String aid) {
		dao.delete(rid, aid);
	}

	@Override
	public List<Authority> getUserAuthority(String uid, String menuId) {
		return dao.getUserAuthority(uid, menuId);
	}

	@Override
	public boolean userAuthorityExist(String uid, String aid) {
		Authority a = dao.userAuthorityExist(uid, aid);
		if (a == null) {
			return false;
		}
		return true;
	}

	@Override
	public void saveUserAuthority(String uid, String aid) {
		dao.saveUserAuthority(uid, aid);
	}

	@Override
	public void deleteUserAuthority(String uid, String aid) {
		dao.deleteUserAuthority(uid, aid);
	}

	@Override
	public List<Authority> getAuthorityByRoleId(String rid) {
		return dao.getAuthorityByRoleId(rid);
	}

	@Override
	public List<Authority> getAuthorityByWorkerId(String uid) {
		return dao.getAuthorityByWorkerId(uid);
	}

}
