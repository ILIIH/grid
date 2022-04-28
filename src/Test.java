public class Test {
    public static void main(String[] args) {
        Queue theQueue = new Queue(3); // Очередь из 5 ячеек

        theQueue.insert(1);
        theQueue.insert(2);
        theQueue.insert(3);

        theQueue.insert(4);


        theQueue.show();
        System.out.println("--------------------------------------");
        Dqeue theDueue = new Dqeue(4); // Очередь из 5 ячеек

        theDueue.insertLeft(1);
        theDueue.insertLeft(2);
        theDueue.insertRight(3);

        theDueue.insertRight(4);
        theDueue.insertLeft(5);

        theDueue.show();

        System.out.println("--------------------------------------");
        Stack stack = new Stack(3);
        stack.put(1);
        stack.put(2);
        stack.put(3);
        stack.put(4);
        stack.put(5);

        stack.show();

        System.out.println("--------------------------------------");

        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        thePQ.show();

    }
}
