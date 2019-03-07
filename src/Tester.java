/**
 * 
 * @author Andrew Scott
 * @version Fall 2017
 * 
 * A simple tester to throw several tests at your driver. This
 * class will call your Driver as if the parameters were entered 
 * in from the command line.
 * 
 * If you want to call your project from the command line. Call <code>Driver</code>
 * and not this class.
 */
public class Tester {
	
	   /**
	    * Run a load of tests.
	    * @param args Not used.
	    */
	  public static void main(String[] args){
			
  		String dic = args[0];
  		
  		System.out.println("TEST 1: - No params");
  	    Driver.main(new String[0]);
  	    System.out.println("====================================\n\n");
  	    
  	    
  		System.out.println("TEST 1: - No not enough params");
  		String[] arg2 = new String[2];
  		arg2[0] = args[0];
  		arg2[1] = "petrol";
  	    Driver.main(arg2);
  	    System.out.println("====================================\n\n");
  	    
  		System.out.println("TEST 2: - Too many params");
  		String[] arg3 = new String[4];
  		arg3[0] = args[0];
  		arg3[1] = "petrol";
  		arg3[2] = "patrol";
  		arg3[3] = "patron";
  	    Driver.main(arg3);
  	    System.out.println("====================================\n\n");
  	     
  		System.out.println("TEST 3: - Not the same Length");
  		args[1] =  "coke";
  	    args[2] = "broke";
  	    Driver.main(args);
  	    System.out.println("====================================\n\n");
  	      
  	    System.out.println("TEST 4: - Words not in dictionary");
  		args[1] =  "xycz";
  	    args[2] = "byxl";
  	    Driver.main(args);
  	    System.out.println("====================================\n\n");
  	    
  	    System.out.println("TEST 5: - No link");
  		args[1] =  "marriage";
  	    args[2] = "marigold";
  	    Driver.main(args);
  	    System.out.println("====================================\n\n");
  	    
  	    System.out.println("TEST 6: - XS Link");
  	  	 args[1] =  "bad";
  	  	 args[2] = "sad";
  	  	 Driver.main(args);
  	    System.out.println("====================================\n\n");
  	  	    
  	    System.out.println("TEST 7: - S Link");
  		args[1] =  "pink";
  	    args[2] = "sink";
  	    Driver.main(args);
  	    System.out.println("====================================\n\n");
  	    
  	    System.out.println("TEST 8: - SM Link");
  	  	args[1] =  "cold";
  	  	args[2] = "warm";
  	  	Driver.main(args);
  	  	 System.out.println("====================================\n\n");
  	    
  	    System.out.println("TEST 9: - M Link");
  		args[1] =  "sail";
  	    args[2] = "ruin";
  	    Driver.main(args);
  	    System.out.println("====================================\n\n");
  	    
  	    System.out.println("TEST 10: - L Link");
  		args[1] =  "stone";
  	    args[2] = "money";
  	    Driver.main(args);
  	    System.out.println("====================================\n\n");
  	    
  	    System.out.println("TEST 11: - XL Link");
  		args[1] =  "crust";
  	    args[2] = "shoes";
  	    Driver.main(args);
  	    System.out.println("====================================\n\n");
	  	   	
	}//end main

}//end class
