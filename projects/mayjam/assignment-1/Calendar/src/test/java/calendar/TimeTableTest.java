package calendar;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class TimeTableTest {

	@Test
	public void test() throws DateOutOfRangeException {
	
		//test getApptRange method
		
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
		         description);
		 startDay = 9;
		 title="Birthday Party 0";
		 Appt appt0 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);		 
		 startDay = 12;
		 title="Birthday Party 2";
		 Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 startDay = 15;
		 title="Birthday Party 3";
		 Appt appt3 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 
		 TimeTable timeTable=new TimeTable();
	        //Create a linked list of calendar days to return
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 listAppts.add(appt0);
		 listAppts.add(appt);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 Collections.sort(listAppts);
		 
		 GregorianCalendar yesterday = new GregorianCalendar(2018,1,9);
		 GregorianCalendar today = new GregorianCalendar(2018,1,10);
		 GregorianCalendar nextWeek = new GregorianCalendar(2018,1,17);
		 GregorianCalendar later = new GregorianCalendar(2018,2,10);
		 
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = timeTable.getApptRange(listAppts, yesterday, nextWeek);
		 assertEquals(8,calDays.size());
		 calDays = timeTable.getApptRange(listAppts, yesterday, today);
		 assertEquals(1,calDays.size());
		 assertEquals("[\t --- 1/9/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\t1/9/2018 at 11:30am ,Birthday Party 0, This is my birthday party.\n" + " \n]",calDays.toString());
		 /*
		 CalDay calday1 = new CalDay(today);
		 CalDay calday2 = new CalDay(nextMonth);
		 CalDay calday3 = new CalDay(later);
		 
		 calday1.addAppt(appt);
		 calday2.addAppt(appt2);
		 calday3.addAppt(appt3);*/
		
		//test deleteAppt
		
		//test permute
		
	}

}
