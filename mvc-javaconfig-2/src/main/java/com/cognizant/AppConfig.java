package com.cognizant;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.cognizant")
@PropertySource("classpath:db.properties")
public class AppConfig {
	@Autowired
	Environment environment;

	private final String DEV_URL = "DEV_URL";
	private final String DEV_USERNAME = "DEV_USERNAME";
	private final String DEV_DRIVER_CLASS = "DEV_DRIVER_CLASS";
	private final String DEV_PASSWORD = "DEV_PASSWORD";
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(environment.getProperty(DEV_DRIVER_CLASS));
        ds.setUrl(environment.getProperty(DEV_URL));
        ds.setUsername(environment.getProperty(DEV_USERNAME));
        ds.setPassword(environment.getProperty(DEV_PASSWORD));
        return ds;
	}
}
