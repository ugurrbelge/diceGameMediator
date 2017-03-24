import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class HumanPlayer implements Player {
    private Scanner reader = new Scanner(System.in);
    private String name;
    private ArrayList<Dice> playerDices = new ArrayList<>();
    private ArrayList<Integer> playerColumnsNumbers;




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

    public ArrayList<Integer> getPlayerColumnsNumbers(){
        return this.playerColumnsNumbers;
    }

    private void setPlayerColumnsNumbers(ArrayList<Integer> selectedColumns){
        this.playerColumnsNumbers = selectedColumns ;
    }

    private void getPlayerColumnsNumbers(ArrayList<Integer> selectedColumns){
        this.playerColumnsNumbers = selectedColumns ;
    }

    private void setPlayerColumnsNumbers(Integer firstColumn,Integer secondColumn) {
        if(playerColumnsNumbers.size() > 0) {
            playerColumnsNumbers.set(0,firstColumn);
            playerColumnsNumbers.set(1,secondColumn);
        }
        else {
            playerColumnsNumbers.add(firstColumn);
            playerColumnsNumbers.add(secondColumn);
        }
    }

    private void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> selectPlayerColumns() {
        Integer[] firstColumnDiceNumber = new Integer[2];
        Integer[] secondColumnDiceNumber = new Integer[2];

        System.out.println("This round for select your column number.");
        System.out.println("Your dices are :");
        playerDices.forEach((dice) -> System.out.print(dice.getRandomInt() + " "));

        System.out.println("Take group of two dice and write them such that 1 push the enter 2 push and repeat");

        System.out.println("Select your first Column's 1. Dice :");
        firstColumnDiceNumber[0] = reader.nextInt();
        while(firstColumnDiceNumber[0] > 4 ) {
            System.out.println("Your decision invalid please select first column's first dice");
            firstColumnDiceNumber[0] = reader.nextInt();
        }

        System.out.println("Select your first Column's 2. Dice :");
        firstColumnDiceNumber[1] = reader.nextInt();
        while(firstColumnDiceNumber[1] > 4 || firstColumnDiceNumber[0] == firstColumnDiceNumber[1]) {
            System.out.println("Your desicion is invalid please select first column's second dice");
            firstColumnDiceNumber[1] = reader.nextInt();
        }

        System.out.println("Select your second Column's 1. Dice :");
        secondColumnDiceNumber[0] = reader.nextInt();
        while(secondColumnDiceNumber[0] > 4 || firstColumnDiceNumber[0] == secondColumnDiceNumber[0] || firstColumnDiceNumber[1] == secondColumnDiceNumber[0]) {
            System.out.println("Your desicion is invalid please select first column's first dice");
            secondColumnDiceNumber[0] = reader.nextInt();
        }
        System.out.println("Select your second Column's 2. Dice :");
        secondColumnDiceNumber[1] = reader.nextInt();
        while(secondColumnDiceNumber[1] > 4 || firstColumnDiceNumber[0] == secondColumnDiceNumber[1] || firstColumnDiceNumber[1] == secondColumnDiceNumber[1] || secondColumnDiceNumber[0] == secondColumnDiceNumber[1]) {
            System.out.println("Your desicion is invalid please select first column's second dice");
            secondColumnDiceNumber[0] = reader.nextInt();
        }

        Integer column1 = playerDices.get(firstColumnDiceNumber[0]).getRandomInt() * playerDices.get(firstColumnDiceNumber[1]).getRandomInt();
        Integer column2 = playerDices.get(secondColumnDiceNumber[0]).getRandomInt() * playerDices.get(secondColumnDiceNumber[1]).getRandomInt();

        setPlayerColumnsNumbers(column1,column2);

        return playerColumnsNumbers;
    }

    @Override
    public Move makeMove() {

        Integer[] firstColumnDiceNumber = new Integer[2];
        Integer[] secondColumnDiceNumber = new Integer[2];

        rollDice();

        System.out.println("Your dices are :");
        playerDices.forEach((dice) -> System.out.print(dice.getRandomInt() + " "));

        System.out.println("Take group of two dice and write them such that 1 push the enter 2 push and repeat");

        System.out.println("Select your first Group's 1. Dice :");
        firstColumnDiceNumber[0] = reader.nextInt();
        while(firstColumnDiceNumber[0] > 4 ) {
            System.out.println("Your decision invalid please select first group's first dice");
            firstColumnDiceNumber[0] = reader.nextInt();
        }

        System.out.println("Select your first Group's 2. Dice :");
        firstColumnDiceNumber[1] = reader.nextInt();
        while(firstColumnDiceNumber[1] > 4 || firstColumnDiceNumber[0] == firstColumnDiceNumber[1]) {
            System.out.println("Your desicion is invalid please select first group's second dice");
            firstColumnDiceNumber[1] = reader.nextInt();
        }

        System.out.println("Select your second Group's 1. Dice :");
        secondColumnDiceNumber[0] = reader.nextInt();
        while(secondColumnDiceNumber[0] > 4 || firstColumnDiceNumber[0] == secondColumnDiceNumber[0] || firstColumnDiceNumber[1] == secondColumnDiceNumber[0]) {
            System.out.println("Your desicion is invalid please select first group's first dice");
            secondColumnDiceNumber[0] = reader.nextInt();
        }
        System.out.println("Select your second Group's 2. Dice :");
        secondColumnDiceNumber[1] = reader.nextInt();
        while(secondColumnDiceNumber[1] > 4 || firstColumnDiceNumber[0] == secondColumnDiceNumber[1] || firstColumnDiceNumber[1] == secondColumnDiceNumber[1] || secondColumnDiceNumber[0] == secondColumnDiceNumber[1]) {
            System.out.println("Your desicion is invalid please select first group's second dice");
            secondColumnDiceNumber[0] = reader.nextInt();
        }

        Integer column1 = playerDices.get(firstColumnDiceNumber[0]).getRandomInt() * playerDices.get(firstColumnDiceNumber[1]).getRandomInt();
        Integer column2 = playerDices.get(secondColumnDiceNumber[0]).getRandomInt() * playerDices.get(secondColumnDiceNumber[1]).getRandomInt();

        if(playerColumnsNumbers.contains(column1)){
            if(playerColumnsNumbers.contains(column2) && column1 != column2){
                return (new Move(column1,column2));
            }else {
                return (new Move(column1));
            }
        }
        else if (playerColumnsNumbers.contains(column2)) {
            return new Move(column2);
        }
        else {
            return (new Move(0));
        }
    }

    public String toString() {
        return name;
    }

}
