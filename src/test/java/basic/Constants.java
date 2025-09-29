package basic;

import java.util.Random;

public class Constants {

    public static class Urls{

        public static final String URL_PRODUCTS = "https://automationexercise.com/products";
    }
public static class TimeoutVariable

    {

    }
    public static int randomNumber(int num){
        Random random = new Random();
        int randomNumber = random.nextInt(num);
        return randomNumber;
    }


}
