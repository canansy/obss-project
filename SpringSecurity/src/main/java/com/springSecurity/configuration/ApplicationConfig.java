package com.springSecurity.configuration;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan(basePackages = "com.springSecurity")
@EnableWebMvc
@PropertySource(value={"classpath:application.properties"})
public class ApplicationConfig {
	
	@Autowired
	private Environment env;
	
	 @Bean
	   public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
	        return dataSource;
	    }
	

	    protected void configure(HttpSecurity http) throws Exception {
	        
	    	http
	        .cors().and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().and()
	        .authorizeRequests()
	        .antMatchers("**").permitAll()
	        .and()
	        .csrf().disable();
	    }
	    
	    @Bean
	    public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	          registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "GET", "PUT","DELETE");
	        }
	      };
	    }


}