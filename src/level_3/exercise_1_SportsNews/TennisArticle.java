package level_3.exercise_1_SportsNews;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TennisArticle extends Article {
    public TennisArticle(String title, String text, double rating, String competition, ArrayList<String> players) {
        super(title, text, rating);
        this.competition = competition;
        this.players = players;
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
}
