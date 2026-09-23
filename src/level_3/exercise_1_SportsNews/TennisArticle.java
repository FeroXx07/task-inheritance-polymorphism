package level_3.exercise_1_SportsNews;

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
    private final static double addonBigThree = 100;
    private final static List<String> bigThreePlayers = List.of("Federer", "Nadal", "Djokovic");

    protected String competition;
    protected ArrayList<String> players;

    @Override
    protected void calculatePriceNews() {
        this.price = basePrice;

        // Only add the addon once, hence the break
        for (String player : players) {
            if (containsAny(player, bigThreePlayers))
            {
                price += addonBigThree;
                break;
            }
        }
    }

    @Override
    protected void calculateRating() {

    }
}
