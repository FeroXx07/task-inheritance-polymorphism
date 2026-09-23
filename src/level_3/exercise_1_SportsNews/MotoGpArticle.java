package level_3.exercise_1_SportsNews;

public class MotoGpArticle extends Article {
    public MotoGpArticle(String title, String text, double rating, double price, String team) {
        super(title, text, rating, price);
        this.team = team;
    }

    protected String team;
}
