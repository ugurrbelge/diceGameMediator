import java.util.ArrayList;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class Move {
    private ArrayList<Integer> rows = new ArrayList<>();

    public Move(){}

    public Move(Integer row){
        try{
            rows.add(row);
        }catch (Exception e){
            System.out.println(e.toString());
            System.out.println(1);
        }
    }

    public Move(Integer row1, Integer row2){
        try{
            rows.add(row1);
            rows.add(row2);
        }catch (Exception e){
            System.out.println(e.toString());
            System.out.println(2);
        }
    }

    public ArrayList<Integer> getRows(){
        return rows;
    }
}
