package level_3.exercise_1_SportsNews;

import java.util.ArrayList;

public class EditorialOffice {
    public EditorialOffice(ArrayList<Editor> editors) {
        this.editors = editors;
    }

    public EditorialOffice() {
        editors = new ArrayList<>();
    }
    ArrayList<Editor> editors;
}
