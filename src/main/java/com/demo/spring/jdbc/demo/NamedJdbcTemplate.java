/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.spring.jdbc.demo;

import com.demo.spring.jdbc.demo.dao.OrganizationDao;
import com.demo.spring.jdbc.demo.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author David
 */
public class NamedJdbcTemplate {
    public static void main(String[] args) {
        
        
        //Lectura de XML de spring con los beans
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
        //Lectura de Bean 
        OrganizationDao organizationDao = (OrganizationDao) ctx.getBean("organizationDao");

        DaoUtils.createSeedData(organizationDao);

        //Recuperar organizaciones e imprimir
        DaoUtils.printOrganizations(organizationDao.readAll(), DaoUtils.readOperation);

        //Crear nueva organizacion
        boolean isCreated = organizationDao.create(new Organization("Toyota", 1986, "87878", 30000, "Toyota slogan"));
        DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);

        Organization o = organizationDao.read(4);
        DaoUtils.printOrganization(o, DaoUtils.readOperation);


        //Cleanup
        organizationDao.cleanUp();
        DaoUtils.printOrganizationCount(organizationDao.readAll(), DaoUtils.cleanupOperation);

        ((ClassPathXmlApplicationContext) ctx).close();
        
        
    }
}
