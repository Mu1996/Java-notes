package com.muyonghui.i18n;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


public class I18NJava {

	public static void main(String[] args) {
		String path = "E:/i18n/BankTransferServiceImpl";
		// String path = "E:/i18n/department/show";
		String prefix = "banktransfer.";
		i18n(path, prefix);
	}

	public static void i18n(String path, String prefix) {
		String content = XmlTool.readFile(path + ".java", "UTF-8");
		// String content = XmlTool.readFile(path + ".jsp", "UTF-8");
		String quotes = "\"";
		int index = content.indexOf(quotes);
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		List<String> list = new ArrayList<String>();
		Map<String, String> map = addContains();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		while (index != -1) {
			String text = content.substring(index + 1, content.indexOf(quotes, index + 1));
			index = content.indexOf(quotes, content.indexOf(quotes, index + 1) + 1);
			if (p.matcher(text).find() && !list.contains(text)) {
				list.add(text);
			}
		}
		int i = 1;
		String properties = "";
		for (String t : list) {
			if (!map.containsValue(t)) {
				properties = properties + prefix + String.format("%04d", i) + "=" + t + "\n";
				content = content.replace(quotes + t + quotes, quotes + prefix + String.format("%04d", i) + quotes);
				i++;
			} else {
				content = content.replace(quotes + t + quotes, quotes + getKey(map, t) + quotes);
			}
		}
		writeFile(path + ".txt", content, "UTF-8");
		writeFile(path + ".properties", properties, "UTF-8");
		//System.out.println(content);
		System.out.println("success");
	}

	private static final String getKey (Map<String, String> map, String value) {
		Set<String> kset = map.keySet();
		for (String ks : kset) {
			if (value.equals(map.get(ks))) {
				return ks;
			}
		}
		return null;
	}

	private static final Map<String, String> addContains () {
		Map<String, String> map = new HashMap<String, String>();
		map.put("public.num.paramisempty", "参数为空");
		map.put("public.operator.deleting", "操作员已被删除");
		map.put("public.select.fail", "查询失败");
		return map;
	}
	
	/**
	 * 写文件(如果没有则创建目录文件)
	 * @param path 文件全路径(包含文件名)
	 * @param content 内容
	 * @param encoding 编码(默认UTF-8)
	 */
	public static final void writeFile(String path, String content, String encoding) {
		File file = new File(path);
		if (file.exists()) file.delete();
		writeFile(file, content, encoding);
	}
	
	/**
	 * 写文件
	 * @param file 对象
	 * @param content 内容
	 * @param encoding 编码
	 */
	public static final void writeFile(File file, String content, String encoding) {
		if (null != file) {
			if (!file.exists()) {
				createFile(file, true);
			}
			FileOutputStream fos = null;
			OutputStreamWriter osw = null;
			BufferedWriter bw = null;
			try {
				fos = new FileOutputStream(file);
				osw = new OutputStreamWriter(fos, encoding);
				bw = new BufferedWriter(osw);
				bw.write(content);
				bw.flush();
			} catch (UnsupportedEncodingException e) {
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			} finally {
				try {
					if (null != osw) osw.close();
					if (null != fos) fos.close();
					if (null != bw) bw.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	/**
	 * 创建文件
	 * @param file 文件
	 * @param state 状态 true:文件 false:文件夹
	 */
	private static void createFile(File file, boolean state) {
		if (null == file || !file.exists()) {
			if (null == file.getParentFile() || !file.getParentFile().exists()) {
				createFile(file.getParentFile(), false);
			} else {
				if (state) {
					try {
						file.createNewFile();
						file.setWritable(true, false);
					} catch (IOException e) {
					}
				} else {
					file.mkdir();
				}
			}
		}
	}
}
