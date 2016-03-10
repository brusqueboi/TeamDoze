//***********************************************************************************************
//  Team: Doze
//  ICS 314
//  Authors: Dorienne Matsuno, Marlene Mabut, Jacob Dalton
//
//***********************************************************************************************
import java.util.*;
import java.text.*;
import java.io.*;

public class CalendarEvent {
  public static void main (String [] arg){

//***********************************************************************************************
//  Declaration of variables
//***********************************************************************************************
    File file;
//***********************************************************************************************
//  start of code
//***********************************************************************************************
    try{

      // create ics file
      file = new File("calendarevent.ics");
      BufferedWriter output = new BufferedWriter(new FileWriter(file));

      // write to file
      output.write("BEGIN:VCALENDAR\n");
      output.write("VERSION: 2.0\n");
      output.write("BEGIN:VEVENT\n");
      output.write("DTSTART;TZID=Pacific/Honolulu:20160226T130000\n");
      output.write("DTEND;TZID=Pacific/Honolulu:20160226T140000\n");
      output.write("LOCATION: UH Manoa ICSpace\n");
      output.write("SUMMARY: meeting\n");
      output.write("END:VEVENT\n");
      output.write("END:VCALENDAR\n");

      output.close();

    }
    catch(Exception e){
      System.out.print("Error");
    }

    System.exit(0);
  }
  
  public void Directions(){
	  System.out.print("******************************************\n");
	  System.out.print("        iCalender Event Scheduler         \n");
	  System.out.print("******************************************\n");
	  System.out.print("Instructions: The following options will schedule an event.\n");
	  System.out.print("              Please chose from the list to setup the event.\n");
  }  
  
  public void Menu(){
	  System.out.print("1: Event\n");
	  System.out.print("2: Time Start\n");
	  System.out.print("3: Time End\n");
	  System.out.print("4: Location\n");
	  System.out.print("5: Discription\n");
	  System.out.print("6: Time Zone\n");
  }
  
  public void userInput(){
	  Switch(){
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
		  default:
			  System.out.println("Error: Please choose from the list.");
			  break;
	  }	  
  }
  
  public void Event(){
	  System.out.println("Enter the event:");
  }
  
  public void StartTime(){
	  System.out.println("Enter the start time:");
  }
  
  public void EndTime(){
	  System.out.println("Enter the end time:");'
  }
  
  public void Location(){
	  System.out.println("Enter the location:");
  }
  
  public void Discription(){
	  System.out.println("Enter a discription of event:");
  }
  
  public void TimeZone(){
	  System.out.println("Enter the time zone:");
  }
}
