package level_3.exercise_1_SportsNews;

public class FormulaOneArticle extends Article {
    public FormulaOneArticle(String title, String text, double rating, double price, String scuderia) {
        super(title, text, rating, price);
        this.scuderia = scuderia;
    }

    protected String scuderia;
}
