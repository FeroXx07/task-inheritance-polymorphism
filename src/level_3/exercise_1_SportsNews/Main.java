package level_3.exercise_1_SportsNews;

import utility.ScannerUtility;

import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);

     void main(String[] args) {
        boolean exit = false;
        seedData();
        do{
            try {
                switch(inputMainMenu(input)){
                    case 0: System.out.println("Thank you for using this application.");
                        exit = true;
                    case 1: handleEditorAddition(input);
                }
            }
            catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }while(!exit);
    }

    private void seedData() {

    }

    private byte inputMainMenu(Scanner input) {
        byte option;
        final byte MINIM = 0;
        final byte MAXIM = 7;

        do{
            System.out.println("\nMAIN MENU");
            System.out.println("Option 0: Exit App");
            System.out.println("Option 1: Add Editor");
            System.out.println("Option 2: Remove Editor");
            System.out.println("Option 3: Add Article to Editor");
            System.out.println("Option 4: Remove Article");
            System.out.println("Option 5: Show Article of Editor");
            System.out.println("Option 6: Calculate Article Price");
            System.out.println("Option 7: Calculate Article Rating");
            option = ScannerUtility.fetchNumber(input, "", "Invalid byte value.", byte.class);
            if(option < MINIM || option > MAXIM){
                System.out.println("Select a valid option!");
            }
        }while(option < MINIM || option > MAXIM);
        return option;
    }

    private void handleEditorAddition(Scanner input) {
        System.out.println("\nOption 1 selected: Add Editor");
        // Inputs through utility class, they manage exception handling and retries.
        // After each numerical input, small range validation.
        String dni = ScannerUtility.fetchStringInput(input, "Please enter a DNI: ");
        Editor.validateDni(dni);
    }

}

