package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Artist {


//    When we need to create a structure in a way that the objects in the structure has to be treated the same way, we can apply composite design pattern.
    private List<Shape> shapes;

    public Artist() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public void clear(){
        shapes.clear();
    }

    public void draw (String color){
        shapes.forEach(
                shape -> shape.draw(color)
        );
    }

}
