public class Test {
    public static void main(String[] args) {
        int maxSize = 100;
// Размер массива
        ArrayBub arr;
// Ссылка на массив
        arr = new ArrayBub(maxSize); // Создание массива
        arr.insert(77);
        arr.insert(99);
// Вставка 10 элементов
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();
// Вывод элементов
        arr.EvenOddSort();
// Пузырьковая сортировка элементов
        arr.display();

        System.out.println("///////////////////////////////");

        int maxSize2 = 100;
// Размер массива
        ArrayIns arr2;
// Ссылка на массив
        arr2 = new ArrayIns(maxSize); // Создание массива
        arr2.insert(16);
        arr2.insert(15);
        arr2.insert(14);
        arr2.insert(11);
        arr2.insert(10);
        arr2.insert(9);
        arr2.insert(2);
        arr2.insert(2);
        arr2.insert(7);
        arr2.insert(5);
        arr2.insert(3);

// Вставка 10 элементов

        arr2.display(); // Вывод элементов
        arr2.insertionSort(); // Сортировка методом вставки
        arr2.display();
        arr2.median();
// Вставка 10 элементов
    }
}
