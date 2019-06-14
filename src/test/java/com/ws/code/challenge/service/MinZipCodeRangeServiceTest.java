package com.ws.code.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ws.code.challenge.model.ZipCodeRange;

/**
 * Test class for  MinZipCodeRangeService
 * 
 * @author Swaroop Shivarudrappa
 *
 */
public class MinZipCodeRangeServiceTest {
	
	@Test
	/**
	 * Test case where range cannot be minimized as there is no overlap
	 * [94133,94133] [94200,94299] [94400,94600]
	 */
	public void testCase1() {
		ZipCodeRange zp1 = new ZipCodeRange(94133,94133);
		ZipCodeRange zp2 = new ZipCodeRange(94200,94299);
		ZipCodeRange zp3 = new ZipCodeRange(94600,94699);
		
		List<ZipCodeRange> input = new ArrayList<>();
		input.add(zp1);
		input.add(zp2);
		input.add(zp3);
		
		List<ZipCodeRange> actual = MinZipCodeRangeService.validateRange(input);
		List<ZipCodeRange> expected =new ArrayList<>();
		ZipCodeRange ezp1 = new ZipCodeRange(94133,94133);
		ZipCodeRange ezp2 = new ZipCodeRange(94200,94299);
		ZipCodeRange ezp3 = new ZipCodeRange(94600,94699);
		expected.add(ezp1);
		expected.add(ezp2);
		expected.add(ezp3);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	/**
	 * Test case where range can be minimized
	 * [94133,94133] [94200,94299] [94266,94400]
	 */
	public void testCase2() {
		ZipCodeRange zp1 = new ZipCodeRange(94133,94133);
		ZipCodeRange zp2 = new ZipCodeRange(94200,94299);
		ZipCodeRange zp3 = new ZipCodeRange(94226,94399);
		
		List<ZipCodeRange> input = new ArrayList<>();
		input.add(zp1);
		input.add(zp2);
		input.add(zp3);
		
		List<ZipCodeRange> actual = MinZipCodeRangeService.validateRange(input);
		List<ZipCodeRange> expected =new ArrayList<>();
		ZipCodeRange ezp1 = new ZipCodeRange(94133,94133);
		ZipCodeRange ezp2 = new ZipCodeRange(94200,94399);
		expected.add(ezp1);
		expected.add(ezp2);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	/**
	 * Test case where all ranges are equal hence resulting in just 1 range
	 * [94200,94200] [94200,94200] [94200,94200]
	 */
	public void testCase3() {
		ZipCodeRange zp1 = new ZipCodeRange(94200,94200);
		ZipCodeRange zp2 = new ZipCodeRange(94200,94200);
		ZipCodeRange zp3 = new ZipCodeRange(94200,94200);
		
		List<ZipCodeRange> input = new ArrayList<>();
		input.add(zp1);
		input.add(zp2);
		input.add(zp3);
		
		List<ZipCodeRange> actual = MinZipCodeRangeService.validateRange(input);
		List<ZipCodeRange> expected =new ArrayList<>();
		ZipCodeRange ezp1 = new ZipCodeRange(94200,94200);
		expected.add(ezp1);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	/**
	 * Test case where there is multiple overlaps
	 * [50000,40000] [45000,60000] [55000,75000] [76000,85000]
	 */
	public void testCase4() {
		ZipCodeRange zp1 = new ZipCodeRange(50000,40000);
		ZipCodeRange zp2 = new ZipCodeRange(39000,60000);
		ZipCodeRange zp3 = new ZipCodeRange(55000,75000);
		ZipCodeRange zp4 = new ZipCodeRange(76000,85000);
		
		List<ZipCodeRange> input = new ArrayList<>();
		input.add(zp1);
		input.add(zp2);
		input.add(zp3);
		input.add(zp4);
		
		List<ZipCodeRange> actual = MinZipCodeRangeService.validateRange(input);
		List<ZipCodeRange> expected =new ArrayList<>();
		ZipCodeRange ezp1 = new ZipCodeRange(39000,75000);
		ZipCodeRange ezp2 = new ZipCodeRange(76000,85000);
		expected.add(ezp1);		
		expected.add(ezp2);	
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	/**
	 * Test case to test invalid input
	 */	
	public void testInvalidInput() {
		 MinZipCodeRangeService.validateRange(null);
	}

}
