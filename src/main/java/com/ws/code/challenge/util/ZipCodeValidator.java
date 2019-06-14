package com.ws.code.challenge.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Util class to valid the zip code pattern
 * @author Swaroop Shivarudrappa
 *
 */
public class ZipCodeValidator {
	
	//The patter checks if the input is within "[]" square brackets and contqins exactly 5 digits
	private static final Pattern zipCodeRangePattern = Pattern.compile("\\[\\d{5},\\d{5}\\]");
	
	/**
	 * 
	 * @param The range in the format [94133,94133]
	 * @return true if valid else false
	 */
	public static boolean isValidZipCodeRange(String range) {
		if(range==null || range.length()==0) return false;
		
		Matcher matcher = zipCodeRangePattern.matcher(range);
		return matcher.matches();
	}

}
