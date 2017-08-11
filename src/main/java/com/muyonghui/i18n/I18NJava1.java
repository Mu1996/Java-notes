package com.muyonghui.i18n;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

//import com.hzsun.easytong.XmlTool;

public class I18NJava1 {

	public static void main(String[] args) {
		String path = "E:/service/TransactionTypeServiceImpl";
		// String path = "E:/i18n/department/show";
		String prefix = "transactiontype.";
		i18n(path, prefix);
	}

	public static void i18n(String path, String prefix) {
		String content = XmlTool.readFile(path + ".java", "UTF-8");
		// String content = XmlTool.readFile(path + ".jsp", "UTF-8");
		String quotes = "\"";
		int index = content.indexOf(quotes);
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		List<String> list = new ArrayList<String>();
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
			properties = properties + prefix + String.format("%04d", i) + "=" + t + "\n";
			//System.out.println(prefix + String.format("%04d", i) + "=" + t);
			content = content.replace("\"" + t + "\"", "\"" + prefix + String.format("%04d", i) + "\"");
			i++;
		}
		writeFile(path + ".txt", content, "UTF-8");
		writeFile(path + ".properties", properties, "UTF-8");
		//System.out.println(content);
		System.out.println("success");
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
