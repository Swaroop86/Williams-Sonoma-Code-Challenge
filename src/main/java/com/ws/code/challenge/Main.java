package com.ws.code.challenge;

import java.util.List;

import org.apache.log4j.Logger;

import com.ws.code.challenge.model.MinimizedZipCodeRangeResult;
import com.ws.code.challenge.service.MinZipCodeRangeService;

/**
 * Main class which begins the minimize process by invoking the MinZipCodeRangeService
 * @author Swaroop Shivarudrappa
 *
 */
public class Main {
	private final static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		
		logger.info("Started ZipCode Minimizer service");
		long start = System.currentTimeMillis();
		
		//Invoke MinZipCodeRangeService to get the minimized zipcode ranges
		List<MinimizedZipCodeRangeResult> minimizedRanges = MinZipCodeRangeService.findMinZipCodeRange();
		long end = System.currentTimeMillis();
		
		logger.info("ZipCode Minimizer service completed in : "+(end-start)+"ms");		
		logger.info("*******************RESULTS*****************************");

		//Final output is printed to console
		for(MinimizedZipCodeRangeResult minZipRes : minimizedRanges) {
			logger.info(minZipRes);
			System.out.println("The Minimized Zip code range for input :"+minZipRes.getInput() +" : "+ minZipRes.getOutput());
		}
		logger.info("*******************RESULTS*****************************");
	}

}
