package dataStructures.linkedList;

/* @author Richa Rochna */

public class DeleteNode extends SinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.push(7);
        linkedList.push(1);
        linkedList.push(3);
        linkedList.push(2);

        System.out.println("Created Linked list is:");
        printList();

        deleteNode(1); // Delete node with data 1

        System.out.println("Linked List after Deletion of 1:");
        printList();
    }

    /* Given a key, deletes the first occurrence of key in linked list */
    static void deleteNode(int key) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next;
    }
}
