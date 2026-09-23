package level_3.exercise_1_SportsNews;

public class TennisArticle extends Article {
    public TennisArticle(String title, String text, double rating, double price, String competition, String playerA, String playerB) {
        super(title, text, rating, price);
        this.competition = competition;
        this.playerA = playerA;
        this.playerB = playerB;
    }

    protected String competition;
    protected String playerA;
    protected String playerB;
}
