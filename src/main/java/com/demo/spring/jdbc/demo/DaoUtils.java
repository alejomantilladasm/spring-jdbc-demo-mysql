/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.spring.jdbc.demo;

import com.demo.spring.jdbc.demo.dao.OrganizationDao;
import com.demo.spring.jdbc.demo.domain.Organization;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class DaoUtils {

    public final String createOperation = "CREATE";
    public final String readOperation = "READ";
    public final String updateOperation = "UPDATE";
    public final String deleteOperation = "DELETE";
    public final String cleanupOperation = "TRUNCATE";

    public void printOrganizations(List<Organization> organizations, String operation) {
        System.out.println("\nMostrar organizaciones al " + operation);
        for (Organization o : organizations) {
            System.out.println(" * " + o);
        }
    }

    public void printOrganization(Organization organizations, String operation) {
        System.out.println("\nMostrar organizacion al " + operation);
        System.out.println(" * " + organizations);
    }

    public void printSuccessFailure(String operation, boolean param) {
        if (param) {
            System.out.println("\nOperation " + operation + " Successful");
        } else {
            System.out.println("\nOperation " + operation + " failed");
        }
    }

    public void createSeedData(OrganizationDao organizationDao) {
        List<Organization> organizations = new ArrayList<>();
        organizations.add(0, new Organization("BMW", 1929, "45456", 10000, "BMW Slogan"));
        organizations.add(1, new Organization("Amazon", 1994, "75757", 20000, "Amazon Slogan"));
        organizations.add(2, new Organization("Google", 1980, "666", 30000, "Google Slogan"));
        int count = 0;
        for (Organization o : organizations) {
            boolean isCreated = organizationDao.create(o);
            if (isCreated) {
                count++;
            }
        }
        System.out.println("\nCreated " + count + " organizations.");

    }

    public void printOrganizationCount(List<Organization> organizations, String operation) {
        System.out.println("\nActualmente se tiene " + organizations.size() + " organizaciones despues de la operacion de " + operation);
    }
}
