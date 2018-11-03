package com.konrad.task;

import com.konrad.task.Address;
import com.konrad.task.Language;
import java.util.LinkedList;
import java.util.Comparator;
import java.lang.IllegalArgumentException;

public class Company
{
	protected String identifier;
	protected String name;
	protected String telephone;
	protected LinkedList<Address> addresses;
	protected Language language;
	protected String parentCompany;

	public Company(String identifier) throws IllegalArgumentException
	{
		if(!identifier.matches("([A-Z]{4})")) throw new IllegalArgumentException("Identifier need to be four capital letters");
		this.identifier = identifier;
		addresses = new LinkedList<Address> ();
		language  = new Language("English","ENG");
	}

	public Company(String identifier, String name, String telephone, Address[] _addresses, Language language, String parentCompany) throws IllegalArgumentException
	{
		if(!identifier.matches("([A-Z]{4})")) throw new IllegalArgumentException("Identifier need to be four capital letters");
		this.identifier = identifier;
		this.name = name;
		if(!telephone.matches("(\\+[0-9]{2}[0-9]+)")) throw new IllegalArgumentException("Telephone number need to be with country prefix");
		this.telephone = telephone;
		this.language = language;
		if(!parentCompany.matches("([A-Z]{4})")) throw new IllegalArgumentException("Idetifier of parent company need to be four capital letters");
		this.parentCompany = parentCompany;

		addresses = new LinkedList<Address>();
		for(int i = 0; i < _addresses.length; i++) addresses.add(_addresses[i]);
	}

	public String getIdentifier(){return identifier;}
	public String getName()
	{
		if(name == null)return "NULL";
		else return name;
	}
	public String getTelephone()
	{
		if(telephone == null)return "NULL";
		else return telephone;
	}
	public LinkedList<Address> getAddresses(){return addresses;}
	public Language getLanguage(){return language;}
	public String getParentCompany()
	{
		if(parentCompany == null)return "NULL";
		else return parentCompany;
	}

	public void setName(String name) throws IllegalArgumentException{this.name = name;}
	public void setTelephone(String telephone) throws IllegalArgumentException
	{
		if(!telephone.matches("(\\+[0-9]{2}[0-9]+)")) throw new IllegalArgumentException("Telephone number need to be with country prefix");
		this.telephone = telephone;
	}
	public void setLanguage(Language language){this.language = language;}
	public void setParentCompany(String parentCompany) throws IllegalArgumentException
	{
		if(!parentCompany.matches("([A-Z]{4})")) throw new IllegalArgumentException("Idetifier of parent company need to be four capital letters");
		this.parentCompany = parentCompany;
	}
}
