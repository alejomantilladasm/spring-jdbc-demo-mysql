/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.spring.jdbc.demo.dao;

import com.demo.spring.jdbc.demo.domain.Organization;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author David
 */
public interface OrganizationDao {
    
    //Requerido para realizar la conexion con la base de datos.
    public void setDataSource(DataSource ds);
        
    public boolean create(Organization organization);
    public Organization read(int id);
    public List<Organization> readAll();
    public List<Organization> readErrorAll();
    public boolean update(Organization organization);
    public boolean delete(Organization organization);
    
    public void cleanUp();
    
}
