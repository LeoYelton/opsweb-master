package com.opentpi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期格式化类
 * 
 * @author ChenZW
 * 
 */
public class DateUtil {
	public static final long serialVersionUID = 1L;

	public static String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		String strDate = formatter.format(cal.getTime());
		return strDate;
	}

	public static String getCurrentDate(String foramt) {
		if ((foramt == null) || (foramt.equals("")))
			foramt = "yyyy-MM-dd";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(foramt);

		String strDate = formatter.format(cal.getTime());
		return strDate;
	}

	public static String getCurrentDate6() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");

		String strDate = formatter.format(cal.getTime());
		return strDate;
	}

	public static String getCurrentDate8() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		String strDate = formatter.format(cal.getTime());
		return strDate;
	}

	public static String getCurrentDate9() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");

		String strDate = formatter.format(cal.getTime());
		return strDate;
	}

	public static String getCurrentDateAll() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String strDate = formatter.format(cal.getTime());
		return strDate;
	}

	public static String getTime() {
		SimpleDateFormat format = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		String str = format.format(date);
		return str;
	}

	public static String getDateStringAll(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String strDate = formatter.format(date);
		return strDate;
	}

	public static Calendar createDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();

		cal.set(year, month - 1, day);

		return cal;
	}

//	public static Calendar createDate(String param) {
//		if (param == null) {
//			return Calendar.getInstance();
//		}
//		if (param.equals("")) {
//			return Calendar.getInstance();
//		}
//
//		int year = FormatUtil.parseInt(param.substring(0, 4));
//		int month = FormatUtil.parseInt(param.substring(5, 7));
//		int day = FormatUtil.parseInt(param.substring(8, 10));
//
//		return createDate(year, month, day);
//	}

	public static String getDateString(String param) {
		if (param.length() > 10) {
			return param.substring(0, 10);
		}

		return param;
	}

	public static String getDateString(Calendar cal) {
		String strDate = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			strDate = formatter.format(cal.getTime());
		} catch (Exception ex) {
			strDate = "";
		}

		return strDate;
	}

	public static String getDateString(Date date) {
		String strDate = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			strDate = formatter.format(date);
		} catch (Exception ex) {
			strDate = "";
		}

		return strDate;
	}

	public static String getStringYearMonth(Date date) {
		String strDate = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");

			strDate = formatter.format(date);
		} catch (Exception ex) {
			strDate = "";
		}

		return strDate;
	}

	public static String getStringYear(Date date) {
		String strDate = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy");

			strDate = formatter.format(date);
		} catch (Exception ex) {
			strDate = "";
		}
		return strDate;
	}

	public static Date stringToDate(String param) {
		if (param == null) {
			return new Date();
		}
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat formater = new SimpleDateFormat(pattern);

		Date date = null;
		try {
			date = formater.parse(param);
		} catch (ParseException ex) {
			date = new Date();
		}
		return date;
	}

	public static Date stringToDate(String param, String patter) {
		String pattern = patter;
		SimpleDateFormat formater = new SimpleDateFormat(pattern);

		Date date = null;
		try {
			date = formater.parse(param);
		} catch (ParseException ex) {
			date = new Date();
		}
		return date;
	}

	public static boolean greatThen(Date time, String timeStr) {
		boolean flag = false;
		try {
			if ((timeStr != null) && (!"".equals(timeStr))) {
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				Date date = formater.parse(timeStr);
				if (time.getTime() >= date.getTime())
					flag = true;
			}
		} catch (Exception ex) {
		}
		return flag;
	}

	/**
	 * 获取礼拜的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getWeekBegin(Date date) {
		if (date == null) {
			date = new Date();
		}

		Calendar calendar = Calendar.getInstance(java.util.Locale.CHINA);// 获取一个中国日历
		calendar.setTime(date);// 设置时间
		calendar.set(Calendar.HOUR_OF_DAY, 0);// 设置为0点
		calendar.set(Calendar.MINUTE, 0);// 设置0分
		calendar.set(Calendar.SECOND, 0);// 设置0秒
		calendar.set(Calendar.MILLISECOND, 1);// 设置0毫秒

		return new Date(calendar.getTime().getTime() - 1000L * 60L * 60L * 24L * (calendar.get(Calendar.DAY_OF_WEEK) - 1));
	}

	/**
	 * 获取礼拜的最后时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getWeekEnd(Date date) {
		if (date == null) {
			date = new Date();
		}

		Calendar calendar = Calendar.getInstance(java.util.Locale.CHINA);// 获取一个中国日历
		calendar.setTime(date);// 设置时间
		calendar.set(Calendar.HOUR_OF_DAY, 0);// 设置为0点
		calendar.set(Calendar.MINUTE, 0);// 设置0分
		calendar.set(Calendar.SECOND, 0);// 设置0秒
		calendar.set(Calendar.MILLISECOND, 0);// 设置0毫秒

		return new Date(calendar.getTime().getTime() + 1000L * 60L * 60L * 24L * (((7 + 1) - calendar.get(Calendar.DAY_OF_WEEK))));
	}

	public static String getChinaWeek(Date d) {
		Calendar calendar = Calendar.getInstance(java.util.Locale.CHINA);// 获取一个中国日历
		calendar.setTime(d);// 设置时间

		Map<Integer, String> conf = new HashMap<Integer, String>();
		conf.put(Calendar.MONDAY, "星期一");
		conf.put(Calendar.TUESDAY, "星期二");
		conf.put(Calendar.WEDNESDAY, "星期三");
		conf.put(Calendar.THURSDAY, "星期四");
		conf.put(Calendar.FRIDAY, "星期五");
		conf.put(Calendar.SATURDAY, "星期六");
		conf.put(Calendar.SUNDAY, "星期天");

		return conf.get(calendar.get(Calendar.DAY_OF_WEEK));
	}

	public static void main(String arg[]) {
		Date date = new Date();
		System.out.println(getDateStringAll(getWeekEnd(date)));
	}

}
