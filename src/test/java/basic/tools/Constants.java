package basic.tools;

import java.util.Random;

public class Constants {

    public static int randomNumber(int num){
        Random random = new Random();
        int randomNumber = random.nextInt(num);
        return randomNumber;
    }


}
