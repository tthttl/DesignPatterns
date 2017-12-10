package behavioral.iterator.practice;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        CollectionToIterateOver collection = new CollectionToIterateOver(list);

        Iterator collIterator = collection.getIterator();

        while (collIterator.hasNext()){
            System.out.println(collIterator.next());
        }

    }


}
