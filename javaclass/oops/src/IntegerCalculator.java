public class IntegerCalculator extends BaseCalculator{
    public String add(String a, String b){
        System.out.println("IntegerCalculator.add method called");
        int c=Integer.valueOf(a) + Integer.valueOf(b);
        return Integer.toString(c);
    }
}
