package structural.composite_everyobjectimplementsthesameinterface;

public class Palette {

    public static void main (String[]args){

        Artist artist = new Artist();

        artist.addShape(new Rectangle());
        artist.addShape(new Triangle());
        artist.addShape(new Circle());

        artist.draw("red");
    }

}
