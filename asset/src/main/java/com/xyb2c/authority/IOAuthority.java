package com.xyb2c.authority;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyb2c.pojo.Authority;

public class IOAuthority {

	/**
	 * 把用户拥有的权限生成txt文本文件,员工编号.txt
	 * @param list
	 * @param id
	 */
	public void out(List<Authority> list, String id) {
		if (list != null) {
		String json = listParseJson(list);
		File file = new File(getFilePath(), id + ".txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file, false);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(json);
			bufferWriter.flush();
			bufferWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}}
	}

	/**
	 * 读取权限文件
	 * @param id
	 * @return
	 */
	public Map<String, Authority> read(String id) {
		File file = new File(getFilePath(), id + ".txt");
		String json = "";
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String temp = null;
			while ((temp = bufferedReader.readLine()) != null) {
				json += temp;
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonParseMap(json);
	}

	private Map<String, Authority> jsonParseMap(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Authority> map = null;
		try {
			map = mapper.readValue(json.toString(), new TypeReference<Map<String, Authority>>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	private String listParseJson(List<Authority> list) {
		Map<String, Authority> map = new HashMap<>();
		for (Authority a : list) {
			String url = a.getUrl();
			String[] temp = url.split(";");
			for (String s : temp) {
				Authority authority = a;
				authority.setUrl(s);
				map.put(s, authority);
			}
		}
		StringBuffer json = new StringBuffer("{ ");
		for (String s : map.keySet()) {
			json.append("\"" + s + "\":{\"url\":\"" + map.get(s).getUrl() + "\"");
			json.append("},");
		}
		json = json.deleteCharAt(json.length() - 1);
		json.append(" }");
		return json.toString();
	}

	/**
	 * 获取权限文件地址
	 * @return
	 */
	private String getFilePath() {
		File file = new File((Authority.class.getClassLoader().getResource("").toString()));
		String targetPath = file.getParent() + "\\authority\\";
		targetPath = targetPath.substring(targetPath.indexOf("\\"));
		File targetFile = new File(targetPath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		return targetPath;
	}
}
