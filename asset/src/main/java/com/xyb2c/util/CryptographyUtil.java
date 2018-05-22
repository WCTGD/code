package com.xyb2c.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import com.xyb2c.util.CryptographyUtil;

/*
 * 加密工具
 */
public class CryptographyUtil {

	// MD5加密
	public static String md5(String str) {
		return new Md5Hash(str).toString();
	}

	public static void main(String[] args) {
		String password = "123456";
		System.out.println("Md5加密："
				+ CryptographyUtil.md5(password));
	}
}
