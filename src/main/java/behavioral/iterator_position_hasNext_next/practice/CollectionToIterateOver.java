package behavioral.iterator.practice;

import java.util.List;

public class CollectionToIterateOver {

    private List<Integer> intList;

    public CollectionToIterateOver(List<Integer> intList) {
        this.intList = intList;
    }


    public CollIterator getIterator(){
        return new CollIterator();
    }

    private class CollIterator implements Iterator{

        int position;

        @Override
        public boolean hasNext() {
            return position<intList.size();
        }

        @Override
        public Object next() {
            return hasNext() ? intList.get(position++) : null;
        }
    }

}
