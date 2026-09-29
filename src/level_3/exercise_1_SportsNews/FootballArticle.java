package level_3.exercise_1_SportsNews;

import utility.StringUtility;

import java.util.List;

public class FootballArticle extends Article {
    private final static double BASE_PRICE = 300;
    private final static double ADDON_PRICE_CHAMPIONS_LEAGUE = 100;
    private final static double ADDON_PRICE_BARCELONA_MADRID = 100;
    private final static double ADDON_PRICE_FERRAN_BENZEMA = 50;

    private final static double BASE_RATING = 5;
    private final static double ADDON_RATING_CHAMPIONS_LEAGUE = 3;
    private final static double ADDON_RATING_LEAGUE = 2;
    private final static double ADDON_RATING_BARCELONA_MADRID = 1;
    private final static double ADDON_RATING_FERRAN_BENZEMA = 1;

    protected String competition;
    protected String club;
    protected String player;

    public FootballArticle(String title, String text, String competition, String club, String player) {
        super(title, text);
        this.competition = competition;
        this.club = club;
        this.player = player;

        calculatePriceNews();
        calculateRating();
    }
    
    @Override
    protected void calculatePriceNews() {
        this.price = BASE_PRICE;

        if (StringUtility.contains(competition, "Champions League")){
            price += ADDON_PRICE_CHAMPIONS_LEAGUE;
        }

        if (StringUtility.containsAny(club, List.of("Barcelona", "Madrid"))){
            price += ADDON_PRICE_BARCELONA_MADRID;
        }

        if (StringUtility.containsAny(player, List.of("Benzema", "Ferran Torres"))){
            price += ADDON_PRICE_FERRAN_BENZEMA;
        }

        System.out.println("Price of this article has been updated!");
    }

    @Override
    protected void calculateRating() {
        this.rating = BASE_RATING;

        if (StringUtility.contains(competition, "Champions League")){
            rating += ADDON_RATING_CHAMPIONS_LEAGUE;
        }
        else if (StringUtility.contains(competition, "League")){
            rating += ADDON_RATING_LEAGUE;
        }

        if (StringUtility.containsAny(club, List.of("Barcelona", "Madrid"))){
            rating += ADDON_RATING_BARCELONA_MADRID;
        }

        if (StringUtility.containsAny(player, List.of("Benzema", "Ferran Torres"))){
            rating += ADDON_RATING_FERRAN_BENZEMA;
        }

        System.out.println("Rating of this article has been updated!");
    }
}
