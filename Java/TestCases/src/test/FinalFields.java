package test;

public class FinalFields {
	
	private final StringBuffer sb;
	
	public FinalFields() {
		sb = new StringBuffer("Hello World");
	}
	
	public void run() {
		sb.append("!!!");
	}
	
	public StringBuffer getSb() {
		return sb;
	}
}
