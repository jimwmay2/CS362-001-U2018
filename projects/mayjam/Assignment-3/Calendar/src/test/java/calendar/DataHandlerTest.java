
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static junit.framework.TestCase.fail;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  
	  DataHandler dat = new DataHandler();
	  String file = "file01";
	  DataHandler dat2 = new DataHandler(file);
	  DataHandler dat3 = new DataHandler(file, false);
	  
	  Calendar rightnow = Calendar.getInstance();
		 int startHour=11;
		 int startMinute=30;
		 int startDay = 10;
		 int startMonth = 1;
		 int startYear = 2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointments object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description,null);
		 startDay = 9;
		 title="Birthday Party 0";
		 Appt appt0 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description,null);		 
		 startDay = 12;
		 title="Birthday Party 2";
		 Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description,null);
		 startDay = 15;
		 title="Birthday Party 3";
		 Appt appt3 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description,null);
		//add invalid appt
		 startHour = 27;
		 Appt appt4 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description,null);
		 //make appt recur
		 int[] recurDays = {};
		 int[] recurDayz = {7};
		 int recurBy = 7;
		 int recurIncrement = 6;
		 int recurNumber = -1;
		 appt.setRecurrence(recurDays, appt.RECUR_BY_WEEKLY, recurIncrement, Integer.MAX_VALUE);
		 appt2.setRecurrence(recurDays, 2, 0, 7);
		 appt3.setRecurrence(recurDays, recurBy, recurIncrement, 0);
		 appt4.setRecurrence(recurDayz, recurBy, recurIncrement, recurNumber);
		 
	        //Create a linked list of calendar days to return
		 //LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 dat.saveAppt(appt0);
		 dat.saveAppt(appt);
		 dat.saveAppt(appt2);
		 dat.saveAppt(appt3);
		 dat.saveAppt(appt4);
		 //Collections.sort(listAppts);
		 
		 GregorianCalendar yesterday = new GregorianCalendar(2018,1,9);
		 GregorianCalendar today = new GregorianCalendar(2018,1,10);
		 GregorianCalendar nextWeek = new GregorianCalendar(2018,1,17);
		 GregorianCalendar later = new GregorianCalendar(2018,3,10);
		 
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		 //assertEquals(0,calDays.size());
		 calDays = (LinkedList<CalDay>) dat.getApptRange(yesterday, nextWeek);
		 assertEquals(8,calDays.size());
		 calDays = (LinkedList<CalDay>) dat.getApptRange(yesterday, later);
		 assertEquals(60,calDays.size());
		 calDays = (LinkedList<CalDay>) dat.getApptRange(yesterday, today);
		 assertEquals(1,calDays.size());
		 assertEquals("[\t --- 3/9/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		 "\n]",calDays.toString());
		 
		 CalDay calday1 = new CalDay(today);
		 CalDay calday2 = new CalDay(nextWeek);
		 CalDay calday3 = new CalDay(later);
		 
		 calday1.addAppt(appt);
		 calday2.addAppt(appt2);
		 calday3.addAppt(appt3);
  }
  
  
  
  @Test(expected = DateOutOfRangeException.class)
  public void test01()  throws Throwable  {
	  
	  DataHandler dat = new DataHandler();
	  String file = "file01";
	  //DataHandler dat2 = new DataHandler(file);
	  //DataHandler dat3 = new DataHandler(file, false);
	  
	  Calendar rightnow = Calendar.getInstance();
		 int startHour=11;
		 int startMinute=30;
		 int startDay = 10;
		 int startMonth = 1;
		 int startYear = 2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointments object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description,null);
		 startDay = 9;
		 title="Birthday Party 0";
		 Appt appt0 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description,null);		 
		 startDay = 12;
		 title="Birthday Party 2";
		 Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description,null);
		 startDay = 15;
		 title="Birthday Party 3";
		 Appt appt3 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description,null);
		//add invalid appt
		 startHour = 27;
		 Appt appt4 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description,null);
		 //make appt recur
		 int[] recurDays = {};
		 int[] recurDayz = {7};
		 int recurBy = 7;
		 int recurIncrement = 6;
		 int recurNumber = -1;
		 appt.setRecurrence(recurDays, appt.RECUR_BY_WEEKLY, recurIncrement, Integer.MAX_VALUE);
		 appt2.setRecurrence(recurDays, 2, 0, 7);
		 appt3.setRecurrence(recurDays, recurBy, recurIncrement, 0);
		 appt4.setRecurrence(recurDayz, recurBy, recurIncrement, recurNumber);
	  
	  GregorianCalendar yesterday = new GregorianCalendar(2018,1,9);
		 GregorianCalendar today = new GregorianCalendar(2018,1,10);
		 GregorianCalendar nextWeek = new GregorianCalendar(2018,1,17);
		 GregorianCalendar later = new GregorianCalendar(2018,3,10);
		 

		 LinkedList<CalDay> calDays = (LinkedList<CalDay>) dat.getApptRange(nextWeek, yesterday);

  }

}
