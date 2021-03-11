package com.opti.shope.app.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.opti.shope.service.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	public final UserService userDetailsService;

	public final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//configure http API endpoints
		http.cors().and().csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.POST,SecurityConstants.SIGN_UP_URL).permitAll()
		.anyRequest().authenticated().and()
		.addFilter(getAuthenticationFilter())
		
		//authorization for api
		.addFilter(new AuthorizationFilter(authenticationManager()))
		//creating services session less(state-less) so that server will not maintain any session. 
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	//Sets the URL that determines if authentication is required
	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter filter=new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/users/login");
		return filter;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	

}
