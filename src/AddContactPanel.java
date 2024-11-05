import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class AddContactPanel extends JPanel {
    private JTextField nameField, numberField;
    private JFrame frame;

    public AddContactPanel(JFrame frame) {
        this.frame = frame;
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 20, 200, 25);
        add(nameField);

        JLabel numberLabel = new JLabel("Number:");
        numberLabel.setBounds(20, 60, 100, 25);
        add(numberLabel);

        numberField = new JTextField();
        numberField.setBounds(120, 60, 200, 25);
        add(numberField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(120, 100, 100, 25);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String number = numberField.getText();
                if (!name.isEmpty() && !number.isEmpty()) {
                    // Add to database
                    JOptionPane.showMessageDialog(frame, "Contact added successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in both fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Create the Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(120, 140, 100, 25);
        add(backButton);

        // ActionListener for the Back button
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goBackToMain();
            }
        });
    }

    // Method to go back to the main panel
    private void goBackToMain() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new MainStartPanel(frame)); // Switch to the main menu panel
        frame.revalidate();
        frame.repaint();
    }
}
