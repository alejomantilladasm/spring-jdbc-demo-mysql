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
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean create(Organization organization) {
        String sqlQuery = "insert into organization (company_name, year_of_incorporation, postal_code, employee_count, slogan)"
                + "values (?, ?, ?, ?, ?)";

        Object[] args = new Object[]{organization.getCompanyName(), organization.getYearOfIncorporation(),
            organization.getPostalCode(), organization.getEmployeeCount(), organization.getSlogan()};

        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    @Override
    public Organization read(int id) {
        String sqlQuery = "select * from organization where id = ?";
        Object[] args = new Object[]{id};
        Organization organization = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
        return organization;
    }

    @Override
    public List<Organization> readAll() {
        String sqlQuery = "select * from organization";
        List<Organization> listOrganization = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
        return listOrganization;
    }

    @Override
    public boolean update(Organization organization) {
        String sqlQuery = "update organization set slogan = ?  where id = ?";
        Object[] args = new Object[]{organization.getSlogan(), organization.getId()};
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    @Override
    public boolean delete(Organization organization) {
        String sqlQuery = "delete from organization where id = ?";
        Object[] args = new Object[]{organization.getId()};
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    @Override
    public void cleanUp() {
        String sqlQuery = "TRUNCATE TABLE organization";
        jdbcTemplate.execute(sqlQuery);
    }

}
