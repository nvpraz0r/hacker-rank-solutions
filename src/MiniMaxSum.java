/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 * 
 * SAMPLE INPUT
 * 1 2 3 4 5
 * 
 * SAMPLE OUTPUT
 * 10 14
*/

package src;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class MiniMaxSum {

    public static void Result(List<Integer> arr) {
        long max = arr.get(0), min = arr.get(0), sum = 0;
        for (int i : arr) {
            sum += i;
            if(i > max) max = i;
            if(i < min) min = i;
        }
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
