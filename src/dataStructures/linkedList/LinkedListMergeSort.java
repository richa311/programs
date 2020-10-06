package dataStructures.linkedList;
/* @author Richa Rochna */

public class LinkedListMergeSort {

    public static void main(String[] args) {
        SinglyLinkedList li = new SinglyLinkedList();
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);

        // Apply merge Sort
        li.head = mergeSort(li.head);
        System.out.print(" Sorted Linked List is: ");
        li.printList();
    }

    public static SinglyLinkedList.Node mergeSort(SinglyLinkedList.Node h) {
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the list
        SinglyLinkedList.Node middle = getMiddle(h);
        SinglyLinkedList.Node nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        SinglyLinkedList.Node left = mergeSort(h);

        // Apply mergeSort on right list
        SinglyLinkedList.Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        SinglyLinkedList.Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    public static SinglyLinkedList.Node sortedMerge(SinglyLinkedList.Node a, SinglyLinkedList.Node b) {
        SinglyLinkedList.Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public static SinglyLinkedList.Node getMiddle(SinglyLinkedList.Node head) {
        if (head == null)
            return head;
        SinglyLinkedList.Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
