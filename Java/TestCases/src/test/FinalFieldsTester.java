package test;

public class FinalFieldsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalFields sb = new FinalFields();
		System.out.println(sb.getSb());
		sb.run();
		System.out.println(sb.getSb());
		StringBuffer newSb = sb.getSb();
		System.out.println(newSb);
		newSb.append("adding This");
		System.out.println(newSb);
		newSb = new StringBuffer("gello");
		System.out.println(newSb);
		System.out.println(sb.getSb());

	}

}
