import java.util.ArrayList;

/**
 * Created by ugurbelge on 3/23/17.
 */
public interface Player {

    ArrayList<Dice> getDiceNumbers();
    ArrayList<Integer> getPlayerColumnsNumbers();
    ArrayList<Integer> selectPlayerColumns();
    void rollDice();
    Move makeMove();

}
