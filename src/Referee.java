import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;


public class Referee {
    private Board board ;
    private ArrayList<Integer> reservedColumns = new ArrayList<>();
    private ArrayList<Player> players;
    private Player currentPlayer ;
    private int currentPlayerIndex = 0;

    public void conductGame(){

        board.display();
        Move move = null;

        for (Player player : players){
            do {
                player.rollDice();
                if (isSuitableColumnExist(player.getDiceNumbers())) {
                    while (!(isSelected(player.selectPlayerColumns()))) {
                        reservedColumns.add(player.getPlayerColumnsNumers().get(0), player.getPlayerColumnsNumers().get(1));
                    }
                }
            }while (!(isSuitableColumnExist(player.getDiceNumbers())));
        }


        while( ! board.isGameOver( ) )
        {
            boolean isValidMove = false;
            do
            {
                System.out.println();
                System.out.println( currentPlayer + " It is your turn ..." );

                move = currentPlayer.makeMove();

                isValidMove = this.isValidMove( move );
                if( ! isValidMove )
                {
                    System.out.println( currentPlayer + " That is NOT a VALID Move !!! " );
                    board.display();
                }
            }
            while( ! isValidMove );

            System.out.println( currentPlayer + " moved: " + move );
            System.out.println();
            board.processMove( move );
            board.display();
            currentPlayer = getNextPlayer();
        }
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

    }
}
