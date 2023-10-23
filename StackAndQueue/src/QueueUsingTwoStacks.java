
import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {
    private static long[] queue = new long[100005];
    private static int size = 0;
    private static void enqueue(long x) {
        queue[size++] = x;
    }
    private static void dequeue() {
        for(int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        size--;
    }
    private static void peek() {
        System.out.println(queue[0]);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while(q-- > 0) {
            int t = in.nextInt();
            if(t == 1) {
                long x = in.nextInt();
                enqueue(x);
            } else if(t == 2) {
                dequeue();
            } else if(t == 3) {
                peek();
            }
        }
    }
}
