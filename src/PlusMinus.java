/**
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
 * Print the decimal value of each fraction on a new line with 6 places after the decimal.
 * 
 * SAMPLE INPUT:
 * 6 (size of the array)
 * -4 3 -9 0 4 1 (numbers present in the array)
 * 
 * SAMPLE OUTPUT:
 * 0.500000
 * 0.333333
 * 0.166667
 * 
 * EXAMPLE
 * arr = [1,1,0,-1,-1]
 * There are n=5 elements, two positive, two negative, and one zero.
 * Their rations are: 2/5 = 0.400000, 2/5 = 0.400000 and 1/5 = 0.200000
 * Results are printed as:
 *  0.400000
 *  0.400000
 *  0.200000
 * 
*/

package src;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class PlusMinus {

    public static void calculate(List<Integer> arr) {
        
        //initialize variables
        float positiveValue = 0, negativeValue = 0, zeroValue = 0;
        
        //loop through List arr
        for (int i : arr) {
            //if "i" is greater than, less than, or equal to 0
            //increase relative variable
            if(i > 0) positiveValue++;
            if(i < 0) negativeValue++;
            if(i == 0) zeroValue++;
        }
        
        //to get the perspective ratios divide the size of the array by the variable value
        //for instance say there were 3 positive integers in an array with the size of 6: 3/6 or 0.5

        //format the ratio in the print statement
        System.out.println(String.format("%.6f", positiveValue/arr.size()));
        System.out.println(String.format("%.6f", negativeValue/arr.size()));
        System.out.println(String.format("%.6f", zeroValue/arr.size()));        
    }

    public static void print() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //integer isn't called - when removed the code doesn't execute properly??
        // int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        PlusMinus.calculate(arr);

        bufferedReader.close();
    }
}