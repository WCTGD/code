package com.xyb2c.util;

public class StringUtil {

	/**
	 * 
	 * @param value 需要填充0的数值
	 * @param length 填充0之后的字符串的长度
	 * @return 填充0后的字符串
	 */
	public static final String fillZero(int value, int length) {
		if (length <= String.valueOf(value).length()) {
			return String.valueOf(value);
		} else {
			return String.format("%0" + length + "d", value);
		}
	}

}
