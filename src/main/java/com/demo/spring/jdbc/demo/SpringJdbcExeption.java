/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.spring.jdbc.demo;

import com.demo.spring.jdbc.demo.dao.OrganizationDao;
import com.demo.spring.jdbc.demo.domain.Organization;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

/**
 *
 * @author David
 */
public class SpringJdbcExeption {

    public static void main(String[] args) {

        //Lectura de XML de spring con los beans
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
        //Lectura de Bean 
        OrganizationDao organizationDao = (OrganizationDao) ctx.getBean("organizationDao");

        try {
            List<Organization> organizations = organizationDao.readErrorAll();
            for (Organization o : organizations) {
                System.out.println(o);
            }

        } catch (BadSqlGrammarException bsge) {
            System.out.println("Sub Message : " + bsge.getMessage());
            System.out.println("Sub Class : " + bsge.getClass());
        } catch (DataAccessException dae) {
            System.out.println("Message : " + dae.getMessage());
            System.out.println("Class : " + dae.getClass());
        }

        ((ClassPathXmlApplicationContext) ctx).close();

    }

}
