
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   
	   
	   UrlValidator urlVal = new UrlValidator();	// DEFAULT_SCHEMES =  http, https, ftp 
	   assertFalse(urlVal.isValidScheme("http"));     	// Bug found
	   assertFalse(urlVal.isValidScheme("https"));		// Bug found
	   assertFalse(urlVal.isValidScheme("ftp"));      	// Bug found
	       	
	   urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   assertTrue(urlVal.isValidScheme("http"));	
	   assertTrue(urlVal.isValidScheme("https"));  
	   assertTrue(urlVal.isValidScheme("ftp"));       
	   assertTrue(urlVal.isValidScheme("file"));	
	   assertTrue(urlVal.isValidScheme("h2o"));  
	   assertTrue(urlVal.isValidScheme("FTP"));


   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   assertFalse(urlVal.isValid("http://z.com:0"));          	// Bug found
	   assertFalse(urlVal.isValid("http://z.com:1/"));         	// Bug found
	   assertFalse(urlVal.isValid("http://z.com:2"));           // Bug found
	   assertFalse(urlVal.isValid("http://z.com:80/"));         // Bug found  
	   assertFalse(urlVal.isValid("http://z.com:8080/"));     	// Bug found
	   assertFalse(urlVal.isValid("http://z.com:21"));          // Bug found
	   assertFalse(urlVal.isValid("http://1.1.1.1:0"));        	// Bug found

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
