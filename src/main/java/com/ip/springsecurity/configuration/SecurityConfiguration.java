package com.ip.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("a").password("a").roles("USER");
        auth.inMemoryAuthentication().withUser("miekem").password("1234").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("gilles").password("1234").roles("ADMIN", "DBA");
        auth.inMemoryAuthentication().withUser("Sofie").password("GillesIsTheBest").roles("ADMIN", "DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/event/home**" , "/event/", "/event/rest/**").permitAll()
                .antMatchers("/event/eventOverview**", "/event/addEvent**").hasAnyRole("ADMIN")
                .and().formLogin().loginPage("/security/login")
                .usernameParameter("ssoId").passwordParameter("password")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/security/Access_Denied");
    }
}
