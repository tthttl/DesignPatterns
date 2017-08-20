package behavioral.memento;

public class SaveAndReloadUtil {

    private Object lastSave;

    public void save(TextEditor editor){
        this.lastSave = editor.save();
    }

    public void reload(TextEditor editor){
        editor.reload(this.lastSave);
    }



}
