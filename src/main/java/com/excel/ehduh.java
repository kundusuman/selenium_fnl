package com.excel;

public class ehduh 
{
	public static void main(String args[])
	{
		String s=String.valueOf(java.time.LocalTime.now());
		s=s.replaceAll(":", "");
		
	System.out.println(s);
	}
}
