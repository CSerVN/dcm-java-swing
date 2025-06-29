
public class Appointment {
	private Customer customer;
	private String date;
	private int startingTime;
	private String note;
	public Appointment(Customer customer, String date, int startingTime, String note) {
		this.customer = customer;
		this.date = date;
		this.startingTime = startingTime;
		this.note = note;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public String getDate() {
		return date;
	}

	public int getStartingTime() {
		return startingTime;
	}

	public String getNote() {
		return note;
	}

	@Override
	public String toString() {
		return customer + "\ndate: " + date + "\nstartingTime: " + startingTime + "\nnote: "
				+ note + "\n";
	}
}
