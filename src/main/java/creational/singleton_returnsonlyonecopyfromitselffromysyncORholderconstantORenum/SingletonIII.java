package creational.singleton_returnsonlyonecopyfromitselffromysyncORholderconstantORenum;

enum SingletonIII {

    INSTANCE ("name", 2);

    private String name;
    private int size;

    SingletonIII(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


