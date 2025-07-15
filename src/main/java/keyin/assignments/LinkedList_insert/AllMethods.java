package keyin.assignments.LinkedList_insert;

import java.util.LinkedList;

public class AllMethods {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedlist(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    LinkedList<String> lit = new LinkedList<>();

    //Insert Method
    public void insertLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        // Empty List
        if (head == null) {
            createSingleLinkedlist(nodeValue);
            return;
        }

    // Insert at beginning of list
        if (location == 0) {
            node.next = head;
            head = node;
        }

    // Insert at end of list
        if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        }

    // Insert in middle of list
        // Start at head
        Node tempNode = head;

        // traverse the list until you find the node just before target location
        // tempNode will now point to the node before where you want to insert
        int index = 0;
        while (index < location - 1) {
            tempNode = tempNode.next;
            index++;
        }

        // insert node
        Node nextNode = tempNode.next; //Save the original next of tempNode into nextNode
        tempNode.next = node; // Point tempNode.next to your new node
        node.next = nextNode; // Point your new node to nextNode

        // update size
        size++;
    }

    // Traversing through a linked list

    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    //Search for an element
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.print("Found the node at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("Node not found");
        return false;
    }

    //implement deleting a node from single linked list
    public void deleteLinkedList(int location) {

        // empty list (== no head)
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Invalid position (position doesn't exist)
        if (location < 0 || location >= size) {
            System.out.println("Invalid position: " + location);
        }

        // Delete at beginning (i.e., delete current head, make next node head)
        if (location == 0) {
            // update next node (after current head) to be the head
            head = head.next;

            // decrement the size
            size--;

            // If there are no more nodes, mark the tail as null
            if (size == 0) {
                tail = null;
            }
            return;
        }

        // Delete elsewhere: (whether it's in the middle or the tail, need to traverse the length of the link till we find the node)
        if (location == size - 1) {
            //Move tempNode to node before the one being deleted
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }

            // delete the node
            Node nodeToDelete = tempNode.next; // find where the node to delete points
            tempNode.next = nodeToDelete.next; // make the previous node (before the one to delete) point to the following node (afgter the one to delete)

            // if the deleted node was the tail, make the node before it the tail
            if (location == size - 1) {
                tail = tempNode;
            }

            // reduce size of list
            size--;
        }
    }

}

