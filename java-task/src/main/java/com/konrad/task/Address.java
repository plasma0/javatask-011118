package com.konrad.task;

import java.lang.IllegalArgumentException;

public class Address
{
	private String street;
	private String city;
	private String zipCode;

	public Address(String street, String city, String zipCode) throws IllegalArgumentException
	{
		this.street = street;
		this.city = city;
		if(!zipCode.matches("([0-9]{2}\\-[0-9]{3})")) throw new IllegalArgumentException("Zip code need to follow DD-DDD template where D is single digit");
		this.zipCode = zipCode;
	}

	public String getStreet(){return street;}
	public String getCity(){return city;}
	public String getZipCode(){return zipCode;}
}
