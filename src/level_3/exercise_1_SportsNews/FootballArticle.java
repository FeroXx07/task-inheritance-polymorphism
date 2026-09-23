package level_3.exercise_1_SportsNews;

import java.util.List;

public class FootballArticle extends Article {
    public FootballArticle(String title, String text, String competition, String club, String player) {
        super(title, text);
        this.competition = competition;
        this.club = club;
        this.player = player;

        calculatePriceNews();
        calculateRating();
    }

    private final static double basePrice = 300;
    private final static double addonChampionsLeague = 300;
    private final static double addonBarcelonaMadrid = 100;
    private final static double addonFerranBenzema = 50;

    protected String competition;
    protected String club;
    protected String player;

    @Override
    protected void calculatePriceNews() {
            this.price = basePrice;

        if (contains(competition, "Champions League")){
            price += addonChampionsLeague;
        }

        if (containsAny(club, List.of("Barcelona", "Madrid"))){
            price += addonBarcelonaMadrid;
        }

        if (containsAny(player, List.of("Benzema", "Ferran Torres"))){
            price += addonFerranBenzema;
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {

    }
}
