package level_3.exercise_1_SportsNews;

import java.util.ArrayList;
import java.util.List;

public class EditorialOffice {
    public EditorialOffice(ArrayList<Editor> editors) {
        this.editors = editors;
    }

    public EditorialOffice() {
        editors = new ArrayList<>();
    }
    ArrayList<Editor> editors;

    public void addEditor(String dni) {
        Editor.validateDni(dni);
        validateEditorNotExists(dni);
        editors.add(new Editor(dni));
    }

    public void removeEditor(String dni){
        Editor toRemove = getEditor(dni);
        editors.remove(toRemove);
    }

    public Editor getEditor(String dni){
        Editor.validateDni(dni);
        validateEditorExists(dni);
        return editors.stream().filter(e -> e.getDni().equalsIgnoreCase(dni)).findFirst().orElse(null);
    }

    public void addArticleToEditor(Article toAdd, String dni) {
        Editor editor = getEditor(dni);
        editor.addArticle(toAdd);
    }

    public void removeArticleFromEditor(String articleTitle, String dni) {
        Editor editor = getEditor(dni);
        Article toRemove = editor.getArticle(articleTitle);
        editor.removeArticle(toRemove);
    }

    public void showArticlesOfEditor(String dni) {
        Editor editor = getEditor(dni);
        System.out.println("Showing articles of editor " + editor.getDni());
        System.out.println(editor);
    }

    private void validateEditorNotExists(String editorDNI){
        if (editors.stream().anyMatch(editor -> editor.getDni().equalsIgnoreCase(editorDNI))) {
            throw  new IllegalArgumentException("Editor with DNI " + editorDNI + " ALREADY exists in the editors office!");
        }
    }

    private void validateEditorExists(String editorDNI){
        if (editors.stream().noneMatch(editor -> editor.getDni().equalsIgnoreCase(editorDNI))) {
            throw  new IllegalArgumentException("Editor with DNI " + editorDNI + " DOES NOT exists in the editors office!");
        }
    }
}
