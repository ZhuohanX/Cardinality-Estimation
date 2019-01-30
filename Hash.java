/* *************************************************************************
 * 	Student Name:    Zhuohan Xie
 *  Student ID:   	 871089
 *
 *  Description:  Provides a hash function class, which contains one Constructor
 *				  and two hash functions provided by the teaching staff.				  
 *
 *  Written:       2/09/2018
 *  Last updated:  7/09/2018
 *
 *
 ***************************************************************************/

public class Hash{

	/*
 	* 	Set p as a largest integer in Java, therefore, all positive a smaller
 	*	than p should be relatively prime to p, and get random a,b less than p
 	*	should not easily yield same result, which can guarantee that it can 
 	*	generate independent hash functions.	
 	*/	
	
	private int p = 1073741789; 
	private int a, b;

	/*
 	* 	The Constructor generates two random number for hash functions, a cannot
 	*	be 0 for the hash function.
 	*/		
	
	public Hash( ){
		a = StdRandom.uniform(p - 1) + 1;
		b = StdRandom.uniform(p); 
	}

	/*
 	* 	This function takes an integer as input and return an integer which is 
 	*	the hash value of the input integer within the input range.
 	*	It parses all data for calculation because it might get a very large
 	*	number and multiplication might get out of range.
 	*/	

	public int hashvalue(int x, int range){
		long product = (long) a * (long) x;
		product += (long) b;
		long y = product % (long) p;
		int remainder = (int) y % range;
		return (int) remainder;
	}

	/*
 	* 	This function takes an object and an integer as domain, the purpose of
 	*	this function is to truncate the key's hashcode within the input domain
 	*	Noticing domain should be a hexadecimal number like 0x0fffffff
 	*/
	
	public static int h_basic(Object key, int domain){
		
		return (key.hashCode() & domain);
	}	
}
