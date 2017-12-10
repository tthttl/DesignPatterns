package behavioral.memento.practice;

public class TextEditor {

    private StringBuffer text;
    private String fileName;

    public TextEditor(StringBuffer text, String fileName) {
        this.text = text;
        this.fileName = fileName;
    }

    public void write(String textToAdd){
        this.text.append(textToAdd);
    }

    public void read(){
        System.out.println(text);
    }

    public Memento save(){
        return new Memento(text,fileName);
    }

    public void reload(Memento memento){
        this.text = new StringBuffer(memento.text);
        this.fileName = memento.fileName;
    }

    public static class Memento {

        private StringBuffer text;
        private String fileName;

        public Memento(StringBuffer text, String fileName) {
            this.text = new StringBuffer(text);
            this.fileName = fileName;
        }
    }

    public class MementoHolder {

        private Memento lastSave;

        public void save(){
            lastSave = TextEditor.this.save();
        }

        public void reload(){
            TextEditor.this.reload(lastSave);
        }

    }

}
