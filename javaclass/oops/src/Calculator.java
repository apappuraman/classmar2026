public class Calculator {
    /*
    to explain private and public access modifier
    private int add(int a, int b){
        System.out.println("add(int, int) called");
        return a+b;
    }

    public int addwrapper(int x, int y){
        System.out.println("addwrapper(int, int) called");
        return add(x,y);
    }
     */

    //method overloading
    public int add(int a, int b){
        System.out.println("add(int, int) called");
        return a+b;
    }

    public double add(double a, double b){
        System.out.println("add(int, int) called");
        return a+b;
    }

    public int add(int a, int b, int c){
        System.out.println("add(int, int) called");
        return a+b;
    }

}
