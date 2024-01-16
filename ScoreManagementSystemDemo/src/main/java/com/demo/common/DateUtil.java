package com.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Lewis
 */
@Slf4j
public class DateUtil {
	
	private static final String YYYY_MM_DD = "yyyyMMdd";
	private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	private DateUtil(){
		//do nothing because of constructor
	}
	
	//return current date format as yyyyMMdd.
	public static String getCurrentDateString() {
		return new SimpleDateFormat(YYYY_MM_DD).format(new Date());
	}
	
	public static String getCurrentDateWithSlash(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}

	public static String getCurrentDateWithYYYYMMDD(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	public static String getCurrentDateWithDDMMYYYY(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("dd-MM-yyyy").format(date);
	}

	public static String getCurrentDateWithDDMMYYYYHHMMSS(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS").format(date);
	}

	public static String getCurrentDateWithDDMMYYYYHHMMSS2(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date);
	}

	public static String getCurrentDateWithYYYYMMDDHHMMSS2(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).format(date);
	}

	public static String getCurrentDateWithDash(Date date) {
		if (date == null) {
			return "";
		}
		return getDay(date) + "-" + translateMonth(Integer.valueOf(getMonth(date))) + "-" + getYear(date);
	}

	public static String getCurrentDateWithDash1(Date date) {
		if (date == null) {
			return "";
		}
		return getDay(date) + "-" + translateMonthAll(Integer.valueOf(getMonth(date))) + "-" + getYear(date);
	}

	public static String getCurrentDateWithBlank(Date date) {
		if (date == null) {
			return "";
		}
		return getDay(date) + " " + translateMonthAll(Integer.valueOf(getMonth(date))) + " " + getYear(date);
	}
	
	public static String getCurrentTime(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("HH:mm:ss").format(date);
	}

	public static String getCurrentMinute(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("HH:mm").format(date);
	}

	public static String getCurrentDateFullInfor(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("yyMMddHHmmss").format(date);
	}
	
	public static String getDateWithMonthYear(Date date) {
		if (date == null) {
			return "";
		}
		return translateMonth(Integer.parseInt(getMonth(date))) + " " + getYear(date);
	}
	
	public static String getYear(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("yyyy").format(date);
	}
	
	public static String getDay(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("dd").format(date);
	}
	
	public static String getMonth(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("MM").format(date);
	}
	
	public static Date formatDateByString(String value) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		try {
			return new SimpleDateFormat(YYYY_MM_DD).parse(value);
		} catch (ParseException e) {
			return null;
		}
	}
	
	private static String translateMonth(int month) {
		switch (month) {
			case 1:
				return "Jan";
			case 2:
				return "Feb";
			case 3:
				return "Maret";
			case 4:
				return "April";
			case 5:
				return "Mei";
			case 6:
				return "Juni";
			case 7:
				return "Juli";
			case 8:
				return "Agustus";
			case 9:
				return "Sep";
			case 10:
				return "Okt";
			case 11:
				return "Nov";
			case 12:
				return "Des";
			default:
				return "";
		}
	}
	
	public static String translateMonthAll(int month) {
		switch (month) {
		case 1:
			return "Januari";
		case 2:
			return "Februari";
		case 3:
			return "Maret";
		case 4:
			return "April";
		case 5:
			return "Mei";
		case 6:
			return "Juni";
		case 7:
			return "Juli";
		case 8:
			return "Agustus";
		case 9:
			return "September";
		case 10:
			return "Oktober";
		case 11:
			return "November";
		case 12:
			return "Desember";
		default:
			return "";
		}
	}

	public static long getTime() {
		Calendar calendar = Calendar.getInstance();
		long milliseconds = calendar.getTimeInMillis();
		return milliseconds;
	}

	public static Date getCurrentUtilDate(){
		Date date = new Date(getTime());
		return date;
	}

	/**
	 * @param strDate
	 * @return
	 */
	public static String strDateFormate(String strDate){
		SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		SimpleDateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
		String formatDate = "";
		try {
			Date date  = df.parse(strDate);
			formatDate = dateFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatDate;
	}

	/**
	 * @return
	 */
	public static String getCurrentDateTimeString() {
		return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).format(new Date());
	}

	 /* The date after the specified date plus the number of days
      * @return
			  * @throws ParseException
      */
	public static String datePlusDays(int num,String newDate){
		SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		Date  currdate = null;
		String enddate = "";
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, num);
		currdate = ca.getTime();
		enddate = format.format(currdate);

		return enddate;
	}

	public static Date datePlusDays(int num,Date date){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.DATE, num);
		date = ca.getTime();
		return date;
	}


	public static Date dateRoll(Date date, int i, int d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(i, d);
		date = calendar.getTime();
		return date;
	}

	/**
	 * @return
	 */
	public static String newDatePlusDays(int num){
		Date d;
		SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);

		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, num);
		d = ca.getTime();
		String enddate = format.format(d);
		return enddate;
	}

	/**
	 * Calculate Indonesian age in months. If the month is greater than or equal to the birthday month. Age is the year difference, otherwise -1
	 * @param dob
	 * @return
	 */
	public static Integer calculateIndonesiaAge(Date dob){
		Integer monthDiff = getMonthDiff(dob,new Date());
		Integer age = monthDiff/12;
		return age;
	}

	/**
	 *
	 * @param dob
	 * @param now
	 * @param count
	 * @return
	 */
	public static Boolean checkCanBuy(Date dob,Date now,Integer count,Integer unit){
		Boolean result = true;
		if(dob == null || now == null || count == null || unit == null){
			return result;
		}
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(now);
		c2.setTime(dob);
		int year1 = c1.get(Calendar.YEAR);
		int year2 = c2.get(Calendar.YEAR);
		int month1 = c1.get(Calendar.MONTH);
		int month2 = c2.get(Calendar.MONTH);
		int day1 = c1.get(Calendar.DAY_OF_MONTH);
		int day2 = c2.get(Calendar.DAY_OF_MONTH);
		switch (unit){
			default:
			case 2:
				int yearInterval = year1 - year2;
				if (month1 < month2 || month1 == month2 && day1 < day2){
					yearInterval--;
				}
				int monthInterval = (month1 + 12) - month2;
				monthInterval %= 12;
				int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
				if((monthsDiff < count) || (monthsDiff == count && day1 < day2) ){
					result = false;
				}
				break;
		}
		return result;
	}

	public static int getMonthDiff(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		int year1 = c1.get(Calendar.YEAR);
		int year2 = c2.get(Calendar.YEAR);
		int month1 = c1.get(Calendar.MONTH);
		int month2 = c2.get(Calendar.MONTH);
		int day1 = c1.get(Calendar.DAY_OF_MONTH);
		int day2 = c2.get(Calendar.DAY_OF_MONTH);
		int yearInterval = year1 - year2;
		if (month1 < month2 || month1 == month2 && day1 < day2){
			yearInterval--;
		}
		int monthInterval = (month1 + 12) - month2;
		monthInterval %= 12;
		int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
		return monthsDiff;
	}


	public static Date stringToDate(String  inputDate){
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String getYyyyMMddDate(Date date){
		if(date == null){
			return null;
		}
		DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
		try{
			return dateFormat.format(date);
		}catch (Exception e){
			return null;
		}
	}

	public static Date formatDateTimeByString(String datetTime) {
		if (StringUtils.isEmpty(datetTime)) {
			return null;
		}
		try {
			return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).parse(datetTime);
		} catch (ParseException e) {
			log.error("format DateTime By String error: "+e);
			return null;
		}
	}

	public static String getDdMmmYyyyDate(Date date){
		if(date == null){
			return null;
		}
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
		try{
			return dateFormat.format(date);
		}catch (Exception e){
			return null;
		}
	}

	public static Date getDateAfter(Date d,int day){
		Calendar now =Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
		return now.getTime();
	}
}
