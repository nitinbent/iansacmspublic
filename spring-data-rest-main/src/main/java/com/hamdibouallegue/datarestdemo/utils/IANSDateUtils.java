package com.hamdibouallegue.datarestdemo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class IANSDateUtils {
	
public static String convertIntoWordDate(String inputDateFormat, String outputDateFormat, String inputDate) throws ParseException 
	
	{
		DateFormat outputFormat = new SimpleDateFormat(outputDateFormat);
		DateFormat inputFormat = new SimpleDateFormat(inputDateFormat);

		Date date = inputFormat.parse(inputDate);
		String outputText = outputFormat.format(date);
		
		return outputText;
	}

}
