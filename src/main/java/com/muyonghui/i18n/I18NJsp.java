package com.muyonghui.i18n;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

//import com.util.XmlTool;

public class I18NJsp {

	public static void main(String[] args) {
		// String path = "E:/i18n/CampusDaoImpl";
		String path = "E:/commercefee/config/timerpos/show";
		String prefix = "timerpos.";
		i18n(path, prefix);
	}

	public static void i18n(String path, String prefix) {
		// String content = XmlTool.readFile(path + ".java", "UTF-8");
		String content = XmlTool.readFile(path + ".jsp", "UTF-8");
		String quotes = "\'";
		//String quotes = "\'";
		int index = content.indexOf(quotes);
		//Pattern p = Pattern.compile("^([a-zA-Z]+)$");
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		List<String> list = new ArrayList<String>();
		Map<String, String> map = addContains();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		while (index != -1) {
			String text = content.substring(index + 1, content.indexOf(quotes, index + 1));
			index = content.indexOf(quotes, content.indexOf(quotes, index + 1) + 1);
			//if (!p.matcher(text).find() && !text.equals(",") && !text.equals("_") && !text.equals("") && !text.equals("/") && !list.contains(text)) {
			if (p.matcher(text).find() && !list.contains(text)) {
				list.add(text);
			}
		}
		int i = 1;
		String properties = "";
		for (String t : list) {
			//System.out.println(prefix + String.format("%04d", i) + "=" + t);
			if (!map.containsValue(t)) {
				properties = properties + prefix + "page." + String.format("%03d", i) + "=" + t + "\n";
				content = content.replace(quotes + t + quotes, quotes + "<spring:message code=\"" + prefix + "page." + String.format("%03d", i) + "\"/>" + quotes);
				i++;
			} else {
				content = content.replace(quotes + t + quotes, quotes + "<spring:message code=\"" + getKey(map, t) + "\"/>" + quotes);
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
		map.put("login.clickChange", "点击更换验证码");
		map.put("login.text", "登录");
		map.put("public.warning", "警告");
		map.put("public.alert", "提示");
		map.put("public.insert", "新增");
		map.put("public.update", "修改");
		map.put("public.delete", "删除");
		map.put("public.select", "查询");
		map.put("public.chooseall", "全选");
		map.put("public.clearall", "清空");
		map.put("public.ok", "确定");
		map.put("public.cancel", "取消");
		map.put("public.save", "保存");
		map.put("public.saving", "保存中...");
		map.put("public.deleting", "删除中...");
		map.put("public.inserting", "新增中...");
		map.put("public.updating", "修改中...");
		map.put("public.export", "导出");
		map.put("public.import", "导入");
		map.put("public.num.paramisempty", "参数为空");
		map.put("public.num.ewalletcash", "电子现金钱包已满");
		map.put("public.num.ewalletaccount", "电子账户钱包已满");
		map.put("public.operator.deleting", "操作员已被删除");
		map.put("public.card.readcard", "读卡");
		map.put("public.card.notproperlyplaced", "卡片未正确放置");
		map.put("public.yes", "是");
		map.put("public.no", "否");
		map.put("public.all", "全部");
		return map;
	}

	/**
	 * 写文件(如果没有则创建目录文件)
	 * @param path 文件全路径(包含文件名)
	 * @param content 内容
	 * @param encoding 编码(默认UTF-8)
	 */
	private static final void writeFile(String path, String content, String encoding) {
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
	private static final void writeFile(File file, String content, String encoding) {
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
