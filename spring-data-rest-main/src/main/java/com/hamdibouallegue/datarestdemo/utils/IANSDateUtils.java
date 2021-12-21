package com.hamdibouallegue.datarestdemo.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class IANSDateUtils {
	
public static String convertIntoWordDate(String inputDateFormat, String outputDateFormat, String inputDate) throws ParseException 
	
	{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(inputDateFormat, Locale.ENGLISH); 
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(outputDateFormat, Locale.ENGLISH); 
		LocalDate ld = LocalDate.parse(inputDate, dtf); 
		String outputText = dtf2.format(ld);
		
		return outputText;
	}

}
