import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class SearchContactPanel extends JPanel {
    private JTextField nameField, numberField;
    private JTextArea resultArea;
    private JFrame frame;

    public SearchContactPanel(JFrame frame) {
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

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(120, 100, 100, 25);
        add(searchButton);

        resultArea = new JTextArea();
        resultArea.setBounds(20, 140, 300, 100);
        resultArea.setEditable(false);
        add(resultArea);

        // Add action to Search button
        searchButton.addActionListener(e -> showSearchOptions(searchButton));

        // Create and add a Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(120, 250, 100, 25);
        add(backButton);

        // Back button action to return to the main panel
        backButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new MainStartPanel(frame)); // Assuming MainStartPanel is the main panel
            frame.revalidate();
            frame.repaint();
        });
    }

    private void showSearchOptions(JButton searchButton) {
        JPopupMenu searchMenu = new JPopupMenu();
        
        JMenuItem searchByName = new JMenuItem("Search by Name");
        JMenuItem searchByNumber = new JMenuItem("Search by Number");

        searchMenu.add(searchByName);
        searchMenu.add(searchByNumber);

        searchByName.addActionListener(e -> searchByName());
        searchByNumber.addActionListener(e -> searchByNumber());

        searchMenu.show(searchButton, searchButton.getWidth() / 2, searchButton.getHeight());
    }

    private void searchByName() {
        String name = nameField.getText();
        if (!name.isEmpty()) {
            // Simulate searching by name in the database
            resultArea.setText("Results for name search:\nName: John Doe\nNumber: 123456789"); // Sample result
        } else {
            JOptionPane.showMessageDialog(frame, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchByNumber() {
        String number = numberField.getText();
        if (!number.isEmpty()) {
            // Simulate searching by number in the database
            resultArea.setText("Results for number search:\nName: John Doe\nNumber: " + number); // Sample result
        } else {
            JOptionPane.showMessageDialog(frame, "Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
