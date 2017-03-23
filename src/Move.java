import java.util.ArrayList;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class Move {
    private ArrayList<Integer> columns;

    public Move(ArrayList<Integer> columns){
        try{
            setColumns(columns);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void setColumns(ArrayList<Integer> columns){
        this.columns = columns;
    }

    public ArrayList<Integer> getColumns(){
        return columns;
    }
}
