public class Customer {
    private int id;
    private String name;
    private String phone;
    private String address;
    
    public Customer(int id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    
    // Tạo thêm constructor chỉ có id và fullName cho GUI
    public Customer(int id, String name) {
        this(id, name, "", "");
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return id + "-" + name + ", SĐT: " + phone + ", Địa chỉ: " + address;
    }
}
