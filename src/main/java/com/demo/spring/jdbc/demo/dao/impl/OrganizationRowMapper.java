/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.spring.jdbc.demo.dao.impl;

import com.demo.spring.jdbc.demo.domain.Organization;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author David
 */
public class OrganizationRowMapper implements RowMapper<Organization> {

    @Override
    public Organization mapRow(ResultSet rs, int i) throws SQLException {

        Organization organization = new Organization();
        organization.setId(rs.getInt("id"));
        organization.setCompanyName(rs.getString("company_name"));
        organization.setYearOfIncorporation(rs.getInt("year_of_incorporation"));
        organization.setPostalCode(rs.getString("postal_code"));
        organization.setEmployeeCount(rs.getInt("employee_count"));
        organization.setSlogan(rs.getString("slogan"));

        return organization;
    }

}
