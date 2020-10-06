package dataStructures.linkedList;
/* @author Richa Rochna */

import java.util.*;

public class CountPairsSumValue {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x){
        int count = 0;
        Iterator<Integer> itr1 = head1.iterator();
        while(itr1.hasNext()){
            Iterator<Integer> itr2 = head2.iterator();
            Integer t = itr1.next();
            while(itr2.hasNext()){
                if( t + itr2.next() == x){
                    count ++;
                }
            }
        }
        return count;
    }

    public static int countPairs1(LinkedList<Integer> head1, LinkedList<Integer> head2,
                                 int x) {
        int count = 0;
        Set<Integer> set1 = new HashSet<>();
        Iterator<Integer> itr1 = head1.iterator();
        while(itr1.hasNext()){
            set1.add(itr1.next());
        }

        Iterator<Integer> itr2 = head2.iterator();

        while(itr2.hasNext()){
            Integer t = itr2.next();
            Integer diff = x-t;
            if(set1.contains(diff)){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Integer arr1[] = {3, 1, 5, 7};
        Integer arr2[] = {8, 2, 5, 3};

        LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));
        LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));

        int x = 10;
        System.out.println("Count = " + countPairs(head1, head2, x));
    }

}
