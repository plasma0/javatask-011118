package com.konrad.task;

import com.konrad.task.Company;
import com.konrad.task.App;
import com.konrad.task.Query;
import com.konrad.task.CompanyComparator;
import com.konrad.task.Language;

import java.util.LinkedList;
import java.util.Iterator;
/**
 * Konrad Kania
 * Java Task
 *
 * All given lotations are fictional
 */

public class App 
{
    public static void main( String[] args )
    {
    try{
    	Company ajaxInc = new Company("AJAX", "Ajax Incorporated", "+3254235523", new Address[]{new Address("Roadish","New Amsterdam", "23-325")}, new Language("English","ENG"), "YAMA");
	Company borningLtd = new Company("FEEL", "Zorning Limited", "+4845345345", new Address[]{new Address("Lubelska","Tarnow", "33-100"), new Address("Lakowa","Chrszeszczyzeboszyce", "38-110")}, new Language("Polish", "POL"), "AJAX");
	Company conglomerate = new Company("CONG", "Just Conglomerate", "+5465465664", new Address[]{new Address("Palm Street","Freeville", "54-333"),new Address("Blanc vie","Lausanne", "32-358")}, new Language("French", "FRA"), "AJAX");
	Company dartSys = new Company("DART", "Dart Systems", "+543543543", new Address[]{new Address("Strainght","City of Lights", "00-708")}, new Language("Suahili", "SAH"), "CONG");
	Company electricRat = new Company("RATT");
	electricRat.setTelephone("+645646446");
	electricRat.setName("Electric Rattlesnake");

	LinkedList<Company> list = new LinkedList<Company>();
	list.add(ajaxInc);
	list.add(borningLtd);
	list.add(conglomerate);
	list.add(dartSys);
	list.add(electricRat);

	Query query = new Query(list);

	// Search in list by City
	LinkedList<Company> searchResult = query.searchByCity("Tarnow");
	Iterator<Company> searchIterator = searchResult.listIterator();
	while(searchIterator.hasNext())System.out.println(searchIterator.next().getName());
	System.out.println("---------------------------------------------------");

	// Sort list by Company Name
	list.sort(new CompanyComparator());
	Iterator<Company> companyIterator = list.listIterator();
	while(companyIterator.hasNext())System.out.println(companyIterator.next().getName());
	System.out.println("---------------------------------------------------");

	// Remove company from list by ID
	query.removeById("DART");
	Iterator<Company> savedElementsIterator = query.getSubject().listIterator();
	while(savedElementsIterator.hasNext())System.out.println(savedElementsIterator.next().getName());
	System.out.println("---------------------------------------------------");

	// Get list of all languages and language codes from all companies
	LinkedList<Language> languages = query.getAllLanguages();
	Iterator<Language> languagesIterator = languages.listIterator();
	while(languagesIterator.hasNext())
	{
		Language language = languagesIterator.next();
		System.out.println(language.getName()+" : "+language.getCode());
	}

    }catch(IllegalArgumentException exception){System.out.println("EXCEPTION: "+exception.getMessage());}
    }
}
