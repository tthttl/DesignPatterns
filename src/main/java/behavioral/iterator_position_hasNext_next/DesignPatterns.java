package behavioral.iterator;

import java.util.List;

public class DesignPatterns implements IterableCollection {

    List<DesignPattern> patterns;

    public DesignPatterns(List<DesignPattern> patterns) {
        this.patterns = patterns;
    }

    @Override
    public PatternIterator getIterator() {
        return new DesignPatternIterator();
    }

    private class DesignPatternIterator implements PatternIterator{

        int position;

        @Override
        public boolean hasNext() {
            if(position<patterns.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()){
                return patterns.get(position++);
            } else {
                return null;
            }
        }
    }

}
