package datastructures.array;

public class Array {

    // There is no Array class only Foo[].class or int[].class which is created by the JVM at runtime. These classes are subclasses of Object.
    // ==> Array does not have constructor ==> When creating we have to specify either its size, or the elements themselves it will hold.
    // An object is a class instance or an array.
    /* An array is a contiguous sequence of addresses in memory. ==> Indexed ==>
    Accessing an element:
    int[] anArray = new {1,2,3};
    anArray[1] O(1) READ/FIND per index
    anArray[1] = 2 O(1) WRITE per index
    Also read operations are supported by caching ==> Neighbouring addresses are copied to cache when accessing an object in memory ==> When accessing an array
    possibly the whole array is copied to cache. (faster accessible disk)

    LinkedList/Queue/Stack:
    A ccess => O(n)
    S earch => O(n)
    I nsertion => O(1)
    D elete => O(1)

    Array/ArrayList:
    A ccess => O(1)
    S earch => O(n) (contains())
    I nsertion => O(1) BUT O(n) beyond its size because all the elements have to be copied over
    D elete => O(1) BUT O(n) delete + decrease its size because all the elements have to be copied over

    */
    private final int length;

    public Array(int length) {
        this.length = length;
    }

    /* there are no methods in array!! When you want to add an element beyond its size or delete an element and also decrease its size,
    you have to create a new array and copy all elements into the new array. A deleting method would look like this: */

    public int[] delete(int[] originalArray, int position) {

        int[] newArray = new int[originalArray.length - 1];
        /*Azzal, hogy a position van megadva arra a paraméterre, hogy hány db elem másolódjon, pont kihagyásra kerül a törlendõ elem, mert a db szám így eggyel kisebb lesz,
        mivel ugye 0-val kezdõdik a position, szóval a 6 positionon lévõ elem a 7., de így csak 6-ot másolunk át és a 7.-et, azaz a törlendõ elemet nem.
         */
        System.arraycopy(originalArray, 0, newArray, 0, position);
        System.arraycopy(originalArray, position + 1, newArray, position, originalArray.length - position - 1);

        return newArray;

    }

    public int[] add(int[]originalArray, int newElement, int position){

        int[]newArray = new int [originalArray.length+1];

        System.arraycopy(originalArray, 0, newArray, 0, position);
        newArray[position] = newElement;
        System.arraycopy(originalArray, position, newArray, position+1, originalArray.length-position);

        return newArray;
    }

    /*
    Contains operation is O(N) as this cannot benefit from the indexes, we have to loop through the whole array calling equals on each element. 
     */


}

