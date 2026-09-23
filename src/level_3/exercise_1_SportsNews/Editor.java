package level_3.exercise_1_SportsNews;

import java.util.ArrayList;

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

    public void AddArticle(Article toAdd){
//        if (articles.stream().anyMatch(a -> a.id.equalsIgnoreCase(toAdd.id))){
//            throw new IllegalArgumentException("Article with ID " + toAdd.id + " already exists in editor's database");
//        }
        articles.add(toAdd);
    }

    public static void validateDni(String dni) {
        // dni.isEmpty() does not take into account whitespace characters
        if (dni.isBlank()) {
            throw new IllegalArgumentException("INVALID DNI NUMBER: " + dni + ". It cannot be empty");
        }
        if (dni.length() != 9) {
            throw new IllegalArgumentException("INVALID DNI NUMBER: " + dni + ". It must have 9 characters. ");
        }
        // Could add also letter validation but it is out of scope of the exercise.
    }
}
