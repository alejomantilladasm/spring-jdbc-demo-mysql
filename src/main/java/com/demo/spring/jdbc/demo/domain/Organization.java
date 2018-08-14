/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.spring.jdbc.demo.domain;

/**
 *
 * @author David
 */
public class Organization {

    private int id;
    private String companyName;
    private int yearOfIncorporation;
    private String postalCode;
    private int employeeCount;
    private String slogan;

    public Organization() {
    }

    public Organization(String companyName, int yearOfIncorporation, String postalCode, int employeeCount, String slogan) {
        this.companyName = companyName;
        this.yearOfIncorporation = yearOfIncorporation;
        this.postalCode = postalCode;
        this.employeeCount = employeeCount;
        this.slogan = slogan;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the yearOfIncorporation
     */
    public int getYearOfIncorporation() {
        return yearOfIncorporation;
    }

    /**
     * @param yearOfIncorporation the yearOfIncorporation to set
     */
    public void setYearOfIncorporation(int yearOfIncorporation) {
        this.yearOfIncorporation = yearOfIncorporation;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the employeeCount
     */
    public int getEmployeeCount() {
        return employeeCount;
    }

    /**
     * @param employeeCount the employeeCount to set
     */
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    /**
     * @return the slogan
     */
    public String getSlogan() {
        return slogan;
    }

    /**
     * @param slogan the slogan to set
     */
    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Override
    public String toString() {
        return "Organization{" + "id=" + id + ", companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation + ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", slogan=" + slogan + '}';
    }

}
