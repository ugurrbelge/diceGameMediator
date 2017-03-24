import java.util.ArrayList;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class ComputerPlayer implements Player{

    private ArrayList<Integer> playerColumnsNumbers;
    private ArrayList<Dice> playerDices = new ArrayList<>();
    private String name;
    private Strategy strategy = new Strategy();

    public ComputerPlayer(String name){
        this.name = name;
    }

    @Override
    public Move makeMove() {

        ArrayList<Integer> strategyColumns = new ArrayList<Integer>();
        rollDice();


        strategyColumns = strategy.generateStrategy(playerDices,playerColumnsNumbers);

        if(strategyColumns.size() == 2) {
            return new Move(strategyColumns.get(0),strategyColumns.get(1));
        }else if(strategyColumns.size() == 1) {
            return new Move(strategyColumns.get(0));
        }else {
            return new Move(0);
        }
    }

    public ArrayList<Dice> getDiceNumbers(){
        return playerDices;
    }
    public ArrayList<Integer> getPlayerColumnsNumbers(){
        return playerColumnsNumbers;
    }
    public ArrayList<Integer> selectPlayerColumns(){

        ArrayList<Integer> selectedColumns = new ArrayList<Integer>();

        selectedColumns = strategy.selectColumns(playerDices);

        return selectedColumns;
    }
    public void rollDice(){
        for(Dice dice : playerDices){
            dice.setRandomInt();
        }
    }

    public String toString() {
        return name;
    }
}
