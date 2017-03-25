import java.util.ArrayList;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class Move {
    private ArrayList<Integer> columns = new ArrayList<Integer>();

    public Move(){}

    public Move(Integer column){
        try{
            columns.add(column);
        }catch (Exception e){
            System.out.println(e);
            System.out.println(1);
        }
    }

    public Move(Integer column1, Integer column2){
        try{
            columns.add(column1);
            columns.add(column2);
        }catch (Exception e){
            System.out.println(e);
            System.out.println(2);
        }
    }
    private void setColumns(ArrayList<Integer> columns){
        this.columns = columns;
    }

    public ArrayList<Integer> getColumns(){
        return columns;
    }
}
