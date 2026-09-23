package utility;

import java.util.List;
import java.util.Locale;

public class StringUtility {

    public static boolean contains(String current, String other){
        return current.equalsIgnoreCase(other);
    }

    public static boolean containsAny(String content, List<String> toFindList){
        for (String word : toFindList){
            if (content.toLowerCase(Locale.ROOT).contains(word.toLowerCase(Locale.ROOT))){
                return true;
            }
        }
        return false;
    }
}
