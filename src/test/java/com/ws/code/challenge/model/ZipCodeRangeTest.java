package com.ws.code.challenge.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for ZipCodeRange
 * @author Swaroop Shivarudrappa
 *
 */
public class ZipCodeRangeTest {
	
	@Test
	/**
	 * Test if ranges are compared properly
	 */
	public void testEquals() {
		ZipCodeRange range = new ZipCodeRange(94133,94199);
		ZipCodeRange equalsRange = new ZipCodeRange(94133,94199);
		ZipCodeRange notEqualsRange= new ZipCodeRange(94200,94299);
		
		Assert.assertEquals(range, equalsRange);
		Assert.assertNotEquals(range, notEqualsRange);	
	}

}
