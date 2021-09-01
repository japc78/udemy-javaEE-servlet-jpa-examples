package com.formacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@ComponentScan(basePackages= {"com.formacion.controller"})
@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer{
	@Bean
	 public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	 }
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/volver").setViewName("datos");
        registry.addViewController("/").setViewName("datos");
    }   
}
