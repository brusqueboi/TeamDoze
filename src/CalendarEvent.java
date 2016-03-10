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
    String date="";
    int answer=0,start=0,end=0;
    float geolat=0F,geolon=0F;
    String geolonf="";
	String geolatf="";
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
		  System.out.println("2: Date");		  
		  System.out.println("3: Time Start");
		  System.out.println("4: Time End");
		  System.out.println("5: Location");
		  System.out.println("6: Time Zone");
		  System.out.println("7: Geographical Position");
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
				  Date();		  
				  break;
			  case 3:
				  StartTime();			  
				  break;
			  case 4:
				  EndTime();
				  break;
			  case 5:
				  Location();
				  break;
			  case 6:
				  TimeZone();
				  break;
			  case 7:
				  GeoPosition();
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
		        output.write("DTSTART;TZID="+timezone+":"+date+"T"+start+"\n");
		        output.write("DTEND;TZID="+timezone+":"+date+"T"+end+"\n");
		        output.write("LOCATION:"+location+"\n");
		        output.write("GEO:"+geolat+";"+geolon+"\n");
		        output.write("SUMMARY:"+event+"\n");
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
	  
	  public void Date(){
		  System.out.println("Enter date (YYYY/MM/DD) of event:");
		  date=input.next();
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
	  
	  
	  public void TimeZone(){
		  System.out.println("Enter the time zone:");
		  timezone=input.next();
	  }
	  
	  public void GeoPosition(){
		  System.out.println("Enter latitude for the geographical position:");
		  geolat=input.nextFloat();
		  System.out.println("Enter longitude for the geographical position:");	
		  geolon=input.nextFloat();
			
		  NumberFormat nf = NumberFormat.getInstance();
		  nf.setMaximumFractionDigits(6);            
		  nf.setGroupingUsed(false);
		  geolatf=nf.format(geolat).toString();
		  geolonf=nf.format(geolon).toString();
	  }
}	




