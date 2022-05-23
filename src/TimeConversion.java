/**
 * Given a 12 hour AM/PM format, convert it to 24 hour time
 * 
 * SAMPLE INPUT
 * 07:05:45PM
 * 
 * SAMPLE OUTPUT
 * 19:05:45
 *  
 * EXAMPLE
 * s='12:01:00PM'
 * return '12:01:00'
 * s='12:01:00PM'
 * return '00:01:00'
*/


package src;

import java.io.*;
import java.text.*;

public class TimeConversion {
    public static String convert(String s){

        DateFormat twelveHourFormat = new SimpleDateFormat("hh:mm:ssa");
        DateFormat twentyFourHourFormat = new SimpleDateFormat("HH:mm:ss");
        
        try{
            return twentyFourHourFormat.format(twelveHourFormat.parse(s));
        } catch(ParseException e){
            return s;
        }
    }

    public static void print() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversion.convert(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
