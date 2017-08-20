package behavioral.memento;

public class TextEditor {

    private String name;
    private StringBuilder content = new StringBuilder();

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }

    public StringBuilder getContent() {
        return content;
    }

    public void write(StringBuilder stringBuilder){
        this.content.append(stringBuilder);
    }

    public Memento save() {
        return new Memento(this.name, this.content);
    }

    public void reload(Object lastSave) {
        Memento memento = (Memento) lastSave;
        this.setContent(new StringBuilder(memento.content));
        this.setName(memento.name);
    }

    private class Memento {

        private String name;
        private StringBuilder content;

        public Memento(String name, StringBuilder content) {
            this.name = name;
            this.content = new StringBuilder(content);
        }
    }

}
