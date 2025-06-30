import java.util.ArrayList;
import java.util.Collections;

public class DentalClinic {
	ArrayList<Appointment> aL; // aL là danh sách lịch khám

	public DentalClinic() {
		this.aL = new ArrayList<>();
	}
	
	public ArrayList<Appointment> getaL() {
		return aL;
	}

	public void displayAppointment() {
		for(Appointment ap : aL) {
			System.out.println(ap.toString());
		}
	}

	public void addAppointment(Appointment a) {
		aL.add(a);
	}
	
	// public void sortStartingTime() {
	// 	Collections.sort(aL, new Comparator<Appointment>() {
	// 		@Override
	// 		public int compare(Appointment ap1, Appointment ap2) {
	// 			if(ap1.getStartingTime() > ap2.getStartingTime()) {
	// 				return 1;
	// 			} else {
	// 				if(ap1.getStartingTime() == ap2.getStartingTime()) {
	// 					return 0;
	// 				} else {
	// 					return -1;
	// 				}
	// 			}
	// 		}
	// 	});
	// }
	
	public void sortStartingTime(){
		Collections.sort(aL, (a1, a2) -> {
			try {
				java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
				java.util.Date d1 = df.parse(a1.getDate());
				java.util.Date d2 = df.parse(a2.getDate());
				int cmp = d1.compareTo(d2);
				if (cmp != 0) return cmp;
			} catch (Exception e) {

			}
			return Integer.compare(a1.getStartingTime(), a2.getStartingTime());
		});
	}
}
