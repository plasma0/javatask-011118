package com.konrad.task;

import com.konrad.task.Address;
import com.konrad.task.Language;
import java.util.LinkedList;

public class Company
{
	protected String identifier;
	protected String name;
	protected String telephone;
	protected LinkedList<Address> addresses;
	protected Language language;
	protected String parentCompany;

	public Company(String identifier)
	{
		this.identifier = identifier;
		addresses = new LinkedList<Address> ();
		language  = new Language("English","ENG");
	}

	public Company(String identifier, String name, String telephone, Address[] _addresses, Language language, String parentCompany)
	{
		this.identifier = identifier;
		this.name = name;
		this.telephone = telephone;
		this.language = language;
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
	public LinkedList<Address> getAdresses(){return addresses;}
	public Language getLanguage(){return language;}
	public String getParentCompany()
	{
		if(parentCompany == null)return "NULL";
		else return parentCompany;
	}

	public void setName(String name){this.name = name;}
	public void setTelephone(String telephone){this.telephone = telephone;}
	public void setLanguage(Language language){this.language = language;}
	public void setParentCompany(String parentCompany){this.parentCompany = parentCompany;}
}
