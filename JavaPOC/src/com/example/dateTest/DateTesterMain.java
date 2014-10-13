/**
 * 
 */
package com.example.dateTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Akhash Ramamurthy
 * POC
 * May 31, 2012
 */
public class DateTesterMain {

	public static SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("MM:dd:yy:HH:mm:s:SS a");
	public static SimpleDateFormat DATETIME_FORMAT2 = new SimpleDateFormat("MM:dd:yyyy:HH:mm:s:SS");
	public static SimpleDateFormat DATETIME_FORMAT3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sZ");

	public static void main(String[] args){
				Calendar cal = Calendar.getInstance();
		System.out.println("Month ---- >    " + cal.get(Calendar.MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 18);
		Date date = cal.getTime();
		String formatted = DATETIME_FORMAT2.format(date);
		System.out.println("Formatted Date ---- >    " + formatted);
		try {
			Date date2 = DATETIME_FORMAT.parse(formatted);
			System.out.println("Recovered Date ---- >    " + DATETIME_FORMAT2.format(date2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		String nowAsString = DATETIME_FORMAT3.format(new Date());
//		System.out.println("Now As String -- " + nowAsString);
		
//		String s =  "2013-06-25T14:00:00Z";
//		String s =  "2013-06-25T140000Z";
		String s =  "2013-06-25T14:00:00+04";
//		String s =  "2013-06-25T14:00:00+0400";
//		String s =  "2013-06-25T140000+0400";
//		String s =  "2013-06-25T14:00:00-04";
//		String s =  "2013-06-25T14:00:00-0400";
//		String s =  "2013-06-25T140000-0400";
		
//		try {
//			System.out.println("Recovered Date ---- >    " +toDate(s));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
	}

	private static Date toDate(String iso8601string) throws ParseException {
		iso8601string = iso8601string.trim();
		if(iso8601string.toUpperCase().indexOf("Z")>0){
			iso8601string = iso8601string.toUpperCase().replace("Z", "+0000");
		}else if(((iso8601string.indexOf("+"))>0)){
			int index1 = iso8601string.indexOf("+");
			iso8601string = replaceColon(iso8601string, iso8601string.indexOf("+"));
			iso8601string = appendZeros(iso8601string, iso8601string.indexOf("+"), "+");
		}else if(((iso8601string.indexOf("-"))>0)){
			int index2 = iso8601string.indexOf("-");
			iso8601string = replaceColon(iso8601string, iso8601string.indexOf("-"));
			iso8601string = appendZeros(iso8601string, iso8601string.indexOf("-"), "-");
		}
		
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HHmmssZ");
		Date date = null;
		
		if(iso8601string.contains(":"))
			date = format1.parse(iso8601string);
		else{
			date = format2.parse(iso8601string);
		}
		return date;
	}
	
	private static String replaceColon(String sourceStr, int offsetIndex){
		if(sourceStr.substring(offsetIndex).contains(":"))
			return sourceStr.substring(0, offsetIndex) + sourceStr.substring(offsetIndex).replace(":", "");
		return sourceStr;
	}
	
	private static String appendZeros(String sourceStr, int offsetIndex, String offsetChar){
		if((sourceStr.length()-1)-sourceStr.indexOf(offsetChar,offsetIndex)<=2)
			return sourceStr + "00";
		return sourceStr;
	}

}
