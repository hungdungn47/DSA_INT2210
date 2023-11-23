package bonus_hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        Collections.sort(arr);
        Collections.sort(brr);
        int i = 0;
        int j = 0;
        System.out.println(arr);
        System.out.println(brr);
        List<Integer> res = new ArrayList<>();
        while(i < arr.size() && j < brr.size()) {
            if(arr.get(i) > brr.get(j)) {
                if(!res.contains(brr.get(j))) {
                    res.add(brr.get(j));
                }
                j++;
            } else if(arr.get(i) < brr.get(j)) {
                i++;
            } else if(Objects.equals(arr.get(i), brr.get(j))) {
                i++;
                j++;
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = in.nextInt();
            arr.add(x);
        }

        int m = in.nextInt();

        List<Integer> brr = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int x = in.nextInt();
            brr.add(x);
        }

        List<Integer> result = Result.missingNumbers(arr, brr);

        System.out.println(result);
    }
}
