/* *************************************************************************
 * 	Student Name:    Zhuohan Xie
 *  Student ID:   	 871089
 *
 *  Description:  Provides an interface class for Distinct class, defining
 *				  two methods needed in a specific cardinality estimation 
 *				  algorithm and providing a helper function for each 
 *				  algorithm to find tailing Zeros.				  
 *
 *  Written:       2/09/2018
 *  Last updated:  6/09/2018
 *
 *
 ***************************************************************************/

public interface Distinct{

	/*
 	* 	This is a helper function to find tailing zeros of binary 
 	*	representation of a integer. It takes an integer as input and returns
 	*	its tailing zeros as output.
 	*/	

	public static int zeros(int v){
		return Integer.numberOfTrailingZeros(v); 
	}

	/*
 	* 	This defines a function used to take a string as input, which is a line
 	*	from the file. It allows the algorithms do operations with that string. 
 	*/	
 	
	void add(String s);

	/*
 	* 	This defines a function taking no input but will require a double type 
 	*	as output representing the number of distinct elements. 
 	*/

	double distinct(); 
			   
}
