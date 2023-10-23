public class ResizedArrayStackOfStrings {
    private String[] s;
    private int N;
    ResizedArrayStackOfStrings() {
        s = new String[1];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public void push(String item) {
        if(N == s.length) resize(2 * s.length);
        s[N++] = item;
    }
    public String pop() {
        String item = s[--N];
        if(N <= s.length / 4) resize(s.length / 2);
        return item;
    }
    private void resize(int length) {
        String[] newArray = new String[length];
        if (N >= 0) System.arraycopy(s, 0, newArray, 0, N);
        s = newArray;
    }
}
