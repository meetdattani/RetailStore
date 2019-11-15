package com.myRetail.store.config;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/* 
	 * 2 sample users are created,admin and normal user 
	 * */
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("user").password("{noop}storeUser").roles("USER").and().withUser("admin").password("{noop}adminUser").roles("USER","ADMIN");
	}
	
	/*
	 * securing API's here
	 */	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.httpBasic().and().authorizeRequests().anyRequest().hasRole("USER").and().csrf().disable();
		
	}
}
