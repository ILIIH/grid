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


        theDueue.show();
    }
}
