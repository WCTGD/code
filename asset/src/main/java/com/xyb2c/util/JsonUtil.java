
package com.xyb2c.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;

/**
 * @author �캽��
 * @version 1.0
 *          json�ַ��������ת��������
 */
public class JsonUtil {

	private static final Logger logger = Logger.getLogger(JsonUtil.class.getName());

	private static final Gson GSON = new GsonBuilder().create();

	/**
	 * @param json  json�ַ���
	 * @param clazz Class����
	 * @param <T>   ��Ҫת���Ķ��������
	 * @return ��ת����Ķ������ת��ʧ���򷵻�null��
	 */
	public static final <T> T parseJsonToObject(String json, Class<T> clazz) {
		if (json == null || clazz == null) {
			throw new NullPointerException("json or clazz is null");
		}
		if (json.isEmpty()) {
			throw new RuntimeException("json string is empty");
		}
		T t = null;
		try {
			t = GSON.fromJson(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Gson lib error parse string to object : " + json);
		}
		return t;
	}

	/**
	 * @param object ��Ҫת��Json�ַ����Ķ���
	 * @param <T>    Json���������
	 * @return ����ת�����Json�ַ���
	 */
	public static final <T> String parseObjectToString(T object) {
		if (object == null) {
			throw new NullPointerException("object is null");
		}
		return GSON.toJson(object);
	}
}
