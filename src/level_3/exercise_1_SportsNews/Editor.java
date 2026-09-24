package level_3.exercise_1_SportsNews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Editor {
    public Editor(String dni) {
        validateDni(dni);
        this.dni = dni;
        articles = new ArrayList<>();
    }

    private final String dni;
    private static double wage = 1500;
    private ArrayList<Article> articles;

    public String getDni() { return dni; }
    public static double getWage() { return wage; }
    public List<Article> getArticles() { return List.copyOf(articles); }

    public void addArticle(Article toAdd){
        validationArticleNotExists(toAdd.title);
        articles.add(toAdd);
    }

    public void removeArticle(Article toRemove){
        validationArticleExists(toRemove.title);
        articles.remove(toRemove);
    }

    public Article getArticle(String title){
        validationArticleExists(title);
        return articles.stream().filter(a -> a.title.equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    public void validationArticleNotExists(String title){
        if (articles.stream().anyMatch(a -> a.title.equalsIgnoreCase(title))){
            throw new IllegalArgumentException("Article with title \"" + title + "\" ALREADY exists in editor's database");
        }
    }
    public void validationArticleExists(String title){
        if (articles.stream().noneMatch(a -> a.title.equalsIgnoreCase(title))){
            throw new IllegalArgumentException("Article with title \"" + title + "\" DOES NOT exist in editor's database");
        }
    }

    public static void validateDni(String dni) {
        // dni.isEmpty() does not take into account whitespace characters
        if (dni.isBlank()) {
            throw new IllegalArgumentException("INVALID DNI NUMBER: \"" + dni + "\". It cannot be empty");
        }
        if (dni.length() != 9) {
            throw new IllegalArgumentException("INVALID DNI NUMBER: \"" + dni + "\". It must have 9 characters. ");
        }
        // Could add also letter validation but it is out of scope of the exercise.
    }

    @Override
    public String toString() {
        return "Editor{" +
                "dni='" + dni +
                '}';
    }

    public String toFullString() {
        return "Editor{" +
                "dni='" + dni + '\'' +
                ", articles=" + articles +
                '}';
    }
}
