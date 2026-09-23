package level_3.exercise_1_SportsNews;

public class FootballArticle extends Article {
    public FootballArticle(String title, String text, double rating, double price,
                           String competition, String club, String player) {
        super(title, text, rating, price);
        this.competition = competition;
        this.club = club;
        this.player = player;
    }

    protected String competition;
    protected String club;
    protected String player;
}
