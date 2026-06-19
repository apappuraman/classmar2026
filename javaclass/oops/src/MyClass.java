public class MyClass {
    //member variable
    public int a;

    //static variable
    static int counter;

    //member function
    public void test1(){
        System.out.println("a="+a+" counter="+counter);
    }

    MyClass(){
        counter++;
    }

    //static function
    public static void test2(){
        System.out.println( "counter="+counter);
    }
}
