package dataStructures.linkedList;
/* @author Richa Rochna */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static dataStructures.linkedList.SinglyLinkedList.head;
import static dataStructures.linkedList.SinglyLinkedList.printList;

public class SegregateEvenOddNodes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList ll;
        int t = scanner.nextInt();
        List<SinglyLinkedList> lists = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            ll = new SinglyLinkedList();
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                int num = scanner.nextInt();
                ll.push(num);
            }
            lists.add(ll);
            System.out.println("Original Linked List");
            printList();
        }
        lists.forEach(list -> {
            segregateEvenOdd();
            System.out.println("Modified Linked List");
            printList();
        });
    }

    private static void segregateEvenOddNodes() {

        SinglyLinkedList.Node end = head;
        SinglyLinkedList.Node prev = null;
        SinglyLinkedList.Node curr = head;

        /* Get pointer to last Node */
        while (end.next != null)
            end = end.next;

        SinglyLinkedList.Node new_end = end;

        // Consider all odd nodes before getting first eve node
        while (curr.data % 2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        // do following steps only if there is an even node
        if (curr.data % 2 == 0) {
            head = curr;

            // now curr points to first even node
            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    /* Break the link between prev and curr*/
                    prev.next = curr.next;

                    /* Make next of curr as null */
                    curr.next = null;

                    /*Move curr to end */
                    new_end.next = curr;

                    /*Make curr as new end of list */
                    new_end = curr;

                    /*Update curr pointer */
                    curr = prev.next;
                }
            }
        }
        /* We have to set prev before executing rest of this code */
        else prev = curr;

        if (new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }

    public static void segregateEvenOdd() {

        SinglyLinkedList.Node evenStart = null;
        SinglyLinkedList.Node evenEnd = null;
        SinglyLinkedList.Node oddStart = null;
        SinglyLinkedList.Node oddEnd = null;
        SinglyLinkedList.Node currentNode = head;

        while(currentNode != null) {
            int element = currentNode.data;

            if(element % 2 == 0) {

                if(evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }

            } else {

                if(oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
            // Move head pointer one step in forward direction
            currentNode = currentNode.next;
        }
        if(oddStart == null || evenStart == null) {
            return;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;
        head=evenStart;
    }
}
