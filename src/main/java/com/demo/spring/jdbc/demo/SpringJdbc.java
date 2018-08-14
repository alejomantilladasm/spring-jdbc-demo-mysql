/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.spring.jdbc.demo;

import com.demo.spring.jdbc.demo.dao.OrganizationDao;
import com.demo.spring.jdbc.demo.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author David
 */
@Component
public class SpringJdbc {

    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private DaoUtils daoUtils;

    private void actionMethod() {        

        daoUtils.createSeedData(organizationDao);

        //Recuperar organizaciones e imprimir
        daoUtils.printOrganizations(organizationDao.readAll(), daoUtils.readOperation);

        //Crear nueva organizacion
        boolean isCreated = organizationDao.create(new Organization("Toyota", 1986, "87878", 30000, "Toyota slogan"));
        daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);

        Organization o = organizationDao.read(4);
        daoUtils.printOrganization(o, daoUtils.readOperation);

        boolean isUpdated = organizationDao.update(new Organization(3, "", 0, "", 0, "Slogan modificado de Google...!"));
        daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);

        o = organizationDao.read(3);
        daoUtils.printOrganization(o, daoUtils.readOperation);

        daoUtils.printOrganizationCount(organizationDao.readAll(), daoUtils.createOperation);

        boolean isDeleted = organizationDao.delete(new Organization(3));
        daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);

        daoUtils.printOrganizationCount(organizationDao.readAll(), daoUtils.createOperation);

        //Cleanup
        organizationDao.cleanUp();
        daoUtils.printOrganizationCount(organizationDao.readAll(), daoUtils.cleanupOperation);

        
    }
    
    public static void main(String[] args) {
        //Lectura de XML de spring con los beans
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
        
        SpringJdbc springJdbc=ctx.getBean(SpringJdbc.class);
        springJdbc.actionMethod();
        
        //Lectura de Bean 
        //OrganizationDao organizationDao = (OrganizationDao) ctx.getBean("organizationDao");
        
        ((ClassPathXmlApplicationContext) ctx).close();
    }

}
