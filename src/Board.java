import java.util.ArrayList;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class Board {

    private Column[] columnStars = new Column[11];

    public Board() {
        for(int i = 0 ; i < columnStars.length ; i++) {
            columnStars[i] = new Column();
        }
    }
    public void display(){
        for(int i = 0 ; i < columnStars.length ; i++) {
            System.out.print(i + " | " );
            columnStars[i].display();
            System.out.println();
        }
    }

    public boolean isGameOver(){

        return true;
    }

    public void addStar(ArrayList<Integer> columns) {
        for(Integer integer : columns) {
            columnStars[integer].increaseStar();
        }
    }

    public int getScore(ArrayList<Integer> columns) {
        return Integer.parseInt(columnStars[columns.get(0)].toString()) + Integer.parseInt(columnStars[columns.get(1)].toString());
    }
}
