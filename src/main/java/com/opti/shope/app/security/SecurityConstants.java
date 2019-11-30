package com.opti.shope.app.security;

import com.opti.shope.SpringApplicationContext;

public class SecurityConstants {

	public static final long TOKEN_EXPIRATION_TIME = 864000000; // 10 DAYS
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users";
	public static final String TOKEN_SECRET = "TOKEN_SECRET";
	public static final AppProperties appProperties = SpringApplicationContext.getBean("appProperties",
			AppProperties.class);

	private SecurityConstants() {
		throw new IllegalStateException("utility class");
	}

	public static String getSecretToken() {
		return appProperties.getProperties(TOKEN_SECRET);
	}

}
