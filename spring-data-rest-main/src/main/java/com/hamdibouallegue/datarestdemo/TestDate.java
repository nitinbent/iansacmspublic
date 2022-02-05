package com.hamdibouallegue.datarestdemo;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.hamdibouallegue.datarestdemo.utils.IANSDateUtils;

public class TestDate {
	
	public static void main(String[] args) {
		
		/*
		 * String inputDate = "21/12/2021"; DateTimeFormatter dtf =
		 * DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH); DateTimeFormatter
		 * dtf2 = DateTimeFormatter.ofPattern("MMM yyyy", Locale.ENGLISH); LocalDate ld
		 * = LocalDate.parse(inputDate, dtf); String month_name = dtf2.format(ld);
		 * System.out.println(month_name);
		 */
		
		
		  try {
			String inputDate = "2022-02-28"; 
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH); 
			  DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH); 
			  LocalDate ld = LocalDate.parse(inputDate, dtf); 
			  String month_name = dtf2.format(ld);
			  System.out.println(month_name);
			 
			  System.out.println(IANSDateUtils.convertIntoWordDate("yyyy-MM-dd", "dd MMMM yyyy", "2022-02-28"));
			  
			  
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH)));
		
	}

}
