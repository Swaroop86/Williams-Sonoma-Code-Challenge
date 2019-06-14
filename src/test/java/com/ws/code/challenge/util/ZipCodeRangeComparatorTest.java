package com.ws.code.challenge.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ws.code.challenge.model.ZipCodeRange;

public class ZipCodeRangeComparatorTest {
	
	@Test
	public void testSort() {
		ZipCodeRange range1 = new ZipCodeRange(94133, 94166);
		ZipCodeRange range2 = new ZipCodeRange(96400, 96800);
		ZipCodeRange range3 = new ZipCodeRange(95400, 95600);
		ZipCodeRange range4 = new ZipCodeRange(92100, 92500);

		
		List<ZipCodeRange> ranges = new ArrayList<ZipCodeRange>();
		
		ranges.add(range1);
		ranges.add(range2);
		ranges.add(range3);
		ranges.add(range4);

		
		Collections.sort(ranges, new ZipCodeRangeComparator());
		
		Assert.assertEquals(92100, ranges.get(0).getLowerBound());
		Assert.assertEquals(92500, ranges.get(0).getUpperBound());
		Assert.assertEquals(94133, ranges.get(1).getLowerBound());
		Assert.assertEquals(94166, ranges.get(1).getUpperBound());
		Assert.assertEquals(95400, ranges.get(2).getLowerBound());
		Assert.assertEquals(95600, ranges.get(2).getUpperBound());
		Assert.assertEquals(96400, ranges.get(3).getLowerBound());
		Assert.assertEquals(96800, ranges.get(3).getUpperBound());
		
	}

}
