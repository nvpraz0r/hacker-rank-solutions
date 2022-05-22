/**
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 * 
 * 
 * SAMPLE INPUT
 * 3
 * 11 2 4
 * 4 5 6
 * 10 8 -12
 * 
 * SAMPLE OUTPUT
 * 15
 * 
 * EXAMPLE
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * The left-to-right diagonal = 1+5+9=15
 * The right-to-left diagonal = 3+5+9=17
 * Their absolute difference is |15-17|=2
 * 
 * What the table looks like:
 * 
 *      columns
 * i   0   1   2
 *   +---+---+---+
 * 0 | 1 | 2 | 3 |
 *   +---+---+---+
 * 1 | 4 | 5 | 6 |  Rows
 *   +---+---+---+
 * 2 | 7 | 8 | 9 |
 *   +---+---+---+
 * 
*/
package src;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class DiagonalDifference {
    public static int Result(List<List<Integer>> arr){
        int diagTopToBot = 0, diagBotToTop = 0;

        for(int i = 0; i < arr.size(); i++){
            diagTopToBot += arr.get(i).get(i);
            diagBotToTop += arr.get((arr.size() - 1) - i).get(i);
        }
        
        return Math.abs(diagTopToBot - diagBotToTop);
    }

    public static void Main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalDifference.Result(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
