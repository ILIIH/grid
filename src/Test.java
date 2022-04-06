public class Test {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;
// Ссылка на массив
        arr = new HighArray(maxSize); // Создание массива
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(11);
        arr.insert(11);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33); // Вставка 10 элементов
        arr.display(); // Вывод элементов
        int searchKey = 35;
// Поиск элемента
        if( arr.find(searchKey) )
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
        arr.delete(00);
        arr.delete(55);
        arr.delete(99);
// Удаление трех элементов

        System.out.println("Max " + arr.getMax());
        System.out.println("Max removed " + arr.removeMax());
        arr.display();

        // Сортировка
        HighArray Sortedarr =  new HighArray(maxSize);
        while(arr.getMax()!=-1){
            Sortedarr.insert(arr.removeMax());
        }
        System.out.println("Sorted ");
        Sortedarr.display();

        System.out.println("No doubt ");
        Sortedarr.noDups();
        Sortedarr.display();
    }
}
