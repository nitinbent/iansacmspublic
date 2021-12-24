package com.hamdibouallegue.datarestdemo;

public class TestSplit {
	
	public static void main(String[] args) {
		
		String spliStr = "IANS/21-22/N21";
		
		System.out.println(spliStr.split("/")[2].split("N")[1]);
		
	}

}
