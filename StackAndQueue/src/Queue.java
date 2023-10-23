import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue {
    public static void main(String[] args) {
        LinkedQueueOfStrings stack = new LinkedQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) StdOut.print(stack.pop() + " ");
            else stack.push(s);
        }
    }
}
