import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TelephoneDirectoryApp {
    private JFrame frame;

    public TelephoneDirectoryApp() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Telephone Directory");
        frame.setSize(350, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Start with the main start panel
        frame.getContentPane().add(new MainStartPanel(frame));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelephoneDirectoryApp::new);
    }
}
