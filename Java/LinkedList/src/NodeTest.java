/**
 * Created by Yoder on 5/28/2015.
 */
public class NodeTest {

    public static void main(String[] args) {

        Node myNode = new Node(new Person("Matt"));
        Node nextNode = new Node(new Person("Stef"));
        Node head = null;
        int[] num = new int[20];

        /*
        myNode.setNext(nextNode);

        Node current;

        current = myNode;

        Person temp;

        while(current != null) {
            temp = current.getPerson();
            System.out.println(temp.getName());
            current = current.getNext();
        }

        head = Node.Insert(head, 5);
        for(int i=0; i < 20; i++) {
            Node.Insert(head, i);
        }


        Node current = head;
        while(current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
*/
        String s1 = "Java";
        String s2 = "Java";
        String s3 = "java";
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Ja").append("va");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(sb1.toString() == s1);
        System.out.println(sb1.toString().equals(s1));
        System.out.println(s1.toLowerCase() == s3.toLowerCase());
        System.out.println(s1.toLowerCase().equals(s3.toLowerCase()));
    }
}
