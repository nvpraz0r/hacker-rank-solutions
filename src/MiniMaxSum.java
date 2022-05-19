/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 * !!!(The output can be greater than a 32 bit integer, set variables to Long data type)!!!
 * 
 * SAMPLE INPUT
 * 1 2 3 4 5
 * 
 * SAMPLE OUTPUT
 * 10 14
 * 
 * EXAMPLE
 * arr = [1, 2, 3, 4, 5]
 * The minimum is 1+2+3+4=10 and the maximum is 2+3+4+5=14
 * Results are printed as:
 * 10 14
*/

package src;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class MiniMaxSum {

    public static void Result(List<Integer> arr) {
        //initialize variables
        //set max and min to the first integer in the array to guarantee a USEFUL variable
        //if min is set to 0 then the 'algorithm' will malfunction
        long max = arr.get(0), min = arr.get(0), sum = 0;
        //loop through array
        for (int i : arr) {
            //add all elements together
            sum += i;
            //find lowest and highest variables in the array
            //if element is less than or greater than max/min
            //set max/min to element
            if(i > max) max = i;
            if(i < min) min = i;
        }

        //to find the correct values:
        //subtract max from the sum to find the lowest possible value
        //subtract min from the sum to find the highest possible value
        System.out.println((sum - max) + " " + (sum - min));
    }

    public static void Main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        MiniMaxSum.Result(arr);

        bufferedReader.close();
    }
}
