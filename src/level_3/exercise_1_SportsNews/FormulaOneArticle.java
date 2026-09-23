package level_3.exercise_1_SportsNews;

import java.util.List;

public class FormulaOneArticle extends Article {
    public FormulaOneArticle(String title, String text, double rating, String scuderia) {
        super(title, text, rating);
        this.scuderia = scuderia;
    }

    private final static double basePrice = 100;
    private final static double addonFerrariMercedes = 50;

    protected String scuderia;

    @Override
    protected void calculatePriceNews() {
        this.price = basePrice;

        if (containsAny(scuderia, List.of("Ferrari", "Mercedes"))){
            price += addonFerrariMercedes;
        }
    }
}
