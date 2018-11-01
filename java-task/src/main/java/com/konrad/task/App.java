package com.konrad.task;

import com.konrad.task.Company;
/**
 * Konrad Kania
 * Java Task
 */

public class App 
{
    public static void main( String[] args )
    {
    	Company company = new Company("Barlog");
        System.out.println( company.getIdentifier() );
	System.out.println( company.getParentCompany() );
    }
}
