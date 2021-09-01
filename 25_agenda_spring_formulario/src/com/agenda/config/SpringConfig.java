package com.agenda.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@ComponentScan(basePackages = {"com.agenda.repository","com.agenda.service"})
@Configuration
@PropertySource(value = {"classpath:jndi.properties"})
public class SpringConfig {
	
	@Value("${ref-jndi}")
    private String refData;
	/*@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource data=new DriverManagerDataSource();
		data.setDriverClassName("com.mysql.jdbc.Driver");
		data.setUrl("jdbc:mysql://localhost:3306/agenda");
		data.setUsername("root");
		data.setPassword("root");
		return data;
	}*/
	@Bean
    public DataSource dataSource() {
        JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource(refData);
    }
	
	@Bean 
	public JdbcTemplate getTemplate(DataSource datasource) {
		return new JdbcTemplate(datasource);
	}
}
