import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import edu.princeton.cs.algs4.*;

class Result {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int res = 0;
        int sum_left = 0;
        int sum_right = 0;
        for(int i = 1; i < arr.size(); i++) {
            sum_right += arr.get(i);
        }
        while(sum_left < sum_right) {

            sum_left += arr.get(res);
            res++;
            sum_right -= arr.get(res);
        }
        if(sum_left == sum_right) return "YES";
        else return "NO";
    }

}

public class SherlockArray {
    public static void main(String[] args) throws IOException {

        int t = StdIn.readInt();
        while(t > 0) {
            t--;
            List<Integer> arr = new ArrayList<Integer>();
            int n = StdIn.readInt();
            for(int i = 0; i < n; i++) {
                int x = StdIn.readInt();
                arr.add(x);
            }
            System.out.println(Result.balancedSums(arr));
        }

    }
}
