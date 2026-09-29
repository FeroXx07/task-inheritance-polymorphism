package level_3.exercise_1_SportsNews;

import utility.StringUtility;

import java.util.List;

public class BasketballArticle extends Article {
    private final static double BASE_PRICE = 250;
    private final static double ADDON_PRICE_EURO_LEAGUE = 75;
    private final static double ADDON_PRICE_BARCELONA_MADRID = 75;

    private final static double BASE_RATING = 4;
    private final static double ADDON_RATING_EURO_LEAGUE = 3;
    private final static double ADDON_RATING_ACB = 2;
    private final static double ADDON_RATING_BARCELONA_MADRID = 1;
    protected String competition;
    protected String club;
    
    public BasketballArticle(String title, String text, String competition, String club) {
        super(title, text);
        this.competition = competition;
        this.club = club;

        calculatePriceNews();
        calculateRating();
    }

    @Override
    protected void calculatePriceNews() {
        this.price = BASE_PRICE;

        if (StringUtility.contains(competition, "Euro League") || StringUtility.contains(competition, "EuroLeague")){
            price += ADDON_PRICE_EURO_LEAGUE;
        }

        if (StringUtility.containsAny(club, List.of("Barcelona", "Madrid"))){
            price += ADDON_PRICE_BARCELONA_MADRID;
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {
        this.rating = BASE_RATING;

        if (StringUtility.contains(competition, "Euro League") || StringUtility.contains(competition, "EuroLeague")){
            rating += ADDON_RATING_EURO_LEAGUE;
        }
        else if (StringUtility.contains(competition, "ACB")){
            rating += ADDON_RATING_ACB;
        }

        if (StringUtility.containsAny(club, List.of("Barcelona", "Madrid"))){
            rating += ADDON_RATING_BARCELONA_MADRID;
        }

        System.out.println("Rating of this article has been updated!");
    }
}
