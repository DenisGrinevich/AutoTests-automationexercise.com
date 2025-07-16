package basic;

import java.time.Duration;
import java.util.Random;

public class Constants {

    public static class Urls{
        public static final String URL_MAIN = "https://automationexercise.com/";
    }
public static class TimeoutVariable

    {
        public static final int IMPLICIT_WAIT_TEN = 10;
        public static final int IMPLICIT_WAIT_FIVE = 5;
        public static final Duration EXPLICIT_WAIT_TEN = Duration.ofSeconds(10);
        public static final Duration EXPLICIT_WAIT_FIVE = Duration.ofSeconds(5);
    }
    public static int randomNumber(int num){
        Random random = new Random();
        int randomNumber = random.nextInt(num);
        return randomNumber;
    }
}
