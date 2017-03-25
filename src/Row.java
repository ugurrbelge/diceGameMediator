
public class Row {
    private int starNumber = 0;

    public void increaseStar() {
        starNumber ++ ;
    }

    public void display() {
        for(int i = 0 ; i < starNumber ; i++) {
            System.out.print("*");
        }
    }
    public int getStarNumber(){
        return starNumber;
    }
}
