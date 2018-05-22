package com.xyb2c.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.net.www.protocol.http.HttpURLConnection;

/**
 * @author 徐航海
 * @version 1.0
 */
@SuppressWarnings("restriction")
public class HttpUtil {

	private static final Logger LOGGER = Logger.getLogger(HttpUtil.class.getName());
	private static final String POST = "POST".intern();
	private static final String UTF_8 = "UTF-8".intern();
	private static final int DEFAULT_TIMEOUT = 30000; // 30秒
	
	static {
		LOGGER.setLevel(Level.OFF);
	}

	/**
	 * @param url   请求的URL
	 * @param heads 请求头参数
	 * @param parms 请求参数
	 * @return Response
	 * @throws IOException
	 */
	public static final String doGet(final String url, final Map<String, String> heads, final Map<String, String> parms) throws IOException {

		// 拼接URL
		StringBuilder _url = new StringBuilder(url);
		if (parms != null && !parms.isEmpty()) {
			boolean start = true;
			for (Map.Entry<String, String> entry : parms.entrySet()) {
				if (start) {
					_url.append("?");
					start = false;
				} else {
					_url.append("&");
				}
				_url.append(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), UTF_8));
			}
		}
		LOGGER.info(_url.toString());

		// 设置连接参数
		URL httpurl = new URL(_url.toString());
		HttpURLConnection connection = new HttpURLConnection(httpurl, null);
		connection.setReadTimeout(DEFAULT_TIMEOUT);
		connection.setDoOutput(true);
		connection.setUseCaches(false);

		if (heads != null && !heads.isEmpty()) {
			for (Map.Entry<String, String> entry : heads.entrySet()) {
				connection.setRequestProperty(entry.getKey(), entry.getValue());
			}
		}

		// Http连接
		connection.connect();

		// 读取Response并关闭连接
		String response = readResponse(connection);
		connection.disconnect();
		LOGGER.info(response);
		return response;
	}

	/**
	 * @see #doGet(String, Map, Map)
	 */
	public static final String doGet(final String url, final Map<String, String> parms) throws IOException {
		return doGet(url, null, parms);
	}

	/**
	 * @param url   请求的URL
	 * @param heads 请求头参数
	 * @param parms 请求参数
	 * @return Response
	 * @throws IOException
	 */
	public static final String doPost(final String url, final Map<String, String> heads, final Map<String, String> parms) throws IOException {

		// 设置连接参数
		URL httpurl = new URL(url);
		HttpURLConnection connection = new HttpURLConnection(httpurl, null);
		connection.setRequestMethod(POST);
		connection.setReadTimeout(DEFAULT_TIMEOUT);
		connection.setDoOutput(true);
		connection.setUseCaches(false);

		if (heads != null && !heads.isEmpty()) {
			for (Map.Entry<String, String> entry : heads.entrySet()) {
				connection.setRequestProperty(entry.getKey(), entry.getValue());
			}
		}
		LOGGER.info(connection.getRequestProperties().toString());

		// 拼接请求体
		StringBuilder parmString = new StringBuilder(512);
		if (parms != null && !parms.isEmpty()) {
			boolean start = true;
			for (Map.Entry<String, String> entry : parms.entrySet()) {
				if (start) {
					start = false;
				} else {
					parmString.append("&");
				}
				parmString.append(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), UTF_8));
			}
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length", Integer.toString(parmString.toString().getBytes().length));
			LOGGER.info(parmString.toString());
		}

		// 连接
		connection.connect();

		// 发送请求体
		if (parmString.length() > 0) {
			OutputStream out = connection.getOutputStream();
			out.write(parmString.toString().getBytes());
			out.flush();
			out.close();
		}

		// 读取Response并关闭连接
		String response = readResponse(connection);
		LOGGER.info(response);

		connection.disconnect();
		return response;
	}

	/**
	 * @see #doPost(String, Map, Map)
	 */
	public static final String doPost(final String url, final Map<String, String> parms) throws IOException {
		return doPost(url, null, parms);
	}

	private static final String readResponse(final HttpURLConnection connection) throws IOException {
		StringBuilder response = new StringBuilder(512);
		if (connection.getResponseCode() == 200) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = reader.readLine();
			while(line != null) {
				response.append(line);
				line = reader.readLine();
			}
			reader.close();
		}
		return response.toString();
	}
	
	public static void main(String[] args) throws IOException {
//		String url = "http://oa.xyb2c.com/index.php";
//		Map<String, String> parms = new HashMap<>(2);
//		parms.put("m", "login");
//		parms.put("a", "check_login");
//		parms.put("emp_no", "chenm");
//		parms.put("password", "123456");
//		parms.put("mobile_login_type", "app");
//		System.out.println(doGet(url, Collections.singletonMap("User-Agent", "java"), parms));
		
//		String url = "http://oa.xyb2c.com/index.php";
//		Map<String, String> parms = new HashMap<>(2);
//		parms.put("m", "profile");
//		parms.put("a", "index");
//		parms.put("id", "82");
//		parms.put("token", "004badeeb57d9937509a1429692d230a");
//		// parms.put("mobile_login_type", "app");
//		System.out.println(doGet(url, parms));
//		
		// e10adc3949ba59abbe56e057f20f883e
		// 123456 --> e10adc3949ba59abbe56e057f20f883e
		
		//System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
	}

}
