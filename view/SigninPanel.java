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
 */

public class SigninPanel extends JPanel 
{
    
    private JPanel exteriorPanel;
    private JPanel interiorPanel;
    private JButton backToLogInButton;
    
    public SigninPanel() 
    {
        setBackground(UIColors.DARKBLUE);
        exteriorPanel = new JPanel();
        interiorPanel = new JPanel();
        placeComponents();
    }

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
        
        TextFormEntryView name = new TextFormEntryView("NAME", 20);
        TextFormEntryView surname = new TextFormEntryView("SURNAME", 20);
        TextFormEntryView age = new TextFormEntryView("AGE", 20);
        
        TextFormEntryView username = new TextFormEntryView("USERNAME", 20);
        TextFormEntryView password = new TextFormEntryView("PASSWORD", 20);
        
        
        TextFormEntryView email = new TextFormEntryView("EMAIL", 20);
        
        interiorPanel.add(name);
        interiorPanel.add(surname);
        interiorPanel.add(age);
        interiorPanel.add(username);
        interiorPanel.add(password);
        interiorPanel.add(email);
        
        JPanel signinPanel = new JPanel();
        FormButton signinButton = new FormButton("SIGNUP");
        signinButton.setPreferredSize(new Dimension(270, 50));
        
        backToLogInButton = new JButton(" <== Back to login page");
        backToLogInButton.setHorizontalAlignment(SwingConstants.RIGHT);
        backToLogInButton.setForeground(UIColors.DARKBLUE);
        backToLogInButton.setBorder(null);
        backToLogInButton.setBackground(null);
        
        
        signinPanel.add(signinButton);
        signinPanel.setBackground(null);
        
        interiorPanel.add(signinPanel);
        interiorPanel.add(backToLogInButton);
   
        exteriorPanel.add(interiorPanel);
        add(exteriorPanel);
    }
    
    public JButton getbackToLogInButton()
    {
        return backToLogInButton;
    }
}
