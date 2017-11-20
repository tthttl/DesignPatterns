package practice;

import java.util.HashSet;
import java.util.Set;

public class ArrayDuplicates {

    public static void main(String[] args) {



    }


    public static int solution(int[]A){
        Set<Integer> set = new HashSet<>();
        for(int element:A){
            boolean isAddSuccessful = set.add(element);
            if(!isAddSuccessful){
                set.remove(element);
            }
        }
        return set.iterator().next();
    }


}
