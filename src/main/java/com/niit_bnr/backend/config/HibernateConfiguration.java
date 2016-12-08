package com.niit_bnr.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages="com.niit_bnr.backend")
public class HibernateConfiguration {
	
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.driver");
		dataSource.setUrl("jdbc:h2:~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource();
	}
	
	@Autowired
	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBean sessionfactory=new LocalSessionFactoryBean();
		sessionfactory.setDataSource(dataSource);
		sessionfactory.setHibernateProperties(getHibernateProperties());
		sessionfactory.setPackagesToScan(new String[] {"com.niit.backendapp.model"});
		return sessionfactory;
		
	}
	
    public Properties getHibernateProperties()
    {
    	Properties properties=new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        return properties;
         }
     @Autowired
     @Bean
     
     public HibernateTransactionManager gettransactionManager(SessionFactory sessionfactory)
     {
      HibernateTransactionManager transactionManager=new HibernateTransactionManager();
      transactionManager.setSessionFactory(sessionfactory);
      return transactionManager;
     }
    
    }

							