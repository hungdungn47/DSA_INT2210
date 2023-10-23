public class ListTest {
    public static void main(String[] args) {
        MyList<String> myList = new List<String>();
        myList.append("Hello");
        myList.append("my");
        myList.append("friend");
        myList.append("Hello");
        myList.removeAll("Hello");
        System.out.println(myList);
    }
}
