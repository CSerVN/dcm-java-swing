
public class Main {
	public static void main(String[] args) {
		DentalClinic dC = new DentalClinic(); 
		
		Appointment a1 = new Appointment(new Customer(101, "HuynhVan A", "038310369", "Khanh Hai"), "13/03/2025", 9, "Kham Than");
		Appointment a2 = new Appointment(new Customer(102, "Nguyen Khanh", "033933133", "Tokyo"), "13/03/2025", 10, "Kham Rang");
		Appointment a3 = new Appointment(new Customer(103, "Nguyen Thi No", "0919912311", "New York"), "14/03/2025", 11, "Kham Hong");
		Appointment a4 = new Appointment(new Customer(104, "Banh Thi Cun", "088188322", "Columbia"), "14/03/2025", 11, "Kham Tam Ly");
		Appointment a5 = new Appointment(new Customer(105, "Nguyen Quoc Khanh", "083107369", "Na Uy"), "14/03/2025", 15, "Kham Tim");
		
		dC.addAppointment(a1);
		dC.addAppointment(a2);
		dC.addAppointment(a3);
		dC.addAppointment(a4);
		dC.addAppointment(a5);
		
		dC.displayAppointment();
	}
}
