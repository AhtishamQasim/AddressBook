import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Test {
    public static void main(String[] args) {
        AddressBook ab = new AddressBook();

        JFrame frame = new JFrame("Address Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Address Book Application", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        frame.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JButton addButton = new JButton("Add Person");
        JButton searchButton = new JButton("Search Person");
        JButton deleteButton = new JButton("Delete Person");
        JButton displayButton = new JButton("Display All Records");
        JButton exitButton = new JButton("Exit");

        Font buttonFont = new Font("Arial", Font.PLAIN, 24);
        addButton.setFont(buttonFont);
        searchButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
        displayButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ab.addPerson();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter name to search");
                if (name != null && !name.trim().isEmpty()) {
                    ab.searchPerson(name);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter name to delete");
                if (name != null && !name.trim().isEmpty()) {
                    ab.deletePerson(name);
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ab.displayAllRecords();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
