public class StringCalculator1 implements CalculatorInterface{
    public String add(String a, String b){
        System.out.println("StringCalculator.add method called");
        return a+b;
    }
}
