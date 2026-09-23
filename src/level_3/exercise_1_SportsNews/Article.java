package level_3.exercise_1_SportsNews;

public abstract class Article {
    public Article(String title, String text, double rating, double price) {
        this.title = title;
        this.text = text;
        this.rating = rating;
        this.price = price;
    }

    protected String title;
    protected String text = "";
    protected double rating;
    protected double price;
    
    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}
