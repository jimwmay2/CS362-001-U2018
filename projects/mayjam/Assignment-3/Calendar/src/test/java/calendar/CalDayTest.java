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
		 startHour=12;
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
		 startMinute = 12;
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
		 startMonth=63;
		 title="Birthday Party 4";
		 emailAddress="my@email3.com";
		 Appt appt4 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description,
		         emailAddress);
		 
		 GregorianCalendar today = new GregorianCalendar(rightnow.get(Calendar.YEAR),rightnow.get(Calendar.MONTH),rightnow.get(Calendar.DAY_OF_MONTH));
		 CalDay calday1 = new CalDay(today);
		 CalDay calday2 = new CalDay();
		 
		 
		 //calday2.getFullInfomrationApp(calday2);
		 
		 assertEquals("",calday2.toString());
		 calday1.addAppt(appt3);
		 assertTrue(appt4.getValid());
		 
		 //check toString method
		 assertEquals("\t --- 8/16/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\t7/16/2018 at 1:12pm ,Birthday Party 3, This is my birthday party.\n"+" \n" ,calday1.toString());
		 

		 CalDay calday3 = calday1;
		 assertEquals("\t --- 8/16/2018 --- \n" + 
			 		" --- -------- Appointments ------------ --- \n" + 
			 		"\t7/16/2018 at 1:12pm ,Birthday Party 3, This is my birthday party.\n"+" \n" ,calday3.toString());
		 
		 appt4.setValid();
		 calday1.addAppt(appt);
		 calday1.addAppt(appt2);
		 calday1.addAppt(appt4);
		 
		 //check order appts were added in
		assertEquals("Birthday Party",(calday1.getAppts().get(0)).getTitle());
		assertEquals("Birthday Party 2",(calday1.getAppts().get(1)).getTitle());
		assertEquals("Birthday Party 3",(calday1.getAppts().get(2)).getTitle());
		
		//test get methods
		assertEquals(3,calday1.getSizeAppts());
		assertEquals(rightnow.get(Calendar.DAY_OF_MONTH),calday1.getDay());
		assertEquals(rightnow.get(Calendar.MONTH),calday1.getMonth()-1);
		assertEquals(rightnow.get(Calendar.YEAR),calday1.getYear());
		
		String fullday = rightnow.get(Calendar.MONTH)+1 + "-" + rightnow.get(Calendar.DAY_OF_MONTH) + "-" + rightnow.get(Calendar.YEAR) + " \n" +
 		"\t12:06AM Birthday Party This is my birthday party. \n" +
		"\t0:06AM Birthday Party 2 This is my birthday party. \n" +
		"\t1:12PM Birthday Party 3 This is my birthday party. ";
		
		
		assertEquals(fullday,calday1.getFullInfomrationApp(calday1));
	}
	

	
}
