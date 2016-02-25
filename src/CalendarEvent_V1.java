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
      e.printStactTrace();
    }

    System.exit(0);
  }
}