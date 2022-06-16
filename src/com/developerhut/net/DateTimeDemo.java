package com.developerhut.net;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {

	public static void main(String[] args) {
		
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		//LocalDate sld = LocalDate.of(1976, 12, 23);
		LocalDate sld = LocalDate.of(1976, Month.DECEMBER, 23);
		System.out.println(sld);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String strDate = sld.format(dtf);
		System.out.println(strDate);
		
		LocalDate parsedDate = LocalDate.parse(strDate, dtf);
		System.out.println(parsedDate);
		
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		
		ZonedDateTime centralEstern = LocalDateTime.now().atZone(ZoneId.of("CET"));
		System.out.println(centralEstern);
		
		for (String zone : ZoneId.getAvailableZoneIds()) {
			System.out.println(zone);
		}
		
	}
}
