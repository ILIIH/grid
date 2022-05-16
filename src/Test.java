import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {

        BalancedTree bTree = new BalancedTree();
        bTree.incert(12);
        bTree.incert(22);
        bTree.incert(42);
       bTree.incert(2);
       bTree.incert(26);

        bTree.show();

        int value;
        Tree theTree = new Tree();
        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete: ");
            int choice = getChar();
            switch (choice) {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value, value + 0.9);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = theTree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    }
            }
        }
    }
        // -------------------------------------------------------------
        public static String getString() throws IOException
        {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            return s;
        }
// -------------------------------------------------------------
        public static char getChar() throws IOException
        {
            String s = getString();
            return s.charAt(0);
        }
//-------------------------------------------------------------

    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }

}
