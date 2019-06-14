package com.ws.code.challenge.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.ws.code.challenge.model.MinimizedZipCodeRangeResult;
import com.ws.code.challenge.model.ZipCodeRange;
import com.ws.code.challenge.util.FileUtil;
import com.ws.code.challenge.util.ZipCodeRangeComparator;


/**
 * Service class which contains the main algorithm
 * @author Swaroop Shivarudrappa
 *
 */
public class MinZipCodeRangeService {
	
	private final static Logger logger = Logger.getLogger(MinZipCodeRangeService.class);
	
	/**
	 * Method to findMinZipCodeRange
	 */
	public static List<MinimizedZipCodeRangeResult> findMinZipCodeRange() {
		List<List<ZipCodeRange>> input = FileUtil.parseInput();
		List<MinimizedZipCodeRangeResult> minimizedRanges = new ArrayList<>();
		for(List<ZipCodeRange> list : input) {
			List<ZipCodeRange> minimizedRange = validateRange(list);
			MinimizedZipCodeRangeResult result = new MinimizedZipCodeRangeResult(list, minimizedRange);
			minimizedRanges.add(result);
		}	
		
		return minimizedRanges;
		
	}	
	
	/**
	 * 
	 * @param Algorithm to minimize the zipcode range
	 * @return List<ZipCodeRange>
	 */
	public static List<ZipCodeRange> validateRange(List<ZipCodeRange> list) {
		if(list==null || list.size()==0) {
			logger.error("Invalid input, input cannot be empty");
			throw new IllegalArgumentException("Invalid input, input cannot be empty");
		}

		//sort the list so that we can easliy compare and merge
		Collections.sort(list, new ZipCodeRangeComparator());

		List<ZipCodeRange> res = new ArrayList<>();

		ZipCodeRange merge = list.get(0);

		for(int i=1;i<list.size();i++) {
			ZipCodeRange zpRange = list.get(i);
			//If upperbound of range1 is greater than lower bound of range2 and then its eligible to be reduced
			if(merge.getUpperBound() >= zpRange.getLowerBound()) {
				 merge.setLowerBound(Math.min(merge.getLowerBound(), zpRange.getLowerBound()));
				merge.setUpperBound(Math.max(merge.getUpperBound(), zpRange.getUpperBound()));
			} else{
				res.add(merge);
				merge = zpRange;
			}
		}

		res.add(merge);

		return res;
	}

}
