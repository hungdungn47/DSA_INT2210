interface BaseI {
    void method();
}
class BaseC {
    public void method() {
        System.out.println("hello");
    }
}
class test extends BaseC implements BaseI{
    public static void main(String[] args) {
        (new test()).method();
    }
}


