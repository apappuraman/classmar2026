public class Mythread2 implements Runnable {
    private void func2(){
        System.out.println("Start: I am in func2...");
        /*try{
            Thread.sleep(1000);}
        catch (Exception e){
            System.out.println("Exception in sleep..");
        }*/

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

    @Override
    public void run() {
        func2();
    }
}
