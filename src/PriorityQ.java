class PriorityQ
{
    // Элементы массива сортируются по значению ключа,
// от максимумa (0) до минимума (maxSize-1)
    private int maxSize;
    private long[] queArray;
    private int nItems;
    private int rear = -1 ;
    //-------------------------------------------------------------
    public PriorityQ(int s)
// Конструктор
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }
//-------------------------------------------------------------

    public void show(){

         long[] queArrayPr = new long[maxSize];
            int nItemsPr = 0;
         for(int i =0 ; i < nItems ; i++){
             int j;
             if(nItems==0)
                 queArrayPr[nItemsPr++] = queArray[i];
             else
             {
                 for(j=nItemsPr-1; j>=0; j--)
                 {
                     if( queArray[i] > queArrayPr[j] )
                         queArrayPr[j+1] = queArrayPr[j]; // сдвинуть вверх
                     else
                         break;
                 }
                 queArrayPr[j+1] = queArray[i];
                 nItemsPr++;
             }
         }

         for(int i =0 ; i < nItemsPr ; i++){
             System.out.print(queArrayPr[i]+" ");
         }
    }

public void insert(long j)
{
    if(rear == maxSize-1)
        rear = -1;
    queArray[++rear] = j;
    if(nItems<maxSize)nItems++;
}

public void insertPr(long item)
{
    int j;
    if(nItems==0)
        queArray[nItems++] = item;
    else
    {
        for(j=nItems-1; j>=0; j--)
        {
            if( item > queArray[j] )
                queArray[j+1] = queArray[j]; // сдвинуть вверх
            else
                break;
        }
        queArray[j+1] = item;
        nItems++;
    }
} //


    //-------------------------------------------------------------
    public long remove()
// Извлечение минимального элемента
    { return queArray[--nItems]; }
    //-------------------------------------------------------------
    public long peekMin()
// Чтение минимального элемента
    { return queArray[nItems-1]; }
    //-------------------------------------------------------------
    public boolean isEmpty()
// true, если очередь пуста
    { return (nItems==0); }
    //-------------------------------------------------------------
    public boolean isFull()
// true, если очередь заполнена
    { return (nItems == maxSize); }
//-------------------------------------------------------------
}