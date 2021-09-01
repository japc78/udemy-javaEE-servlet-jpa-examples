package com.cursos.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan(basePackages = {"com.cursos.repository","com.cursos.service"})
@Configuration
@PropertySource(value = {"classpath:jndi.properties"})
public class SpringConfig {
	@Value("${ref-jndi}")
    private String refData;
	
	@Bean
    public DataSource dataSource() {
        JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource(refData);
    }
	
	//adaptador de Hibernate
	@Bean
	public HibernateJpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adp=new HibernateJpaVendorAdapter();
		adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adp;
	}
	//factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
	@Bean
	public LocalContainerEntityManagerFactoryBean factory(DataSource dataSource, HibernateJpaVendorAdapter adapter) {
		LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceUnitName("cursosPU");
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("com.cursos.model");
		factory.setJpaVendorAdapter(adapter);
		return factory;
	}
	
	//gestor de transacción
	@Bean
	public JpaTransactionManager txManager(LocalContainerEntityManagerFactoryBean factory) {
		JpaTransactionManager manager=new JpaTransactionManager();
		manager.setEntityManagerFactory(factory.getObject());
		return manager;
	}
}
