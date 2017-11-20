package practice;

public class Binary {

    public static void main(String[] args) {

        System.out.println(solve(529));
        System.out.println(Integer.toBinaryString(529));

    }

    public static int solve(int input){

        String binary = Integer.toBinaryString(input);
        String[] zeros = binary.split("1");
        if (binary.charAt(binary.length()-1) == '1'){
            return countZeros(zeros, true);
        }
        return countZeros(zeros, false);

    }

    private static int countZeros(String[] zeros, boolean shouldCountLast){
        int maxSize = 0;
        for(int i = 0; shouldCountLast ? i<zeros.length : i<zeros.length-1; i++){
            if (zeros[i].length()>maxSize){
                maxSize = zeros[i].length();
            }
        }
        return maxSize;
    }


}
