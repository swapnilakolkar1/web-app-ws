package com.opti.shope.shared.uility;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomIdGenUtil {
	private static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-";
	private final Random random = new SecureRandom();

	public String generateUserID(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(ALPHABETS.charAt(random.nextInt(ALPHABETS.length())));
		}
		return new String(sb);
	}
}
