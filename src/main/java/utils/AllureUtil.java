package utils;

import io.qameta.allure.Allure;

public class AllureUtil {

     public static void step(String message) {
        Allure.step(message);
    }
    
}
