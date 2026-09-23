package level_3.exercise_1_SportsNews;

import utility.StringUtility;

import java.util.ArrayList;
import java.util.List;

public class TennisArticle extends Article {
    public TennisArticle(String title, String text,
                         String competition, ArrayList<String> players) {
        super(title, text);
        this.competition = competition;
        this.players = players;

        calculatePriceNews();
        calculateRating();
    }

    private final static double basePrice = 150;
    private final static double addonPriceBigThree = 100;

    private final static double baseRating = 4;
    private final static double addonRatingBigThree = 3;

    private final static List<String> bigThreePlayers = List.of("Federer", "Nadal", "Djokovic");

    protected String competition;
    protected ArrayList<String> players;

    @Override
    protected void calculatePriceNews() {
        this.price = basePrice;

        // Only add the addon once, hence the break
        for (String player : players) {
            if (StringUtility.containsAny(player, bigThreePlayers))
            {
                price += addonPriceBigThree;
                break;
            }
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {
        this.rating = baseRating;

        // Only add the addon once, hence the break
        for (String player : players) {
            if (StringUtility.containsAny(player, bigThreePlayers))
            {
                rating += addonRatingBigThree;
                break;
            }
        }
        System.out.println("Rating of this article has been updated!");
    }
}
