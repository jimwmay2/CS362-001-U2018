package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 
		 DataHandler dat = new DataHandler();
		 String file = "file01.xml";
		 String file1 = "file01.xml";
		 boolean boo = true;
		
		 DataHandler dat1 = new DataHandler(file,boo);
		 boo = false;
		 DataHandler dat2 = new DataHandler(file1,boo);
		 Calendar rightnow = Calendar.getInstance();
		 GregorianCalendar today = new GregorianCalendar(rightnow.get(Calendar.YEAR),rightnow.get(Calendar.MONTH),rightnow.get(Calendar.DAY_OF_MONTH));
		 CalDay calday1 = new CalDay(today);
		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				int rand = ValuesGenerator.getRandomIntBetween(random, 1, 4);
				int month = ValuesGenerator.getRandomIntBetween(random, 1, 8);
				int day = ValuesGenerator.getRandomIntBetween(random, 0, 20);
				GregorianCalendar first = new GregorianCalendar(2018,month,day);
				GregorianCalendar second = new GregorianCalendar(2018,month+rand,day+rand);
				dat.getApptRange(first, second);
		        dat1.getApptRange(first, second);
		        dat2.getApptRange(first, second);
				
				
				 int startHour=ValuesGenerator.getRandomIntBetween(random, -10, 30);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -30, 90);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -10, 45);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -4, 16);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, -10, 20);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";
				
				 
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);
		         appt.setValid();
		         calday1.addAppt(appt);
		         
		         
		         dat.deleteAppt(appt);
		         dat.saveAppt(appt);
		         dat.deleteAppt(appt);
		         
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = CalDayRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=CalDayRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=CalDayRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
				
				dat1.deleteAppt(appt);
				dat1.saveAppt(appt);
				dat1.deleteAppt(appt);
				dat2.deleteAppt(appt);
				dat2.saveAppt(appt);
				dat2.deleteAppt(appt);
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }
		 
		 
	 }


	

