
public class Dqeue {
    private int maxSize;
    private long[] queArray;
    private int left = -1;
    private int right ;
    private int nItems;

    Dqeue( int size){
        maxSize = size;
        queArray = new long[maxSize] ;

    }

    public void insertLeft(int item){
        if(left == maxSize-2)
            left = -1;
        queArray[++left] = item;

        if(nItems<maxSize)nItems++;
    }

    public void insertRight(int item){
        if(nItems == maxSize-1){
            right = nItems;
            queArray[right] = item;
            right--;
        }
        else queArray[++left] = item;

        if(nItems<maxSize)nItems++;
    }

    private boolean isEmpty(){
        if(nItems==0)return true;
        else return false;
    }

    private boolean isFull(){
        if(nItems==maxSize)return true;
        else return false;
    }

    public void show(){
        for(int i = 0;i<nItems;i++){
            System.out.println(queArray[i]);
        }
    }

    public void show( int i ){
            System.out.println(queArray[i]);
    }
}
