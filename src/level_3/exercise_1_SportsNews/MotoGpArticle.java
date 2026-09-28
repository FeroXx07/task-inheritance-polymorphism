package level_3.exercise_1_SportsNews;

import utility.StringUtility;

import java.util.List;

public class MotoGpArticle extends Article {
    private final static double BASE_PRICE = 100;
    private final static double ADDON_PRICE_HONDA_YAMAHA = 50;

    private final static double BASE_RATING = 100;
    private final static double ADDON_RATING_HONDA_YAMAHA = 50;

    protected String team;
    
    public MotoGpArticle(String title, String text, String team) {
        super(title, text);
        this.team = team;

        calculatePriceNews();
        calculateRating();
    }

    @Override
    protected void calculatePriceNews() {
        this.price = BASE_PRICE;

        if (StringUtility.containsAny(team, List.of("Honda", "Yamaha"))){
            price += ADDON_PRICE_HONDA_YAMAHA;
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {
        this.rating = BASE_RATING;

        if (StringUtility.containsAny(team, List.of("Honda", "Yamaha"))){
            rating += ADDON_RATING_HONDA_YAMAHA;
        }

        System.out.println("Rating of this article has been updated!");
    }
}
