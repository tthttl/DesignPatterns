package homework.passbyvalue;

public class ObjectSwap {

    //PASS BY VALUE - BOTH PRIMITIVES AND OBJECT REFERENCES!!

    public void tricky(Point arg1, Point arg2) {
        arg1.x = 100;
        arg1.y = 100;
// The method successfully alters the value of pnt1.
// In the main() method, pnt1 and pnt2 are nothing more than object references. When you pass pnt1 and pnt2 to the tricky() method,
// Java passes the references by value just like any other parameter. This means the references passed to the method are actually copies of the original references.
// Java copies and passes the reference by value, not the object. Thus, method manipulation will alter the objects, since the references point to the original objects.

        Point temp = arg1;
        arg1 = arg2;
        arg2 = temp;

// But since the references are copies, swaps will fail. The method references swap, but not the original references. The original reference point to their original objects.

    }

    public static void main(String[] args) {
        Point pnt1 = new Point(0, 0);
        Point pnt2 = new Point(0, 0);
        ObjectSwap objectSwap = new ObjectSwap();
        System.out.println("P1X: " + pnt1.x + " P1Y: " + pnt1.y);
        System.out.println("P2X: " + pnt2.x + " P2Y: " + pnt2.y);
        System.out.println(" ");
        objectSwap.tricky(pnt1, pnt2);
        System.out.println("P1X: " + pnt1.x + " P1Y:" + pnt1.y);
        System.out.println("P2X: " + pnt2.x + " P2Y: " + pnt2.y);
    }


}
