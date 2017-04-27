package com.mum.group2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.ui.Model;

public class Utils {
	
	public static void serverTime(Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.getDefault());

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
	}
	
}
