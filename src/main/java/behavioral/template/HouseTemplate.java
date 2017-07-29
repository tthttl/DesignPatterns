package behavioral.template;

public abstract class HouseTemplate {

//    template method should not be possible to be override from child, because  the sequence of the method calls should be fix
//    some of the methods might be implemented in child classes
    public final void  buildHouse(){
        buildFoundation();
        buildWalls();
        buildWindows();
        buildRoof();
    }

    private void buildFoundation(){
        System.out.println("Foundation is built");
    }

    private void buildWalls(){
        System.out.println("Walls are up!");
    }

//    these method could also have default implementation and children could be allowed to override them
    protected abstract void buildWindows();
    protected abstract void buildRoof();


}
