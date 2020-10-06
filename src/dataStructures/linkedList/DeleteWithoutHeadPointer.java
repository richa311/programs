package dataStructures.linkedList;
/* @author Richa Rochna */

import java.util.LinkedList;

public class DeleteWithoutHeadPointer {

    public static void main(String[] args) {
        int N = 2;
        int node = 1;
        LinkedList linkedList = new LinkedList();
        linkedList.push(3);
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(5);

        int i = linkedList.indexOf(node);
        linkedList.remove(i);

        System.out.println(linkedList);
    }

    void deleteNode(SinglyLinkedList.Node node)
    {
        SinglyLinkedList.Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
        temp = null;

    }
}
