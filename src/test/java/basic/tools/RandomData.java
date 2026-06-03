/*
Утилитный класс, в котором будут методы для генерации тестовых данных (числовые данные, данные для регистрации (имя, емейл) и т.п.)
 */

package basic.tools;

import java.util.Random;

public class RandomData {

    public static int randomNumber(int num) {
        Random random = new Random();
        int randomNumber = random.nextInt(num);
        return randomNumber;
    }
}
