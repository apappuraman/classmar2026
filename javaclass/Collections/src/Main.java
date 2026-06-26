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

        //Set
        Set<Integer> set1 = new HashSet<>();
        set1.add(7);
        set1.add(5);
        set1.add(7);
        set1.add(8);

        System.out.println("set length is: " + set1.size());
        for (Integer x:set1) {
            System.out.println(x);
        }

        Set<Integer> set2 = new HashSet<>();
        set2.add(7);
        set2.add(9);
        set2.add(6);

        System.out.println("set length is: " + set2.size());
        for (Integer x:set2) {
            System.out.println(x);
        }

        //A union B
        set1.addAll(set2);
        System.out.println("A union B: " + set1.size());
        for (Integer x:set1) {
            System.out.println(x);
        }

        //reset set1
        set1.clear();
        set1.add(5);
        set1.add(7);
        set1.add(8);

        //A intersection B
        set1.retainAll(set2);
        System.out.println("A intersection B: " + set1.size());
        for (Integer x:set1) {
            System.out.println(x);
        }

        //reset set1
        set1.clear();
        set1.add(5);
        set1.add(7);
        set1.add(8);

        //A - B
        set1.removeAll(set2);
        System.out.println("A - B: " + set1.size());
        for (Integer x:set1) {
            System.out.println(x);
        }

        Set<Integer> set3 = new TreeSet<>();
        set3.add(7);
        set3.add(9);
        set3.add(6);
        System.out.println("Tree Set: " + set3.size());
        for (Integer x:set3) {
            System.out.println(x);
        }

        Set<Integer> set4 = new LinkedHashSet<>();
        set4.add(7);
        set4.add(9);
        set4.add(6);
        System.out.println("Linked Hash Set: " + set4.size());
        for (Integer x:set4) {
            System.out.println(x);
        }

        //Map (key value pair)
        //  - HashMap
        //  - TreeMap
        //  - LinkedHashMap
        System.out.println("Map");
        Map<String, Student> map = new HashMap<>();
        map.put("appu", new Student(11));
        map.put("ragavan", new Student(22));

        System.out.println("Map length is: "+ map.size());
        Student temp = map.get("appu");
        System.out.println("appu obejct is " + temp.val);

        System.out.println("Key set: " + Arrays.toString(map.keySet().toArray()));
        for (String x:map.keySet()) {
            System.out.println("key="+x+" value="+ map.get(x).val);
        }

        //delete
        map.remove("appu");
        System.out.println("After removing appu");
        for (String x:map.keySet()) {
            System.out.println("key="+x+" value="+ map.get(x).val);
        }

        Queue<Student1> q3 = new PriorityQueue<Student1>();
        q3.add(new Student1(7));
        q3.add(new Student1(9));
        q3.add(new Student1(5));

        System.out.println("Priority Queue");
        for(Student1 x: q3){
            System.out.println(x.val);
        }

        Student1 st1 = new Student1(4);
        Student1 st2 = new Student1(5);

        if(st1.compareTo(st2)==0){
            System.out.println("Equal..");
        }
        else if (st1.compareTo(st2)<0){
            System.out.println("st1 is smaller..");
        }
        else {
            System.out.println("st2 is smaller..");
        }
    }
}