package com.ws.code.challenge.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ws.code.challenge.model.ZipCodeRange;



public class FileUtilTest {
	
	@Test
	public void testParseInput() {
		
	}
	
	@Test
	public void testValidateAndMap() {
		String zipRange1 = new String("[94133,94133] [94200,94299] [94400,94600]");
		String zipRange2 = new String("[94133,94133] [94300,94399] [94500,94900]");
		List<String> inputs = new ArrayList<>();
		inputs.add(zipRange1);
		inputs.add(zipRange2);

		List<ZipCodeRange> expected1 = new ArrayList<>();
		List<ZipCodeRange> expected2 = new ArrayList<>();
		ZipCodeRange zipExp1 = new ZipCodeRange(94133,94133);
		ZipCodeRange zipExp2 = new ZipCodeRange(94200,94299);
		ZipCodeRange zipExp3 = new ZipCodeRange(94400,94600);
		expected1.add(zipExp1);
		expected1.add(zipExp2);
		expected1.add(zipExp3);
		
		ZipCodeRange zipExp4 = new ZipCodeRange(94133,94133);
		ZipCodeRange zipExp5 = new ZipCodeRange(94300,94399);
		ZipCodeRange zipExp6 = new ZipCodeRange(94500,94900);
		expected2.add(zipExp4);
		expected2.add(zipExp5);
		expected2.add(zipExp6);
		
		List<List<ZipCodeRange>> expected = new ArrayList<>();
		expected.add(expected1);
		expected.add(expected2);
		
		List<List<ZipCodeRange>> actual = FileUtil.validateAndMap(inputs);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidAndMapError() {
		String zipRange1 = new String("94133,94133] [94200,94299] [94400,94600]");
		List<String> inputs = new ArrayList<>();
		inputs.add(zipRange1);
		FileUtil.validateAndMap(inputs);
	}

}
