import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /* method overlaoding
        Calculator c = new Calculator();
        int rc=c.add(5,3);
        System.out.println("rc="+rc);

        double rc1=c.add(5.0,3.3);
        System.out.println("rc1="+rc1);

         */

        //method overriding
        /*
        BaseCalculator b1 = new BaseCalculator();
        System.out.println("result="+b1.add("5", "3"));

        BaseCalculator b2 = new IntegerCalculator();
        System.out.println("result="+b2.add("5", "3"));

        BaseCalculator b3 = new StringCalculator();
        System.out.println("result="+b3.add("5", "3"));

         */

        //interface
        /* this throws error
        CalculatorInterface b1 = new CalculatorInterface();
        System.out.println("result="+b1.add("5", "3"));
         */

        /*
        CalculatorInterface b2 = new IntegerCalculator1();
        System.out.println("result="+b2.add("5", "3"));

        CalculatorInterface b3 = new StringCalculator1();
        System.out.println("result="+b3.add("5", "3"));
         */

        /* this throw error as we cannot create obejct for abstract class)
        BaseCalculatorA b1 = new BaseCalculatorA();
        System.out.println("result="+b1.add("5", "3"));
         */
        /*
        BaseCalculatorA b1 = new StringCalculator2A();
        System.out.println("result="+b1.add("5", "3"));

         */

        //static method
        /*
        MyClass m = new MyClass();
        m.test1();
        m.test2();

        new MyClass();
        new MyClass();
        new MyClass();
        new MyClass();
        m.test2();
         */
    //calling static method without obejct creation
        MyClass.test2();
    }
}