package com.cjzy.common;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
	
	public static String dateToString(Date date) {
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String format2 = simpleDateFormat.format(date);
		
		return format2;
	}
	
	public static Date stringToDate(String dateString) {
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		ParsePosition pos = new ParsePosition(8);
		Date parse=null;
		parse = simpleDateFormat.parse(dateString,pos);
		
		return parse;
	}
	
	
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		Date date=new Date();
		String dateStr = sdf.format(date);
		Date mydate=null;
		try {
			 mydate = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mydate.toString());

	}
	
	
	
	
}
