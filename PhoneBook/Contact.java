package CompletedAssignment.PhoneBook;

public class Contact {

    private  String email;
    private  String address;
    private  String phoneNumber;
    private  String name;

    public Contact(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public String name() {
        return name;
    }

    public void edit (String name) {
        this.name = name;
    }

    private String phoneNumber() {
        return phoneNumber;
    }

    public void edit( String name, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    private String address() {
        return address;
    }

    public void edit (String name, String phoneNumber, String address,String email) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
        this.email = email;

    }
    private String email() {
        return email;
    }
    @Override
    public String toString(){
        return String.format("Name:%s%nPhoneNumber:%s%nAddress:%s%nEmail:%s%n",name(),phoneNumber(),address(),email());
    }
}

