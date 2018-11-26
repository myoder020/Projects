package node;

public class DoublyLink {

	private DoublyLink next, prev;
	private String text;

	public DoublyLink(String text) {
		this(text, null);
		prev = null;
	}

	public DoublyLink(String text, DoublyLink node) {
		this.text = text;
		next = node;
		
	}

	public String getText() {
		return text;
	}

	public DoublyLink getNext() {
		return next;
	}

	public boolean hasNext() {
		if (next == null)
			return false;

		return true;
	}

	public DoublyLink getPrev() {
		return prev;
	}

	public boolean hasPrev() {
		if (prev == null)
			return false;

		return true;
	}

	public void setPrev(DoublyLink node) {
		prev = node;
	}
}