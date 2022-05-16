import java.util.LinkedList;

class BalancedTree {

    LinkedList<ThreeNodeTree> forest ;

    BalancedTree(){
        forest = new LinkedList<ThreeNodeTree>();
    }
    void show(){
        for(int i =0 ; i<forest.size();i++){
            forest.get(i).show();
        }
    }
    void incert(double item){
        if(forest.isEmpty()){
            ThreeNodeTree temp = new ThreeNodeTree() ;
            temp.incert(item,false);
            forest.add(temp);
        }
        else {
            int i =0;
            boolean poped = false ;
            boolean incerted = false;
            while(i!=forest.size()){

                if(forest.get(i).is_full());
                else {

                    if(forest.get(i).incert(item,poped) == null){
                        incerted = true ;
                        break;
                    }
                    else poped = true ;
                }
                i++;
            }

            if(!incerted) {
                ThreeNodeTree temp = new ThreeNodeTree() ;
                temp.incert(item,false);
                forest.add(temp);
            }
        }
    }
}
class ThreeNodeTree{
    private Node root;

    public ThreeNodeTree() {
        root = null;

    }

    boolean is_full(){
        if(root == null) return false;
        else if(root.leftChild==null)  return false;
        else if(root.rightChild == null) return false;
        return true;
    }

    public void show(){
        System.out.print(root.leftChild+" - "+root + " - "+root.rightChild );
    }

    public  Double incert(double item,boolean poped_iem ){
        Node nod_to_incert = new Node();
        nod_to_incert.dData = item;
        if(root == null) {
            root = nod_to_incert;
            return  null;
        }
        if(poped_iem){
            if(nod_to_incert.dData > root.dData){
                if(root.rightChild==null){
                    Node temp = root;
                    nod_to_incert.leftChild = root.leftChild;
                    temp.leftChild=null;
                    nod_to_incert.rightChild = temp;
                    root = nod_to_incert;
                    return null ;
                }
                else {
                    Node temp = root.rightChild;
                    nod_to_incert.rightChild= temp;
                    nod_to_incert.leftChild = root.leftChild;
                    root = nod_to_incert;
                    return temp.dData ;

                }
            }
            else {
                if(root.leftChild==null){
                    root.leftChild = nod_to_incert;
                    return null;}
                else return nod_to_incert.dData;

            }
        }
        else{
            if( nod_to_incert.dData>root.dData)root.rightChild = nod_to_incert;
            else root.leftChild = nod_to_incert;
        }
        return  null ;
    }
}