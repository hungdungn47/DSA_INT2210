import edu.princeton.cs.algs4.*;

public class StackApply {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) StdOut.print(stack.pop() + " ");
            else stack.push(s);
        }
    }
}