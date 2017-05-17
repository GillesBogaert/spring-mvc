/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.configuration;

import com.ip.events.service.EventService;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ApplicationConfig {

    @Bean (destroyMethod ="close")
    public EventService service() {
        return new EventService("Memory");
    }
    
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource result
            = new ResourceBundleMessageSource();
 
        String[] basenames = {
            "locale.messages"
            
        };
 
        result.setBasenames(basenames);
 
        return result;
 
    }
 
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
 
        LocaleChangeInterceptor result = new LocaleChangeInterceptor();
        result.setParamName("lang");
 
        return result;
 
    }
 
    @Bean
    public LocaleResolver localeResolver() {
 
        SessionLocaleResolver result = new SessionLocaleResolver();
        result.setDefaultLocale(Locale.ENGLISH);
 
        return result;
 
    }
    
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
    


    
}
