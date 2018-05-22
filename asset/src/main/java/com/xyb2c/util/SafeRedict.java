package com.xyb2c.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
/**
 * 
 * @author zzf
 *
 * @version 1.0
 */
public class SafeRedict {
	/**
	 * 
	 * @param url
	 *            
	 * @param data
	 *            数据
	 * @return 返回结果
	 */
	public static String post(String url, String data) {
		HttpClient client = new HttpClient();
		// client.getHostConfiguration().setHost("localhost", 8081, "http");
		String s = null;
		HttpMethod method = null;
		try {
			method = new PostMethod(url+data);
			method.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
			method.setRequestHeader("User-Agent", "java");
			client.executeMethod(method);
			s = method.getResponseBodyAsString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		method.releaseConnection();
		return s;
	}

	/**
	 * 
	 * @param url
	 *            
	 * @param data
	 *            数据
	 * @return 返回结果
	 */
	public static String get(String url, String data) {
		HttpClient client = new HttpClient();
		// client.getHostConfiguration().setHost("localhost", 8081, "http");
		String s = null;
		HttpMethod method = null;
		try {
			method = new GetMethod(url+data);
			method.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
			method.setRequestHeader("User-Agent", "java");
			client.executeMethod(method);
			s = method.getResponseBodyAsString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		method.releaseConnection();
		return s;
	}
}
