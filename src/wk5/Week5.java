package wk5;

import java.security.SecureRandom;
import java.util.*;

public class Week5 {

    static void example1(){

        //ObjectClassName<Reference Data Type> nameOfVar = new ObjectClassName<>();

        ArrayList<Integer> nums = new ArrayList<>();


        nums.add(123);
        nums.add(456);
        nums.add(987);

        //iterator

        //loop to cycle thru all values

        for(int i = 0; i < nums.size(); i++){
            System.out.println(nums.get(i));
        }


        //Iterator Object
        Iterator<Integer> iterator = nums.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /*

            values          100             200         300         400
            indexes         0               1           2           3
            iterator
                       ^
                            after next() call
                                     ^
                                                                            ^
         */


    }

    static void example2(){


        LinkedList<Double> linkedList = new LinkedList<>();

        linkedList.add(123d);
        linkedList.add(456D);
        linkedList.add(76.54);

        SecureRandom random = new SecureRandom();

        for(int i = 0; i < 5; i++){

            linkedList.add((double) random.nextInt(100, 500));
        }

        ArrayList<Double> arrayList = new ArrayList<>(linkedList);

        //add a value to the first index
        //arraylist
        arrayList.add(0, 975d);
        linkedList.addFirst(420d);
        linkedList.add(3, 426d);

        List<Double> subList = linkedList.subList(0, 3);

        LinkedList<Double> secondLinkedList = new LinkedList<>(subList);
        ArrayList<Double> arrayList1 = new ArrayList<>(subList);

        linkedList.addAll(2, secondLinkedList);

//        arrayList.addAll(1, subList);


        ListIterator<Double> listIterator = linkedList.listIterator();

        for(int i = 0; i < linkedList.size(); i++){
            System.out.printf("Index %d has value of %.1f%n", i, linkedList.get(i));
        }
        listIterator.hasNext();; //what is result?
        listIterator.next(); //420
        listIterator.hasPrevious();
        listIterator.previous(); //420
        listIterator.hasPrevious();
        listIterator.next();
        listIterator.next();
        listIterator.next(); //what is the value


        Object[] array1 = linkedList.toArray();

        Collections.shuffle(arrayList);
        ArrayList<Double> copiedList = new ArrayList<>();
//        for(int i = 0;  i < linkedList.size(); i++){
//            copiedList.add(1d);
//        }
        Collections.copy(linkedList,copiedList); // will throw IndexOutOf ounds Exception
        //if copiedList is not the same size

    }

    static void example3(){

        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(123d);
        priorityQueue.offer(456d);
        priorityQueue.add(-100d);

        while(priorityQueue.size() > 0){

            System.out.println(priorityQueue.poll());
        }
    }

    static void example4(){

        TreeSet<Double> doubleTreeSet = new TreeSet<>();
        HashSet<Double> doubleHashSet = new HashSet<>();

        //add 10 random values
        addRandomValues(doubleHashSet);
        addRandomValues(doubleTreeSet);

        //output all the values of both Sets
        System.out.println("Tree Set Values Are: ");
        //call a method
        outputValues(doubleTreeSet);
        System.out.println("Hash Set Values Are: ");
        //call a method
        outputValues(doubleHashSet);

    }

    static void outputValues(Collection<Double> data){

        Iterator<Double> values = data.iterator();

        while(values.hasNext()){
            System.out.println(values.next());
        }

    }
    static void addRandomValues( Set data){
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            data.add((double) random.nextInt(-100, 100));
        }

    }

    static void example5(){

        TreeMap<Integer, Double> favNums = new TreeMap<>();
        favNums.put(1, 100d);
        favNums.put(-1, 250d);

        HashMap<String, Double> data = new HashMap<>();
        data.put("course code", 1011d);
        data.put("course time", 9d);

        System.out.println(favNums.get(-1)); // 250

        favNums.containsKey(5); //false
        favNums.containsValue(200); //false

        Set<Integer> favNumsKeys = favNums.keySet();
        for(int key : favNumsKeys){
            System.out.println(favNums.get(key));
        }

    }

    static void example6(){

        /*
            1   8       4       7       9       0       -1      3

                give me this data as unique sorted values in desc order

                put data in a Set
                    which Set? TreeSet
                    Collections class
                        static method reversed
         */

    }
    public static void main(String[] args) {
        example5();
    }
}
