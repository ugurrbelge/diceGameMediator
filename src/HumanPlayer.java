import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class HumanPlayer implements Player {
    private Scanner reader = new Scanner(System.in);
    private String name;
    private ArrayList<Dice> playerDices = new ArrayList<>();
    private ArrayList<Integer> playerColumnsNumers ;


    public HumanPlayer(String name){

        try{
            setName(name);
            createDices();

        }catch (Exception e){
            System.out.println(e);
        }
    }
    private void createDices(){

        int index = 0;
        for (index=0 ; index<4 ; index++){
            playerDices.add(new Dice());
        }
    }

    public ArrayList<Dice> getDiceNumbers(){
        return playerDices;
    }

    public void rollDice(){

        for(Dice dice : playerDices){
            dice.setRandomInt();
        }
    }

    public ArrayList<Integer> getPlayerColumnsNumers(){
        return this.playerColumnsNumers;
    }

    private void setPlayerColumnsNumers(ArrayList<Integer> selectedColumns){
        this.playerColumnsNumers = selectedColumns ;
    }

    private void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> selectPlayerColumns(){

        String[] selectedGroupOne;
        String[] selectedGroupTwo;
        ArrayList<Integer> validColumn = new ArrayList<>();
        String grupOne;
        String grupTwo;

        System.out.println("This raund for select your column number.");
        System.out.println("Your dices are :");
        playerDices.forEach((dice) -> System.out.println(dice.getRandomInt()));

        System.out.println("Take grups of two and write them such that 2,3 push the enter button and repeat");
        System.out.println("Select your first column :");
        grupOne = reader.next();
        System.out.println("Select your second column :");
        grupTwo = reader.next();

        selectedGroupOne = grupOne.split(",");
        selectedGroupTwo = grupTwo.split(",");

        int column1 = Integer.parseInt(selectedGroupOne[0])*Integer.parseInt(selectedGroupOne[1]);
        int column2 = Integer.parseInt(selectedGroupTwo[0])*Integer.parseInt(selectedGroupTwo[1]);

        playerColumnsNumers.add(column1,column2);
        return playerColumnsNumers;


    }

    @Override
    public Move makeMove() {
        String[] selectedGroupOne;
        String[] selectedGroupTwo;
        ArrayList<Integer> validColumn = new ArrayList<>();
        String grupOne;
        String grupTwo;
        rollDice();
        System.out.println("Your dices are :");
        playerDices.forEach((dice) -> System.out.println(dice.getRandomInt()));
        System.out.println("Your columns are " + playerColumnsNumers.get(0) +" and " + playerColumnsNumers.get(1)+" .");
        System.out.println("Take grups of two and write them such that 2,3 push the enter button and repeat");
        System.out.println("Select your first group :");
        grupOne = reader.next();
        System.out.println("Select your second group :");
        grupTwo = reader.next();

        selectedGroupOne = grupOne.split(",");
        selectedGroupTwo = grupTwo.split(",");

        int column1 = Integer.parseInt(selectedGroupOne[0])*Integer.parseInt(selectedGroupOne[1]);
        int column2 = Integer.parseInt(selectedGroupTwo[0])*Integer.parseInt(selectedGroupTwo[1]);

        if(playerColumnsNumers.contains(column1)){
            if(playerColumnsNumers.contains(column2) && column1 != column2){

                validColumn.add(column1,column2);
                return (new Move(validColumn));

            }else {
                validColumn.add(column1);
                return (new Move(validColumn));
            }

        }else {
            return (new Move(validColumn));
        }
    }


}
