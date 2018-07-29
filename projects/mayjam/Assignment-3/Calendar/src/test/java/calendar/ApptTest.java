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
			 int startMinute=0;
			 int startDay = 28;
			 int startMonth = 2;
			 int startYear = 1;
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
			 //startMonth=1;	 
			 startHour=-1;
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
			 startMinute = 60;
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
			 startYear=0;
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
			 startMonth=13;
			 title="Birthday Party 9";
			 emailAddress=null;
			 Appt appt9 = new Appt(
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 startHour=24;
			 title="Birthday Party 2";
			 emailAddress="my@email2.com";
			 Appt appt10 = new Appt(startHour,
			          startMinute ,
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 startMinute = 60;
			 title="Birthday Party 3";
			 emailAddress="my@email3.com";
			 Appt appt11 = new Appt(startHour,
			          startMinute ,
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 startMonth=12;
			 startHour=23;
			 startMinute = 59;
			 title="Birthday Party 3";
			 emailAddress="my@email3.com";
			 Appt appt13 = new Appt(startHour,
			          startMinute ,
			          startDay ,
			          startMonth ,
			          startYear ,
			          title,
			         description,
			         emailAddress);
			 startMonth=1;
			 startHour=0;
			 startMinute = 0;
			 title="Birthday Party 3";
			 emailAddress="my@email3.com";
			 Appt appt14 = new Appt(startHour,
			          startMinute ,
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
			 appt13.setValid();
			 appt14.setValid();
			 
			 assertTrue(appt.getValid());
			 assertTrue(appt13.getValid());
			 assertTrue(appt14.getValid());
			 //assertEquals(0, appt12.toString());
			 
			 appt2.setValid();
			 appt4.setValid();
			 appt5.setValid();
			 appt6.setValid();
			 appt7.setValid();
			 appt8.setValid();
			 appt9.setValid();
			 appt10.setValid();
			 appt11.setValid();
			 
			 assertEquals("\t2/31/2018 at -1:-1am ,, This is my birthday party.\n",appt5.toString());
	// assertions
		 
		 
		 assertFalse(appt2.getValid());
		 assertFalse(appt3.getValid());
		 assertFalse(appt4.getValid());
		 assertFalse(appt5.getValid());
		 assertFalse(appt6.getValid());
		 assertFalse(appt7.getValid());
		 assertFalse(appt8.getValid());
		 assertFalse(appt9.getValid());
		 assertFalse(appt10.getValid());
		 assertFalse(appt11.getValid());
		 
		 
		 assertEquals(0, appt.getStartHour());
		 assertEquals(0, appt.getStartMinute());
		 assertEquals(28, appt.getStartDay());
		 assertEquals(02, appt.getStartMonth());
		 assertEquals(1, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription()); 
		 assertEquals("my@email.com", appt.getEmailAddress()); 
		 
		 assertFalse(appt.isOn(1, 1, 1));
		 assertFalse(appt.isOn(28, 1, 1));
		 assertFalse(appt.isOn(28, 2, 2));
		 assertTrue(appt.isOn(28, 2, 1));
		 
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


