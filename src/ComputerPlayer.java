import java.util.ArrayList;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class ComputerPlayer implements Player{

    private ArrayList<Integer> playerRowsNumbers;
    private ArrayList<Dice> playerDices = new ArrayList<>();
    private String name;
    private Strategy strategy = new Strategy();
    private ArrayList<Integer> strategyRows = new ArrayList<>();
    private ArrayList<Integer> selectedRows = new ArrayList<Integer>();

    public ComputerPlayer(String name){
        try {
            this.name = name;
            createDices();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void createDices(){
        int index ;
        for (index=0 ; index<4 ; index++){
            playerDices.add(new Dice());
        }
    }

    @Override
    public Move makeMove() {

        rollDice();
        System.out.print("Your dices are :");
        playerDices.forEach((dice) -> System.out.print(dice.getRandomInt() + " "));
        System.out.println();
        strategyRows = strategy.generateStrategy(playerDices,playerRowsNumbers);

        if(strategyRows.size() == 2) {
            return new Move(strategyRows.get(0),strategyRows.get(1));
        }else if(strategyRows.size() == 1) {
            return new Move(strategyRows.get(0));
        }else {
            return new Move();
        }
    }

    public ArrayList<Dice> getDiceNumbers(){
        return playerDices;
    }

    public ArrayList<Integer> getPlayerRowsNumbers(){
        return playerRowsNumbers;
    }

    public ArrayList<Integer> selectPlayerRows(){
        selectedRows = strategy.selectRows(playerDices);
        playerRowsNumbers = selectedRows;
        return selectedRows;
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
