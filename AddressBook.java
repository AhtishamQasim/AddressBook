import java.io.*;
import java.util.*;
import javax.swing.*;

class AddressBook {
    ArrayList<PersonInfo> persons;

    // Constructor
    public AddressBook() {
        persons = new ArrayList<>();
        loadPersons();
    }

    // Add a new person
    public void addPerson() {
        String name = JOptionPane.showInputDialog("Enter name:");
        String address = JOptionPane.showInputDialog("Enter address:");
        String phoneNum = JOptionPane.showInputDialog("Enter phone number:");

        if (name != null && address != null && phoneNum != null &&
            !name.isEmpty() && !address.isEmpty() && !phoneNum.isEmpty()) {
            PersonInfo p = new PersonInfo(name, address, phoneNum);
            persons.add(p);
            JOptionPane.showMessageDialog(null, "Person added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input. All fields are required.");
        }
    }

    // Search for a person
    public void searchPerson(String name) {
        boolean found = false;
        for (PersonInfo p : persons) {
            if (name.equalsIgnoreCase(p.getName())) {
                JOptionPane.showMessageDialog(null, "Found:\n" + p.getInfo());
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Record not found.");
        }
    }

    // Delete a person
    public void deletePerson(String name) {
        boolean found = false;
        Iterator<PersonInfo> iterator = persons.iterator();
        while (iterator.hasNext()) {
            PersonInfo p = iterator.next();
            if (name.equalsIgnoreCase(p.getName())) {
                iterator.remove();
                JOptionPane.showMessageDialog(null, "Person deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Record not found.");
        }
    }

    // Display all records
    public void displayAllRecords() {
        if (persons.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No records found.");
        } else {
            StringBuilder allRecords = new StringBuilder("All Records:\n");
            for (PersonInfo p : persons) {
                allRecords.append(p.getInfo()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, allRecords.toString());
        }
    }

    // Load records from a file
    public void loadPersons() {
        try (BufferedReader br = new BufferedReader(new FileReader("persons.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 3) {
                    persons.add(new PersonInfo(tokens[0], tokens[1], tokens[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading persons: " + e.getMessage());
        }
    }

    // Save records to a file
    public void savePersons() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("persons.txt"))) {
            for (PersonInfo p : persons) {
                pw.println(p.getName() + "," + p.getAddress() + "," + p.getPhoneNum());
            }
        } catch (IOException e) {
            System.out.println("Error saving persons: " + e.getMessage());
        }
    }
}