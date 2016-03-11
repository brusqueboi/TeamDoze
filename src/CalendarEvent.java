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
<<<<<<< HEAD
    Scanner sc = new Scanner (System.in);
    int choice;
    String input = "";
    String geolatf = "";
    String geolonf = "";
    String geo = "";
    String input2 = "";
    String summary = "";
    String location = "";
    String newDateStr = "";
    String dtstart = "";
    String dtend = "";
    Boolean end = false;
    Boolean dend = false;
    Boolean endl = false;
    String[] htime;
    String shtime = "";
    String smtime = "";
    String ehtime = "";
    String emtime = "";
    String y = "yes";
    String classi = "";
    String co = "CONFIDENTIAL";
    String pr = "PRIVATE";
    String p = "PUBLIC";
    float longi = 0;
    float lat = 0;
    int nshtime = 0;
    int nehtime = 0;

    final String uFormat = "MM/dd/yyyy";
    final String cFormat = "yyyy/MM/dd";

//***********************************************************************************************
//  start of code
//***********************************************************************************************

    while(end == false){

    System.out.println("******************************************\n");
    System.out.print("        iCalender Event Scheduler         \n");
    System.out.print("******************************************\n");
    System.out.print("Instructions: The following options will schedule an event.\n");
    System.out.print("              Please choose from the list to setup the event.\n");

    System.out.println("1: Quit");
    System.out.print("2: Create Event\n");
    System.out.print("3. Modify Event");


    input = sc.nextLine();

    try{

      choice = Integer.parseInt(input);

      if(choice >= 1 && choice < 7){

        switch(choice){

          case 1:

            System.out.println("You have selected to exit the program, Good Bye!");
            end = true;
            break;

          case 2:

            System.out.println("You have selected to create an Event");

            // input of event details
            // name of event

            System.out.println("\nName of Event: ");
            input = sc.nextLine();
            summary = summary.concat(input + "\n");

            // input of event location

            System.out.println("\nLocation of Event: ");
            input = sc.nextLine();
            location = location.concat(input + "\n");

            System.out.println("Enter latitude for the geographical position:");
            lat = sc.nextFloat();
            System.out.println("Enter longitude for the geographical position:");
            longi = sc.nextFloat();

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(6);
            nf.setGroupingUsed(false);
            geolatf = nf.format(lat).toString();
            geolonf = nf.format(longi).toString();

            sc.nextLine();

            // input and format of the date field

            while(dend == false){

              System.out.println("\nPlease the date in this format: MM/DD/YYYY");
              System.out.println("Date of Event: ");

              input = sc.nextLine();

              try{

                SimpleDateFormat sdf = new SimpleDateFormat(uFormat);
                Date day = new Date();
                day = sdf.parse(input);
                sdf.applyPattern(cFormat);
                newDateStr = sdf.format(day);
                input = newDateStr.replaceAll("/", "");
                dtstart = dtstart.concat(input);
                dtend = dtstart;
                dend = true;
              }
              catch(ParseException e){
                System.out.print("Error, Date is wrong");
                dend = false;
              }
            }

            // input for time and formatting

            System.out.println("\nStart Time of Event (4am or 4:30am)");
            input = sc.nextLine();
            System.out.println("\nEnd Time of Event (6pm or 6:30pm)");
            input2 = sc.nextLine();

            // removal of am or pm for calendar format

            if(input.contains("am")){
              input = input.replace("am", "");
            }
            else if(input.contains("pm")){
              input = input.replace("pm", "");
            }

            if(input2.contains("am")){
              input2 = input2.replace("am", "");
            }
            else if(input2.contains("pm")){
              input2 = input2.replace("pm", "");
            }

            // removal of the : for calendar format

            if(input.contains(":")){
              htime = input.split(":");
              shtime = htime[0];
              smtime = htime[1];

              nshtime = Integer.parseInt(shtime);
              nshtime = nshtime + 12;

              dtstart = dtstart.concat("T" + nshtime + smtime + "00\n");

            }

            // if time doesn't have a am or pm

            else{
              nshtime = Integer.parseInt(input);
              nshtime = nshtime + 12;

              dtstart = dtstart.concat("T" + nshtime + "0000\n");
            }

            if(input2.contains(":")){
              htime = input2.split(":");
              ehtime = htime[0];
              emtime = htime[1];

              nehtime = Integer.parseInt(ehtime);
              nehtime = nehtime + 12;

              dtend = dtend.concat("T" + nehtime + emtime + "00\n");

            }

            // if time doesn't have a am or pm

            else{
              nehtime = Integer.parseInt(input2);
              nehtime = nehtime + 12;

              dtend = dtend.concat("T" + nehtime + "0000\n");
            }

            // end of formatting time

            // input of event classification

            System.out.println("\nClassification of Event");
            System.out.println("confidential \nprivate \npublic");
            input = sc.nextLine();

            classi = input.toUpperCase();

            if(classi == co){
              classi = classi.concat(co + "\n");
            }
            else if(classi == pr){
              classi = classi.concat(pr + "\n");
            }
            else if(classi == p){
              classi = classi.concat(p + "\n");
            }
            else{
              classi = "PUBLIC\n";
            }

            break;
          case 3:
            System.out.println("Modify an Event");
            System.out.println("STILL IN DEVELOPMENT");
            break;
          default:
            System.out.println("Error: Please choose from the list.");
            break;
        }
      }
    }
    catch(NumberFormatException e){
      System.out.println("Sorry, you must input a number corresponding to the menu");
    }

    try{

      // create ics file
      file = new File("calendarevent.ics");
      BufferedWriter output = new BufferedWriter(new FileWriter(file));

      // write to file
      output.write("BEGIN:VCALENDAR\n");
      output.write("VERSION: 2.0\n");
      output.write("BEGIN:VEVENT\n");
      output.write("DTSTART;TZID=Pacific/Honolulu:"+ dtstart);
      output.write("DTEND;TZID=Pacific/Honolulu:" + dtend);
      output.write("LOCATION:" + location);
      output.write("GEO:" + geolatf + ";" + geolonf + "\n");
      output.write("SUMMARY:" + summary);
      output.write("CLASS:" + classi);
      output.write("END:VEVENT\n");
      output.write("END:VCALENDAR\n");
=======
    Scanner input=new Scanner(System.in);
    String event="";
    String location="";
    String discription="";
    String timezone="";
    String date="";
    String classification="";
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
		  System.out.println("8: Classification");
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
			  case 8:
				  Class();
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
>>>>>>> origin/master

		        // write to file
		        output.write("BEGIN:VCALENDAR\n");
		        output.write("VERSION: 2.0\n");
		        output.write("BEGIN:VEVENT\n");
		        output.write("DTSTART;TZID="+timezone+":"+date+"T"+start+"\n");
		        output.write("DTEND;TZID="+timezone+":"+date+"T"+end+"\n");
		        output.write("LOCATION:"+location+"\n");
		        output.write("GEO:"+geolat+";"+geolon+"\n");
		        output.write("SUMMARY:"+event+"\n");
		        output.write("CLASS:"+classification+"\n");
		        output.write("END:VEVENT\n");
		        output.write("END:VCALENDAR\n");

<<<<<<< HEAD
    }
    catch(Exception e){
      System.out.print("Error");
    }
    }

    System.exit(0);
  }

}
=======
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
	  
	  public void Class(){
		  System.out.println("Enter the classification type for the event:");
		  classfication=input.next().toUppercase();
	  }
}	




>>>>>>> origin/master
