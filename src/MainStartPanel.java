import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

class MainStartPanel extends JPanel {
    private JFrame frame;

    public MainStartPanel(JFrame frame) {
        this.frame = frame;
        setLayout(null); 

        // Background Label with phone image
        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Pictures\\output.jpg")); // Path to mobile image
        backgroundLabel.setBounds(0, 0, 350, 600);
        add(backgroundLabel);

        // Add Contact Button
        JButton addContactButton = new JButton("Add Contact");
        addContactButton.setBounds(100, 250, 150, 30); // Position for "Add Contact" button on the phone
        addContactButton.setFocusPainted(false);
        addContactButton.setBorderPainted(true);
        backgroundLabel.add(addContactButton);

        // Delete Contact Button
        JButton deleteContactButton = new JButton("Delete Contact");
        deleteContactButton.setBounds(100, 300, 150, 30); // Position for "Delete Contact" button on the phone
        deleteContactButton.setFocusPainted(false);
        deleteContactButton.setBorderPainted(true);
        backgroundLabel.add(deleteContactButton);

        // Search Contact Button
        JButton searchContactButton = new JButton("Search");
        searchContactButton.setBounds(100, 350, 150, 30); // Position for "Search" button on the phone
        searchContactButton.setFocusPainted(false);
        searchContactButton.setBorderPainted(true);
        backgroundLabel.add(searchContactButton);

        // Add Action Listeners to Buttons
        addContactButton.addActionListener(e -> showAddContactPanel());
        deleteContactButton.addActionListener(e -> showDeleteContactPanel());
        searchContactButton.addActionListener(e -> showSearchOptions(searchContactButton));
    }

    private void showSearchOptions(JButton searchButton) {
        JPopupMenu searchMenu = new JPopupMenu();
        
        JMenuItem searchByName = new JMenuItem("Search by Name");
        JMenuItem searchByNumber = new JMenuItem("Search by Number");

        searchMenu.add(searchByName);
        searchMenu.add(searchByNumber);

        searchByName.addActionListener(e -> showSearchByNamePanel());
        searchByNumber.addActionListener(e -> showSearchByNumberPanel());

        searchMenu.show(searchButton, searchButton.getWidth() / 2, searchButton.getHeight());
    }

    private void showSearchByNamePanel() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new SearchContactPanel(frame)); // Pass true to indicate name search
        frame.revalidate();
        frame.repaint();
    }

    private void showSearchByNumberPanel() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new SearchContactPanel(frame)); // Pass false to indicate number search
        frame.revalidate();
        frame.repaint();
    }

    private void showAddContactPanel() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new AddContactPanel(frame));
        frame.revalidate();
        frame.repaint();
    }

    private void showDeleteContactPanel() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new DeleteContactPanel(frame));
        frame.revalidate();
        frame.repaint();
    }
}
