package com.konrad.task;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.LinkedList;

import com.konrad.task.*;

/**
 * Unit test for javatask-011118
 */
public class QueryTest 
    extends TestCase
{
    public QueryTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( QueryTest.class );
    }

    public void testApp()
    {
    	Company ajaxInc = new Company("AJAX", "Ajax Incorporated", "+3254235523", new Address[]{new Address("Roadish","New Amsterdam", "23-325")}, new Language("English","ENG"), "YAMA");
	Company borningLtd = new Company("FEEL", "Borning Limited", "+4845345345", new Address[]{new Address("Lubelska","Tarnow", "33-100"), new Address("Lakowa","Chrszeszczyzeboszyce", "38-110")}, new Language("Polish", "POL"), "AJAX");
	Company conglomerate = new Company("CONG", "Just Conglomerate", "+5465465664", new Address[]{new Address("Palm Street","Freeville", "54-333"),new Address("Blanc vie","Lausanne", "32-358")}, new Language("French", "FRA"), "AJAX");
	Company dartSys = new Company("DART", "Dart Systems", "+543543543", new Address[]{new Address("Strainght","Tarnow", "00-708")}, new Language("Suahili", "SAH"), "CONG");
	Company electricRat = new Company("RATT");
	electricRat.setTelephone("+645646446");
	electricRat.setName("Electric Rattlesnake");
	
	LinkedList<Company> unordered = new LinkedList<Company>();
	unordered.add(ajaxInc);
	unordered.add(borningLtd);
	unordered.add(conglomerate);
	unordered.add(dartSys);
	unordered.add(electricRat);
	
	// Search in list by City - TEST
	Query query = new Query(unordered);
	LinkedList<Company> searchResult = query.searchByCity("Tarnow");
	assertEquals(2, searchResult.size());

	// Sort list by Company Name - TEST
	LinkedList<Company> ordered = new LinkedList<Company>();
	ordered.add(ajaxInc);
	ordered.add(borningLtd);
	ordered.add(dartSys);
	ordered.add(electricRat);
	ordered.add(conglomerate);
	
	unordered.sort(new CompanyComparator());
	assertEquals(ordered,unordered);

	// Remove company from list by ID - TEST
	query.removeById("DART");
	assertEquals(4,query.getSubject().size());

	// Get list of all languages and language codes from all companies - TEST
	LinkedList<Language> languages = query.getAllLanguages();
	assertEquals(3, languages.size());
    }
}
