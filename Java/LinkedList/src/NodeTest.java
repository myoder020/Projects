/**
 * Created by Yoder on 5/28/2015.
 */
public class NodeTest {

    public static void main(String[] args) {

        Node myNode = new Node(new Person("Matt"));
        Node nextNode = new Node(new Person("Stef"));
        Node head = null;
        int[] num = new int[20];

        System.out.println(myNode.getPerson().getName());

        myNode.setNext(nextNode);
        System.out.println(myNode.getNext().getPerson().getName());
    }
}
