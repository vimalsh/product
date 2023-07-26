package com.deadly.java8.topics;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

@Service
public class DateTimeAPI {
	public void run() {
		try {
//			LocalDate
//			LocalDate localDateNow = LocalDate.now(); //create a localDate
//			LocalDate localDateOf = LocalDate.of(2020,8,28);
//			LocalDate localDateParse = LocalDate.parse("2022-08-22");
//			System.out.println("localDateNow===="+localDateNow);
//			System.out.println("localDateOf===="+localDateOf);
//			System.out.println("localDateParse===="+localDateParse);
//			LocalDateTIme
			LocalDateTime localDateTime = LocalDateTime.now().minusHours(2);
			System.out.println("localDateTime=="+localDateTime);
			ZoneId zone = ZoneId.of("UTC");
			ZonedDateTime zoneDateTime = ZonedDateTime.now(zone);
			System.out.println("ZonedDateTime=="+zoneDateTime);
			// convert LocalDateTime to ZonedDateTime, with default system zone id
	        ZonedDateTime zonedDateTime1 = localDateTime.atZone(zone);
			System.out.println("zoneDateTime1=="+zonedDateTime1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
