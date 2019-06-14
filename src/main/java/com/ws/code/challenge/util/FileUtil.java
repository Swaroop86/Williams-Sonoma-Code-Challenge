package com.ws.code.challenge.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ws.code.challenge.model.ZipCodeRange;

/**
 * Util class to parse the input and Build Valid ZipCodeRange objects
 * 
 * @author Swaroop Shivarudrappa
 *
 */
public class FileUtil {
	
	private final static Logger logger = Logger.getLogger(FileUtil.class);
	
	/**
	 * Method to parse the input file, the inputs are picked from inputs.txt under src/main/resources
	 * 
	 * @return Returns a List of List containing valid ZipCode Ranges
	 */
	public static List<List<ZipCodeRange>> parseInput(String filename) {		
		
		List<String> input = null;
		try {    
			input = Files.readAllLines(Paths.get(FileUtil.class.getClassLoader().getResource(filename).toURI()));			
		} catch (IOException e) {
			logger.error("IO Exception while accessing the file: "+e);			
		} catch(Exception e) {
			logger.error("EXception which accessing the file: "+e);
		}
		
		if(input==null || input.size()==0) {
			logger.error("Please place valid input in the inputs.txt file");
			throw new IllegalArgumentException("Input file is empty or missing");
		}
		
		return validateAndMap(input);
		
	}
	
	/**
	 * Method to validate the input and Build ZipCodeRange objects
	 * @param List of zipcode ranges picked from input.txt
	 * @return
	 */
	public static List<List<ZipCodeRange>> validateAndMap(List<String> inputs) {
		List<List<ZipCodeRange>> validZipCodes = new ArrayList<>();	
		
		//Each line in the file is one input and needs to be parsed
		for(String input : inputs) {
			//The zipcode ranges are separated by spaces, hence use that as delimiter to split
			String[] zipCodeRanges = input.split("\\s");
			List<ZipCodeRange> list = new ArrayList<>();
			List<String> invalidZipCodes = new ArrayList<>();
			for(String range : zipCodeRanges) {
				if(ZipCodeValidator.isValidZipCodeRange(range)) {
					//replace the [] brackets and split using "," delimiter
					String zipCodeRange[] = range.replace("[","").replace("]", "").split(",");
					
					int lowerBound = Integer.parseInt(zipCodeRange[0]);
					int upperBound = Integer.parseInt(zipCodeRange[1]);
					
					//If the upper bound is less than lower bound then need to swap
					if(upperBound < lowerBound) {
						int temp = lowerBound;
						lowerBound = upperBound;
						upperBound = temp;
					}
					list.add(new ZipCodeRange(lowerBound, upperBound));
				} else {
					invalidZipCodes.add(range);
				}
				
				
			}
			//Any Invalid inputs will cause the program to fail
			if(invalidZipCodes.size()>0) {
				logger.error("Invalid Input : Zip codes should be provided as [94133, 94140] [94200, 94299] and separated by spaces, rather found "+invalidZipCodes);
				throw new IllegalArgumentException("Invalid input");
			}
			
			validZipCodes.add(list);
			
		}
		
		
		
		return validZipCodes;
	}

}
