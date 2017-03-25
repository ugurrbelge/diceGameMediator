import java.awt.*;
import java.util.Random;

/**
 * Created by ugurbelge on 3/23/17.
 */
public class Dice {

    private int randomInt = 0;

    public int getRandomInt(){
        return this.randomInt;

    }

    public void setRandomInt(){

        this.randomInt = randomGenerator();
    }

    private int randomGenerator(){

        Random generator = new Random();
        return generator.nextInt(6)+1;

    }
}
