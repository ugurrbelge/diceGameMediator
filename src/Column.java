/**
 * Created by ugurbelge on 3/23/17.
 */
public class Column {
    private int starNumber = 0;

    public void increaseStar() {
        starNumber ++ ;
    }

    public void display() {
        for(int i = 0 ; i < starNumber ; i++) {
            System.out.print("*");
        }
    }
}
