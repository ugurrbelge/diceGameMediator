/**
 * Created by ugurbelge on 3/23/17.
 */
public class DiceGame {

    private DiceGame game = null;

    public static void main(String[] args){

        System.out.println( "\n!!!! Welcome to the Sticks Game !!!!" );


        try {
            Referee referee = new Referee();
            System.out.println();

        }




    }


    private void play() throws SaveGameException
    {
        System.out.println();
        System.out.println( players[ 0 ] + " VS. " );
        System.out.println( players[ 1 ] + " !!!! " );

        referee.conductGame();
        referee.announceWinner();

        System.out.println( "" );
        Console.readLine( "Press << \"enter\" >> to exit: " );
    }
}
