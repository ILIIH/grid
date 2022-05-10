public class Test {
    public static void main(String[] args) {

        System.out.println(Multiplayer.mult(2,3));
        int lenght = 16 ;
        BreanchPrinter.printTree(lenght,lenght/2);
        System.out.println(pow(2,4));

        Backpack bp = new Backpack();
        bp.CollectBackpack(6,0);
    }

    public static int pow(int n1, int n2){
        if(n2==1)return n1;
        else  return  n1 * pow (n1,n2-1);
    }
}
