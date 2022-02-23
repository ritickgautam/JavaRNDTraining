package com.ritick.lms.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity

public class Configuration extends WebSecurityConfigurerAdapter{

	  @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()

	                .withUser("user").password("admin").roles("USER").and()
	                .withUser("demo").password("test2").roles("ADMIN");
	    }

	  @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {

	        httpSecurity
	                .authorizeRequests()
	                .anyRequest()
	                .fullyAuthenticated()
	                .and()
	                .oauth2Login();
	        httpSecurity.csrf().disable();

	    }


}
