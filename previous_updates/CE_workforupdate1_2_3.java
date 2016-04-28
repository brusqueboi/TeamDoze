//***********************************************************************************************
//  Team: Doze
//  ICS 314
//  Authors: Dorienne Matsuno, Marlene Mabut, Jacob Dalton
//
//***********************************************************************************************
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;

public class CalendarEvent {

  class node {

    private String dtstart = "";
    private node next;
    private node previous;
    private String dtend = "";
    private String location = "";
    private String summary = "";
    private String cla = "";

  }

  public static void main (String [] arg){

//***********************************************************************************************
//  Declaration of variables
//***********************************************************************************************

    File file;
    Scanner sc = new Scanner (System.in);
    int choice;
    String input = "";
    String geolatf = "";
    String geolonf = "";
    String geo = "";
    String input2 = "";
    String summary = "";
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
    String filen = "";
    int[] startTime = new int[20];
    int[] endTime = new int[20];
    String[] location = new String[20];
    float longi = 0;
    float lat = 0;
    int nshtime = 0;
    int nehtime = 0;
    int numfile = 0;
    int length =  0;

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

            System.out.println("Add multiple events for a single day.");

            System.out.println("\nHow many event files would you like to add?");
            input = sc.nextLine();



            try{
              numfile = Integer.parseInt(input);

              if(numfile < 1) {

                for (int i = 0; i < numfile; i++) {

                  System.out.println("\nPlease enter the name of the first file: ");
                  filen = sc.nextLine();

                  try {

                    BufferedReader filein = new BufferedReader(filen);

                    while(sc.hasnextLine()){

                      input = sc.nextLine();

                      if(input.contains("DTSTART;TZID=")){

                        try {

                          length = input.length() - 6;
                          startTime[i] = Integer.parseInt(input.substring(length, input.length()));
                          Arrays.sort(startTime);


                        }
                        catch(NumberFormatException e){
                          System.out.println("\nError: Unable to read files start time.");
                        }
                      }

                      if(input.contains("DTEND;TZID=")){

                        try{
                          length = input.length() - 6;
                          endTime[i] = input.substring(length, input.length());
                        }
                        catch(NumberFormatException e){
                          System.out.println("\nError: Unable to read files end time.");
                        }
                      }
                      if(input.contains("Location:")){

                        locations[i] = input.substring(8, input.length());

                      }

                    }
                  }

                  catch(IOException io){
                    System.out.println("\nError: please provide a valid input.");
                  }

                }

              }

              else{

                System.out.println("\nError: Please input a positive number");
              }
            }
            catch(NumberFormatException e){
              System.out.println("\nError: please input a a valid format");
            }

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

      output.close();

    }
    catch(Exception e){
      System.out.print("Error");
    }
    }

    System.exit(0);
  }

}
