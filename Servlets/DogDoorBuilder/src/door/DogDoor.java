package door;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
	
	private boolean open;
	private int close;
	private List<Bark> allowedBark;
	
	public DogDoor() {
		this.open = false;
		close = 5000;
	}
	
	public void open() {
		System.out.println("The dog door opens.");
		open = true;
		
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				close();
				timer.cancel();
			}
		}, close);
	}
	
	public void close() {
		System.out.println("The dog door closes.");
		open = false;
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public void setCloseTime(int close) {
		this.close = close;
	}
	
	public void setAllowedBark(List<Bark> bark) {
		this.allowedBark = bark;
	}
	
	public List<Bark> getAllowedBark() {
		return allowedBark;
	}
	
}
