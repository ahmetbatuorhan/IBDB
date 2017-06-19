package ibdb;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.User;
import view.LoginPanel;
import view.SettingsPanel;
import view.SignupPanel;
import view.TopListPanel;

/**
 *
 * @Author Ahmet Batu ORHAN and �lkim G�VEN
 * 
 */

public class FrameViewer extends JFrame 
{
    // PROPERTIES   
    private final TopFixedPanelViewer  topFixedPanel;
    private final HomePageViewer       homePage;
    private final LoginPanel           loginPanel;
    private final SettingsPanel        settingsPanel;
    private final TopListPanel         topListPanel;
    private final SignupPanel          signupPanel;
    private final IBDBActionListener         actionListener;
    private JPanel                     currentPanel;
    private String username;
    
    // CONSTRUCTOR
    public FrameViewer( String username)
    {       
        this.username = username;
        // Initilazing topFixedPanel, homePage, topListPanel, loginPanel, signinPanel and actionListener
        topFixedPanel  = new TopFixedPanelViewer();
        homePage       = new HomePageViewer(username);
        topListPanel   = new TopListPanel(username);
        loginPanel     = new LoginPanel();
        settingsPanel  = new SettingsPanel();
        signupPanel    = new SignupPanel();
        
        actionListener = new IBDBActionListener(this, homePage, topFixedPanel,
                topListPanel, loginPanel, settingsPanel, signupPanel);
        
        // Setting layout to loginPanel
        loginPanel.setLayout(new GridBagLayout());

        this.add( loginPanel, BorderLayout.CENTER);

        currentPanel = loginPanel;
    }
    
    // METHODS
    
    public void add(JPanel panel)
    {
        add(panel, BorderLayout.CENTER);
        repaint();
        revalidate();
        currentPanel = panel;
    }
    
    public void remove()
    {
        remove(currentPanel);
        repaint();
        revalidate();
    }
    
    public void removeAll()
    {
        this.getContentPane().removeAll();
        repaint();
        revalidate();
    }
    
    public LoginPanel getLoginPanel() 
    {
        return loginPanel;
    }
    
    public SignupPanel getSignupPanel() 
    {
        return signupPanel;
    }
    
    public JPanel getCurrentPanel() 
    {
        return currentPanel;
    }
    
    public User getUser()
    {
       return actionListener.getUser();
    }
    
    public void setUsername( String newUsername)
    {
        username = newUsername;
    }
}
