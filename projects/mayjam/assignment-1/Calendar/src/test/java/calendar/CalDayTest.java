package calendar;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class CalDayTest {

	//Test addAppt method
	@Test
	public void test() {
		
		//get todays date
    	Calendar rightnow = Calendar.getInstance();
		 int startHour=11;
		 int startMinute=30;
		 int startDay = rightnow.get(Calendar.DAY_OF_MONTH);
		 int startMonth = rightnow.get(Calendar.MONTH)+1;
		 int startYear = rightnow.get(Calendar.YEAR);
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
		 startHour=12;
		 title="Birthday Party 2";
		 Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 startHour=13;
		 title="Birthday Party 3";
		 Appt appt3 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 
		 
		 GregorianCalendar today = new GregorianCalendar(rightnow.get(Calendar.YEAR),rightnow.get(Calendar.MONTH),rightnow.get(Calendar.DAY_OF_MONTH));
		 CalDay calday1 = new CalDay(today);
		 
		 calday1.addAppt(appt3);
		 
		 
		 //check toString method
		 assertEquals("\t --- 0/30/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\t1/30/2018 at 1:30pm ,Birthday Party 3, This is my birthday party.\n"+" \n" ,calday1.toString());
		 
		 
		 calday1.addAppt(appt);
		 calday1.addAppt(appt2);
		 
		 //check order appts were added in
		assertEquals("Birthday Party",(calday1.getAppts().get(0)).getTitle());
		assertEquals("Birthday Party 2",(calday1.getAppts().get(1)).getTitle());
		assertEquals("Birthday Party 3",(calday1.getAppts().get(2)).getTitle());
		
		//test get methods
		assertEquals(3,calday1.getSizeAppts());
		assertEquals(rightnow.get(Calendar.DAY_OF_MONTH),calday1.getDay());
		assertEquals(rightnow.get(Calendar.MONTH),calday1.getMonth());
		assertEquals(rightnow.get(Calendar.YEAR),calday1.getYear());
	}
	

	
}
