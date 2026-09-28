package level_3.exercise_1_SportsNews;

import utility.StringUtility;

import java.util.List;

public class FormulaOneArticle extends Article {
    private final static double BASE_PRICE = 100;
    private final static double ADDON_PRICE_FERRARI_MERCEDES = 50;

    private final static double BASE_RATING = 100;
    private final static double ADDON_RATING_FERRARI_MERCEDES = 50;

    protected String scuderia;
    
    public FormulaOneArticle(String title, String text, String scuderia) {
        super(title, text);
        this.scuderia = scuderia;

        calculatePriceNews();
        calculateRating();
    }

    @Override
    protected void calculatePriceNews() {
        this.price = BASE_PRICE;

        if (StringUtility.containsAny(scuderia, List.of("Ferrari", "Mercedes"))){
            price += ADDON_PRICE_FERRARI_MERCEDES;
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {
        this.rating = BASE_RATING;

        if (StringUtility.containsAny(scuderia, List.of("Ferrari", "Mercedes"))){
            rating += ADDON_RATING_FERRARI_MERCEDES;
        }

        System.out.println("Rating of this article has been updated!");
    }
}
