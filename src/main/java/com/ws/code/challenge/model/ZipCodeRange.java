package com.ws.code.challenge.model;

/**
 * Model class to represent zipcode range
 * @author Swaroop Shivarudrappa
 *
 */
public class ZipCodeRange {
	
	private int lowerBound;	
	private int upperBound;
	
	/**
	 * 
	 * @param lowerBound
	 * @param upperBound
	 */
	public ZipCodeRange(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	/**
	 * Method to get lowerbound
	 * @return
	 */
	public int getLowerBound() {
		return lowerBound;
	}

	/**
	 * Method to set lowerbound
	 * @param lowerBound
	 */
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	/**
	 * Method to get upperbound
	 * @return
	 */
	public int getUpperBound() {
		return upperBound;
	}

	/**
	 * Method to set upperbound
	 * @param upperBound
	 */
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	
	@Override
	/**
	 * Returns true if the upper bound and lowerbound match in the range
	 */
	public boolean equals(Object obj) {
		ZipCodeRange range = (ZipCodeRange) obj;
		return this.lowerBound == range.lowerBound && this.upperBound == range.upperBound;
	}

	@Override
	/**
	 *Return zip code range in the format [94133,94133]
	 */
	public String toString() {
		return "["+this.lowerBound+","+this.upperBound+"]";
	}
}
