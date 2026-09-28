package level_3.exercise_1_SportsNews;

import utility.StringUtility;

import java.util.ArrayList;
import java.util.List;

public class TennisArticle extends Article {
    private final static double BASE_PRICE = 150;
    private final static double ADDON_PRICE_BIG_THREE = 100;

    private final static double BASE_RATING = 4;
    private final static double ADDON_RATING_BIG_THREE = 3;

    private final static List<String> BIG_THREE_PLAYERS = List.of("Federer", "Nadal", "Djokovic");

    public TennisArticle(String title, String text,
                         String competition, ArrayList<String> players) {
        super(title, text);
        this.competition = competition;
        this.players = players;

        calculatePriceNews();
        calculateRating();
    }

    protected String competition;
    protected ArrayList<String> players;

    @Override
    protected void calculatePriceNews() {
        this.price = BASE_PRICE;

        // Only add the addon once, hence the break
        for (String player : players) {
            if (StringUtility.containsAny(player, BIG_THREE_PLAYERS))
            {
                price += ADDON_PRICE_BIG_THREE;
                break;
            }
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {
        this.rating = BASE_RATING;

        // Only add the addon once, hence the break
        for (String player : players) {
            if (StringUtility.containsAny(player, BIG_THREE_PLAYERS))
            {
                rating += ADDON_RATING_BIG_THREE;
                break;
            }
        }
        System.out.println("Rating of this article has been updated!");
    }
}
