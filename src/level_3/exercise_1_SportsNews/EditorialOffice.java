package level_3.exercise_1_SportsNews;

import java.util.ArrayList;
import java.util.List;

public class EditorialOffice {
    ArrayList<Editor> editors;

    public EditorialOffice() {
        editors = new ArrayList<>();
    }

    public void addEditor(String dni) {
        Editor.validateDni(dni);
        validateEditorNotExists(dni);
        editors.add(new Editor(dni));
        System.out.println("Editorial Office: \"" + dni + "\" added successfully");
        showAllEditors();
    }

    public void removeEditor(String dni){
        Editor toRemove = getEditor(dni);
        editors.remove(toRemove);
        System.out.println("Editorial Office: \"" + dni + "\" removed successfully");
        showAllEditors();
    }

    public Editor getEditor(String dni){
        Editor.validateDni(dni);
        validateEditorExists(dni);
        return editors.stream().filter(e -> e.getDni().equalsIgnoreCase(dni)).findFirst().orElse(null);
    }

    public void addArticleToEditor(Article toAdd, String dni) {
        Editor editor = getEditor(dni);
        editor.addArticle(toAdd);
        System.out.println("Editorial Office: Article with title: \"" + toAdd.title + "\" added successfully to the editor: " + dni);
    }

    public void removeArticleFromEditor(String articleTitle, String dni) {
        Editor editor = getEditor(dni);
        Article toRemove = editor.getArticle(articleTitle);
        editor.removeArticle(toRemove);
        System.out.println("Editorial Office: Article with title: \"" + articleTitle + "\" removed successfully from the editor: " + dni);
    }

    public void showAllEditors() {
        System.out.println("Editorial Office: Current editors -> " + editors);
    }

    public void showArticlesOfEditor(String dni) {
        Editor editor = getEditor(dni);
        System.out.println("Editorial Office: Showing articles of editor " + editor.getDni());
        System.out.println(editor.toFullString());
    }

    private void validateEditorNotExists(String editorDNI){
        if (editors.stream().anyMatch(editor -> editor.getDni().equalsIgnoreCase(editorDNI))) {
            throw new IllegalArgumentException("Editorial Office: Editor with DNI \"" + editorDNI + "\" ALREADY exists in the editors office!");
        }
    }

    private void validateEditorExists(String editorDNI){
        if (editors.stream().noneMatch(editor -> editor.getDni().equalsIgnoreCase(editorDNI))) {
            throw new IllegalArgumentException("Editorial Office: Editor with DNI \"" + editorDNI + "\" DOES NOT exists in the editors office!");
        }
    }
}
