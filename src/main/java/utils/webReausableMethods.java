package utils;

public class webReausableMethods {

    public static int extractPrice(String text) {
    return Integer.parseInt(text.replaceAll("[^0-9]", ""));
}
    
}
