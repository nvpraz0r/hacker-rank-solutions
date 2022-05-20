/**
 * There is a collection of input strings and a collection of query strings.
 * For each query string, determine how many times it occurs in the list of input strings.
 * Return an array of the results.
 * 
 * EXAMPLE
 * strings = [ab, ab, abc]
 * queries = [ab, abc, bc]
 * There are two instances of 'ab', one of 'abc' and zero of 'bc'.
 * For each query, add an element to the return array, results=[2,1,0]
*/


package src;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SparseArray {
    public static List<Integer> CollectionResult(List<String> strings, List<String> queries) {
        List<Integer> sol = new ArrayList<>();
        
        for(int i = 0; i < strings.size(); i++){
            sol.add(Collections.frequency(strings, i));
        }
        
        return sol;
    }

    public static void Main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        //Collection Result can change to HashMapResult
        List<Integer> res = SparseArray.CollectionResult(strings, queries);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
