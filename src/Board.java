import java.util.ArrayList;


public class Board {

    private Row[] rowStars = new Row[13];
    private int index;
    public Board() {
        for(index = 0 ; index < rowStars.length ; index++) {
            rowStars[index] = new Row();
        }
    }

    public void display(){
        for(index = 1 ; index < rowStars.length ; index++) {
                if(index < 10) {
                    System.out.print(" ");
                }
                System.out.print(index + " | ");
                rowStars[index].display();
                System.out.println();
        }
    }

    public void addStar(ArrayList<Integer> rows) {
        if (rows == null){
            System.out.println("Not match row!");
        }else{
            for(Integer integer : rows) {
                rowStars[integer].increaseStar();
            }
        }
   }

    public int getScore(ArrayList<Integer> rows) {
        int a;
        if (rows.size()==1){
            a = rowStars[rows.get(0)].getStarNumber();
        }else if (rows.size()==2){
             a = rowStars[rows.get(0)].getStarNumber()+rowStars[rows.get(1)].getStarNumber();
        }else {
            return 0;
        }
        return a;
    }
}
