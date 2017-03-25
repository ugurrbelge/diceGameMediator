import java.util.ArrayList;
import java.util.List;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class Strategy {


    public ArrayList<Integer> generateStrategy(ArrayList<Dice> dices, ArrayList<Integer> computerColumns) {


        List diceNumber = new ArrayList<Integer>();
        List combinasyon = new ArrayList<Integer>();
        int i,j;
        for (Dice dice : dices){
            diceNumber.add(dice.getRandomInt());
        }

        for (i=0;i<diceNumber.size();i++) {
            for (j = i + 1; j < diceNumber.size(); j++) {
                combinasyon.add(Integer.parseInt(diceNumber.get(i).toString()) + Integer.parseInt(diceNumber.get(j).toString()));
            }
        }

        if(combinasyon.contains(computerColumns.get(0)) && combinasyon.contains(computerColumns.get(1))) {
            return computerColumns;
        }else if (combinasyon.contains(computerColumns.get(0))) {
            ArrayList<Integer> column = new ArrayList<Integer>();
            column.add(computerColumns.get(0));
            return column;
        }else if (combinasyon.contains(computerColumns.get(1))) {
            ArrayList<Integer> column = new ArrayList<Integer>();
            column.add(computerColumns.get(1));
            return column;
        }
        return new ArrayList<Integer>();
    }

    public ArrayList<Integer> selectColumns(ArrayList<Dice> diceNumbers) {

        List diceNumber = new ArrayList<Integer>();
        List combinasyon = new ArrayList<Integer>();
        List bestChoice  = new ArrayList<Integer>();
        List secondChoice  = new ArrayList<Integer>();
        List badChoice  = new ArrayList<Integer>();
        ArrayList<Integer> selected= new ArrayList<Integer>();
        bestChoice.add(6);
        bestChoice.add(7);
        bestChoice.add(8);
        secondChoice.add(4);
        secondChoice.add(5);
        secondChoice.add(9);
        secondChoice.add(10);
        badChoice.add(2);
        badChoice.add(3);
        badChoice.add(11);
        badChoice.add(12);

        int i,j;
        for (Dice dice : diceNumbers){
            diceNumber.add(dice.getRandomInt());
        }

        for (i=0;i<diceNumber.size();i++){
            for (j=i+1 ; j<diceNumber.size();j++){
                if(bestChoice.contains(Integer.parseInt(diceNumber.get(i).toString())+Integer.parseInt(diceNumber.get(j).toString()))){
                    selected.add(Integer.parseInt(diceNumber.get(i).toString())+Integer.parseInt(diceNumber.get(j).toString()));
                    if(i < j) {
                        diceNumber.remove(j);
                        diceNumber.remove(i);
                    }else if(j < i) {
                        diceNumber.remove(i);
                        diceNumber.remove(j);
                    }
                    System.out.print("");
                    selected.add(Integer.parseInt(diceNumber.get(0).toString())+Integer.parseInt(diceNumber.get(1).toString()));
                    return selected;
                }
            }
        }

        for (i=0;i<diceNumber.size();i++){
            for (j=i+1 ; j<diceNumber.size();j++){
                if(secondChoice.contains(Integer.parseInt(diceNumber.get(i).toString())+Integer.parseInt(diceNumber.get(j).toString()))){
                    selected.add(Integer.parseInt(diceNumber.get(i).toString())+Integer.parseInt(diceNumber.get(j).toString()));
                    if(i < j) {
                        diceNumber.remove(j);
                        diceNumber.remove(i);
                    }else if(j < i) {
                        diceNumber.remove(i);
                        diceNumber.remove(j);
                    }
                    selected.add(Integer.parseInt(diceNumber.get(0).toString())+Integer.parseInt(diceNumber.get(1).toString()));
                    return selected;
                }
            }
        }

        for (i=0;i<diceNumber.size();i++){
            for (j=i+1 ; j<diceNumber.size();j++){
                if(badChoice.contains(Integer.parseInt(diceNumber.get(i).toString())+Integer.parseInt(diceNumber.get(j).toString()))){
                    selected.add(Integer.parseInt(diceNumber.get(i).toString())+Integer.parseInt(diceNumber.get(j).toString()));
                    if(i < j) {
                        diceNumber.remove(j);
                        diceNumber.remove(i);
                    }else if(j < i) {
                        diceNumber.remove(i);
                        diceNumber.remove(j);
                    }
                    selected.add(Integer.parseInt(diceNumber.get(0).toString())+Integer.parseInt(diceNumber.get(1).toString()));
                    return selected;
                }
            }
        }
        //Integer.parseInt(diceNumber.get(0).toString())+Integer.parseInt(diceNumber.get(1).toString())
       // selected.add(Integer.parseInt(diceNumber.get(2).toString())+Integer.parseInt(diceNumber.get(3).toString()));
        return selected;
    }

}
