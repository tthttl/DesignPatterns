package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

// Goal: Being able to traverse a collection without exposing the underlying implementation
public class Client {

//    2 interfaces => first implemented by the collection in order to being able to return an iterator for the specified collection
//    ==> second is implemented by the private class inside the collection (this private class will be concrete iterator, unique for the given collection)
//    ==> this private class has access to the elements of the parent collection
    public static void main (String[] args){

        List<DesignPattern> patterns = new ArrayList<>();
        patterns.add(new DesignPattern("iterator"));
        patterns.add(new DesignPattern("mediator"));
        patterns.add(new DesignPattern("adapter"));
        patterns.add(new DesignPattern("factory"));
        patterns.add(new DesignPattern("singleton"));

        DesignPatterns designPatterns = new DesignPatterns(patterns);

        PatternIterator iterator = designPatterns.getIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

    }

}
