import java.util.*;
import java.text.*;
import java.io.*;

public class CalendarEvent {
  public static void main (String [] arg){

    // Scanner to read user input
    Scanner sc = new Scanner (System.in);

    // strings for the date and the correct format
    final String uformat = "MM/dd/yyyy";
    final String cformat = "yyyy/MM/dd";

    // declarations of variables used for the .ics file
    boolean end = false;
    String input = "";
    int choice = 0;
    File file = null;
    String ver = "VERSION:", pvt = "PRIVATE", pub = "PUBLIC", con = "CONFIDENTIAL";
    double verNum = 2.0;
    String timez = "", tx = "",dtstart = "", dtend = "", upper = "";
    String location = "", summary = "", input = "", cl = "", priority = "";
    String newStartDateStr  = "", newEndDateStr = "";
    String[] splitTime, splitDate;
    String sTime = "", eTime = "", sHTime = "", sMTime = "", eHTime = "", eMTime = "", sDate = "", eDate = "";
    int intETime, intSTime, intSHTime, intSMTime, intEHTime, intEMTime, intPriority;
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

      }
      catch (java.lang.NumberFormatException se){

        System.out.println("\nYou have entered an invalid selection.");
        System.out.println("\nPlease try again.")
      }
    }
    System.exit(0);
  }
}