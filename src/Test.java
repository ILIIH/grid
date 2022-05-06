public class Test {
    public static void main(String[] args) {

        ListedPriorityQueue PQ = new ListedPriorityQueue();
        PQ.incert(11);
        PQ.incert(2);
        PQ.incert(4);
        PQ.incert(121);
        PQ.incert(1000);
        PQ.incert(19);

        PQ.show();


        CycledList CL = new CycledList();
        CL.incert(1);
        CL.incert(2);
        CL.incert(3);
        CL.incert(4);
        CL.incert(5);
        CL.incert(6);


        System.out.println();
        System.out.println ("////////////////////////////////");  ;
        System.out.println(  CL.peak(7));  ;


        System.out.println ("////////////////////////////////");  ;

        Matrix m1 = new Matrix(2,2);
        m1.get(0,0).dData=100L;
        m1.get(0,1).dData=200L;
        m1.get(1,0).dData=1488L;
        m1.get(1,1).dData=200L  ;

        m1.show();

    }
}
