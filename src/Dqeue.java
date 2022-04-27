

public class Dqeue {
    private int maxSize;
    private long[] queArray;
    private int rear = -1;
    private int right ;
    private int nItems;

    Dqeue( int size){
        maxSize = size;
        queArray = new long[maxSize] ;

    }

    public void insertLeft(int item){
        if(rear == maxSize-1)
            rear = -1;
        queArray[++rear] = item;

        if(nItems<maxSize)nItems++;
    }

    public void insertRight(int item){
        if(nItems == maxSize-1){
            right = nItems;
            queArray[right] = item;
            right--;
        }
        else queArray[++rear] = item;

        if(nItems<maxSize)nItems++;
    }

    public void show(){
        for(int i = 0;i<nItems;i++){
            System.out.println(queArray[i]);
        }
    }
}
