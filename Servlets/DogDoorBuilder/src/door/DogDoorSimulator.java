package door;

import java.util.ArrayList;
import java.util.List;

public class DogDoorSimulator {
	
	public static void main(String[] args) {
		DogDoor door = new DogDoor();
		Remote remote = new Remote(door);
		BarkRecognizer recog = new BarkRecognizer(door);
		List<Bark> bruceBarks = new ArrayList<Bark>();
		bruceBarks.add(new Bark("woof"));
		bruceBarks.add(new Bark("bark"));
		
		
		door.setAllowedBark(bruceBarks);
		System.out.println("Fido barks to go outside...");
		door.setCloseTime(5000);
		recog.recognize(new Bark("woof"));
		System.out.println("\nFido has gone outside...");
		
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("\nFido's all done...");
		System.out.println("Fido barks to go inside...");
		//other dog barking
		recog.recognize(new Bark("yip"));
		//bruce barking
		recog.recognize(new Bark("bark"));
		System.out.println("\nFido's back inside...");
		
	}
	
}
