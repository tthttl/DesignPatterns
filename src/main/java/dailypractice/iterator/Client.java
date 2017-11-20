package dailypractice.iterator;

public class Client {

    public static void main (String[]args){

        DesignPattern iterator = new DesignPattern("iterator");
        DesignPattern command = new DesignPattern("command");
        DesignPattern interpreter = new DesignPattern("interpreter");
        DesignPattern chain = new DesignPattern("chain");

        DesignPatterns patterns = new DesignPatterns();

        patterns.addNewPattern(interpreter);
        patterns.addNewPattern(iterator);
        patterns.addNewPattern(command);
        patterns.addNewPattern(chain);

        Iterator patternIterator = patterns.getIterator();

        while (patternIterator.hasNext()){
            System.out.println(patternIterator.next().toString());
        }

    }





}
