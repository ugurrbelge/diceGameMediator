import java.util.ArrayList;
import java.util.List;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class Strategy {

    public ArrayList<Integer> generateStrategy(ArrayList<Dice> dices, ArrayList<Integer> computerRows) {

        List diceNumber = new ArrayList<Integer>();
        List combination = new ArrayList<Integer>();
        int i,j;
        for (Dice dice : dices){
            diceNumber.add(dice.getRandomInt());
        }

        for (i=0;i<diceNumber.size();i++) {
            for (j = i + 1; j < diceNumber.size(); j++) {
                combination.add(Integer.parseInt(diceNumber.get(i).toString()) + Integer.parseInt(diceNumber.get(j).toString()));
            }
        }

        ArrayList<Integer> row = new ArrayList<Integer>();
        if(((combination.get(0) == computerRows.get(0) && combination.get(5) == computerRows.get(1)) || (combination.get(0) == computerRows.get(0) && combination.get(5) == computerRows.get(1)))
                || ((combination.get(1) == computerRows.get(0) && combination.get(4) == computerRows.get(1)) || (combination.get(1) == computerRows.get(0) && combination.get(4) == computerRows.get(1)))
                || ((combination.get(2) == computerRows.get(0) && combination.get(3) == computerRows.get(1)) || (combination.get(2) == computerRows.get(0) && combination.get(3) == computerRows.get(1)))) {
            return computerRows;
        }else if (combination.contains(computerRows.get(0))) {
            row.add(computerRows.get(0));
            return row;
        }else if (combination.contains(computerRows.get(1))) {
            row.add(computerRows.get(1));
            return row;
        }

        return new ArrayList<Integer>();

    }

    public ArrayList<Integer> selectRows(ArrayList<Dice> diceNumbers) {
        int index,secondIndex;
        List diceNumber = new ArrayList<Integer>();
        List bestChoice  = new ArrayList<Integer>();
        List secondChoice  = new ArrayList<Integer>();
        List badChoice  = new ArrayList<Integer>();
        ArrayList<Integer> selected= new ArrayList<>();
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


        for (Dice dice : diceNumbers){
            diceNumber.add(dice.getRandomInt());
        }

        for (index=0;index<diceNumber.size();index++){
            for (secondIndex=index+1 ; secondIndex<diceNumber.size();secondIndex++){
                if(bestChoice.contains(Integer.parseInt(diceNumber.get(index).toString())+Integer.parseInt(diceNumber.get(secondIndex).toString()))){
                    selected.add(Integer.parseInt(diceNumber.get(index).toString())+Integer.parseInt(diceNumber.get(secondIndex).toString()));
                    if(index < secondIndex) {
                        diceNumber.remove(secondIndex);
                        diceNumber.remove(index);
                    }else if(secondIndex < index) {
                        diceNumber.remove(index);
                        diceNumber.remove(secondIndex);
                    }
                    System.out.print("");
                    selected.add(Integer.parseInt(diceNumber.get(0).toString())+Integer.parseInt(diceNumber.get(1).toString()));
                    return selected;
                }
            }
        }

        for (index=0;index<diceNumber.size();index++){
            for (secondIndex=index+1 ; secondIndex<diceNumber.size();secondIndex++){
                if(secondChoice.contains(Integer.parseInt(diceNumber.get(index).toString())+Integer.parseInt(diceNumber.get(secondIndex).toString()))){
                    selected.add(Integer.parseInt(diceNumber.get(index).toString())+Integer.parseInt(diceNumber.get(secondIndex).toString()));
                    if(index < secondIndex) {
                        diceNumber.remove(secondIndex);
                        diceNumber.remove(index);
                    }else if(secondIndex < index) {
                        diceNumber.remove(index);
                        diceNumber.remove(secondIndex);
                    }
                    selected.add(Integer.parseInt(diceNumber.get(0).toString())+Integer.parseInt(diceNumber.get(1).toString()));
                    return selected;
                }
            }
        }

        for (index=0;index<diceNumber.size();index++){
            for (secondIndex=index+1 ; secondIndex<diceNumber.size();secondIndex++){
                if(badChoice.contains(Integer.parseInt(diceNumber.get(index).toString())+Integer.parseInt(diceNumber.get(secondIndex).toString()))){
                    selected.add(Integer.parseInt(diceNumber.get(index).toString())+Integer.parseInt(diceNumber.get(secondIndex).toString()));
                    if(index < secondIndex) {
                        diceNumber.remove(secondIndex);
                        diceNumber.remove(index);
                    }else if(secondIndex < index) {
                        diceNumber.remove(index);
                        diceNumber.remove(secondIndex);
                    }
                    selected.add(Integer.parseInt(diceNumber.get(0).toString())+Integer.parseInt(diceNumber.get(1).toString()));
                    return selected;
                }
            }
        }

        return selected;
    }
}
