package node;

public class SingleLinkTester {

	public static void main(String[] args) {
		SingleLink node = new SingleLink("woot");
		
		SingleLink newNode = new SingleLink("new node", node);
		
		SingleLink myNode = new SingleLink("newest node", newNode);
		
		SingleLink curr = myNode;
		while(curr != null) {
			System.out.println(curr.getText());
			curr = curr.getNext();
		}

	}

}
