package com.konrad.task;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.lang.IllegalArgumentException;

import com.konrad.task.Language;

/**
 * Unit test for javatask-011118
 */
public class LanguageTest
    extends TestCase
{
    public LanguageTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( LanguageTest.class );
    }

    public void testApp()
    {
        // Arguement validity check test
	Language language = new Language("English","ENG");
	assertTrue(language instanceof Language);
	assertEquals("English", language.getName());
	assertEquals("ENG", language.getCode());

	try{
		new Language("Polish","PL");
		fail("Exception not thrown while it should");
	}catch(IllegalArgumentException e){assertTrue(e.getMessage().length() > 1);}
    }
}
