package level_3.exercise_1_SportsNews;

public class BasketballArticle extends Article {
    public BasketballArticle(String title, String text, double rating, double price, String competition, String club) {
        super(title, text, rating, price);
        this.competition = competition;
        this.club = club;
    }

    protected String competition;
    protected String club;
}
