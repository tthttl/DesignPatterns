package practice;

import java.util.*;

public class MovingTotal {

    private List<Integer> numList;
    private Set<Integer> totals;

    public MovingTotal() {
        this.numList = new ArrayList<>();
        this.totals = new HashSet<>();
    }

    public void append(int[] list) {

        int total = 0;

        for (int i : list) {
            numList.add(i);
        }
        for(int i=numList.size()-1; i>=numList.size()-3; i--){
            total =+ numList.get(i);
        }

        totals.add(total);

    }

    public boolean contains(int total) {

        return totals.contains(total);

    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[]{1, 2, 3});

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));

        movingTotal.append(new int[]{4});

        System.out.println(movingTotal.contains(9));
    }
}