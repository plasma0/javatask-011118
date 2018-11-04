package com.konrad.task;

import java.lang.IllegalArgumentException;

public class Language
{
	private String name;
	private String code;

	public Language(String name, String code) throws IllegalArgumentException
	{
		this.name = name;
		if(!code.matches("([A-Z]{3})")) throw new IllegalArgumentException("Language code need to be three capital letters");
		this.code = code;
	}

	public String getName(){return name;}
	public String getCode(){return code;}

	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Language))return false;
		return (((Language)obj).getName().equals(this.name) && ((Language)obj).getCode().equals(this.code));
	}

	@Override
	public int hashCode()
	{
		return 7*this.name.hashCode()+this.code.hashCode();
	}
}
