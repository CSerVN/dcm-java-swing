import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DCM extends JFrame{
	DentalClinic dC = new DentalClinic();
	private static final long serialVersionUID = 1L;
	private final String[] dsKhachHang = new String[] {"1-Trần Nguyễn Mai Anh", "2-Nguyễn Hoài Nam", 
			"3-Đặng Thương Tín", "4-Đỗ Thị Hải Yến", "5-Lý Thị Thu Thảo", "6-Trần Thị Thanh Nga"};
	private final JComboBox<String> khachHang;
	private final JTextField ngay, gioBatDau, ghiChu;
	private final JLabel lKhachHang, lNgay, lGioBatDau, lGhiChu;
	private final JPanel jP1, jP2;
	private final JScrollPane jSP;
	private final JButton btn1, btn2;
	private final DefaultTableModel model;
	private final JTable jT;
	public DCM(){
		setTitle("Dental Clinic Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setLocationRelativeTo(null);
		lKhachHang = new JLabel(" Khách hàng:");
		khachHang = new JComboBox<>(dsKhachHang);

		lNgay = new JLabel(" Ngày:");
		ngay = new JTextField();

		lGioBatDau = new JLabel(" Giờ bắt đầu:");
		gioBatDau = new JTextField();

		lGhiChu = new JLabel(" Ghi chú:");
		ghiChu = new JTextField();
		
		jP1 = new JPanel(new GridLayout(4, 2));
		jP1.add(lKhachHang);
		jP1.add(khachHang);
		jP1.add(lNgay);
		jP1.add(ngay);
		jP1.add(lGioBatDau);
		jP1.add(gioBatDau);
		jP1.add(lGhiChu);
		jP1.add(ghiChu);
		add(jP1, BorderLayout.NORTH);
		
		jP2 = new JPanel(new FlowLayout());
		btn1 = new JButton("Thêm");
		btn2 = new JButton("Sắp Xếp");
		jP2.add(btn1);
		jP2.add(btn2);
		add(jP2, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("Họ tên");
		model.addColumn("Ngày");
		model.addColumn("TGBĐ");
		model.addColumn("Ghi chú");
		jT = new JTable(model);
		jSP = new JScrollPane(jT);
		
		add(jSP, BorderLayout.SOUTH);
		
                btn1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String selected = (String) khachHang.getSelectedItem();
                                // Tách ID và tên
                                String[] parts = selected.split("-", 2);
                                int id = Integer.parseInt(parts[0]);
                                String fullName = parts[1].trim();

                                String lNgay = ngay.getText();
                                int lGioBatDau;
                                try {
                                        lGioBatDau = Integer.parseInt(gioBatDau.getText());
                                } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(DCM.this,
                                                        "Giờ bắt đầu không hợp lệ", "Lỗi nhập liệu",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                                String lGhiChu = ghiChu.getText();

                                // Tạo Customer chỉ với tên
                                Customer customer = new Customer(id, fullName);
                                dC.addAppointment(new Appointment(customer, lNgay, lGioBatDau, lGhiChu));
                                model.setRowCount(0);
                                int stt = 1;
                                for(Appointment aP : dC.getaL()) {
                                        model.addRow(new Object[] {
                                                stt++,
                                                aP.getCustomer().getName(),
                                                aP.getDate(),
                                                aP.getStartingTime(),
                                                aP.getNote()
                                        });
                                }
                        }
                });
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dC.sortStartingTime();
				model.setRowCount(0);
				int stt = 1;
				for(Appointment aP : dC.getaL()) {
					model.addRow(new Object[] {stt++, aP.getCustomer().getName(), aP.getDate(), aP.getStartingTime(), aP.getNote()});
				}
				
			}
		});
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	        try {
	            new DCM();
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, 
	                "Lỗi khởi tạo ứng dụng: " + e.getMessage(),
	                "Lỗi",
	                JOptionPane.ERROR_MESSAGE);
	        }
	    });
	}
}
