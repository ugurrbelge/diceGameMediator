import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Referee {
    private Board board ;
    private ArrayList<Integer> reservedColumns = new ArrayList<>();
    private ArrayList<Player> players;
    private Player currentPlayer ;
    private int currentPlayerIndex = 0;
    private int roundNumber = 5;

    public void conductGame(){

        board.display();
        Move move = null;

        //all player select columns
        for (Player player : players){
            if(player instanceof HumanPlayer) {
            do {
                    player.rollDice();

                    if (isSuitableColumnExist(player.getDiceNumbers())) {
                        while (!(isSelected(player.selectPlayerColumns()))) {
                            reservedColumns.add(player.getPlayerColumnsNumbers().get(0), player.getPlayerColumnsNumbers().get(1));
                        }
                    }
            }while (!(isSuitableColumnExist(player.getDiceNumbers())));
            }
            else {
                do {
                    player.rollDice();
                    if(!(isSelected(player.selectPlayerColumns()))) {
                        reservedColumns.add(player.getPlayerColumnsNumbers().get(0), player.getPlayerColumnsNumbers().get(1));
                    }
                }while(!(isSelected(player.selectPlayerColumns())));
            }
        }


        for(int i = 0 ; i < roundNumber ; i++) {
            for (Player player : players) {
                System.out.println();
                System.out.println(player + " It is your turn ...");

                move = player.makeMove();

                board.addStar(move.getColumns());

                board.display();
            }
        }
        announceWinner();

    }



    private boolean isSuitableColumnExist(ArrayList<Dice> diceNumbers){


        List diceNumber = new ArrayList<Integer>();
        List combinasyon = new ArrayList<Integer>();
        int i,j;
        for (Dice dice : diceNumbers){
            diceNumber.add(dice.getRandomInt());
        }

        for (i=0;i<diceNumber.size();i++){
            for (j=i+1 ; j<diceNumber.size();j++){
                    combinasyon.add(Integer.parseInt(diceNumber.get(i).toString())+Integer.parseInt(diceNumber.get(j).toString()));
            }
        }



        if (reservedColumns.contains(combinasyon)){
            return false;
        }else {
            return true;
        }



    }

    private boolean isSelected(ArrayList<Integer> columns){

        if(reservedColumns.contains(columns)){
            return true;
        }else {
            return false;
        }

    }



    public boolean isValidMove( Move move )
    {

        return true;
    }

    private Player getNextPlayer()
    {
        currentPlayerIndex++;
        if(currentPlayerIndex<players.size()) {
            return players.get(currentPlayerIndex);
        }else{
            currentPlayerIndex = 0;
            return players.get(currentPlayerIndex);
        }
    }


    public void init( HashMap<String,String> gamePlayers)
    {
        this.players = new ArrayList<Player>();
        this.board = new Board();
        gamePlayers.forEach((name,type) -> {
            if (type.equals("H")){
                players.add(new HumanPlayer(name));
            }else{
                players.add(new ComputerPlayer(name));
            }
        });
        currentPlayer = players.get(0);
    }

    public void announceWinner(){

        int[] score = new int[players.size()];
        int[] rank = new int[players.size()];
        for(int i = 0 ; i < players.size() ; i++) {
            score[i] = board.getScore(players.get(i).getPlayerColumnsNumbers());
        }
        for(int j = 0 ; j < players.size() ; j++) {
            int max = score[0];
            int temp = 0;
            for (int i = 0; i < players.size(); i++) {
                if (score[i] > max) {
                    max = score[i];
                    temp = i;
                }
            }
            rank[j] = temp;
            score[temp] = 0;
        }
        for(int i = 0 ; i < players.size() ; i++) {
            System.out.println(i + ". Player is " + players.get(rank[i]).toString() );
        }
    }
}
