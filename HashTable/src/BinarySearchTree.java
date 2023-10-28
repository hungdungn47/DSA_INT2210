import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable, Value> {
    Node root;
    public void put(Key key, Value val) {
        root = put(key, val, root);
    }
    private Node put(Key key, Value val, Node x) {
        if(x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {
            x.left = put(key, val, x.left);
        } else if(cmp > 0) {
            x.right = put(key, val, x.right);
        } else {
            x.val = val;
        }
        return x;
    }
    public Value get(Key key) {
        Node x = root;
        while(x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }
    public void printWithBracelets() {
        printWithBracelets(root);
        System.out.println();
    }
    private void printWithBracelets(Node x) {
        if(x == null) return;
        System.out.print("(");
        printWithBracelets(x.left);
        System.out.print(" " + x.key + " ");
        printWithBracelets(x.right);
        System.out.print(")");
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        inOrder(root, queue);
        return queue;
    }
    public Iterable<Key> keysDescending() {
        Queue<Key> queue2 = new LinkedList<>();
        reverseInOrder(root, queue2);
        return queue2;
    }
    private void inOrder(Node x, Queue<Key> queue) {
        if(x == null) return;
        inOrder(x.left, queue);
        queue.add(x.key);
        inOrder(x.right, queue);
    }
    private void reverseInOrder(Node x, Queue<Key> queue) {
        if(x == null) return;
        reverseInOrder(x.right, queue);
        queue.add(x.key);
        reverseInOrder(x.left, queue);
    }
    public void preOrderPrint() {
        System.out.println("Pre order");
        preOrderPrint(root);
        System.out.println();
    }
    private void preOrderPrint(Node x) {
        if(x == null) return;
        System.out.print(x.key + " ");
        preOrderPrint(x.left);
        preOrderPrint(x.right);
    }
    public void postOrderPrint() {
        System.out.println("Post order");
        postOrderPrint(root);
        System.out.println();
    }
    private void postOrderPrint(Node x) {
        if(x == null) return;
        postOrderPrint(x.left);
        postOrderPrint(x.right);
        System.out.print(x.key + " ");
    }
    public Key min() {
        return min(root);
    }
    private Key min(Node x) {
        if(x.left == null) return x.key;
        return min(x.left);
    }
    public Key max() {
        return max(root);
    }
    private Key max(Node x) {
        if(x.right == null) return x.key;
        return max(x.right);
    }
    public Key floor(Key key) {
        return floor(key, root);
    }
    private Key floor(Key key, Node x) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return key;
        if(cmp < 0) {
            return floor(key, x.left);
        }
        Key res = floor(key, x.right);
        if(res != null) return res;
        return x.key;
    }
    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if(x == null) return null;
        if(x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }
    public void delete(Key key) {
        root = delete(key, root);
    }
    private Node delete(Key key, Node x) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {
            x.left = delete(key, x.left);
        } else if(cmp > 0) {
            x.right = delete(key, x.right);
        } else {
            if(x.left == null) {
                return x.right;
            }
            if(x.right == null) {
                return x.left;
            }
            Key minRightKey = min(x.right);
            Value minRightValue = get(minRightKey);
            deleteMin(x.right);
            x.key = minRightKey;
            x.val = minRightValue;
        }
        return x;
    }
    private class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
}
