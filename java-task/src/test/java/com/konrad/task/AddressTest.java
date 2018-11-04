package com.konrad.task;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.lang.IllegalArgumentException;

import com.konrad.task.Address;

/**
 * Unit test for javatask-011118
 */
public class AddressTest 
    extends TestCase
{
    public AddressTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AddressTest.class );
    }

    public void testApp()
    {
        // Arguement validity check test
	Address address = new Address("Krakowska","Tarnow","33-100");
	assertEquals("Krakowska", address.getStreet());
	assertEquals("Tarnow", address.getCity());
	assertEquals("33-100", address.getZipCode());

	try{
		new Address("Krakowska","Tarnow","33100");
		fail("Exception not thrown while it should");
	}catch(IllegalArgumentException e){assertTrue(e.getMessage().length() > 1);}
    }
}
