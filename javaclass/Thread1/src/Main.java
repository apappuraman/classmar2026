import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("I am in main thread....");
        //1. sequential way of calling two methods
        //   func1();
        //   func2();

        //2. Creating thread using runnable interface
        /*
        Thread t1 = new Thread(new Mythread1());
        Thread t2 = new Thread(new Mythread2());
        t1.start();
        t2.start();
        try{
        Thread.sleep(1000);}
        catch (Exception e){
            System.out.println("Exception in sleep..");
        }
         */

        //3. creating thread using Thread as base class
        /*
        Thread t1 = new Mythread3();
        Thread t2 = new Mythread4();
        t1.start();
        t2.start();

         */

        //4. similar to #2 but using anonymous class
        /*
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Start: I am in func1...");

                for(int i =0; i<10; i++){
                    System.out.println("Appu...");
                    try{
                        Thread.sleep(100);}
                    catch (Exception e){
                        System.out.println("Exception in sleep..");
                    }
                }
                System.out.println("End: I am in func1...");
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Start: I am in func2...");

                for(int i =0; i<10; i++){
                    System.out.println("Ragavan...");
                    try{
                        Thread.sleep(100);}
                    catch (Exception e){
                        System.out.println("Exception in sleep..");
                    }
                }
                System.out.println("End: I am in func2...");
            }
        });
        t1.start();
        t2.start();
        try{
            Thread.sleep(1000);}
        catch (Exception e){
            System.out.println("Exception in sleep..");
        }

         */

        //5. similar to #4 using lambda
        Thread t1 = new Thread(()->{
            System.out.println("Start: I am in func1...");

            for(int i =0; i<10; i++){
                System.out.println("Appu...");
                try{
                    Thread.sleep(100);}
                catch (Exception e){
                    System.out.println("Exception in sleep..");
                }
            }
            System.out.println("End: I am in func1...");
        });
        Thread t2 = new Thread(()-> {
            System.out.println("Start: I am in func2...");

            for (int i = 0; i < 10; i++) {
                System.out.println("Ragavan...");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println("Exception in sleep..");
                }
            }
            System.out.println("End: I am in func2...");
        });
        t1.start();
        t2.start();
        try{
            Thread.sleep(1000);}
        catch (Exception e){
            System.out.println("Exception in sleep..");
        }
        System.out.println("End of main thread...");

    }


    private static void func1(){
        System.out.println("Start: I am in func1...");
        for(int i =0; i<10; i++){
            System.out.println("Appu...");
            try{
                Thread.sleep(100);}
            catch (Exception e){
                System.out.println("Exception in sleep..");
            }
        }
        System.out.println("End: I am in func1...");
    }

    private static void func2(){
        System.out.println("Start: I am in func2...");
        for(int i =0; i<10; i++){
            System.out.println("Ragavan...");
            try{
                Thread.sleep(100);}
            catch (Exception e){
                System.out.println("Exception in sleep..");
            }
        }
        System.out.println("End: I am in func2...");
    }

}