package edu.frostburg.cosc460.danielweller.copysystemcalls;

/**
 * This is a program that can copy a file using system calls and bytes.
 * @author Daniel Weller
 *resources http://www.tutorialspoint.com/java/io/bufferedinputstream_read.htm
 *http://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html
 */
//import Buffered Reader
import java.io.*;

public class CopySystemCalls {

	public static void main (String[] args) {
		
//OPENING FILE
		//ask user to enter source file to begin copy
		System.out.println("Please enter the name of the source file to copy:");

		try {
			//read in users input
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//set string to users input
			String sourcename = reader.readLine();
			//set variables to null
			InputStream input = null;
			OutputStream output = null;
		    BufferedInputStream binput = null;
		    //open input stream file for reading purpose.
		    input = new FileInputStream("../" + sourcename);
		    //input stream is converted to buffered input stream
		    binput = new BufferedInputStream(input);
		    //print input file name
		    System.out.println("Opening file: " + sourcename);
		      
		    
//SELECTING DESTINATION FILE
	        //ask user to enter in destination file
	  		System.out.println("Please enter the name of the destination file you want for the new copy: ");
	  		//read in users input for destination file
	  		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));	  		
	  		//set string to users input
	    	String destname = reader2.readLine();
	    	//read output file name
	    	System.out.println("Writing to file: " + destname);
		    
	    	
//READ + WRITE FROM INPUT FILE	    	  
	    	//write to the destination file
	    	output = new FileOutputStream("../" + destname);
	        //while loop that runs while stream is around.
		    while(binput.available()>0){
		        // read the byte
		    	int c = binput.read();
		    	//write the byte to the file
		        output.write(c);   
		    }
		    //print out the status
		    System.out.println("Writing to " + destname + " complete. Thanks for using me!");
		    //*Note- If your reading this, the Orioles just won the AL East!
		    //close the output stream
		    output.close();
		    //close the input stream + buffer
		    if(input!=null)
		    	input.close();
		    if(binput!=null)
		    	binput.close();
		    //still have to close reader1 + reader2
		    //error explaining the file is not there
			} catch (FileNotFoundException e) {
	           System.out.println("The specified file could not be found");
	           System.exit(1);
	        //error explaining the problem.
	        } catch (IOException ioe) {
			   System.out.println("There is an IO error while trying to accept the file name!");
			   System.exit(1);
			}//end main try/catch
	}
	
}
