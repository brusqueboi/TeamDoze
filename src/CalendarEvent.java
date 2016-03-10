//***********************************************************************************************
//  Team: Doze
//  ICS 314
//  Authors: Dorienne Matsuno, Marlene Abut, Jacob Dalton
//
//***********************************************************************************************



import java.util.*;
import java.text.*;
import java.io.*;


public class CalendarEvent {

//***************************************************************************************************
//  Declaration of variables
//***************************************************************************************************	
    File file;
    Scanner input=new Scanner(System.in);
    String event="";
    String location="";
    String discription="";
    String timezone="";
    String summary="";
    int answer=0,start=0,end=0;
//****************************************************************************************************
//  start of code
//****************************************************************************************************    
    
	public static void main(String[] args)
	{	
		new CalendarEvent();
	}
	
	public CalendarEvent()
	{
		
		do
		{
			Directions();
			Menu();
			userInput();
		}
		while(answer!=0);
				
	}
	
	public void Directions()
	{
		System.out.println("**********************************************************");
		System.out.println("                 iCalender Event Scheduler                  ");
		System.out.println("**********************************************************");
		System.out.println("Instructions: The following options will schedule an event.");
		System.out.println("              Please chose from the list to setup the event.");
	}  
	
	  public void Menu(){
		  System.out.println("1: Event");
		  System.out.println("2: Time Start");
		  System.out.println("3: Time End");
		  System.out.println("4: Location");
		  System.out.println("5: Discription");
		  System.out.println("6: Time Zone");
		  System.out.println("0: Quit\n");
	  }
	  
	  public void userInput()
	  {
		  System.out.println("Enter a number: ");
		  answer=input.nextInt();
		  
		  switch(answer)
		  {
			  case 1: 
				  Event();
				  break;
			  case 2:
				  StartTime();		  
				  break;
			  case 3:
				  EndTime();			  
				  break;
			  case 4:
				  Location();
				  break;
			  case 5:
				  Discription();
				  break;
			  case 6:
				  TimeZone();
				  break;
			  case 0:
				  print();
				  System.exit(0);
			  default:
				  System.out.println("Error: Please choose from the list.");
				  break;
		  }	  
	  }
	  
	  public void print()
	  {
		    try{

		        // create ics file
		        file = new File("calendarevent.ics");
		        BufferedWriter output = new BufferedWriter(new FileWriter(file));

		        // write to file
		        output.write("BEGIN:VCALENDAR\n");
		        output.write("VERSION: 2.0\n");
		        output.write("BEGIN:VEVENT\n");
		        output.write("DTSTART;TZID="+location+":20160226T130000\n");
		        output.write("DTEND;TZID="+location+"Pacific/Honolulu:20160226T140000\n");
		        output.write("LOCATION:"+location+"\n");
		        output.write("SUMMARY:"+summary+"\n");
		        output.write("END:VEVENT\n");
		        output.write("END:VCALENDAR\n");

		        output.close();

		      }
		      catch(Exception e){
		        System.out.print("Error");
		      }			  
	  }
	  
	  public void Event(){
		  System.out.println("Enter the event:");
		  event=input.next();
	  }
	  
	  public void StartTime(){
		  System.out.println("Enter the start time:");
		  start=input.nextInt();
		  
		  try
		  {
		    if(start == 0)
		    {
		      throw new Exception("\n\tInput must at least be 1.");
		    }
		    if (start < 0)
		    {
		      throw new Exception("\n\tInput cannot be a negative.");
		    }
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
			  StartTime();
		  }
		  
	  }
	  
	  public void EndTime(){
		  System.out.println("Enter the end time:");
		  end=input.nextInt();	  
		  
		  try
		  {
		    if(end == 0)
		    {
		      throw new Exception("\n\tInput must at least be 1.");
		    }
		    if (end < 0)
		    {
		      throw new Exception("\n\tInput cannot be a negative.");
		    }
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
			  EndTime();
		  }	  
		  
	  }
	  
	  public void Location(){
		  System.out.println("Enter the location:");
		  location=input.next();
	  }
	  
	  public void Discription(){
		  System.out.println("Enter a discription of event:");
		  summary=input.next();
	  }
	  
	  public void TimeZone(){
		  System.out.println("Enter the time zone:");
		  timezone=input.next();
	  }
}	


