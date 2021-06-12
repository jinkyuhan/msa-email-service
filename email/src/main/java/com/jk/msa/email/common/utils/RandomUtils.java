package com.jk.msa.email.common.utils;

import java.util.Random;

public class RandomUtils {
	public static String getRandomString(int length) {
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		String sourceChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0; i < length; i++) {
			buffer.append(sourceChars.charAt(random.nextInt(sourceChars.length())));
		}
		
		return buffer.toString();
	}
}
