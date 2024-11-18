import javax.swing.*;

class PersonInfo {
    private String name;
    private String address;
    private String phoneNum;

    public PersonInfo(String name, String address, String phoneNum) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getInfo() {
        return "Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNum;
    }

    public void print() {
        JOptionPane.showMessageDialog(null, 
            "Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNum);
    }
}
