import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


class DeleteContactPanel extends JPanel {
    private JTextField nameField;
    private JFrame frame;

    public DeleteContactPanel(JFrame frame) {
        this.frame = frame;
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 20, 200, 25);
        add(nameField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(120, 60, 100, 25);
        add(deleteButton);

        deleteButton.addActionListener(e -> {
            String name = nameField.getText();
            if (!name.isEmpty()) {
                // Delete from database
                JOptionPane.showMessageDialog(frame, "Contact deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        JButton backButton = new JButton("Back");
        backButton.setBounds(120, 100, 100, 25); // Positioned below the Delete button
        add(backButton);

        // ActionListener for the Back button
        backButton.addActionListener(e -> goBackToMain());
    }

    // Method to go back to the main panel
    private void goBackToMain() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new MainStartPanel(frame)); // Switch to the main menu panel
        frame.revalidate();
        frame.repaint();
    }
}

