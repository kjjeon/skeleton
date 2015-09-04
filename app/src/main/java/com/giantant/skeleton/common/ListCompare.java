package com.giantant.skeleton.common;

import java.util.Comparator;

public class ListCompare {

	public static Comparator<Integer> IntergerFCompare = new Comparator<Integer>()
	{
	    @Override
	    public int compare(Integer lhs, Integer rhs)
	    {
	        return lhs.compareTo(rhs);
	    }
	};
	
	public static Comparator<Integer> IntergerRCompare = new Comparator<Integer>()
	{
	    @Override
	    public int compare(Integer lhs, Integer rhs)
	    {
	        return rhs.compareTo(lhs);
	    }
	};
}
