public class ListedPriorityQueue {

    SortedList list ;

    ListedPriorityQueue(){
        list =  new SortedList();
    }

    void incert(long item){
        list.insert(item);
    }
    long get(){
        return list.getFirst();
    }

    void show(){
        while(!list.isEmpty()){
            System.out.print(get() + " , ");
        }
    }
}
