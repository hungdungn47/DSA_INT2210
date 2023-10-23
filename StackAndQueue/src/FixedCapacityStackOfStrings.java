public class FixedCapacityStackOfStrings {
    private final String[] s;
    private int N;
    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public void push(String item) {
        s[N] = item;
        N++;
    }
    public String pop() {
        String item = s[--N];
        s[N] = null;
        return item;
    }
}
