package com.mouritech.rolebasedstaffapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private static final String MANAGER = "MANAGER";
	private static final String SALESPERSON = "SALESPERSON";
	private static final String CEO = "CEO";
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http1) throws Exception {
		http1.authorizeRequests().antMatchers("/ceo").hasRole(CEO)
								 .antMatchers("/manager").hasAnyRole(MANAGER,CEO)
								 .antMatchers("/salesperson").hasAnyRole(MANAGER,SALESPERSON,CEO)
								 .antMatchers("/all").permitAll()
								 .and().formLogin();
		}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
