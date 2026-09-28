package utility;

import java.util.List;
import java.util.Locale;

public class StringUtility {

    public static boolean contains(String current, String other){
        return current.equalsIgnoreCase(other);
    }

    public static boolean containsAny(String current, List<String> otherList){
        for (String word : otherList){
            if (current.toLowerCase(Locale.ROOT).contains(word.toLowerCase(Locale.ROOT))){
                return true;
            }
        }
        return false;
    }
}
