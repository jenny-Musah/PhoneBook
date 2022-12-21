package CompletedTest.Phonebooktest;

import CompletedAssignment.PhoneBook.Contact;
import CompletedAssignment.PhoneBook.PhoneBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {
    PhoneBook phone;
    Contact contact;
    @BeforeEach
    public void setUP(){
        contact = new Contact("Jennifer","14, onikoyi street","09090997878","Jennymusah99@gmail.com");
        phone = new PhoneBook();
    }
    @Test
    public void testThatICanCreatAnotherContactAndAddToPhoneBook(){
        Contact contact1 = new Contact("Yung","5, funh china road","8948483930","yung@gmail.com");
        phone.addContact(contact1);
        assertEquals(String.valueOf(contact1), phone.Search("Yung"));
    }
    @Test
    public void testToEditName(){
        System.out.println("Before editing");
        assertEquals(String.valueOf(contact), phone.Search("Jennifer"));
        System.out.println(contact);
        contact.edit("Mercy");
        assertEquals(String.valueOf(contact), phone.Search("Mercy"));
    }
    @Test
    public void testToEditNameAndNumber(){
        phone.addContact(contact);
        assertEquals(String.valueOf(contact), phone.Search("Jennifer"));
        contact.edit("Jennifer", "08188845181");
        assertEquals(String.valueOf(contact), phone.Search("Jennifer"));
    }
    @Test
    public void editAllContactsInfo() {
        phone.addContact(contact);
        System.out.println(contact);
        contact.edit("o.smith", "08188845181","3, Omololu road","o.smith@gmail.com");
        System.out.println("After editing");
        assertEquals(String.valueOf(contact), phone.Search("o.smith"));
        System.out.println(contact);
    }
    @Test
    public void testThatICanAddMultipleObjectAndGetThem(){
        phone.addContact(contact);
        assertEquals(String.valueOf(contact), phone.Search("Jennifer"));
        Contact contact2 = new Contact("fuu","1,yanku china","0998756789","fuuChiyang@gmail.com");
        phone.addContact(contact2);
        assertEquals(String.valueOf(contact), phone.Search("fuu"));
    }
    @Test
    public void testThaICanSearchForAGivenContact(){
        phone.addContact(contact);
        Contact contact1 = new Contact("fuu","1,yanku china","0998756789","fuuChiyang@gmail.com");
        phone.addContact(contact1);
        Contact contact2 = new Contact("Golry","12,yongu","09745632","Glory@gmail.com");
        phone.addContact(contact2);
        assertEquals(String.valueOf(contact2), phone.Search("Golry"));
    }
    @Test
    public void testThatICanDisplayContact(){
        phone.addContact(contact);
        Contact contact1 = new Contact("fuu","1,yanku china","0998756789","fuuChiyang@gmail.com");
        phone.addContact(contact1);
        Contact contact2 = new Contact("Golry","12,yongu","09745632","Glory@gmail.com");
        phone.addContact(contact2);
        phone.display();
    }
    @Test
    public void testThatDeleteContact(){
        phone.addContact(contact);
        Contact contact1 = new Contact("fuu","1,yanku china","0998756789","fuuChiyang@gmail.com");
        phone.addContact(contact1);
        Contact contact2 = new Contact("Golry","12,yongu","09745632","Glory@gmail.com");
        phone.addContact(contact2);
        phone.display();
        phone.delete("Jennifer");
        phone.display();
        phone.delete("fuu");
        phone.display();

    }

}

