package dataStructures.array;
/* @author Richa Rochna */

import java.util.ArrayList;
import java.util.List;

public class UncommonElement {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        System.out.println(getUnCommonElements(list1, list2));
    }

    private static int getUnCommonElements(List<Integer> list1, List<Integer> list2) {
        List<Integer> list3 = new ArrayList<>();
        list1.forEach(element -> {
            if(!list2.contains(element)){
                list3.add(element);
            }
        });
        return list3.size();
    }

}
