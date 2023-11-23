import java.io.*;
import java.util.*;

public class SimpleTextEditor {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    private static String[] states = new String[1000005];
    private static char[] curr = new char[2000005];
    private static int size = 0;
    private static int num_of_states = 1;
    private static void append(String w) {
        for(int i = 0; i < w.length(); i++) {
            curr[size++] = w.charAt(i);
        }
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < size; i++) s.append(curr[i]);
        states[num_of_states++] = s.toString();
    }
    private static void delete(int k) {
        size -= k;
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < size; i++) s.append(curr[i]);
        states[num_of_states++] = s.toString();
    }
    private static void print(int k) {
        System.out.println(curr[k - 1]);
    }
    private static void undo() {
        if(num_of_states >= 2) {
            String s = states[num_of_states - 2];
            num_of_states--;
            size = 0;
            for(int i = 0; i < s.length(); i++) {
                curr[size++] = s.charAt(i);
            }
        }
    }
    public static void main(String[] args) {
        states[0] = "";
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        FastReader in = new FastReader();
        int q = in.nextInt();
        while(q-- > 0) {
            int type = in.nextInt();
            if(type == 1) {
                String w = in.nextLine().split(" ")[1];
                //System.out.println(w);
                append(w);
            } else if(type == 2) {
                int k = in.nextInt();
                delete(k);
            } else if(type == 3) {
                int k = in.nextInt();
                print(k);
            } else {
                undo();
            }
        }
    }
}
