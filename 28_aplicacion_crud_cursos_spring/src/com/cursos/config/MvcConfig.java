package com.cursos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("com.cursos.controller")
@Configuration
@EnableWebMvc
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
		registry.addViewController("/").setViewName("menu");
		registry.addViewController("/toVolver").setViewName("menu");
        registry.addViewController("/toNuevo").setViewName("nuevo");
        registry.addViewController("/toSeleccionDuracion").setViewName("seleccionDuracion");
   }   
}
