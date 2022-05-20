/**
 * Given an array of integers, where all elements but one occur twice, find the unique element.
 * 
 * SAMPLE INPUT
 * 1 1 2
 * 
 * SAMPLE OUTPUT
 * 2
 * 
 * EXAMPLE
 * a=[1,2,3,4,1,2,3]
 * the unique element is 4
*/

package src;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


public class LonelyInteger {

    public static int Result(List<Integer> a) {
        //instatiate sum
        int sum = 0;
        //loop through array
        for(int key: a){
            //use XOR bitwise operator to separate 
            //the unique element from the array
            sum ^= key;
        }
        //return the unique element
        return sum;
    }
    
    public static void Main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = LonelyInteger.Result(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
