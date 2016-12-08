package com.niit_bnr.backendapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit_bnr.backend.DAO.PersonDAO;
import com.niit_bnr.backend.config.HibernateConfiguration;
import com.niit_bnr.backend.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	
    public static void main( String[] args )
    {
    	
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(HibernateConfiguration.class);
    	context.scan("com.niit_bnr.backend");
    	context.refresh();
    	
    	PersonDAO personDAO=(PersonDAO)context.getBean("personDAO");	
    			
    	Person person=new Person();
    	person.setname("bin");
    	person.setcountry("India");
    	
    	personDAO.addPerson(person);
        System.out.println( "Hello World!" );
    }
}
