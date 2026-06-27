public class Main {
    public static void main(String[] args) {

        int n=3;
        try {
            int val = fac(16);
            System.out.println("Result is: " + val);
        }
        catch(RuntimeException e){
            System.out.println("Failure in calculation. I got an exception. " + e.toString());
        }

        try {
            int val = fac1(17);
            System.out.println("Result is: " + val);
        }
        catch(MyException e){
            System.out.println("Failure in calculation. I got an exception. Error code is: "+ e.getErrorCode() + " " + e.toString());
        }
    }

    public static int fac(int n) throws RuntimeException{
        if(n>16){
            System.out.println("I cannot handle more than 16");
            throw new RuntimeException();
        }
        if(n==0){
            return 1;
        }
        return n*fac(n-1);
    }

    public static int fac1(int n) throws MyException{
        if(n>16){
            System.out.println("I cannot handle more than 16");
            throw new MyException(-12);
        }
        if(n==0){
            return 1;
        }
        return n*fac(n-1);
    }
}