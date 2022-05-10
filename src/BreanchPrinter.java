public class BreanchPrinter {




    public static void printTree(int lenght , int step ){

                if(step==1)return  ;
                else {
                    int counter  = 2 ;
                    for(int i = 0 ; i <lenght ; i++ ){
                        if(counter!=step+2){
                            System.out.print( "-");
                            counter++;
                        }
                        else {
                            System.out.print( "*");
                            counter= 0 ;
                        }
                    }
                    System.out.println("");
                     printTree(lenght, (step)/2);

                }

    }
}
