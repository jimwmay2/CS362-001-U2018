package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 
	    	Calendar rightnow = Calendar.getInstance();
			 int startHour=0;
			 int startMinute=6;
			 int startDay = rightnow.get(Calendar.DAY_OF_MONTH);
			 int startMonth = rightnow.get(Calendar.MONTH)+1;
			 int startYear = rightnow.get(Calendar.YEAR);
			 String title="Birthday Party";
			 String description="This is my birthday party.";
			 String emailAddress="my@email.com";
			 //Construct a new Appointment object with the initial data	 
			 Appt appt = new Appt(startHour,
			          startMinute ,
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 startHour=35;
			 title="Birthday Party 2";
			 emailAddress="my@email2.com";
			 Appt appt2 = new Appt(startHour,
			          startMinute ,
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 startHour=13;
			 startMinute = 82;
			 title="Birthday Party 3";
			 emailAddress="my@email3.com";
			 Appt appt3 = new Appt(startHour,
			          startMinute ,
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 startMonth=3;
			 startMinute=6;
			 startYear=-12;
			 title=null;
			 emailAddress="my@email4.com";
			 Appt appt4 = new Appt(startHour,
			          startMinute ,
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 startMonth=2;
			 startDay=31;
			 startYear = rightnow.get(Calendar.YEAR);
			 title=null;
			 emailAddress="my@email5.com";
			 Appt appt5 = new Appt(
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 startDay=0;
			 Appt appt6 = new Appt(
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 startDay=28;
			 title="Birthday Party 7";
			 emailAddress=null;
			 Appt appt7 = new Appt(
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 startMonth=0;
			 title="Birthday Party 8";
			 emailAddress=null;
			 Appt appt8 = new Appt(
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 
			 
			 appt3.setValid();
			 assertTrue(appt4.getValid());
			 
			 //check toString method
			 appt.setValid();
			 appt2.setValid();
			 appt4.setValid();
			 appt5.setValid();
			 appt6.setValid();
			 appt7.setValid();
			 appt8.setValid();
			 assertEquals("\t2/31/2018 at -1:-1am ,, This is my birthday party.\n",appt5.toString());
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(0, appt.getStartHour());
		 assertEquals(6, appt.getStartMinute());
		 assertEquals(27, appt.getStartDay());
		 assertEquals(07, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription()); 
		 assertEquals("my@email.com", appt.getEmailAddress()); 
		 
		 assertFalse(appt.isOn(1, 1, 1));
		 assertFalse(appt.isOn(rightnow.get(Calendar.DAY_OF_MONTH), 1, 1));
		 assertFalse(appt.isOn(rightnow.get(Calendar.DAY_OF_MONTH), rightnow.get(Calendar.MONTH)+1, 1));
		 assertTrue(appt.isOn(rightnow.get(Calendar.DAY_OF_MONTH), rightnow.get(Calendar.MONTH)+1, rightnow.get(Calendar.YEAR)));
		 
		 int[] recurDays = {3,4,5};
		 int recurBy = 2;
		 int recurIncrement = 6;
		 int recurNumber = 7;
		 assertEquals(2,appt.getRecurBy());
		 assertEquals(0,appt.getRecurNumber());
		 assertFalse(appt.isRecurring());
		 assertEquals(0,appt.getRecurIncrement());
		 //assertEquals(0,appt.getRecurDays());
		 appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		 for(int i = 0;i < recurDays.length;i++) {
			 assertEquals(recurDays[i],appt.getRecurDays()[i]);
		 }
		 assertTrue(appt.isRecurring());
		 assertEquals(recurBy,appt.getRecurBy());
		 assertEquals(recurIncrement,appt.getRecurIncrement());
		 assertEquals(recurNumber,appt.getRecurNumber());
		 recurDays = null;
		 appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		 int[] num = appt.getRecurDays();
		 assertEquals(num,appt.getRecurDays());
		 
		 /* 
		 int[] recurDays = {4,7,10};
		 int recurBy = 3;
		 int recurIncrement = 12;
		 int recurNumber = 2;
		  * appt.setRecurrence( recurDays, recurBy, recurIncrement, recurNumber);
		 for(int i =0; i < recurDays.length;i++) {
			assertEquals(1,appt.getRecurDays()[i+1]); 
		 }
		 assertEquals(3,appt.getRecurBy());
		 assertEquals(12,appt.getRecurIncrement());
		 assertEquals(0,appt.getRecurNumber());*/
	 }

}


