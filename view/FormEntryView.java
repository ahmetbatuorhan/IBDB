package view;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @Author Ahmet Batu
 * 
 * FormEntryView(String imgStr, int userOrPass) : Creates textField with image
 * for the purpose of using it in LogInPanel.
 */

public class FormEntryView extends JPanel
{
    // PROPERTIES
    private JTextField     usernameField;
    private JPasswordField passwordField;
    
    // CONSTRUCTOR
    public FormEntryView(String imgStr, int userOrPass) 
    {
        this.setBackground(null);
        
        // Creating resized icon
        ImageIcon icon = new ImageIcon(imgStr);
        Image img = icon.getImage();
        Image imgResized = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(imgResized);
        
        // Adding resized icon the the JButton
        JButton iconButton = new JButton(icon);
        iconButton.setPreferredSize(new Dimension(40, 40));
        iconButton.setBackground(null);
        iconButton.setBorder(null);
        
        this.add(iconButton);
        
        if (userOrPass == 0) 
        {
            usernameField = new JTextField(20);
            usernameField.setPreferredSize(new Dimension(100, 35));
            usernameField.setBorder(null);
            add(usernameField);
        }
        else 
        {
            passwordField = new JPasswordField(20);
            passwordField.setPreferredSize(new Dimension(100, 35));
            passwordField.setBorder(null);
            add(passwordField);
        }
    }
    
    // METHODS
    protected String getUsername()
    {
        return usernameField.getText();
    }
    
    protected String getUserPassword()
    {
       String s = "";
        char[] password = passwordField.getPassword();
        for( int i = 0 ; i < password.length ; i++)
        {
            s = s + password[i];
        }
        return s;
    }
}