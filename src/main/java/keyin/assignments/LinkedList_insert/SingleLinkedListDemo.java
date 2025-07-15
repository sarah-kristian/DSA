package keyin.assignments.LinkedList_insert;


public class SingleLinkedListDemo {
    public static void main(String[] args) {
        AllMethods sll = new AllMethods();
        sll.traverseLinkedList();
        sll.insertLinkedList(1,0);
        sll.insertLinkedList(2,1);
        sll.insertLinkedList(3,2);
        sll.insertLinkedList(4,3);
        sll.traverseLinkedList();
        sll.searchNode(4);

    }
}
