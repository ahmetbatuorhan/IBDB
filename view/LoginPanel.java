package view;

import constants.UIColors;
import database.CheckUser;
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
 */

public class LoginPanel extends JPanel 
{
    // PROPERTIES
    private final JPanel exteriorPanel;
    private final JPanel interiorPanel;
    
    private FormButton    loginButton;
    private  static FormEntryView userText;
    private FormEntryView passwordText;
    private JButton       signInButton;
    private CheckUser     cu;
    private static String a;
    
    // CONSTRUCTOR
    public LoginPanel() 
    {
        this.setBackground(UIColors.DARKBLUE);
        exteriorPanel = new JPanel();
        interiorPanel = new JPanel();
        placeComponents();
    }

    private void placeComponents() 
    {
        exteriorPanel.setPreferredSize(new Dimension(400, 300));
        exteriorPanel.setBackground(UIColors.NIGHTBLUE);
        
        interiorPanel.setLayout(new GridLayout(5,1));
        interiorPanel.setBackground(UIColors.NIGHTBLUE);
        
        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setFont(new Font(loginLabel.getFont().getName(), Font.PLAIN, 18));
        interiorPanel.add(loginLabel);
        
        userText = new FormEntryView("user_icon.png", 0);
        interiorPanel.add(userText);
        
        passwordText = new FormEntryView("password_icon.png", 1);
        interiorPanel.add(passwordText);
        
        // Creating a LogIn Button
        JPanel loginPanel = new JPanel();
        loginButton = new FormButton("LOGIN");
        loginButton.setPreferredSize(new Dimension(270, 50));
        loginPanel.add(loginButton);
        loginPanel.setBackground(null);
        interiorPanel.add(loginPanel);
        
        // Creating a Button which basically creates a Sigup Panel 
        signInButton = new JButton("Don't you have an account?");
        signInButton.setHorizontalAlignment(SwingConstants.RIGHT);
        signInButton.setForeground(UIColors.DARKBLUE);
        signInButton.setBorder(null);
        signInButton.setBackground(null);
        interiorPanel.add(signInButton);
        
        exteriorPanel.add(interiorPanel);
        add(exteriorPanel);
    }
    
    // METHODS
    public JButton getLoginButton()
    {
        return loginButton;
    }
    
    public static String getUsername()
    {
        return userText.getUsername();
    }
    
    public String getUserPassword()
    {
        return passwordText.getUserPassword();
    }
    
    public JButton getSignInButton()
    {
        return signInButton;
    }
    
    /*public User getUser()
    {
        return new User(userText.getUsername(), passwordText.getUserPassword());
    }*/
}
