package behavioral.memento;


// Goal: To be able to restore the state of the object to a previous state. (save button)

// State is stored inside the original object in a private memento class, which has the same fields as the object.
// An external util class is needed to store the memento (as a plain Object, since its private) and reload it
// ==> it will make the editor which it gets as a parameter equal to its stored memento.
// Deep copy is necessary during storing and reloading.
public class Client {

    public static void main (String[] args){
        TextEditor editor = new TextEditor();
        editor.setName("kiskutya");
//        AKA the CareTaker!! :) ==> Must not operate on the memento. Only calls the Original objects methods. ==> The Originator does the saving and reloading.
        SaveAndReloadUtil util = new SaveAndReloadUtil();

        editor.write(new StringBuilder("Hozd vissza a botot!"));

        util.save(editor);

        editor.write(new StringBuilder("Nem hozom, mondta a kutya, faszér dobtad el??"));

        System.out.println(editor.getContent());

        util.reload(editor);

        System.out.println(editor.getContent());

    }


}
