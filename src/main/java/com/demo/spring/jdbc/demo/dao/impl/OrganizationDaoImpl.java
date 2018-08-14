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
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository("organizationDao")
public class OrganizationDaoImpl implements OrganizationDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        //JdbcTemplate
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        //NamedParameterJdbcTemplate
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public boolean create(Organization organization) {
        //JdbcTemplate
//        String sqlQuery = "insert into organization (company_name, year_of_incorporation, postal_code, employee_count, slogan)"
//                + "values (?, ?, ?, ?, ?)";
//        Object[] args = new Object[]{organization.getCompanyName(), organization.getYearOfIncorporation(),
//            organization.getPostalCode(), organization.getEmployeeCount(), organization.getSlogan()};
//        return jdbcTemplate.update(sqlQuery, args) == 1;

        //NamedParameterJdbcTemplate
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(organization);
        String sqlQuery = "insert into organization (company_name, year_of_incorporation, postal_code, employee_count, slogan)"
                + "values (:companyName, :yearOfIncorporation, :postalCode, :employeeCount, :slogan)";

        Object[] args = new Object[]{organization.getCompanyName(), organization.getYearOfIncorporation(),
            organization.getPostalCode(), organization.getEmployeeCount(), organization.getSlogan()};

        return namedParameterJdbcTemplate.update(sqlQuery, parameterSource) == 1;
    }

    @Override
    public Organization read(int id) {
        //JdbcTemplate
//        String sqlQuery = "select * from organization where id = ?";
//        Object[] args = new Object[]{id};
//        Organization organization = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
//        return organization;

        //NamedParameterJdbcTemplate
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        String sqlQuery = "select * from organization where id = :id";
        Organization organization = namedParameterJdbcTemplate.queryForObject(sqlQuery, parameterSource, new OrganizationRowMapper());
        return organization;
    }

    @Override
    public List<Organization> readAll() {
        //JdbcTemplate
//        String sqlQuery = "select * from organization";
//        List<Organization> listOrganization = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
//        return listOrganization;
        //NamedParameterJdbcTemplate
        String sqlQuery = "select * from organization";
        List<Organization> listOrganization = namedParameterJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
        return listOrganization;
    }

    @Override
    public boolean update(Organization organization) {
        //JdbcTemplate
//        String sqlQuery = "update organization set slogan = ?  where id = ?";
//        Object[] args = new Object[]{organization.getSlogan(), organization.getId()};
//        return jdbcTemplate.update(sqlQuery, args) == 1;
        //NamedParameterJdbcTemplate
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(organization);
        String sqlQuery = "update organization set slogan = :slogan  where id = :id";
        return namedParameterJdbcTemplate.update(sqlQuery, parameterSource) == 1;

    }

    @Override
    public boolean delete(Organization organization) {
        //JdbcTemplate
//        String sqlQuery = "delete from organization where id = ?";
//        Object[] args = new Object[]{organization.getId()};
//        return jdbcTemplate.update(sqlQuery, args) == 1;
        //NamedParameterJdbcTemplate
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(organization);
        String sqlQuery = "delete from organization where id = :id";
        return namedParameterJdbcTemplate.update(sqlQuery, parameterSource) == 1;
    }

    @Override
    public void cleanUp() {
        String sqlQuery = "TRUNCATE TABLE organization";
        //JdbcTemplate
        //jdbcTemplate.execute(sqlQuery);
        //NamedParameterJdbcTemplate
        namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);

    }

    @Override
    public List<Organization> readErrorAll() {
        String sqlQuery = "sele * from organization";
        List<Organization> listOrganization = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
        return listOrganization;
    }

}
