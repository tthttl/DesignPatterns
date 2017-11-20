//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//public class Train {
//    private Map<Integer, Integer> wagons;
//
//    public Train(int wagonCount, Function<Integer, Integer> fillWagon) {
//        this.wagons = new HashMap<>(100000,0.9F);
//
//        for (int i = 0; i < wagonCount; i++) {
//            this.wagons.put(i, fillWagon.apply(i));
//        }
//    }
//
//    public int peekWagon(int wagonIndex) {
//        return this.wagons.get(wagonIndex);
//    }
//
//    public static void main(String[] args) {
//        Train train = new Train(10, wagonIndex -> wagonIndex);
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Wagon: " + i + ", cargo: " + train.peekWagon(i));
//        }
//    }
//}