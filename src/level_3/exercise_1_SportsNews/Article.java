package level_3.exercise_1_SportsNews;

import utility.IdGenerator;

import java.util.List;
import java.util.Locale;

public abstract class Article {
    public Article(String title, String text) {
        this.title = title;
        this.text = text;

        id = IdGenerator.generateTimestampId();
    }

    protected String id;
    protected String title;
    protected String text = "";
    protected double rating;
    protected double price;

    protected abstract void calculatePriceNews();
    protected abstract void calculateRating();
    
    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}' + '\n';
    }
}
