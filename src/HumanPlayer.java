import java.util.ArrayList;
import java.util.Scanner;


public class HumanPlayer implements Player {
    private Scanner reader = new Scanner(System.in);
    private String name;
    private ArrayList<Dice> playerDices = new ArrayList<>();
    private ArrayList<Integer> playerRowsNumbers = new ArrayList<>();

    public HumanPlayer(String name){
        try{
            setName(name);
            createDices();

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    private void createDices(){
        int index;
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

    public ArrayList<Integer> getPlayerRowsNumbers(){
        return this.playerRowsNumbers;
    }

    private void setPlayerRowsNumbers(Integer firstRow,Integer secondRow) {
        if(!playerRowsNumbers.isEmpty()) {
            playerRowsNumbers.set(0,firstRow);
            playerRowsNumbers.set(1,secondRow);
        }
        else {
            playerRowsNumbers.add(firstRow);
            playerRowsNumbers.add(secondRow);
        }
    }

    private void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> selectPlayerRows() {
        Integer[] firstRowDiceNumber = new Integer[2];
        Integer[] secondRowDiceNumber = new Integer[2];

        System.out.println("This round for select your row number.");
        System.out.println(this.toString() + ", it is your tern !");
        System.out.print("Your dices are :");
        playerDices.forEach((dice) -> System.out.print(dice.getRandomInt() + " "));
        System.out.println();

        System.out.println("Take group of two dice and write them such that 1 push the enter 2 push and repeat");

        System.out.println("Select your first Row's 1. Dice :");
        firstRowDiceNumber[0] = reader.nextInt();

        while(firstRowDiceNumber[0] > 4 ) {
            System.out.println("Your decision invalid please select first row's first dice");
            firstRowDiceNumber[0] = reader.nextInt();
        }

        System.out.println("Select your first Row's 2. Dice :");
        firstRowDiceNumber[1] = reader.nextInt();

        while(firstRowDiceNumber[1] > 4 || firstRowDiceNumber[0].equals(firstRowDiceNumber[1])) {
            System.out.println("Your desicion is invalid please select first row's second dice");
            firstRowDiceNumber[1] = reader.nextInt();
        }

        System.out.println("Select your second Row's 1. Dice :");
        secondRowDiceNumber[0] = reader.nextInt();

        while(secondRowDiceNumber[0] > 4 || firstRowDiceNumber[0].equals(secondRowDiceNumber[0]) || firstRowDiceNumber[1].equals(secondRowDiceNumber[0])) {
            System.out.println("Your desicion is invalid please select first row's first dice");
            secondRowDiceNumber[0] = reader.nextInt();
        }
        System.out.println("Select your second Row's 2. Dice :");
        secondRowDiceNumber[1] = reader.nextInt();

        while(secondRowDiceNumber[1] > 4 || firstRowDiceNumber[0].equals(secondRowDiceNumber[1]) || firstRowDiceNumber[1].equals(secondRowDiceNumber[1]) || secondRowDiceNumber[0].equals(secondRowDiceNumber[1])) {
            System.out.println("Your desicion is invalid please select first row's second dice");
            secondRowDiceNumber[0] = reader.nextInt();
        }

        Integer row1 = playerDices.get(firstRowDiceNumber[0]).getRandomInt()+playerDices.get(firstRowDiceNumber[1]).getRandomInt();
        Integer row2 = playerDices.get(secondRowDiceNumber[0]).getRandomInt()+playerDices.get(secondRowDiceNumber[1]).getRandomInt();

        setPlayerRowsNumbers(row1,row2);

        return playerRowsNumbers;
    }

    @Override
    public Move makeMove() {

        Integer[] firstRowDiceNumber = new Integer[2];
        Integer[] secondRowDiceNumber = new Integer[2];

        rollDice();

        System.out.print("Your dices are :");
        playerDices.forEach((dice) -> System.out.print(dice.getRandomInt() + " "));
        System.out.println();
        System.out.println("Take group of two dice and write them such that 1 push the enter 2 push and repeat");

        System.out.println("Select your first Group's 1. Dice :");
        firstRowDiceNumber[0] = reader.nextInt();
        while(firstRowDiceNumber[0] > 4 ) {
            System.out.println("Your decision invalid please select first group's first dice");
            firstRowDiceNumber[0] = reader.nextInt();
        }

        System.out.println("Select your first Group's 2. Dice :");
        firstRowDiceNumber[1] = reader.nextInt();
        while(firstRowDiceNumber[1] > 4 || firstRowDiceNumber[0].equals(firstRowDiceNumber[1])){
            System.out.println("Your desicion is invalid please select first group's second dice");
            firstRowDiceNumber[1] = reader.nextInt();
        }

        System.out.println("Select your second Group's 1. Dice :");
        secondRowDiceNumber[0] = reader.nextInt();
        while(secondRowDiceNumber[0] > 4 || firstRowDiceNumber[0].equals(secondRowDiceNumber[0]) || firstRowDiceNumber[1].equals(secondRowDiceNumber[0])) {
            System.out.println("Your desicion is invalid please select first group's first dice");
            secondRowDiceNumber[0] = reader.nextInt();
        }
        System.out.println("Select your second Group's 2. Dice :");
        secondRowDiceNumber[1] = reader.nextInt();
        while(secondRowDiceNumber[1] > 4 || firstRowDiceNumber[0].equals(secondRowDiceNumber[1]) || firstRowDiceNumber[1].equals(secondRowDiceNumber[1]) || secondRowDiceNumber[0].equals(secondRowDiceNumber[1])) {
            System.out.println("Your desicion is invalid please select first group's second dice");
            secondRowDiceNumber[0] = reader.nextInt();
        }

        Integer row1 = playerDices.get(firstRowDiceNumber[0]).getRandomInt() + playerDices.get(firstRowDiceNumber[1]).getRandomInt();
        Integer row2 = playerDices.get(secondRowDiceNumber[0]).getRandomInt() + playerDices.get(secondRowDiceNumber[1]).getRandomInt();


        if(playerRowsNumbers.contains(row1)){
            if(playerRowsNumbers.contains(row2)){
                return (new Move(row1,row2));
            }else {
                return (new Move(row1));
            }
        }
        else if (playerRowsNumbers.contains(row2)) {
            return new Move(row2);
        }
        else {
            return (new Move());
        }
    }

    public String toString() {
        return name;
    }

}
