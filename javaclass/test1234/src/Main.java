import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int a;
        int b;
        a = 5;
        b = 6;
        int c = add(a, b);
        System.out.println("a=" + a);

        //comment
        // this is single line comment
        /*
            this is
            multi line comment
         */

        //data types
        int v1 = 5;
        float v2 = 5.5f;
        long v3 = 100;
        double v4 = 5.5;
        boolean v5 = true; //false
        char v6 = 'a';
        short v7 = 3;

        //type casting
        float x = 7.8f;
        int y = (int) x;
        double z = y;

        //operators
        //arithmatic +. -, /, %, ++, --
        //assignment operator
        //=, +=, -=, /=, %=....
        //left shift <<
        a = 5; //binary value 5=101
        b = a << 2; //left shifted value 10100
        //right shift >>
        b = a >> 2; //001

        //logical operator
        //operators returns true/false
        //or - || and && not - !

        //bitwise operator
        a = 5 + 3; //101 + 011
        a = 5 | 3; //101 + 011 = 111
        //bitwise or - |, &, ^, ~

        //terinary operator (? :)
        //a=(condition)?valeu if condition is true : value if condition is flase
        a = 5;
        b = 3;
        boolean x = (a < b) ? true : false;

        //if else
        if (a < 5)
            System.out.println("a is greater");

        if (a < 5) {
            System.out.println("a is greater");
        }

        if (a < 5) {
            System.out.println("a is greater");
        } else {
            System.out.println("a is smaller");
        }

        a = 5;
        switch (a) {
            case 1:
                System.out.println("a is 1");
                break;
            case 2:
                System.out.println("a is 2");
                break;
            default:
                System.out.println("a is unknown");
        }

        //loop
        //for loop
        //for(initialize; condtion; any statement)
        for (int i = 0; i < 5; i++) {
            System.out.println("Appu");
        }

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        //using normal for loop
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }

        //using for each
        for (int x1 : nums) {
            System.out.println(x);
        }

        //while
        //while(condition){
        // body
        //}
        int i=6;
        while(i<5){
            System.out.println("Appu");
            i++;
        }

        //do while do{}while(condition)
        do{
            System.out.println("Appu");
            i++;
        }while(i<5);

        //break
        for(int i=0; i<10; i++){
            System.out.println("Appu");
            if(i==5){
                break;
            }
        }

        //continue
        for(int i=0; i<10; i++){
            if(i%2==0){
                continue;
            }
            System.out.println("Appu");
        }
    }

    public static int add(int x,int y){
        int z=0;
        z=x+y;
        return z;
    }
}




