package level_3.exercise_1_SportsNews;

import utility.StringUtility;

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
    private final static double addonPriceChampionsLeague = 300;
    private final static double addonPriceBarcelonaMadrid = 100;
    private final static double addonPriceFerranBenzema = 50;

    private final static double baseRating = 5;
    private final static double addonRatingChampionsLeague = 3;
    private final static double addonRatingLeague = 2;
    private final static double addonRatingBarcelonaMadrid = 1;
    private final static double addonRatingFerranBenzema = 1;

    protected String competition;
    protected String club;
    protected String player;

    @Override
    protected void calculatePriceNews() {
        this.price = basePrice;

        if (StringUtility.contains(competition, "Champions League")){
            price += addonPriceChampionsLeague;
        }

        if (StringUtility.containsAny(club, List.of("Barcelona", "Madrid"))){
            price += addonPriceBarcelonaMadrid;
        }

        if (StringUtility.containsAny(player, List.of("Benzema", "Ferran Torres"))){
            price += addonPriceFerranBenzema;
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {
        this.rating = baseRating;

        if (StringUtility.contains(competition, "Champions League")){
            rating += addonRatingChampionsLeague;
        }
        else if (StringUtility.contains(competition, "League")){
            rating += addonRatingLeague;
        }

        if (StringUtility.containsAny(club, List.of("Barcelona", "Madrid"))){
            rating += addonRatingBarcelonaMadrid;
        }

        if (StringUtility.containsAny(player, List.of("Benzema", "Ferran Torres"))){
            rating += addonRatingFerranBenzema;
        }

        System.out.println("Rating of this article has been updated!");
    }
}
