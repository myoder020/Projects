package node;

public class DoublyLinkTester {

	public static void main(String[] args) {
		DoublyLink node = new DoublyLink("woot");
		
		DoublyLink newNode = new DoublyLink("new node", node);
		
		DoublyLink myNode = new DoublyLink("newest node", newNode);
		
		DoublyLink curr = myNode;
		while(curr != null) {
			System.out.println(curr.getText());
			curr = curr.getNext();
		}

	}

}
