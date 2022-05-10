public class Multiplayer {



    public static int mult(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }

        else {
            return num1 + mult(num1, num2 - 1);
        }

    }
}
