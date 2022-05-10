import java.util.ArrayList;

public class Backpack {
    ArrayList<Integer> Items = new ArrayList<Integer>();
    ArrayList<Integer> ItemsInside = new ArrayList<Integer>();

    Backpack (){
        Items.add(3);
        Items.add(2);
        Items.add(3);


    }

    void CollectBackpack(int weight, int i ){


   if(i>=Items.size()) i = 0 ;
   int current = Items.get(i) ;
   if(current<=weight&&weight!=0){

       ItemsInside.add(current);

       CollectBackpack(weight-current,i+1);


   }
   else if(weight!=0) {
       ItemsInside.remove(ItemsInside.get(ItemsInside.size()-1));
       return;
   }

        if(weight == 0 ) {

            return ;
        }

   CollectBackpack(weight,i+1);





    }
}
