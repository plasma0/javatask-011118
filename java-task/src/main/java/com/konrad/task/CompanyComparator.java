package com.konrad.task;

import com.konrad.task.Company;
import java.util.Comparator;

public class CompanyComparator implements Comparator<Company>
{
	@Override
	public int compare(Company A, Company B)
	{
		return A.getName().compareTo(B.getName());
	}
}
