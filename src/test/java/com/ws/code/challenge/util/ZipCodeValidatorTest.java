package com.ws.code.challenge.util;

import org.junit.Assert;
import org.junit.Test;

public class ZipCodeValidatorTest {
	
	@Test
	public void testValidZipRanges() {

		Assert.assertEquals(true, ZipCodeValidator.isValidZipCodeRange("[94133,94166]"));
		Assert.assertEquals(true, ZipCodeValidator.isValidZipCodeRange("[94200,94299]"));
	}
	
	/**
	 * Test various invalid zip code strings.
	 */
	@Test
	public void testInvalidZipRanges() {
		//Invalid pattern
		Assert.assertEquals(false, ZipCodeValidator.isValidZipCodeRange("[94133,83jdhjd]"));
		
		//Above 5 digit zipcode
		Assert.assertEquals(false, ZipCodeValidator.isValidZipCodeRange("[941335,947890"));
		
		//Missing brackets
		Assert.assertEquals(false, ZipCodeValidator.isValidZipCodeRange("9427894568]"));
		
		//Empty input
		Assert.assertEquals(false, ZipCodeValidator.isValidZipCodeRange("[]"));
		
		//missing upper bound
		Assert.assertEquals(false, ZipCodeValidator.isValidZipCodeRange("[94200,]"));
				
		//missing lower bound
		Assert.assertEquals(false, ZipCodeValidator.isValidZipCodeRange("[,94299]"));
		
		//special characters
		Assert.assertEquals(false, ZipCodeValidator.isValidZipCodeRange(null));
		
	}

}
