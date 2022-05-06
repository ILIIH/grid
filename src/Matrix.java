
class Link2
{
    public Long dData;
    public Link2 nextLine;
    public Link2 nextColumn;
    public Link2(Long dd)
    { dData = dd; }
    public void displayLink() {
        if (dData != Long.MIN_VALUE) System.out.print(dData + " ");
        else System.out.print("-");
    }
}

public class Matrix {

    private Link2 first;
    int Width,Height;
    Matrix(int width,int height){
        Width= width;
        Height = height;
        for(int i = 0 ;i <width;i++){
            for(int j =0 ; j<height;j++){
                init(i,j);
            }
        }

    }

    void show(){
        Link2 curent = first ;
        for(int i =0;i<Width;i++){

            for(int j =0 ; j<Height;j++){
                System.out.print(curent.dData+" ");
                if(curent.nextLine==null)break;
                curent = curent.nextLine;
            }
            System.out.println("");
            System.out.println("");

            if(i==0&&first.nextColumn!=null)curent = first.nextColumn;
            else if(curent.nextColumn!=null) curent = curent.nextColumn;
        }
    }

    void init(int x , int y ){
        Link2 newRight = new Link2(Long.MIN_VALUE) ;
        Link2 newBotton = new Link2(Long.MIN_VALUE);
        if(x==0&&y==0){
            first = new Link2(Long.MIN_VALUE);
            first.nextLine = newRight ;
            first.nextColumn = newBotton ;
        }
        else {
            Link2 parrent = get(x,y);
            if (y == 0) {
                if(x>Width)parrent.nextLine = null;
                else parrent.nextLine =newRight;
                parrent.nextColumn = newBotton ;
            }
            else {
                if(x==0&&y==1){
                    int o = 0;
                }
                if(x>Width)parrent.nextLine = null;
                else parrent.nextLine =get(x+1,y);
                if(y>Height)parrent.nextColumn = null;
                else parrent.nextColumn = newBotton ;
            }


        }
    }

    Link2 get(int x ,int y ){

        Link2 curent = first ;
        for(int i = 0 ;i <x;i++)curent = curent.nextLine;
        for(int i = 0 ;i <y;i++)curent = curent.nextColumn;
        return curent ;
    }
}
