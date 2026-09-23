package level_3.exercise_1_SportsNews;

import utility.StringUtility;

import java.util.List;

public class MotoGpArticle extends Article {
    public MotoGpArticle(String title, String text, String team) {
        super(title, text);
        this.team = team;

        calculatePriceNews();
        calculateRating();
    }

    private final static double basePrice = 100;
    private final static double addonPriceHondaYamaha = 50;

    private final static double baseRating = 100;
    private final static double addonRatingHondaYamaha = 50;

    protected String team;

    @Override
    protected void calculatePriceNews() {
        this.price = basePrice;

        if (StringUtility.containsAny(team, List.of("Honda", "Yamaha"))){
            price += addonPriceHondaYamaha;
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {
        this.rating = baseRating;

        if (StringUtility.containsAny(team, List.of("Honda", "Yamaha"))){
            rating += addonRatingHondaYamaha;
        }

        System.out.println("Rating of this article has been updated!");
    }
}
