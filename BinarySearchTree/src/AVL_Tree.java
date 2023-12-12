import java.util.LinkedList;
import java.util.Queue;

public class AVL_Tree<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value val;
        Node left, right;
        int height;
        int balance;

        Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    Node root;

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        update(x);
        return balance(x);
    }

    private void update(Node x) {
        int leftNodeHeight = (x.left == null) ? -1 : x.left.height;
        int rightNodeHeight = (x.right == null) ? -1 : x.right.height;
        x.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
        x.balance = rightNodeHeight - leftNodeHeight;
    }

    private Node balance(Node x) {
        if (x.balance == -2) {
            if (x.left.balance <= 0) {
                return leftLeftCase(x);
            } else {
                return leftRightCase(x);
            }
        } else if (x.balance == 2) {
            if (x.right.balance >= 0) {
                return rightRightCase(x);
            } else {
                return rightLeftCase(x);
            }
        }
        return x;
    }

    private Node leftLeftCase(Node x) {
        return rightRotation(x);
    }

    private Node leftRightCase(Node x) {
        x.left = leftRotation(x.left);
        return leftLeftCase(x);
    }

    private Node rightRightCase(Node x) {
        return leftRotation(x);
    }

    private Node rightLeftCase(Node x) {
        x.right = rightRotation(x.right);
        return rightRightCase(x);
    }

    private Node leftRotation(Node x) {
        Node newParent = x.right;
        x.right = newParent.left;
        newParent.left = x;
        update(x);
        update(newParent);
        return newParent;
    }

    private Node rightRotation(Node x) {
        Node newParent = x.left;
        x.left = newParent.right;
        newParent.right = x;
        update(x);
        update(newParent);
        return newParent;
    }

    public void remove(Key key) {
        root = remove(root, key);
    }

    private Node remove(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = remove(x.left, key);
        } else if (cmp > 0) {
            x.right = remove(x.right, key);
        } else {
            if (x.left == null) {
                return x.right;
            } else if (x.right == null) {
                return x.left;
            } else {
                if (x.left.height > x.right.height) {
                    Key successorKey = findMax(x.left);
                    Value successorVal = get(successorKey);
                    x.key = successorKey;
                    x.val = successorVal;
                    x.left = remove(x.left, successorKey);
                } else {
                    Key successorKey = findMin(x.right);
                    Value successorVal = get(successorKey);
                    x.key = successorKey;
                    x.val = successorVal;
                    x.right = remove(x.left, successorKey);
                }
            }
        }
        update(x);
        return balance(x);
    }

    private Key findMax(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x.key;
    }

    private Key findMin(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x.key;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        inOrder(root, queue);
        return queue;
    }

    private void inOrder(Node x, Queue<Key> queue) {
        if (x == null) return;
        inOrder(x.left, queue);
        queue.add(x.key);
        inOrder(x.right, queue);
    }
}
