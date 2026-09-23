package level_3.exercise_1_SportsNews;

import java.util.List;

public class MotoGpArticle extends Article {
    public MotoGpArticle(String title, String text, double rating, String team) {
        super(title, text, rating);
        this.team = team;
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
}
