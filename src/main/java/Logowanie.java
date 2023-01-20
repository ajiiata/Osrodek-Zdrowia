import java.awt.Cursor;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Logowanie extends JDialog implements ActionListener {
    private final String LOGIN_LABEL = "Login Panel";
    private final String USERNAME_LABEL = "Username: ";
    private final String PASSWORD_LABEL = "Password: ";
    private final String BUTTON_LABEL = "Login";
    private JPanel jPanel;
    private JLabel userLabel;
    private JLabel passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton logButton;
    private JLabel wrongCredentialsLabel;
    private boolean loginOK = false;

    public Logowanie(Frame parentFrame) {
        super(parentFrame, "Login", true);

// Create a new panel with GridBagLayout manager

        jPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

// Set labels for input fields

        userLabel = new JLabel(USERNAME_LABEL);
        constraints.gridx = 0;
        constraints.gridy = 0;
        jPanel.add(userLabel, constraints);
        passLabel = new JLabel(PASSWORD_LABEL);
        constraints.gridx = 0;
        constraints.gridy = 1;
        jPanel.add(passLabel, constraints);

// Set input fields

        userField = new JTextField(getUsername());
        constraints.gridx = 1;
        constraints.gridy = 0;
        jPanel.add(userField, constraints);
        passField = new JPasswordField(20);
        constraints.gridy = 1;
        jPanel.add(passField, constraints);

// Set button

        logButton = new JButton(BUTTON_LABEL);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        logButton.addActionListener(this);
        jPanel.add(logButton, constraints);

// adding hand cursor on button

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        logButton.setCursor(cursor); // applying cursor to the button

//Set label

        wrongCredentialsLabel = new JLabel();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        jPanel.add(wrongCredentialsLabel, constraints);

// Set border      jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LOGIN_LABEL));

        add(jPanel);

// required to have a nice view

        pack();

// window should start in the central part

        setLocationRelativeTo(null);

    }

    @Override

    public void actionPerformed(ActionEvent event) {
        String usernameInput = userField.getText();
        String passwordInput = String.valueOf(passField.getPassword());

        if (event.getSource() == logButton) {
            if (performAuthentication(usernameInput, passwordInput)) {
                loginOK = true;
                dispose();
            } else {
                wrongCredentialsLabel.setText("Wrong credentials, try again!");
            }
        }

//required again to refresh the content

        pack();
    }

    public boolean isLoginOk() {
        return loginOK;
    }

    private boolean performAuthentication(String usernameInput, String passwordInput) {
        if(passwordInput.equals("ok")) {
            return true;
        } else return false;
    }

    private String getUsername() {
        return System.getProperty("user.name");
    }
}

