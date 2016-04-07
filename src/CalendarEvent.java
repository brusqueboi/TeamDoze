//***********************************************************************************************
//  Team: Doze
//  ICS 314
//  Authors: Dorienne Matsuno, Marlene Mabut, Jacob Dalton
//
//***********************************************************************************************
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.Math;

public class CalendarEvent {

//***********************************************************************************************
//  Declaration of variables
//***********************************************************************************************
    File file;
    Scanner sc = new Scanner (System.in);
    int choice;
    int inputchoice = 0;     
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
    double distance = 0.0;     
    float longi = 0;
    float lat = 0;
    int nshtime = 0;
    int nehtime = 0;
    char[] readLat1 = new char[9]; 
    char[] readLongi1 = new char[10];
    char[] readLat2 = new char[9]; 
    char[] readLongi2 = new char[10];	
    char[] traceoutput = new char[200];	
    double greatdistance = 0.0;
    

    private static final double RADIUS = 3950.02; //miles
    final String uFormat = "MM/dd/yyyy";
    final String cFormat = "yyyy/MM/dd";

//***********************************************************************************************
//  start of code
//***********************************************************************************************

  public static void main (String [] arg){
	  new CalendarEvent();  
  }
	
  public CalendarEvent(){
	  scheduler(); 
  }    

  public double greatCircleDistance(double lat1, double long1, double lat2, double long2){
	 double geolat1 = Math.toRadians(lat1);
	 double geolong1 = Math.toRadians(long1);
	 double geolat2 = Math.toRadians(lat2);
	 double geolong2 = Math.toRadians(long2);
	 distance = RADIUS*Math.acos(Math.sin(geolat1)*Math.sin(geolat2) + Math.cos(geolat1)*Math.cos(geolat2)*Math.cos(geolong1-geolong2));
	 return (distance);
  }

  public void scheduler(){
    
    while(end == false){

    System.out.println("******************************************");
    System.out.println("        iCalender Event Scheduler         ");
    System.out.println("******************************************");
    System.out.println("Instructions: The following options will schedule an event.");
    System.out.println("              Please choose from the list to setup the event.");

    System.out.println("1: Quit");
    System.out.println("2: Create Event");
    System.out.println("3. Modify Event");


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


            // input and format of the date field

            while(dend == false){

              System.out.println("\nEnter the date in this format: MM/DD/YYYY");
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
            System.out.println("Select the following option to modify the event\n");
            System.out.println("1. Geographical position");
            
            inputchoice = sc.nextInt();
            if(inputchoice == 1){  
            System.out.println("Enter latitude for the geographical position:");
            lat = sc.nextFloat();
            System.out.println("Enter longitude for the geographical position:");
            longi = sc.nextFloat();

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(6);
            nf.setGroupingUsed(false);
            geolatf = nf.format(lat).toString();
            geolonf = nf.format(longi).toString();

	try{
            	BufferedReader readoutput = new BufferedReader(new FileReader("sortedEvents.txt"));
            	
            	readoutput.read(traceoutput,0,199); //stores events
            	for (int i = 0; i < readLat1.length; i++){
            		readLat1[i] = traceoutput[i+24]; //stores 1st row latitude coordinates
            		readLat2[i] = traceoutput[i+67]; //stores 2nd row latitude coordinates
            	}
            	
            	for (int i = 0; i < readLongi1.length; i++){
            		readLongi1[i] = traceoutput[i+33]; //stores 1st row longitude coordinates
            		readLongi2[i] = traceoutput[i+77]; //stores 2st row longitude coordinates            		
            	}            	                 	
            	        
            	String storeLat1 = new String(readLat1);
            	String storeLongi1 = new String(readLongi1);
            	String storeLat2 = new String(readLat2);
            	String storeLongi2 = new String(readLongi2);
            	
            	greatCircleDistance(Double.parseDouble(storeLat1),Double.parseDouble(storeLongi1),Double.parseDouble(storeLat2),Double.parseDouble(storeLongi2));       
            	System.out.println("Distance:");
            	readoutput.close();
        }
        catch(IOException e){
            System.out.println("Error: File not found.");
        }
            sc.nextLine();
            break;
            }
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
      output.write("COMMENT:" + "Event:" + distance + "\n");      
      output.write("END:VEVENT\n");
      output.write("END:VCALENDAR\n");

      output.close();

    }
    catch(Exception e){
      System.out.print("Error");
    }
    }

    System.exit(0);
  }

}
