package practice;

import java.util.ArrayList;
import java.util.function.Function;

public class Train {
    private ArrayList<Integer> wagons;

    public Train(int wagonCount, Function<Integer, Integer> fillWagon) {
        this.wagons = new ArrayList<>(Integer.MAX_VALUE);

        for (int i = 0; i < wagonCount; i++) {
            this.wagons.add(i, fillWagon.apply(i));
        }
    }

    public int peekWagon(int wagonIndex) {
        return this.wagons.get(wagonIndex);
    }

    public static void main(String[] args) {
        Train train = new Train(10, wagonIndex -> wagonIndex);

        for (int i = 0; i < 10; i++) {
            System.out.println("Wagon: " + i + ", cargo: " + train.peekWagon(i));
        }
    }
}
