public class Mythread3 extends Thread{
    private void func1(){
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

    @Override
    public void run() {
        func1();
    }
}
