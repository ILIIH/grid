class ArrayBub
{
    private long[] a;
// Ссылка на массив a
private int nElems;
    // Количество элементов данных
//--------------------------------------------------------------

    public ArrayBub(int max)
// Конструктор
    {
        a = new long[max];
// Создание массива
        nElems = 0;
// Пока нет ни одного элемента
    }
    //--------------------------------------------------------------
    public void insert(long value)
// Вставка элемента в массив
    {
        a[nElems] = value;
// Собственно вставка
        nElems++;
// Увеличение размера
    }
    //--------------------------------------------------------------
    public void display()
// Вывод содержимого массива
    {
        for(int j=0; j<nElems; j++)
// Для каждого элемента
            System.out.print(a[j] + " "); // Вывод
        System.out.println("");
    }
    //--------------------------------------------------------------
    public void bubbleSort()
    {
        int out, in ,in2 ;
        for(out=nElems-1; out>1; out--)
// Внешний цикл (обратный)
            for(in=0; in<out; in++)
// Внутренний цикл (прямой)
                if( a[in] > a[in+1] ){
                    swap(in, in+1);
                if(in == out-1 ){
                    for(in2=in; in2>out; in2--)
                        if( a[in2] < a[in2-1] )
                            swap(in2, in2-1);
                    }
                }
// Поменять местами
    }

    public void EvenOddSort(){
        var sorted = false;
        while(!sorted) {
            sorted = true;
            for (var i = 1; i < nElems - 1; i += 2) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    sorted = false;
                }
            }

            for (var i = 0; i < nElems - 1; i += 2) {
                if (a[i] > a[i + 1]) {
                    swap( i, i + 1);
                    sorted = false;
                }
            }
        }}

    //--------------------------------------------------------------
    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
} // Конец класса ArrayBub