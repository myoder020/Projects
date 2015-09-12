package node;

public class SingleLink {
	
	private SingleLink next;
	private String text;
	
	public SingleLink(String text) {
		this(text, null);
	}
	
	public SingleLink(String text, SingleLink node) {
		this.text = text;
		next = node;
	}
	
	public String getText() {
		return text;
	}
	
	public SingleLink getNext() {
		return next;
	}
	
	public boolean hasNext() {
		if(next == null)
			return false;
		
		return true;
	}
}
