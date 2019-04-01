package com.chang.once;

import java.text.SimpleDateFormat;

public class SingleObject {

	private static SimpleDateFormat dateFormat = null;
	public static void main(String[] args) {
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		dateFormat = new SimpleDateFormat("hh:mm:ss");
		// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
		dateFormat.setLenient(true);

		String str = "01:12:90";
		System.out.println(isValidDate(str));
	}


	public static boolean isValidDate(String s) {
		try {
			System.out.println(dateFormat.parse(s));
			return true;
		}
		catch (Exception e)
		{
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
}
