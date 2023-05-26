import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Toolkit;

public class LaunchPage implements ActionListener, ILaunchPage {
    private JFrame frame;
    private JButton myButton;
    private JButton backButton;
    private JButton submitButton;
    private JTextField myTextField;

    public LaunchPage() {
        frame = new JFrame();
        myButton = new JButton("Pria Bibir Oren");
        backButton = new JButton("Kembali");
        submitButton = new JButton("Submit");
        myTextField = new JTextField(20);

        myButton.setFocusable(false);
        myButton.addActionListener(this);

        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setVisible(false);

        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setVisible(false);

        myTextField.setVisible(false);
        myTextField.setFocusable(true);

        frame.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 0.5;
        constraints.anchor = GridBagConstraints.CENTER;
        frame.add(myButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.PAGE_END;
        frame.add(backButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        frame.add(myTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.PAGE_START;
        frame.add(submitButton, constraints);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        centerFrame();
        frame.setVisible(true);
    }

    private void centerFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        frame.setLocation(x, y);
    }

    @Override
    public void setActionListener(ActionListener listener) {
        myButton.addActionListener(listener);
        backButton.addActionListener(listener);
        submitButton.addActionListener(listener);
    }

    @Override
    public void showMainPage() {
        myButton.setVisible(true);
        backButton.setVisible(false);
        submitButton.setVisible(false);
        myTextField.setVisible(false);
    }

    @Override
    public void showSecondaryPage() {
        myButton.setVisible(false);
        backButton.setVisible(true);
        submitButton.setVisible(true);
        myTextField.setVisible(true);
        myTextField.setText("");
        myTextField.setFocusable(true);
    }

    @Override
    public void showPreviousPage() {
        backButton.setVisible(false);
        submitButton.setVisible(false);
        myButton.setVisible(true);
        myTextField.setVisible(false);
    }

    public static void main(String[] args) {
        LaunchPage launchPage = new LaunchPage();
        launchPage.setActionListener(launchPage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myButton) {
            showSecondaryPage();
        } else if (e.getSource() == backButton) {
            showPreviousPage();
        } else if (e.getSource() == submitButton) {
            
            String input = myTextField.getText();
            if (!input.isEmpty()) {
                if (input.equals("Pria Bibir Oren")) {
                    JOptionPane.showMessageDialog(frame, "Benar");
                } else {
                    JOptionPane.showMessageDialog(frame, "Salah");
                }
            }
        }
    }
}

