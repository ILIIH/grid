public class Stack {

    private int maxSize;
    private long[] Array;
    private int nItems=-1;
    private int rear=-1;

    Stack( int size){
        maxSize = size;
        Array = new long[maxSize] ;

    }
    boolean isOverload(){
        return nItems==maxSize-1 ;
    }
    void show(){
        for(int i = 0 ; i<nItems+1;i++){
            System.out.println(Array[i]);
        }
    }
    long pop(){
        long returned = Array[nItems];
        Array[nItems] = 0 ;
        nItems--;
        return  Array[nItems];
    }
    long check(){
      return  Array[nItems];
    }
    void put(long item){
        if(isOverload()&&rear==nItems) {
            rear = 0;
            Array[rear] = item;
        }
        else {
            Array[++ rear ]= item;
           if(!isOverload()) nItems++;}
    }
}
