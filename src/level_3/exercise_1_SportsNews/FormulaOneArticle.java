package level_3.exercise_1_SportsNews;

import java.util.List;

public class FormulaOneArticle extends Article {
    public FormulaOneArticle(String title, String text, String scuderia) {
        super(title, text);
        this.scuderia = scuderia;

        calculatePriceNews();
        calculateRating();
    }

    private final static double basePrice = 100;
    private final static double addonPriceFerrariMercedes = 50;

    private final static double baseRating = 100;
    private final static double addonRatingFerrariMercedes = 50;

    protected String scuderia;

    @Override
    protected void calculatePriceNews() {
        this.price = basePrice;

        if (containsAny(scuderia, List.of("Ferrari", "Mercedes"))){
            price += addonPriceFerrariMercedes;
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {
        this.rating = basePrice;

        if (containsAny(scuderia, List.of("Ferrari", "Mercedes"))){
            rating += addonRatingFerrariMercedes;
        }

        System.out.println("Rating of this article has been updated!");
    }
}
