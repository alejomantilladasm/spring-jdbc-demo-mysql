/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.spring.jdbc.demo.dao.impl;

import com.demo.spring.jdbc.demo.dao.OrganizationDao;
import com.demo.spring.jdbc.demo.domain.Organization;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository("organizationDao")
public class OrganizationDaoImpl implements OrganizationDao {

    private JdbcTemplate jdbcTemplate;
    
    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    @Override
    public boolean create(Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organization read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Organization> readAll() {
        String sqlQuery="select * from organization";
        List<Organization> listOrganization=jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
        return listOrganization;
    }

    @Override
    public boolean update(Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Organization organization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cleanUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
