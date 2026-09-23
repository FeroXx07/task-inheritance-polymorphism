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
    private final static double addonPriceEuroLeague = 75;
    private final static double addonPriceBarcelonaMadrid = 75;

    private final static double baseRating = 4;
    private final static double addonRatingEuroLeague = 3;
    private final static double addonRatingACB = 2;
    private final static double addonRatingBarcelonaMadrid = 1;

    protected String competition;
    protected String club;

    @Override
    protected void calculatePriceNews() {
        this.price = basePrice;

        if (contains(competition, "Euro League") || contains(competition, "EuroLeague")){
            price += addonPriceEuroLeague;
        }

        if (containsAny(club, List.of("Barcelona", "Madrid"))){
            price += addonPriceBarcelonaMadrid;
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {
        this.rating = baseRating;

        if (contains(competition, "Euro League") || contains(competition, "EuroLeague")){
            rating += addonRatingEuroLeague;
        }
        else if (contains(competition, "ACB")){
            rating += addonRatingACB;
        }

        if (containsAny(club, List.of("Barcelona", "Madrid"))){
            rating += addonPriceBarcelonaMadrid;
        }

        System.out.println("Rating of this article has been updated!");
    }
}
