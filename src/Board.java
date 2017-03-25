import java.util.ArrayList;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class Board {

    private Column[] columnStars = new Column[13];

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
        if (columns == null){System.out.println("Not macth column!");
        }else{
            for(Integer integer : columns) {
                columnStars[integer].increaseStar();
            }
        }


   }

    public int getScore(ArrayList<Integer> columns) {
        System.out.println("adaw :"+columns.toString());
        int a;
        if (columns.size()==1){
            a = columnStars[columns.get(0)].getStarNumber();
        }else if (columns.size()==2){
             a = columnStars[columns.get(0)].getStarNumber()+columnStars[columns.get(1)].getStarNumber();
        }else {
            return 0;
        }
        return a;
    }
}
