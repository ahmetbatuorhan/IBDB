package view;

import constants.UIColors;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @Author Ahmet Batu
 * 
 * SignupPanel() : Creates a signup Panel.
 */

public class SignupPanel extends JPanel 
{
    // PROPERTIES
    private final JPanel exteriorPanel;
    private final JPanel interiorPanel;

    private TextFormEntryView name;
    private TextFormEntryView surname;
    private TextFormEntryView username;
    private TextFormEntryView password;
    private TextFormEntryView email;
    
    private JButton           backToLogInButton;
    private FormButton        signupButton;
    
    // CONSTRUCTOR
    public SignupPanel() 
    {
        setBackground(UIColors.DARKBLUE);
        exteriorPanel = new JPanel();
        interiorPanel = new JPanel();
        placeComponents();
    }
    
    // METHODS
    private void placeComponents() 
    {
        exteriorPanel.setPreferredSize(new Dimension(600, 600));
        exteriorPanel.setBackground(UIColors.NIGHTBLUE);
        
        interiorPanel.setLayout(new GridLayout(9,1));
        interiorPanel.setBackground(UIColors.NIGHTBLUE);
        interiorPanel.setPreferredSize(new Dimension(300, 550));
        
        JLabel signinLabel = new JLabel("SIGNIN");
        signinLabel.setForeground(Color.WHITE);
        signinLabel.setFont(new Font(signinLabel.getFont().getName(), Font.PLAIN, 18));
        interiorPanel.add(signinLabel);
        
        name     = new TextFormEntryView("NAME", 20);
        surname  = new TextFormEntryView("SURNAME", 20);
        username = new TextFormEntryView("USERNAME", 20);
        password = new TextFormEntryView("PASSWORD", 20);
        email    = new TextFormEntryView("EMAIL", 20);
        
        interiorPanel.add(name);
        interiorPanel.add(surname);
        interiorPanel.add(username);
        interiorPanel.add(password);
        interiorPanel.add(email);
        
        JPanel signupPanel = new JPanel();
        signupButton = new FormButton("SIGNUP");
        signupButton.setPreferredSize(new Dimension(270, 50));
        
        backToLogInButton = new JButton(" <== Back to login page");
        backToLogInButton.setHorizontalAlignment(SwingConstants.RIGHT);
        backToLogInButton.setForeground(UIColors.DARKBLUE);
        backToLogInButton.setBorder(null);
        backToLogInButton.setBackground(null);

        signupPanel.add(signupButton);
        signupPanel.setBackground(null);
        
        interiorPanel.add(signupPanel);
        interiorPanel.add(backToLogInButton);
        exteriorPanel.add(interiorPanel);
        add(exteriorPanel);
    }
    
    public JButton getbackToLogInButton()
    {
        return backToLogInButton;
    }
    
    public JButton getSignupButton()
    {
        return signupButton;
    }
    
    public String getTextEntryName()
    {
        return name.getTextEntery();
    }
    
    public String getTextEntrySurname()
    {
        return surname.getTextEntery();
    }
    
    public String getTextEntryUsername()
    {
        return username.getTextEntery();
    }
    
    public String getTextEntryPassword()
    {
        return password.getTextEntery();
    }
    
    public String getTextEntryEmail()
    {
        return email.getTextEntery();
    }
}
