package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());    
		 int[] recurDays = {3,4,5};
		 int recurBy = 2;
		 int recurIncrement = 6;
		 int recurNumber = 7;
		 appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		 for(int i = 0;i < recurDays.length;i++) {
			 assertEquals(recurDays[i],appt.getRecurDays()[i]);
		 }
		 assertEquals(recurBy,appt.getRecurBy());
		 assertEquals(recurIncrement,appt.getRecurIncrement());
		 assertEquals(recurNumber,appt.getRecurNumber());
		 
		 //test toString method
		 assertEquals("\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n",appt.toString());
	 }

	 
	/**
	 * Test that the isValid method works as expected.
    */
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=27;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;											//dont need to test month, the code will throw DateOutOfRangeException
		 int startYear=2018;										//year can be anything
		 String title="Birthday Party";								//title can be anything
		 String description="This is my birthday party.";			//description can be anything
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 startHour=21;
		 startMinute=61;
		 startDay=15;
		  
		 Appt appt1 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 startHour=21;
		 startMinute=30;
		 startDay=40;
		 		  
		 Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 startHour=21;
		 startMinute=30;
		 startDay=15;
		 
		 assertFalse(appt.getValid());
		 assertFalse(appt1.getValid());
		 assertFalse(appt2.getValid());
	 }


}
