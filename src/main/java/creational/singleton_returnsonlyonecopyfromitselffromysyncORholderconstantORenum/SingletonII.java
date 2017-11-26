package creational.singleton_returnsonlyonecopyfromitselffromysyncORholderconstantORenum;

public class SingletonII {

   private SingletonII (){

   }

   public static SingletonII getInstance (){
       return SingletonHolder.INSTANCE;
   }

   private static class SingletonHolder {
       private static final SingletonII INSTANCE = new SingletonII();
   }

}
