package view;

import constants.UIColors;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.User;

/**
 *
 * @Author Ahmet Batu
 * 
 * SettingsPanel() : Creates a settings panel for helping user to change their 
 * username and password
 */

public class SettingsPanel extends JPanel 
{
    // PROPERTIES
    private final JPanel exteriorPanel;
    private final JPanel interiorPanel;
    private final User   user;
    
    private JButton backToLogInButton;

    // CONSTRUCTOR
    public SettingsPanel() 
    {
        this.setBackground(UIColors.DARKBLUE);
        exteriorPanel = new JPanel();
        interiorPanel = new JPanel();
        user = new User();
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
        
        TextFormEntryView changeUsername = new TextFormEntryView("OLD USERNAME : " + user.getUsername() + " - NEW USERNAME : ", 20);
        TextFormEntryView changePassword = new TextFormEntryView("NEW PASSWORD : ", 20);
        
        interiorPanel.add(changeUsername);
        interiorPanel.add(changePassword);
        
        JPanel signinPanel = new JPanel();
        FormButton signinButton = new FormButton("SIGNUP");
        signinButton.setPreferredSize(new Dimension(270, 50));
        
        signinPanel.add(signinButton);
        signinPanel.setBackground(null);
        
        interiorPanel.add(signinPanel);
        exteriorPanel.add(interiorPanel);
        add(exteriorPanel);
    }
    
    public JButton getbackToLogInButton()
    {
        return backToLogInButton;
    }
}
