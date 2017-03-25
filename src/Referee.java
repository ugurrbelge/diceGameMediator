import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Referee {
    private Board board ;
    private ArrayList<Integer> reservedRows = new ArrayList<>();
    private ArrayList<Player> players;


    public void conductGame(){
        Move move;
        int roundNumber = 1;
        for (Player player : players){
            if(player instanceof HumanPlayer) {

                do {
                    player.rollDice();

                    if (isSuitableRowExist(player.getDiceNumbers())) {
                        System.out.println("Reserved Rows : " + reservedRows);
                        System.out.println();

                        while (isSelected(player.selectPlayerRows())) {
                            System.out.println("Selected Row is Invalid...Please try again");
                        }

                        System.out.println();
                        System.out.print(player.toString() + " select :");
                        System.out.println(player.getPlayerRowsNumbers().get(0) + "," + player.getPlayerRowsNumbers().get(1));
                    }
                }while (!(isSuitableRowExist(player.getDiceNumbers())));

                reservedRows.add(player.getPlayerRowsNumbers().get(0));
                reservedRows.add(player.getPlayerRowsNumbers().get(1));
            }
            else {
                System.out.println("Reserved rows : " + reservedRows);

                do {
                    player.rollDice();
                }while((isSelected(player.selectPlayerRows())));

                reservedRows.add(player.getPlayerRowsNumbers().get(0));
                reservedRows.add(player.getPlayerRowsNumbers().get(1));

                System.out.print(player.toString() + " select :");
                System.out.print(player.getPlayerRowsNumbers().get(0) + "," + player.getPlayerRowsNumbers().get(1));
                System.out.print(" rows.");
                System.out.println();
            }
            System.out.println();
            System.out.println("next player");
            System.out.println();
        }

        for(int i = 0 ; i < roundNumber ; i++) {
            for (Player player : players) {
                System.out.println(player + ", it is your turn !");
                System.out.println();
                System.out.print("Your rows are : ");
                System.out.print(player.getPlayerRowsNumbers().get(0) + "," + player.getPlayerRowsNumbers().get(1));
                System.out.println();

                move = player.makeMove();
                board.addStar(move.getRows());
                System.out.println();
                board.display();
                System.out.println();
            }
        }
        announceWinner();
    }

    private boolean isSuitableRowExist(ArrayList<Dice> diceNumbers){

        List diceNumber = new ArrayList<Integer>();
        List combination = new ArrayList<Integer>();
        int i,j;

        for (Dice dice : diceNumbers){
            diceNumber.add(dice.getRandomInt());
        }

        for (i=0;i<diceNumber.size();i++){
            for (j=i+1 ; j<diceNumber.size();j++){
                    combination.add(Integer.parseInt(diceNumber.get(i).toString())+Integer.parseInt(diceNumber.get(j).toString()));
            }
        }


        if (reservedRows.contains(combination.get(0)) || reservedRows.contains(combination.get(5)) || combination.get(0).equals(combination.get(5))
                && reservedRows.contains(combination.get(1)) || reservedRows.contains(combination.get(4)) || combination.get(1).equals(combination.get(4))
                && reservedRows.contains(combination.get(2)) || reservedRows.contains(combination.get(3)) || combination.get(2).equals(combination.get(3))){
            return false;
        }else {
            return true;
        }

    }

    private boolean isSelected(ArrayList<Integer> rows){

        if(reservedRows.contains(rows.get(0)) || reservedRows.contains(rows.get(1)) || rows.get(0).equals(rows.get(1))){
            return true;
        }else {
            return false;
        }
    }

    public void init( HashMap<String,String> gamePlayers){

        this.players = new ArrayList<>();
        this.board = new Board();

        gamePlayers.forEach((name,type) -> {
            if (type.equals("H")){
                players.add(new HumanPlayer(name));
            }else{
                players.add(new ComputerPlayer(name));
            }
        });

    }

    private void announceWinner(){

        int[] score = new int[players.size()];
        int[] rank = new int[players.size()];
        int index;
        int secondIndex;
        for(index = 0 ; index < players.size() ; index++) {
            score[index] = board.getScore(players.get(index).getPlayerRowsNumbers());
        }

        for(secondIndex = 0 ; secondIndex < players.size() ; secondIndex++) {
            int max = score[0];
            int temp = 0;
            for (int i = 0; i < players.size(); i++) {
                if (score[i] > max) {
                    max = score[i];
                    temp = i;
                }
            }

            rank[secondIndex] = temp;
            score[temp] = -1;
        }
        for(int i = 0 ; i < players.size() ; i++) {
            System.out.println(i+1 + ". Player is " + players.get(rank[i]).toString() );
        }
    }
}
