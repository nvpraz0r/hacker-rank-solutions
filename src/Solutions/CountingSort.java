/**
 * Note: example is worded poorly.
 * Given a list of integers, count and return the number of times each value appears as an array of integers.
*/

package src.Solutions;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class CountingSort {
    public static List<Integer> sort(List<Integer> arr) {
        
        // List<Integer> result = new ArrayList<Integer>();
        // while(result.size() < 100)
        //     result.add(0);
        
        // for(int i : arr)
        //     result.set(i, result.get(i) + 1);
        
        // return result;
        
        //-------------------------------------------------------
        
        // List<Integer> freqArray = new ArrayList<Integer>();
        // int value;
        // int freq;
        
        // for(int i = 0; i < 100;i++){
        //     freqArray.add(0);            
        // }
        
        // for(int i = 0; i < arr.size(); i++){
        //     value = arr.get(i);
        //     freq = freqArray.get(value);
            
        //     freqArray.set(value, freq+1);            
        // }
                
        // return freqArray;
        
        //-------------------------------------------------------
        
        int[] freq = new int[100];
        for(int x: arr)freq[x]++;                 
        return IntStream.of(freq).boxed().collect(Collectors.toList());
    }
    
    public static void print() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //integer isn't called - when removed the code doesn't execute properly??
        // int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = CountingSort.sort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
