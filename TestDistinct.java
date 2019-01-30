/* *************************************************************************
 * 	Student Name:    Zhuohan Xie
 *  Student ID:   	 871089
 *
 *  Description:  Provides a test distinct class, which is the main class of
 *				  this project. It takes one command line input as filename and
 *				  construct an AMS estimator then read files and process each
 *				  line and print a single number as estimated cardinality 
 *				  result for the input file.		  
 *
 *  Written:       2/09/2018
 *  Last updated:  7/09/2018
 *
 *
 ***************************************************************************/
import java.io.*;

public class TestDistinct{
	public static void main(String args[]){

		/*
 		* 	This is to construct an AMS estimator, 0x7fffffff is chosen for 
 		*	domain, because it's the largest number so it can eliminate 
 		*	collision. And 30 is the number of estimator number, which is 
 		*	obtained from my report and guarantee a good trade-off between
 		*	accuracy, running time and space.
 		*/
		
		Distinct a = new AMS(0x7fffffff,30);

		/*
 		* 	It reads the first argument of command line as file name, then
 		*	open the file, and process each line, then print the estimated 
 		*	cardinality.
 		*/

		try {
	        FileInputStream fstream = new FileInputStream(args[0]);
	        DataInputStream in = new DataInputStream(fstream);
	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        String strline;
	        while((strline = br.readLine())!= null) {
	        	a.add(strline);
	        }
	        in.close();
	        }catch(Exception e) {
	        	System.out.println("Error: " + e.getMessage());
	        }
	    System.out.print((int)a.distinct());
	}
}

