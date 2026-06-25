import java.util.*;

public class Main {
    public static void main(String[] args) {

        //1. Array List without data type
        ArrayList l = new ArrayList();

        //For any data structure
        //- insert new element
        // - read(get) element from the data structure
        // - delete/remove element from data structure
        // - length of the data structure

        //insert ew element
        Student s = new Student(11);
        l.add(s);
        l.add(new Student(22));
        l.add(new Student(33));

        //what is the length of the list
        System.out.println(l.size());

        //read first element from the list
        Object t1 = l.get(0);
        //System.out.println(t1.val); //throws error

        Student t2 = (Student)l.get(0);
        System.out.println(t2.val);

        Student t3 = (Student)l.get(l.size()-1);
        System.out.println(t3.val);

        //using C, C++ style for loop
        System.out.println("C, C++ style for loop");
        for (int i=0; i<l.size(); i++){
            System.out.println(((Student)l.get(i)).val);
        }

        //for each
        System.out.println("Python style - for each for loop");
        for (Object x: l){
            System.out.println(((Student)x).val);
        }

        //delete
        l.remove(0);
        System.out.println("After removing 0th element");
        for (Object x: l){
            System.out.println(((Student)x).val);
        }

        //Student specific list container
        ArrayList<Student> l1 = new ArrayList<Student>();
        l1.add(new Student(44));
        l1.add(new Student(55));
        l1.add(new Student(66));

        //get 0th element
        Student t4= l1.get(0);
        System.out.println(t4.val);

        //preferred way of implementation
        System.out.println("Using List interface");
        List<Student> l2 = new ArrayList<Student>();
        l2.add(new Student(77));
        l2.add(new Student(88));
        l2.add(new Student(99));

        //get 0th element
        Student t5= l2.get(0);
        System.out.println(t5.val);

        //using linked list
        System.out.println("Using Linked List");
        List<Student> l3 = new LinkedList<Student>();
        l3.add(new Student(77));
        l3.add(new Student(88));
        l3.add(new Student(99));

        //get 0th element
        Student t6= l3.get(0);
        System.out.println(t6.val);

        //Queue
        Queue<Integer> q = new PriorityQueue<Integer>();
        q.add(77);
        q.add(88);
        q.add(99);

        //get element from queue
        System.out.println("Queue");
        System.out.println("Queue length " + q.size());
        Integer t7= q.poll();
        System.out.println(t7);
        System.out.println("Queue length after one poll " + q.size());

        //get element from queue using peek
        System.out.println("Queue");
        System.out.println("Queue length " + q.size());
        Integer t8= q.peek();
        System.out.println(t8);
        System.out.println("Queue length after one peek " + q.size());

        //Stack
        Stack<Integer> st = new Stack<Integer>();
        st.add(77);
        st.add(88);
        st.add(99);

        //get element from stack
        System.out.println("Stack");
        System.out.println("Stack length " + st.size());
        Integer t9= st.pop();
        System.out.println(t9);
        System.out.println("Stack length after one pop " + st.size());

        //get element from stack using peek
        System.out.println("Stack");
        System.out.println("Stack length " + st.size());
        Integer t10= st.peek();
        System.out.println(t10);
        System.out.println("Stack length after one peek " + st.size());
    }
}