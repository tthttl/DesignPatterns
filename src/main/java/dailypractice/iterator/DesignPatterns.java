package dailypractice.iterator;

import java.util.ArrayList;
import java.util.List;

public class DesignPatterns implements IterableCollection {

    private List<DesignPattern> designPatterns;

    public DesignPatterns() {
        this.designPatterns = new ArrayList<>();
    }

    public void addNewPattern(DesignPattern designPattern){
        designPatterns.add(designPattern);
    }

    @Override
    public Iterator getIterator() {
        return new DesignPatternIterator();
    }

    private class DesignPatternIterator implements Iterator{

        int position;

        @Override
        public boolean hasNext() {
            return position<designPatterns.size();
        }

        @Override
        public DesignPattern next() {
            if(hasNext()){
                return designPatterns.get(position++);
            }
            return null;
        }
    }
}
