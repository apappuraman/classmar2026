public class Student1 implements Comparable<Student1>{
    int val;

    public Student1(int v){
        val=v;
    }

    @Override
    public int compareTo(Student1 o) {
        return this.val-o.val;
    }
}
