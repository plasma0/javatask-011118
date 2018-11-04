package com.konrad.task;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.lang.IllegalArgumentException;

import com.konrad.task.Address;
import com.konrad.task.Language;
import com.konrad.task.Company;

/**
 * Unit test for javatask-011118
 */
public class CompanyTest 
    extends TestCase
{
    public CompanyTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( CompanyTest.class );
    }

    public void testApp()
    {
        // Arguement validity check test
	Address address = new Address("Krakowska","Tarnow","33-100");

	Company A = new Company("REGO");
	Company B = new Company("REGO", "RoxarCorp", "+13131414", new Address[]{address}, new Language("English","ENG"), "ROJO");

	assertEquals("REGO",A.getIdentifier());
	assertEquals("NULL",A.getTelephone());

	assertEquals("RoxarCorp", B.getName());

	try{
		new Company("REX");
		new Company("REGO", "RoxarCorp", "13131414", new Address[]{address}, new Language("English","ENG"), "ROJO");
		new Company("REGO", "RoxarCorp", "+13131414", new Address[]{address}, new Language("English","ENG"), "ROO");
		fail("Exception not thrown while it should");
	}catch(IllegalArgumentException e){assertTrue(e.getMessage().length() > 1);}
    }
}
