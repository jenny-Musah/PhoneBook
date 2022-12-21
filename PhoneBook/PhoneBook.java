package CompletedAssignment.PhoneBook;

public class PhoneBook {
    Contact [] contacts = new Contact[10];
    int counter = 0;
    public void addContact(Contact contact){
        contacts[counter] = contact;
        counter++;
    }
    public String Search(String name)throws NullPointerException{
        for (Contact contact : contacts) {
            if (contact.name().equals(name)) {
                return String.valueOf(contact);
            }
        }
        return "Contact Not found";
    }
    public void display(){
        for (Contact contact : contacts) {
            if (contact != null) {

                System.out.println(contact);
            }
        }
    }

    public void delete(String name) {
        for (int i = 0; i < contacts.length; i++) {
            if(contacts[i] != null) {
                if(contacts[i].name().equals(name)) {
                    contacts[i] = null;
                    System.out.println("Contact deleted...");
                }
            }else
                continue;
        }
    }
}

