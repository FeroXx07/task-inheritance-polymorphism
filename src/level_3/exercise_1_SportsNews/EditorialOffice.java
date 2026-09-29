package level_3.exercise_1_SportsNews;

import java.util.ArrayList;
import java.util.List;

public class EditorialOffice {
    private List<Editor> editors;

    public EditorialOffice() {
        editors = new ArrayList<>();
    }

    public void addEditor(String name, String dni) {
        Editor.validateDni(dni);
        validateEditorNotExists(dni);
        editors.add(new Editor(name, dni));
    }

    public void removeEditor(String dni){
        Editor toRemove = getEditor(dni);
        validateEditorExists(dni);
        editors.remove(toRemove);
    }

    public Editor getEditor(String dni){
        Editor.validateDni(dni);

        Editor foundEditor = editors.stream().filter(e -> e.getDni().equalsIgnoreCase(dni)).findFirst().orElse(null);
        if (foundEditor == null){
            throw new IllegalArgumentException("Editorial Office: Editor with DNI \"" + dni + "\" DOES NOT exists in the editors office!");
        }

        return foundEditor;
    }
    public List<Editor> getEditors() { return List.copyOf(editors); }

    public void addArticleToEditor(Article toAdd, String dni) {
        Editor editor = getEditor(dni);
        editor.addArticle(toAdd);
    }

    public void removeArticleFromEditor(String articleTitle, String dni) {
        Editor editor = getEditor(dni);
        Article toRemove = editor.getArticle(articleTitle);
        editor.removeArticle(toRemove);
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
