
class Link
{
    public long dData;
    public Link next;
    public Link(long dd)
    { dData = dd; }
    public void displayLink()
    { System.out.print(dData + " "); }
}


class SortedList
{
    private Link first;

    public SortedList()
    { first = null; }

    public boolean isEmpty()
    { return (first==null); }

    long getFirst(){
        long data = first.dData;
        first = first .next ;
        return data;
    }
    public void insert(long key)
    {
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;
        while(current != null && key > current.dData)
        {
            previous = current;
            current = current.next;
        }
        if(previous==null) first = newLink;

        else
            previous.next = newLink;
        newLink.next = current;
    }

    public Link remove()
    {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

}



