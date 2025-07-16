package keyin.assignments.LinkedList_insert;

public class InsertMethod {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedList(int nodeValue){
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertNode(int nodeValue, int location) {
        Node node = new Node(nodeValue);

        if (head == null){
            createSingleLinkedList(nodeValue);
            return;
        }
        if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size){
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

}
