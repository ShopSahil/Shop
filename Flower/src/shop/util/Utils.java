package shop.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.servlet.http.HttpServletRequest;



public class Utils {
	// Method to parses a String to int
	// if String is blank or throws NumberFormatException return 0
	public static int parseInt(String s) {
		int i = 0;
		if (s != null) {
			try {
				i = Integer.parseInt(s.trim());
			} catch (NumberFormatException nfe) {
				// Do nothing
			}
		}
		return i;
	}

	public static int[] stringArrayToIntArray(String[] strArray) {
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i].trim());
		}
		return intArray;
	}

	public static String[] intArrayToStringArray(int[] intArray) {
		String[] strArray = new String[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			strArray[i] = Integer.toString(intArray[i]);
		}
		return strArray;
	}
	
	public static String removeBlankSpaces(String name){
    	
   	 StringTokenizer st = new StringTokenizer(name," ",false);
		 String completelyFormattedValue="";
		 while (st.hasMoreElements()) completelyFormattedValue += st.nextElement();
		 return completelyFormattedValue;
   }

	
	public static String removeLastChar(String name, String removeCharacter) {

		while (name.endsWith(removeCharacter)) {

			name = name.substring(0, name.length() - 1);

		}

		return name;
	}


	
	public static String[] booleanArrayToStringArray(boolean[] booleanArray) {
		String[] strArray = new String[booleanArray.length];
		for (int i = 0; i < booleanArray.length; i++) {
			strArray[i] = Boolean.toString(booleanArray[i]);
		}
		return strArray;
	}

	public static boolean[] stringArrayToBooleanArray(String[] stringArray) {
		boolean[] booleanArray = new boolean[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			booleanArray[i] = Boolean.getBoolean(stringArray[i]);
		}
		return booleanArray;
	}

	public static HashMap stringArrayToHashMap(String[] stringArray) {
		HashMap hashMap = new HashMap();
		for (int i = 0; i < stringArray.length; i++) {
			hashMap.put(stringArray[i], stringArray[i]);
		}
		return hashMap;
	}

	public static TreeMap stringArrayToTreeMap(String[] stringArray) {
		TreeMap treeMap = new TreeMap();
		for (int i = 0; i < stringArray.length; i++) {
			treeMap.put(stringArray[i], stringArray[i]);
		}
		return treeMap;
	}

	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException ne) {
			return false;
		}
		return true;
	}

	// method return the counter value at the end of the string
	public int getEndCounter(String s) {

		String counter = "-1";

		if ((s != null) && (!s.equals(""))) {

			counter = "";
			int at = s.length();
			String endStr = s.substring(at, 1);

			while (isInteger(endStr)) {
				counter = endStr + counter;
				if (at != 0) {
					endStr = s.substring(--at, 1);
				}
			} // while

		} // if
		return Integer.parseInt(counter);

	} // getEndCounter

	/**
	 * <p>
	 * String null check.
	 * </p>
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNotEmpty(String str) {
		return str != null && str.trim().length() > 0;
	}

	/**
	 * <p>
	 * String null check.
	 * </p>
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return !(isNotEmpty(str));
	}

	/**
	 * <p>
	 * Return trim, non-null representation of object.
	 * </p>
	 * 
	 * @param obj
	 *            Object
	 * @return String
	 */
	public static String checkString(Object obj) {
		String str = String.valueOf(obj);
		if (str == null || str.equals("null") || str.length() < 1) {
			str = "";
		}
		return str.trim();
	}

	public static String[] checkStringArray(Object[] obj) {
		String[] strArray = new String[obj.length];
		for (int i = 0; i < strArray.length; i++) {
			strArray[i] = checkString(obj[i]);
		}
		return strArray;
	}

	/**
	 * <p>
	 * Check for valid string, no special chars including:
	 * "#","&","^","%","*","/","\\","(",")"
	 * </p>
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isValidString(String str) {
		boolean valid = true;
		if (valid) {
			String invalid[] = { "~", "`", "!", "@", "$", "?", "#", "&", "^",
					"%", "*", "/", "\\", "(", ")" };
			for (int i = 0; i < invalid.length; i++) {
				if (str.indexOf(invalid[i]) >= 0) {
					valid = false;
				}
			}
		}
		return valid;
	}

	/**
	 * <p>
	 * Check for valid string - trim special characters
	 * </p>
	 * 
	 * @param str
	 *            String
	 * @return String
	 * @author Viru Hosamath
	 */

	public static String getValidString(String str) {
		String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int strLength = str.length();
		char charArray[] = new char[strLength];
		for (int x = 0; x < strLength; x++) {
			charArray[x] = str.charAt(x);
			if (validChars.indexOf(charArray[x]) == -1) {
				charArray[x] = '\'';
			}
		}
		String finalStr = new String(charArray);
		finalStr = finalStr.replaceAll("\'", "");
		return finalStr.trim();
	}

	public static boolean validateString(String str) {
		boolean validate = false;
		String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789:_-";
		int strLength = str.length();
		char charArray[] = new char[strLength];
		for (int x = 0; x < strLength; x++) {
			charArray[x] = str.charAt(x);
			if (validChars.indexOf(charArray[x]) == -1) {
				validate = true;
			}
		}
		return validate;
	}

	/**
	 * <p>
	 * Check for valid string representation of number.
	 * </p>
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isValidNumber(String str) {
		boolean valid = true;

		try {
			long tmpLong = Long.parseLong(str);
		} catch (NumberFormatException nfe) {
			return false;
		}

		return valid;
	}

	// D A T E M A N I P U L A T I O N
	/**
	 * <p>
	 * String representation of a calendar. Format: MM/DD/YYYY
	 * </p>
	 * 
	 * @param pCalendar
	 *            Calendar
	 * 
	 * @return String
	 */
	public static String getDisplayDate(Calendar pCalendar) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		if (pCalendar != null) {
			return format.format(pCalendar.getTime());
		} else {
			return "";
		}
	}

	/**
	 * <p>
	 * Convert string representation of a date to calendar.
	 * </p>
	 * 
	 * @param str
 	 *            String
	 * 
	 * @return Calendar
	 */
	public static Calendar str2Calendar(String str) {
		Calendar cal = null;
		if (!isEmpty(str)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				java.util.Date d = sdf.parse(str);
				cal = Calendar.getInstance();
				cal.setTime(d);
			} catch (ParseException e) {
			}
		}
		return cal;
	}

	/**
	 * <p>
	 * String representation of current date. Format: MM/DD/YYYY
	 * </p>
	 * 
	 * @return String
	 */
	public static String getCurrentDate() {
		return getDisplayDate(Calendar.getInstance());
	}
	
	public static String getCurrentDateTime() {
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c1 = Calendar.getInstance();
	//	Date d1 = new Date();
	//	c1.add(Calendar.DATE, daysFromNow);
		return format.format(c1.getTime());
		//return getDisplayDate(c1.getInstance().getTime());
	}
	
	// Added by Gopi
	public static String getCurrentDateAndTime() {
		Date dt = Calendar.getInstance().getTime();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return format.format(dt);
	}
	
	public static String getCurrentDateAndTimeFormat() {
		Date dt = Calendar.getInstance().getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(dt);
	}
	
	public static String getCurrentDateAndTimeFormat1() {
		Date dt = Calendar.getInstance().getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
		return format.format(dt);
	}
	// M I S C E L L A N E O U S
	/**
	 * <p>
	 * Print collection contents.
	 * </p>
	 * 
	 * @param col
	 *            Collection
	 * @param type
	 *            String
	 * @return String
	 */
	public static String col2Str(Collection col, String type) {
		StringBuffer str = new StringBuffer();
		if (col != null && !col.isEmpty()) {
			str.append(" Num of " + type + ": " + col.size() + " |");
			Iterator itr = col.iterator();
			while (itr.hasNext()) {
				Object obj = itr.next();
				str.append(" " + obj.toString());
			}
		} else {
			str.append(type + ": [null]");
		}
		return str.toString();
	}

	/**
	 * <p>
	 * Get full context path of URL, i.e. http://localhost:port
	 * </p>
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return String
	 */
	public static String getFullContextPath(HttpServletRequest request) {
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String nextPage = "http://" + serverName + ":" + serverPort;
		return nextPage;
	}

	/**
	 * <p>
	 * Get HTPP method- POST or GET. This is used to debug the query string.
	 * </p>
	 * 
	 * @return String
	 */
	public static String getHttpMethod() {
		return "POST";
	}

	/**
	 * <p>
	 * Get servlet name from given mapping.
	 * </p>
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param name
	 *            String
	 * @return String
	 */

	public static String getFutureDate(int daysFromNow) {

		long milli = (24 * 3600 * 1000) * daysFromNow + new Date().getTime();
		Date date = new Date(milli);
		// change format
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

		return format.format(date);
	}
	
	
	public static String setDate(int daysFromNow) {
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c1 = Calendar.getInstance();
		Date d1 = new Date();
		c1.add(Calendar.DATE, daysFromNow);
		return format.format(c1.getTime());
	}
	
	public static String setYear(int YearsFromNow) {
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c1 = Calendar.getInstance();
	//	Date d1 = new Date();
		c1.add(Calendar.YEAR, YearsFromNow);
		return format.format(c1.getTime());
	}


	public static String[] insertSection(int index, String insertStr,
			String[] strArray) {
		// strArray==null assign a new array
		strArray = strArray != null ? strArray : new String[0];

		Vector arrayVector = new Vector(Arrays.asList(strArray));
		arrayVector.add(index, insertStr);
		String[] returnStr = (String[]) arrayVector.toArray(new String[0]);
		return returnStr;
	}

	public static String[] insertSection(String insertStr, String[] strArray) {
		// strArray==null assign a new array
		strArray = strArray != null ? strArray : new String[0];

		Vector arrayVector = new Vector(Arrays.asList(strArray));
		arrayVector.add(insertStr);
		String[] returnStr = (String[]) arrayVector.toArray(new String[0]);
		return returnStr;
	}
	

	public static String[] deleteSection(int index, String[] strArray) {
		Vector arrayVector = new Vector(Arrays.asList(strArray));
		arrayVector.remove(index);
		String[] returnStr = (String[]) arrayVector.toArray(new String[0]);
		return returnStr;
	}

	public static String[] vectorToStringArray(Vector vec) {
		String[] returnStr = vec != null ? (String[]) vec
				.toArray(new String[0]) : new String[0];
		return returnStr;
	}

	public static String delimateStrings(String[] str) {
		String names = "";
		for (int i = 0; i < str.length; i++) {
			names = i > 0 ? (names + ", ") : names;
			names += str[i];
		} // for
		return names;
	}

	public static int rate(String target, String expression) {
		int score = 0;
		int HIGH_SCORE = 999;
		// do regular expression match
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(target);
		boolean matched = matcher.matches();
		if (matched) {
			if (expression.equals(target)) {
				score = HIGH_SCORE;
			} else {
				score = expression.length();
			} // if
		}

		return score;
	} // rate

	/*
	 * @Vikas Bhardwaj This method will convert date coming from database to
	 * String which can be directly used by all front end components.
	 */
	public static String getORADateToStr(Date theDate) {
		if (theDate == null) {
			return "";
		}
		return new SimpleDateFormat("MM/dd/yyyy").format(theDate);
	}

	/*
	 * @Vikas Bhardwaj This method will convert string format of date to Date.
	 */

	public static String convertTimestampToString(Timestamp timestamp) {
		if (timestamp == null) {
			// System.out.println("The value of timestamp is
			// NULL..........@@@@@@@@@@@@@@@@@@@@@");
			return "";
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = (Date) timestamp;
		return format.format(date);

	}

	
	public static String convertTimestampToStringWithTimeZone(Timestamp timestamp,String timeZoneFormat) {
		if (timestamp == null) {
			// System.out.println("The value of timestamp is
			// NULL..........@@@@@@@@@@@@@@@@@@@@@");
			return "";
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = (Date) timestamp;
		TimeZone tz = TimeZone.getTimeZone(timeZoneFormat);
		format.setTimeZone(tz);
		
		return format.format(date);

	}

	public static String convertTimestampToStringWithFormat(
			Timestamp timestamp, String Format) {
		if (timestamp == null) {
			// System.out.println("The value of timestamp is
			// NULL..........@@@@@@@@@@@@@@@@@@@@@");
			return "";
		}

		SimpleDateFormat format = new SimpleDateFormat(Format);
		Date date = (Date) timestamp;
		return format.format(date);

	}

	// Added by Gopi
	public static String displayTimestampAsString(Timestamp timestamp) {

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = (Date) timestamp;
		return format.format(date);

	}

	// Added by Gopi ==> converts string in format 05/24/2006 12:45:40 to
	// timestamp object
	public static Timestamp convertStringToTimestamp(String dateTime) {

		String MM = dateTime.substring(0, 2);
		String dd = dateTime.substring(3, 5);
		String yyyy = dateTime.substring(6, 10);
		String hh = dateTime.substring(11, 13);
		String mm = dateTime.substring(14, 16);
		String ss = dateTime.substring(17, 19);
		String finalString = yyyy + "-" + MM + "-" + dd + " " + hh + ":" + mm
				+ ":" + ss;
		return Timestamp.valueOf(finalString);

	}
	
//	 Added by Neeraj ==> converts string in format 2009-02-01 12:45:40 to
	// timestamp object
	
	public static Timestamp convertStringToTimestamp2(String dateTime) {
		String yyyy = dateTime.substring(0, 4);
		String MM = dateTime.substring(5, 7);
		String dd = dateTime.substring(8, 10);
		String hh = dateTime.substring(11, 13);
		String mm = dateTime.substring(14, 16);
		String ss = dateTime.substring(17, 19);
		String finalString = yyyy + "-" + MM + "-" + dd + " " + hh + ":" + mm
				+ ":" + ss;
		return Timestamp.valueOf(finalString);

	}
	
	

	public static String isEmptyThenReturn(String value, String assignStr) {
		String returnValue;

		if (isEmpty(value)) {
			returnValue = assignStr;
		} else {
			returnValue = value.trim();
		}
		return returnValue;

	} // isEmptyThenReturn

	public static java.sql.Date toSQLDate(java.util.Date inDate) {
		java.sql.Date outDate = null;
		if (inDate != null) {
			outDate = new java.sql.Date(inDate.getTime());
		}
		return outDate;
	}


	public static String escapeSpecialCharacters(String result) {

		String finalResult = "";
		// convert all new Line characters to <br>
		Pattern newLinePattern = Pattern.compile("\\r\\n|\\r|\\n");
		Matcher newLineMatcher = newLinePattern.matcher(result);
		result = newLineMatcher.replaceAll("<br>");
		// remove all single quotes
		Pattern singleQuotePattern = Pattern.compile("'");
		Matcher singleQuoteMatcher = singleQuotePattern.matcher(result);
		result = singleQuoteMatcher.replaceAll("");
		return result;

	}

	public static String getParsedString(String str) {
		String finalStr = str;
		if (str.indexOf(":") != -1) {
			finalStr = str.substring(0, str.indexOf(":"));
		}
		return finalStr;
	}

	public static void main(String[] arg) {
		
		System.out.println("Date will be: " + getFutureDate(7));
	}

	public static String getColorCode(Timestamp time) {
		String colorCode = "<img src='./images/bar_red.gif' border='0' />";

		// String green = "#00FF00";
		// String yellow = "#FFFF00";
		if (time == null) {
			return colorCode;
		}
		try {
			long currentTimeInLong = System.currentTimeMillis();
			long timeInLong = time.getTime();
			if (timeInLong < (currentTimeInLong - 2 * 24 * 60 * 60 * 1000)) {
				// colorCode = "#FFFF00";
				colorCode = "<img src='./images/bar_yellow.gif' border='0' />";
			} else {
				// colorCode = "#00FF00";
				colorCode = "<img src='./images/bar_green.gif' border='0' />";
			}

		} catch (Exception ex) {

		}
		return colorCode;
	}
	public static HashMap getParseStrList(String parseString,String searchStr) {

		HashMap strMap = new HashMap();
		
		try {

			StringTokenizer st = null;
			String strToken = null;
			
			// parse tsavalid status using StringTokenizer
			if (Utils.isNotEmpty(parseString)) {
				st = new StringTokenizer(parseString, searchStr);
			}
			// construct list
			while (st.hasMoreTokens()) {
				strToken = st.nextToken();
				strMap.put(strToken.toLowerCase(),strToken.toLowerCase());
			}

		} catch (Exception ex) {

		}
		return strMap;
	}
	
	public static boolean compareDates(String startDate,String endDate){
		
		boolean afterDt = false;
		try{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date startDt = df.parse(startDate);
		Date endDt = df.parse(endDate);
		
		if(startDt.after(endDt)){
			afterDt = true;	
		}
		}catch(Exception ex){
			
			
		}
		return afterDt;
	}
	
// Added by Gaurav for #473349.
	public static boolean checkDateEquality(String date1, String date2){
		boolean res = false;
		
		try{
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date date_1 = df.parse(date1);
			Date date_2 = df.parse(date2);
			
			if(date_1.equals(date_2))
				res=true;
			
		}catch(Exception ex){
			
		}
		
		return res;
	}
	
	public static boolean futureDate(String strDate){
		boolean futureDate = false;
		try{
			
			
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date enteredDate = df.parse(strDate);
			Date currDate = new Date();
			
			if(enteredDate.after(currDate)){
				futureDate = true;
			}
			
		}catch(Exception ex){
		}
		
		return futureDate;
		
	}
	
	public static boolean isValidDouble(String doubleValue){
		
		boolean isValid = true;
        int count = 0;
        int index = 0;
        
        // Loop round all characters in the input or until invald character detected
        while (index < doubleValue.length() && isValid) { 
            char c = doubleValue.charAt(index);            
            // Check if it's a decimal point
            if (c == 46) {
                count ++;                
                // Invalid if there's been more than one
                if (count > 1) {
                    isValid = false;
                }
                
            // Check if it's less than the ASCII for '0' or greater than the ASCII for '9'
            } else if (c < 48 || c > 57) {
                isValid = false;
            }           
           
            index ++;
        }
        return isValid;
    }	
	public static Map sortMapByValue(Map map) {
		     ArrayList list = new ArrayList( map.entrySet());
		     Collections.sort(list , new Comparator() { 
		    	 public int compare( Object o1 , Object o2 )  
		    	 {   
		    		 Map.Entry e1 = (Map.Entry)o1 ;
		    		 Map.Entry e2 = (Map.Entry)o2 ;      
		    		 
		    		 String first[]=e1.getValue().toString().toLowerCase().split("-");
		    		 first.toString().trim();
		    		 String second[]=e2.getValue().toString().toLowerCase().split("-");
		    		 second.toString().trim();
		    		 String third=first[1].toString().toLowerCase();
		    		 third.toString().trim();
		    		 //System.out.println("String third : " + third);
		    		 String fourth=second[1].toString().toLowerCase();
		    		 fourth.toString().trim();
		    		 //System.out.println("String fourth : " + fourth);
		    		 return third.toString().trim().compareTo( fourth.toString().trim());   
		    		 }  
		    	 });
	
		     Map result = new LinkedHashMap();
		 	
		for (Iterator it = list.iterator(); it.hasNext();) {
			 Map.Entry entry = (Map.Entry)it.next();
		     result.put(entry.getKey(), entry.getValue());
			 //result.put(entry.getValue(),entry.getKey());
		     }
		return  result;
		}
	
	public static java.sql.Date convertStringTimestampToDate(String passedDate) throws ParseException{
	DateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	java.util.Date parsedUtilDate = formater.parse(passedDate);
	java.sql.Date sqltDate = null;
	return sqltDate= new java.sql.Date(parsedUtilDate.getTime()); 

	 
	}

	public static String getORADateToStrwithFormat(Date theDate) {
		if (theDate == null) {
			return "";
		}
		return new SimpleDateFormat("YYYY-MM-DD").format(theDate);
	}
	
	public String getsqlTimestampToString(Timestamp sqlDate ){
	SimpleDateFormat sdfFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
	 sdfFormat.setLenient(false);
	 Calendar cal = Calendar.getInstance();
	 cal.setTime(sqlDate);
	 String finalDate = sdfFormat.format(cal.getTime());
	return finalDate;
	}
	
	public static String getCurrentTimeStamp() {
		final Calendar cal = Calendar.getInstance();
		final SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhhmmss");
		return sdf.format(cal.getTime());
	}

	
	public  static String  extendDateFromGivenDate(Date startDate,int numberOfDays) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c1 = Calendar.getInstance();
		c1.setTime(startDate);
		c1.add(Calendar.DATE, numberOfDays);
		return format.format(c1.getTime());
	}

	public  static Timestamp  extendDateinTimeStamp(Date startDate,int numberOfDays) throws ParseException{
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	Calendar c1 = Calendar.getInstance();
	c1.setTime(startDate);
	c1.add(Calendar.DATE, numberOfDays);
	Timestamp tstamp = new Timestamp(c1.getTimeInMillis()); 
	return tstamp; 

}


	
public static void calculateNextWorkingDate(Calendar cal,List holidays, int days){
	
	Calendar startDate=cal;
	List holidaysDays=new ArrayList();
	SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
	String currDate=sdf.format(startDate.getTime());
	int totHolidays=holidays.size();
	if(holidays !=null){
		for(int j=0;j<totHolidays;j++){
			holidaysDays.add(sdf.format(holidays.get(j)));
		}
		
	}
	if(startDate.get(startDate.DAY_OF_WEEK)==1 || (holidays !=null && holidaysDays.contains(currDate))){
		startDate.add(startDate.DATE, 1);
	}
	else if (startDate.get(startDate.DAY_OF_WEEK)==7 ){
		startDate.add(startDate.DATE, 2);
	}
		
	for(int i=days;i>0;)
	{
		if(!(startDate.get(startDate.DAY_OF_WEEK)==1 || startDate.get(startDate.DAY_OF_WEEK)==7))
		{
			currDate=sdf.format(startDate.getTime());
			if(!(holidays !=null && holidaysDays.contains(currDate))){
				i--;
			}
		}
		if(i>0){
			startDate.add(startDate.DATE, 1);
		}
	}
}
	
 	public static String setEmptyIfNull(String value){
		return value==null?"":value.trim();
	}
	
	public static String getQuotedString(String str){
		StringBuilder string = new StringBuilder();
		string.append("\"" + Utils.setEmptyIfNull(str)+ "\"");
		return string.toString();
	}
	
	public static String getQuotedString(int str){
		StringBuilder string = new StringBuilder();
		string.append("\"" + Utils.setEmptyIfNull(Integer.toString(str))+ "\"");
		return string.toString();
	}
	
	public static int setEmptyStringZeroInt(String value)
	{
		int returnValue = 0;
		if (value.equals("") || value.length()==0 || value== null){
			returnValue = 0;
		
		
		}
		else if (!Utils.isInteger(value)){
			returnValue =  -1;
		}
		return returnValue;	
	}
	

public static List<String> delimitedStringToList(String str,String delimiter){	
	List<String> sellItems = new ArrayList<String>();
	if (Utils.isNotEmpty(str) && Utils.isNotEmpty(delimiter)){  
		sellItems=Arrays.asList(str.split(delimiter));
	}
	return sellItems;
}


}
