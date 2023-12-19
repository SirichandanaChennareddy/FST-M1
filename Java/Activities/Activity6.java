package JavaActivities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
	private final List<String> Passengers;
	private int maxPassengers;
	private Date LastTimeTakeOff;
	private Date LastTimeLanded;

	public Plane(int maxPassengers) {
	        this.maxPassengers = maxPassengers;
	        this.Passengers = new ArrayList<>();
	    }

	public void onboard(String Passenger) {
		this.Passengers.add(Passenger);
	}

	public Date takeOff() {
		this.LastTimeTakeOff = new Date();
		return LastTimeTakeOff;
	}

	public void land() {
		this.LastTimeLanded = new Date();
		this.Passengers.clear();

	}

	public Date getLastTimeLanded() {
		return LastTimeLanded;
	}

	public List<String> getPassesngers() {
		return Passengers;
	}
}

public class Activity6 {
	public static void main(String[] args) throws InterruptedException {
		Plane plane = new Plane(10);
		
		plane.onboard("Krishna");
		plane.onboard("Chaitanya");
		plane.onboard("Rishyank");
		
		System.out.println("The take off time is :" + plane.takeOff());
		System.out.println("List of people on the plane : " + plane.getPassesngers());
		
		Thread.sleep(5000);
		plane.land();
		
		System.out.println("The landing time is : " + plane.getLastTimeLanded());
		System.out.println("List of people on the plane after landing : " + plane.getPassesngers());
	}
}
