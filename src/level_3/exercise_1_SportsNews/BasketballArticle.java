package level_3.exercise_1_SportsNews;

import java.util.List;

public class BasketballArticle extends Article {
    public BasketballArticle(String title, String text, String competition, String club) {
        super(title, text);
        this.competition = competition;
        this.club = club;

        calculatePriceNews();
        calculateRating();
    }

    private final static double basePrice = 250;
    private final static double addonEuroLeague = 75;
    private final static double addonBarcelonaMadrid = 75;

    protected String competition;
    protected String club;

    @Override
    protected void calculatePriceNews() {
        this.price = basePrice;

        if (contains(competition, "Euro League") || contains(competition, "EuroLeague")){
            price += addonEuroLeague;
        }

        if (containsAny(club, List.of("Barcelona", "Madrid"))){
            price += addonBarcelonaMadrid;
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {

    }
}
