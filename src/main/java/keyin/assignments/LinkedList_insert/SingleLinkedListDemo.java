package keyin.assignments.LinkedList_insert;


public class SingleLinkedListDemo {
    public static void main(String[] args) {
        AllMethods sll = new AllMethods();
        sll.traverseLinkedList();
        sll.insertNode(1,0);
        sll.insertNode(2,1);
        sll.insertNode(3,2);
        sll.insertNode(4,3);
        sll.traverseLinkedList();
        sll.searchNode(4);

    }
}
