//***********************************************************************************************
//  Team: Doze
//  ICS 314
<<<<<<< HEAD
//  Authors: Dorienne Matsuno, Marlene Abut, Jacob Dalton
=======
//  Authors: Dorienne Matsuno, Marlene Abut, Jacob Dalton
>>>>>>> origin/master
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
    // Scanner to read user input
    Scanner sc = new Scanner (System.in);

    // strings for the date and the correct format
    final String uformat = "MM/dd/yyyy";
    final String cformat = "yyyy/MM/dd";

    // declarations of variables used for the .ics file
    boolean end = false;
    int choice = 0;
    File file = null;
    String ver = "VERSION:", pvt = "PRIVATE", pub = "PUBLIC", con = "CONFIDENTIAL";
    double verNum = 2.0;
    String timez = "", tx = "", dtstart = "", dtend = "", upper = "";
    String location = "", summary = "", input = "", cl = "", priority = "";
    String newStartDateStr  = "", newEndDateStr = "";
    String[] splitTime, splitDate;
    String sTime = "", eTime = "", sHTime = "", sMTime = "", eHTime = "", eMTime = "", sDate = "", eDate = "";
    int intETime, intSTime, intSHTime, intSMTime, intEHTime, intEMTime, intPriority;

//***********************************************************************************************
//  start of code
//***********************************************************************************************

    ver = ver.concat(verNum + "\n");

    System.out.println("\nThis program is to create an event that gets exported");
    System.out.println("to a .ics file and then could be imported to a calendar");
    System.out.println("application.");

    while(end == false) {

      System.out.println("\nPlease pick from the following options to create an");
      System.out.println("event: ");
      System.out.println("\n1. Single day event \n2. Multiple day event \n3. quit");

      input = sc.nextLine();

      try {
          choice = Integer.parseInt(input);
          if(choice<4){

            switch(choice){

                case 1:

                    // user input for the name of the event
                    System.out.println("\nYou have chosen a single day event.");
                    System.out.println("Event name: ");
                    input = sc.nextLine();
                    summary = summary.concat(input+"\n");

                    // user input for the location of event
                    System.out.println("\nLocation of Event: ");
                    input = sc.nextLine();
                    location = location.concat(input+"\n");

                    // user input for the date of event
                    System.out.println("\nEnter date (MM/DD/YYYY) of event: ");
                    input = sc.nextLine();

                    // formats the date
                    SimpleDateFormat sdf = new SimpleDateFormat(uformat);
                    try {

                        // changes date to match the calendar formatting
                        Date d = new Date();
                        d = sdf.parse(input);
                        sdf.applyPattern(calFormat);
                        newStartDateStr = sdf.format(d);

                        // removes all the things not used in the calendar format
                        input = newStartDateStr.replaceAll("/", "");
                        dtstart = dtstart.concat(input);
                        dtend = dtstart;

                    }
                    catch(ParseException pe){

                        // helps find problems in code, if any
                        pe.printStackTrace();
                    }

                    // user input for the  start and end time of the event
                    System.out.println("\nStart time (ex. 8am or 8:30am) of the event: ");
                    sTime = sc.nextLine();
                    System.out.println("\nEnd time (ex. 10am or 10:30am) of the event: ");
                    eTime = sc.nextLine();

                    // format time for calendar format
                    if(sTime.contains("am")){

                        sTime = sTime.replace("am", "");

                        if(sTime.contains(":")){

                            splitTime = sTime.split(":");
                            
                        }
                    }




            }
          }

      }
      catch (java.lang.NumberFormatException se){

        System.out.println("\nYou have entered an invalid selection.");
        System.out.println("\nPlease try again.");
      }
    }
    System.exit(0);
  }
}
