package com.ws.code.challenge.model;

import java.util.List;

/**
 * Class to represent the result which includes both input and output
 * @author Swaroop Shivarudrappa
 *
 */
public class MinimizedZipCodeRangeResult {
	
	private List<ZipCodeRange> input;
	private List<ZipCodeRange> output;
	
	/**
	 * Default constructor
	 * @param input List of valid zipcode ranges
	 * @param output List of minimized zipcode ranges
	 */
	public MinimizedZipCodeRangeResult(List<ZipCodeRange> input, List<ZipCodeRange> output) {
		this.input = input;
		this.output = output;
	}

	/**
	 * method to get Input
	 * @return
	 */
	public List<ZipCodeRange> getInput() {
		return input;
	}

	/**
	 * method to set Input
	 * @param input
	 */
	public void setInput(List<ZipCodeRange> input) {
		this.input = input;
	}

	/**
	 * method to get Output
	 * @return
	 */
	public List<ZipCodeRange> getOutput() {
		return output;
	}

	/**
	 * method to set Output
	 * @param output
	 */
	public void setOutput(List<ZipCodeRange> output) {
		this.output = output;
	}
	
	@Override
	/**
	 * return the string with both input and output
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return "The Minimized Zip code range for input : "+this.getInput()+ ": "+this.getOutput();
	}

}
