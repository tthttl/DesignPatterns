package practice;

import java.util.Arrays;

public class ArrayRotation {


    public static void main(String[] args) {

        Arrays.stream(solution(new int[]{1, 2, 3, 4, 5}, 3)).forEach(System.out::print);

    }

    public static int[] solution(int[] A, int K) {
        if (A.length == 0){
            return A;
        }
        int [] result = A;
        for (int i=0; i<K; i++){
            result = rotate(result);
        }
        return result;
    }

    public static int[] rotate(int[] input) {
        int[] result = new int[input.length];
        System.arraycopy(input, 0, result, 1, input.length - 1);
        result[0] = input[input.length - 1];
        return result;
    }


}
