/**
 * A pangram is a string that contains every letter of the alphabet. 
 * Given a sentence determine whether it is a pangram in the English alphabet.
 * Ignore case. Return either pangram or not pangram as appropriate.
 * 
 * SAMPLE INPUT
 *  we promptly judged antique ivory buckles for the next prize
 * 
 * SAMPLE OUTPUT
 * pangram
*/

package src;

import java.io.*;

public class Pangram {

    public static String sort(String s){
        /**
         * This one can be solved in one line
         *      -convert all to lower
         *      -replace the spaces
         *      -convert to chars
         *      -detect distinct characters
         *      -count said characters
         *      -if count is 26 return "pangram" if not return "not pangram"
        */
        return s.toLowerCase().replace(" ", "").chars().distinct().count() == 26 ? "pangram" : "not pangram";
    }

    public static void print() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Pangram.sort(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
