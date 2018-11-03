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
}
