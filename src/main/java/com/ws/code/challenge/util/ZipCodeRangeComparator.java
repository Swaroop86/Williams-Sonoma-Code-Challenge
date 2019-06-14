package com.ws.code.challenge.util;

import java.util.Comparator;

import com.ws.code.challenge.model.ZipCodeRange;

/**
 * Comparator to have the compare logic used to sort 2 zip code ranges
 * @author Swaroop Shivarudrappa
 *
 */
public class ZipCodeRangeComparator implements Comparator<ZipCodeRange> {

	@Override
	/**
	 * Compares 2 zipcode ranges based on their upper and lower bound.
	 * 
	 * @param range1 1st zip code range
	 * @param range2 2nd zip code range
	 * @return 
	 */
	public int compare(ZipCodeRange range1, ZipCodeRange range2) {
		
		//sort the list in ascending order based on lower bound value
		int compare = range1.getLowerBound() - range2.getLowerBound();
		
		//if lower bounds in 2 ranges matches compare against upperbounds
		if(compare==0) {
			compare = range1.getUpperBound() - range2.getUpperBound();
		}
		return compare;
	}

}
