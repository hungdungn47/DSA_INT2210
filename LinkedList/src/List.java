public class List<Item> implements MyList<Item> {
    Node<Item> head = null;

    public static class Node<Item> {
        Item data;
        Node<Item> next;

        public Node(Item data, Node<Item> next) {
            this.data = data;
            this.next = next;
        }
    }

    public List() {
        head = null;
    }

    public void addFirst(Item data) {
        head = new Node<Item>(data, head);
    }

    public void append(Item data) {
        head = append(data, head);
    }

    private Node<Item> append(Item data, Node<Item> node) {
        if (node == null) return new Node<Item>(data, null);
        node.next = append(data, node.next);
        return node;
    }

    public void removeLast() {
        if (head != null) head = removeLast(head);
    }

    private Node<Item> removeLast(Node<Item> node) {
        if (node.next == null) return null;
        node.next = removeLast(node.next);
        return node;
    }

    public void removeFirst(Item data) {
        head = removeFirst(head, data);
    }

    private Node<Item> removeFirst(Node<Item> node, Item data) {
        if (node == null) return null;
        if (node.data.equals(data)) return node.next;
        node.next = removeFirst(node.next, data);
        return node;
    }

    public void removeAll(Item data) {
        head = removeAll(head, data);
    }

    private Node<Item> removeAll(Node<Item> node, Item data) {
        if (node == null) return null;
        node.next = removeAll(node.next, data);
        if (node.data.equals(data)) return node.next;
        return node;
    }

    public String toString() {
        return toString(head);
    }

    private String toString(Node<Item> node) {
        if (node == null) return "";
        return node.data + " " + toString(node.next);
    }
}
