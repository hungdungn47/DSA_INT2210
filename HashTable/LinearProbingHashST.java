package HashTable;

public class LinearProbingHashST<Key, Value> {
    private final int M = 3001;
    private Key[] keys = (Key[]) new Object[M];
    private Value[] vals = (Value[]) new Object[M];
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public void put(Key key, Value val) {
        int i;
        for(i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if(key.equals(keys[i])) {
                break;
            }
        }
        keys[i] = key;
        vals[i] = val;
    }
    public Value get(Key key) {
        for(int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if(key.equals(keys[i])) {
                return vals[i];
            }
        }
        return null;
    }
    public static void main(String[] args) {
        SeparateChainingHashST<String, String> st = new SeparateChainingHashST<>();
        st.put("Chau", "Vu");
        st.put("Dung", "Nguyen");
        st.put("Manh", "Hoang");
        System.out.println(st.get("Dung"));
    }
}
