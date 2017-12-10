package behavioral.memento.practice;

public class Client {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor(new StringBuffer(), "kuki");
        editor.write("The quick brown fox");
        editor.write(" jumps over");
        TextEditor.MementoHolder util = editor.new MementoHolder();
        util.save();
        editor.write(" the lazy dog.");
        util.reload();
        editor.read();

    }

}
