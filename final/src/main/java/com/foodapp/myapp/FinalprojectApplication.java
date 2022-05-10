package com.foodapp.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan({"com.foodapp.myapp.controller","com.foodapp.myapp.dao","com.foodapp.myapp.pojo","com.foodapp.myapp.validator"})
public class FinalprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalprojectApplication.class, args);
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() 
    {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(10000000);
	    return multipartResolver;
	}

	   @Bean
	    public PasswordEncoder getPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
