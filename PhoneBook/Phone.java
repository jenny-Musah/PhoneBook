package CompletedAssignment.PhoneBook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Phone {
    private static PhoneBook phoneBook = new PhoneBook();
    public static Scanner input = new Scanner(System.in);
    public static int dail;

    public static void main(String[] args) {
        try {
            display1();
        }catch (InputMismatchException e){
            System.out.println("Enter numbers only!");
        }
    }
    public static void display1(){
        System.out.println("PHONE");
        System.out.printf("*Speed dail%n*Enter \"1\" to view contacts%n*Enter \"2\" to add contacts" +
                "%n*Enter \"3\" to search contacts%n*Enter \"4\" to delete contact%n*Enter \"0\" to EXIT%n");
        dail = input.nextInt();
        methodCall(dail);
    }
    public static void methodCall(int number){
        switch (number) {
            case 1 : phoneBook.display();
            returnTo();
                break;
            case 2 : input();
                break;
            case 3 : String name;
                System.out.println("Enter name:");
                name = input.next();try {
                System.out.println(phoneBook.Search(name));
                returnTo();
            }catch (NullPointerException e){
                System.out.println("Search not found!");
            }
                break;
            case 4:
                String name2;
                System.out.println("Enter contact name to delete:");
                name = input.next();
                phoneBook.delete(name);returnTo();
            case 5:
                back();
                break;
            default:
                System.out.println("You are a FOOL!!!!");
        }
    }
    private static void input() {
        String name = inputName();
        String number = inputPhoneNumber();
        String email = inputEmail();
        String address = inputAddress();
        System.out.println("Contact added!");
        contact(name,address,number,email);
    }
    private static String inputName() {
        input.nextLine();
        String name;
        System.out.println("Enter name:");
        name = input.nextLine();
        return name;
    }
    public static String inputPhoneNumber() {
        String phoneNumber;
        String correctNumber;
        System.out.println("Enter phoneNumber:");
        phoneNumber = input.nextLine();
        if(phoneNumber.matches("\\d{11}")) return phoneNumber;
        else {
            System.out.println("Enter number in this format: 08188845181");
            inputPhoneNumber();
        }
        return null;
    }
    public static String inputAddress() {
        String address;
        System.out.println("Enter address:");
        address = input.nextLine();
        return address;
    }
    public static String inputEmail() {
        String email;
        System.out.println("Enter email:");
        email = input.nextLine();
        if (email.matches("[a-z]{5,}\\d*@gmail.com")){
            return email;
    }else if (email.equals("")) {
         return null;
        } else{
            System.out.println("Enter mail in this format: abcde@gmail.com");
            inputEmail();
        }
        return null;
    }
    private static  void contact(String name, String address, String phoneNumber, String email){
        Contact contact = new Contact(name, address, phoneNumber, email);
        add(contact);
    }
    private static void add(Contact contact){
        int enter;
        phoneBook.addContact(contact);
        System.out.println("Enter \"2\" to add another contact or \"5\" to view menu");
        enter = input.nextInt();
        methodCall(enter);
    }
    public static void back(){
        System.out.printf("*Enter \"1\" to view contacts%n*Enter \"2\" to add contacts" +
                "%n*Enter \"3\" to search contacts%n*Enter \"4\" to delete contact%n" +
                "*Enter \"5\" to view menu%n*Enter \"0\" to EXIT%n");
        dail = input.nextInt();
        methodCall(dail);
    }
    private static void returnTo(){
        int enter;
        System.out.println("Enter \"0\" to EXIT or \"5\" to view menu");
        enter = input.nextInt();
        methodCall(enter);
    }
}
