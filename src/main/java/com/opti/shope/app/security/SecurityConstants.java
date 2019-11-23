package com.opti.shope.app.security;

public class SecurityConstants {
	private SecurityConstants() {
		throw new IllegalStateException("utility class");
	}
	public static final long TOKEN_EXPIRATION_TIME = 864000000; // 10 DAYS
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users";
	public static final String TOKEN_SECRET = "M4R4TH496K";


}
