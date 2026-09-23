package level_3.exercise_1_SportsNews;

import java.util.List;

public class MotoGpArticle extends Article {
    public MotoGpArticle(String title, String text, String team) {
        super(title, text);
        this.team = team;

        calculatePriceNews();
        calculateRating();
    }

    private final static double basePrice = 100;
    private final static double addonHondaYamaha = 50;

    protected String team;

    @Override
    protected void calculatePriceNews() {
        this.price = basePrice;

        if (containsAny(team, List.of("Honda", "Yamaha"))){
            price += addonHondaYamaha;
        }
    }

    @Override
    protected void calculateRating() {

    }
}
