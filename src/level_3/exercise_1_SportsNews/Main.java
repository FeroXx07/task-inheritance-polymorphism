package level_3.exercise_1_SportsNews;

import utility.ScannerUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);
    EditorialOffice editorialOffice;

    void main(String[] args) {
        editorialOffice = new EditorialOffice();
        boolean exit = false;
        seedData();
        do {
            try {
                switch (inputMainMenu(input)) {
                    case 0: {
                        System.out.println("Thank you for using this application.");
                        exit = true;
                        break;
                    }
                    case 1:
                        handleEditorAddition(input);
                        break;
                    case 2:
                        handleEditorRemoval(input);
                        break;
                    case 3:
                        handleArticleCreation(input);
                        break;
                    case 4:
                        handleArticleRemoval(input);
                        break;
                    case 5:
                        handleArticlesDisplay(input);
                        break;
                    case 6:
                        handleArticleRatingCalc(input);
                        break;
                    case 7:
                        handleArticlePriceCalc(input);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (!exit);
    }

    private void seedData() {
        final String editorDniA = "61234567A";
        final String editorDniB = "67654321Z";
        editorialOffice.addEditor(editorDniA);
        editorialOffice.addEditor(editorDniB);

        editorialOffice.addArticleToEditor(new FootballArticle("El barcelona de flick vuelve a golear", "El barcelona vuelva golear sin necesidad de ferran torres.",
                "Champions league", "barcelona", "ferran torres"), editorDniA);
        editorialOffice.addArticleToEditor(new FootballArticle("El madrid pierde el derbi", "Los de mourinho se quedan si ver la victoria en el metropolitano.",
                "League", "Madrid", "Vinicius"), editorDniA);

        editorialOffice.addArticleToEditor(new FormulaOneArticle("Kimi Antonelli es campeon del mundo", "Kimi ha anotado un grand slam en abu dhabi",
                "Mercedes"), editorDniB);
    }

    private byte inputMainMenu(Scanner input) {
        byte option;
        final byte MINIM = 0;
        final byte MAXIM = 7;

        do {
            System.out.println("\nMAIN MENU");
            System.out.println("Option 0: Exit App");
            System.out.println("Option 1: Add Editor");
            System.out.println("Option 2: Remove Editor");
            System.out.println("Option 3: Add Article to Editor");
            System.out.println("Option 4: Remove Article");
            System.out.println("Option 5: Show Articles of Editor");
            System.out.println("Option 6: Calculate Article Rating");
            System.out.println("Option 7: Calculate Article Price");
            option = ScannerUtility.fetchNumber(input, "", "Invalid byte value.", byte.class);
            if (option < MINIM || option > MAXIM) {
                System.out.println("Select a valid option!");
            }
        } while (option < MINIM || option > MAXIM);
        return option;
    }

    private byte inputArticleCreationMenu(Scanner input) {
        byte option;
        final byte MINIM = 0;
        final byte MAXIM = 5;
        do {
            System.out.println("\nARTICLE CREATION MENU");
            System.out.println("Option 0: Exit Menu");
            System.out.println("Option 1: Create Football Article");
            System.out.println("Option 2: Create Basket Article");
            System.out.println("Option 3: Create Tennis Article");
            System.out.println("Option 4: Create Formula 1 Article");
            System.out.println("Option 5: Create MotoGP Article");
            option = ScannerUtility.fetchNumber(input, "", "Invalid byte value.", byte.class);
            if (option < MINIM || option > MAXIM) {
                System.out.println("Select a valid option!");
            }
        } while (option < MINIM || option > MAXIM);
        return option;
    }

    private void handleEditorAddition(Scanner input) {
        System.out.println("\nOption 1 selected: Add Editor");
        editorialOffice.showAllEditors();
        // Inputs through utility class, they manage exception handling and retries.
        // After each numerical input, small range validation.
        String dni = ScannerUtility.fetchStringInput(input, "Please enter the DNI of the new Editor: ");
        editorialOffice.addEditor(dni);
    }

    private void handleEditorRemoval(Scanner input) {
        System.out.println("\nOption 2 selected: Remove Editor");
        editorialOffice.showAllEditors();

        String dni = ScannerUtility.fetchStringInput(input, "Please enter the DNI of the to be removed Editor: ");
        editorialOffice.removeEditor(dni);
    }

    private void handleArticleCreation(Scanner input) {
        System.out.println("\nOption 3 selected: Add Article to Editor");
        editorialOffice.showAllEditors();

        String dni = ScannerUtility.fetchStringInput(input, "Please enter the DNI of the Editor to whom the article will be added: ");
        Editor editor = editorialOffice.getEditor(dni);

        String title = ScannerUtility.fetchStringInput(input, "Please enter the title of the article: ");
        editor.validationArticleNotExists(title);

        String text = ScannerUtility.fetchStringInput(input, "Please enter the content of the article: ");

        boolean exit = false;
        do {
            try {
                Article newArticle = switch (inputArticleCreationMenu(input)) {
                    case 0 -> {
                        exit = true;
                        yield null;
                    }
                    case 1 -> {
                        String competition = ScannerUtility.fetchStringInput(input, "Please enter the competition of the article: ");
                        String club = ScannerUtility.fetchStringInput(input, "Please enter the club of the article: ");
                        String player = ScannerUtility.fetchStringInput(input, "Please enter the player of the article: ");
                        yield new FootballArticle(title, text, competition, club, player);
                    }
                    case 2 -> {
                        String competition = ScannerUtility.fetchStringInput(input, "Please enter the competition of the article: ");
                        String club = ScannerUtility.fetchStringInput(input, "Please enter the club of the article: ");
                        yield new BasketballArticle(title, text, competition, club);
                    }
                    case 3 -> {
                        String competition = ScannerUtility.fetchStringInput(input, "Please enter the competition of the article: ");
                        String playerA = ScannerUtility.fetchStringInput(input, "Please enter the first player of the article: ");
                        String playerB = ScannerUtility.fetchStringInput(input, "Please enter the first second of the article: ");
                        yield new TennisArticle(title, text, competition, (ArrayList<String>) List.of(playerA, playerB));
                    }
                    case 4 -> {
                        String scuderia = ScannerUtility.fetchStringInput(input, "Please enter the scuderia of the article: ");
                        yield new FormulaOneArticle(title, text, scuderia);
                    }
                    case 5 -> {
                        String team = ScannerUtility.fetchStringInput(input, "Please enter the team of the article: ");
                        yield new MotoGpArticle(title, text, team);
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + inputArticleCreationMenu(input));
                };

                if (newArticle != null) {
                    editorialOffice.addArticleToEditor(newArticle, editor.getDni());
                    exit = true;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!exit);
    }

    private void handleArticleRemoval(Scanner input) {
        System.out.println("\nOption 4 selected: Remove Article from Editor");
        editorialOffice.showAllEditors();

        String dni = ScannerUtility.fetchStringInput(input, "Please enter the DNI of the Editor to whom the article will be removed: ");
        Editor editor = editorialOffice.getEditor(dni);

        System.out.println("Editorial Office: Articles of Editor: " + editor.getArticles());

        String title = ScannerUtility.fetchStringInput(input, "Please enter the title of the article to be removed: ");
        editorialOffice.removeArticleFromEditor(title, dni);
    }

    private void handleArticlesDisplay(Scanner input) {
        System.out.println("\nOption 5 selected: Show Articles of Editor");
        editorialOffice.showAllEditors();

        String dni = ScannerUtility.fetchStringInput(input, "Please enter the DNI of the Editor of whom the articles will be displayed: ");
        Editor editor = editorialOffice.getEditor(dni);

        System.out.println("Editorial Office: Articles of Editor: " + editor.toFullString());
    }

    private void handleArticleRatingCalc(Scanner input) {
        System.out.println("\nOption 5 selected: Calculate Article Rating");
        editorialOffice.showAllEditors();

        String dni = ScannerUtility.fetchStringInput(input, "Please enter the DNI of the Editor of whom the articles will be displayed: ");
        Editor editor = editorialOffice.getEditor(dni);

        System.out.println("Editorial Office: Articles of Editor: " + editor.getArticles());
        String title = ScannerUtility.fetchStringInput(input, "Please enter the title of the article to show the rating: ");

        Article article = editor.getArticle(title);
        System.out.println("Editorial Office: The rating of the article is: " + article.rating);
    }
    private void handleArticlePriceCalc(Scanner input) {
        System.out.println("\nOption 6 selected: Calculate Article Price");
        editorialOffice.showAllEditors();

        String dni = ScannerUtility.fetchStringInput(input, "Please enter the DNI of the Editor of whom the articles will be displayed: ");
        Editor editor = editorialOffice.getEditor(dni);

        System.out.println("Editorial Office: Articles of Editor: " + editor.getArticles());
        String title = ScannerUtility.fetchStringInput(input, "Please enter the title of the article to show the price: ");

        Article article = editor.getArticle(title);
        System.out.println("Editorial Office: The price of the article is: " + article.price);
    }


}

