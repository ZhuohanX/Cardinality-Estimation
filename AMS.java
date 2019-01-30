/* *************************************************************************
 * 	Student Name:    Zhuohan Xie
 *  Student ID:   	 871089
 *
 *  Description:  Provides an AMS class, which implements all functions 
 *				  declared in the interface Distinct. It has four functions
 *				  in total, two of which are implemented for the interface
 *				  and one Constructor. 
 *				  It implements the AMS algorithm for the project.				  
 *
 *  Written:       2/09/2018
 *  Last updated:  7/09/2018
 *
 *
 ***************************************************************************/

import java.util.Arrays;

public class AMS implements Distinct{

	/*
	* Array is chosen to store the hash functions and z value, because it 
 	*  can save space and it's fast and convenient to process data.
	*/

	private int domain;	
	private int zs[]; // array of z values
	private Hash hashs[]; // array of hash functions
	private int range = 536870912-3;//2^29-3 is chosen to reduce hash collision
	private int k; // size of the array of hash functions
	

	/*
 	* 	Constructor takes a domain and a hash time k as input, and use these two
 	* 	to construct all data structure employed in this algorithm.
 	*/	

	public AMS(int domain, int k){
		this.k = k;
		this.domain = domain;
		zs = new int [k];
		hashs = new Hash[k];
		// this is to create k new hash functions
		for(int i = 0; i < k; i++)
		{
			hashs[i] = new Hash();
		}
		
	}

	/*
 	* 	This function implements add function declared in the interface,
 	*	It takes a string and parses it to an integer, then apply k hash 
 	*	functions on it and check the tailing 0s to see if it needs to change 
 	*	the stored z values independently. 
 	*/

	public void add(String s){
		int value = Integer.parseInt(s);
		for(int i = 0; i < k; i++){
			// For each integer, it applies to hash functions to it, then check
			// the tailing 0 of that value and compare it with stored one, if 
			// the new one is larger, then change it.
			value = Hash.h_basic(s, domain);
			value = hashs[i].hashvalue(value, range);
			int newz = Distinct.zeros(value);
			if(newz > zs[i]) {
				zs[i] = newz;
			}
		}
	}

	/*
 	* 	This is a simple help function provided by the teaching staff to 
 	*	calculate median of one integer arrays.
 	*/


	public static double getMedian(int[] data) {
	    int[] copy = Arrays.copyOf(data, data.length);
	    Arrays.sort(copy);
	    // if the length is odd, return the middle item, 
	    // else return the average of the two middle items
	    return (copy.length % 2 != 0) ? copy[copy.length / 2] : 
	    (copy[copy.length / 2] + copy[(copy.length / 2) - 1]) / 2;
	}

	/*
 	* 	This function implements distinct function declared in the interface,
 	*	It takes no input and returns a double type as output for cardinality
 	*	estimation.
 	*	By the trick explained in detail in my report, the function takes the 
 	*	median of z values first, then calculates all values 1 distance within
 	*	median for final z value to calculate output.
 	*/

	public double distinct(){
		double median = getMedian(zs);
		double count = 0; // number of z values around median
		double sum = 0;	  // sum of z values around median
		for(int i = 0; i < k; i++) {
			if(zs[i] <= median + 1 && zs[i] >= median - 1) {
				sum += zs[i];
				count += 1;	
			}	
		}
		return Math.pow(2, sum/count+0.5);
	}	
}