package com.konrad.task;

import java.util.Iterator;
import java.util.LinkedList;
import com.konrad.task.Company;
import com.konrad.task.Address;

public class Query
{
	protected LinkedList<Company> subject;
	protected Iterator<Company> iterator;
	public Query(LinkedList<Company> subject){this.subject = subject;}

	public LinkedList<Company> getSubject(){return subject;}

	public LinkedList<Company> searchByCity(String city)
	{
		LinkedList<Company> result = new LinkedList<Company>();
		iterator = subject.listIterator();
		while(iterator.hasNext()){
			Company company = iterator.next();
			LinkedList<Address> addresses = company.getAddresses();
			Iterator<Address> addressesIter = addresses.listIterator();
			while(addressesIter.hasNext()){
				Address address = addressesIter.next();
				if(address.getCity() == city)
				{
					result.add(company);
					break;
				}
			}
		}
		return result;
	}

	public void removeById(String id)
	{
		iterator = subject.listIterator();
		while(iterator.hasNext()) if(iterator.next().getIdentifier() == id)iterator.remove();
	}
	
	public LinkedList<Language> getAllLanguages()
	{
		LinkedList <Language> result = new LinkedList<Language>();
		iterator = subject.listIterator();
		do{
			Language language = iterator.next().getLanguage();
			if(!result.contains(language))result.add(language);
		}while(iterator.hasNext());

		return result;
	}
}
