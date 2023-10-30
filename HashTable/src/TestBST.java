public class TestBST {
    public static void testBST() {
        String s = "PSEUDOMYTHICAL";
        BinarySearchTree<Character, Integer> bst = new BinarySearchTree<>();
        for(int i = 0; i < s.length(); i++) {
            bst.put(s.charAt(i), i);
            //bst.printWithBracelets();
        }
        System.out.println("In order");
        for(Character c : bst.keys()) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("Reverse in order");
        for(Character c: bst.keysDescending()) {
            System.out.print(c + " ");
        }
        System.out.println();
        bst.preOrderPrint();
        bst.postOrderPrint();
        System.out.println("Min: " + bst.min());
        System.out.println("Max: " + bst.max());

        bst.delete('E');
        bst.delete('I');
        System.out.println("In order");
        for(Character c : bst.keys()) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
    public static void testRedBlackTree() {
        String s = "PSEUDOMYTHICAL";
        RedBlackTree<Character, Integer> myRbTree = new RedBlackTree<>();
        for(int i = 0; i < s.length(); i++) {
            myRbTree.put(s.charAt(i), i);
        }
        System.out.println("In order");
        for(Character c : myRbTree.keys()) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
    public static void testAVL_Tree() {
        String s = "PSEUDOMYTHICAL";
        AVL_Tree<Character, Integer> myAVL = new AVL_Tree<>();
        for(int i = 0; i < s.length(); i++) {
            myAVL.put(s.charAt(i), i);
        }
        System.out.println("In order");
        for(Character c : myAVL.keys()) {
            System.out.print(c + " ");
        }
        System.out.println();
        myAVL.remove('E');
        System.out.println("In order");
        for(Character c : myAVL.keys()) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        testAVL_Tree();
    }
}
