package basic.tools;

import java.util.Random;

public class Constants {

    public static int randomNumber(int num) {
        Random random = new Random();
        int randomNumber = random.nextInt(num);
        return randomNumber;
    }

    public static enum Gender {
        MR("Mr"),
        MRS("Mrs");

        Gender(String displayGender) {
            this.displayGender = displayGender;
        }
        public String displayGender;
        public String getDisplayGender(){
            return displayGender;
        }


    }
    public static enum Country {
        IND("India"),
        USA("United States"),
        CAN("Canada"),
        AUS("Australia"),
        ISR("Israel"),
        NZL("New Zeeland"),
        SGP("Singapore");

        public String displayCountry;

        public String getDisplayCountry(){
            return displayCountry;
        }

        Country(String displayCountry) {
            this.displayCountry = displayCountry;
        }
    }

}
