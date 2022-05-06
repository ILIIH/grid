class CycledList
{
    int size = 0 ;
    Link current;

    void incert(long key ){
        Link newLink = new Link(key);
        Link prev;
        if(size==0){
            current = newLink;
            current.next = null;
        }
        else if(size==1){
            prev = current ;
            current = newLink ;
            current.next = prev;
            prev.next = current ;
        }
        else {
            prev = current ;
            current = newLink ;
            current.next = prev.next;
            prev.next = current ;
        }
        size++;
    }

    long peak(int n){
        long choose = 0 ;
        current = current.next;
        for(int i = 0 ; i < n ; i++){
            current = current.next;
            if(i==n-1) {
                choose = current.dData;
                return current.dData;}
        }
        return -1 ;
    }

}