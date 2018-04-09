package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	private static String MYSQL_FORMAT="yyyy-MM-dd HH:mm:ss";
	private static String DATE_FORMAT="yyyy-MM-dd";
	
	public static String getCurrentTime(){
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(MYSQL_FORMAT);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String dateString=simpleDateFormat.format(date);
		return dateString;
	}
	
	public static String getCurrentDate(){
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(DATE_FORMAT);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String dateString=simpleDateFormat.format(date);
		return dateString;
	}
	
	
	public static long getTimeGap(Date earlyTime,Date lateTime){
		long gapTime=-1;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(MYSQL_FORMAT);
			String earlyTimeString=sdf.format(earlyTime);
			String lateTimeString=sdf.format(lateTime);
			gapTime=sdf.parse(lateTimeString).getTime()-sdf.parse(earlyTimeString).getTime();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return gapTime;
	}
	
	
	public static void main(String[] args) {
		//Date date1=new Date();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//Date date2=new Date();
		System.out.println(getCurrentTime());
	}


}
