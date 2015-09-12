/**
 * Created by Yoder on 5/28/2015.
 */
public class Node {

    private Person person;
    private Node next;
    private int data;

    public Node() {

    }

    public Node(Person person) {
        this.person = person;
    }

    public void setNext(Node node) {
        next = node;
    }

    public Node getNext() {
        return next;
    }

    public Person getPerson() {
        return person;
    }

    public static Node Insert(Node head, int data) {
        Node tail = new Node();
        if(head == null) {
            head = new Node();
            head.data = data;
        } else {
            Node current = head;
            while(current.next != null)
                current = current.next;
            current.next = new Node();
            current.next.data = data;
        }

        return head;
    }

    public int getData() {
        return data;
    }

    public void deleteFirst() {

    }

    public Node InsertNth(Node head, int data, int position) {
        int count = 0;
        if(head == null) {
            head = new Node();
            head.data = data;
        } else if(position == 0){
            Node newHead = new Node();
            newHead.data = data;
            newHead.next = head;
            head = newHead;
        } else {
            Node current = head;
            Node prev = null;
            while(count < position && current != null) {
                prev = current;
                current = current.next;
                count++;
            }
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = current;
            prev.next = newNode;
        }

        return head;
    }
}
