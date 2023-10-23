public class LinkedStackOfStrings {
    private static class Node {
        Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }

        String item;
        Node next;
    }

    private Node first = null;

    public void push(String item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
