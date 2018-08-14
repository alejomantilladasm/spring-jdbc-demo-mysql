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

/**
 *
 * @author David
 */
public class SpringJdbc {

    public static void main(String[] args) {

        //Lectura de XML de spring con los beans
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
        //Lectura de Bean 
        OrganizationDao organizationDao = (OrganizationDao) ctx.getBean("organizationDao");
        List<Organization> listaOrganization = organizationDao.readAll();
        System.out.println("Organizaciones... !");
        for (Organization o : listaOrganization) {
            System.out.println(o);
        }
    }

}
