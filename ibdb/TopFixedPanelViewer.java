package ibdb;

import constants.UIColors;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import view.MenuButton;
import view.SearchView;

/**
 *
 * @Author Ahmet Batu ORHAN and İlkim G�VEN
 * 
 */

public class TopFixedPanelViewer extends JPanel
{
    private final SearchView searchTextField; 
    private final JButton logoButton;
    private final MenuButton futureReadingsButton;
    private final MenuButton logoutButton;
    private final JPanel horizontalPanel;
    private final JPanel menuView;
    
    
    public TopFixedPanelViewer()
    {   
        menuView = new JPanel();
        menuView.setLayout(new GridBagLayout());
        
        horizontalPanel = new JPanel();
        horizontalPanel.setBackground(UIColors.NIGHTBLUE);
        this.setBorder(null);
        this.setPreferredSize(new Dimension(800, 70));
        searchTextField  = new SearchView();
        
        ImageIcon icon = new ImageIcon("logo.png");
        Image img = icon.getImage();
        Image imgResized = img.getScaledInstance(90, 35, java.awt.Image.SCALE_SMOOTH);
        
        icon = new ImageIcon(imgResized);
        
        logoButton = new JButton(icon);
        logoButton.setBackground(UIColors.NIGHTBLUE);
        logoButton.setBorder(null);
        
        futureReadingsButton = new MenuButton("FUTURE READINGS");
        logoutButton = new MenuButton("LOGOUT");

        horizontalPanel.add(logoButton);
        
        horizontalPanel.add(buildMargin(120));
        
        horizontalPanel.add(searchTextField);
        
        horizontalPanel.add(buildMargin(30));
        horizontalPanel.add(futureReadingsButton);
        horizontalPanel.add(buildMargin(8));
        horizontalPanel.add(logoutButton);
        horizontalPanel.add(buildMargin(8));
        
        menuView.add(horizontalPanel);
        this.add(menuView);
        this.setBackground(UIColors.NIGHTBLUE);
    }
    
    // METHODS
    public static JPanel buildMargin(int x) 
    {
        JPanel marginPanel = new JPanel();
        marginPanel.setPreferredSize(new Dimension(x, 40));
        marginPanel.setBackground(null);
        marginPanel.setBorder(null);
        return marginPanel;
    }
    
    protected MenuButton getFutureReadingsButton()
    {
        return futureReadingsButton;
    }
    
    protected JButton getIBDBButton()
    {
        return logoButton;
    }
    
    protected MenuButton getLogoutButton()
    {
        return logoutButton;
    }
    
    public JButton getSearchButton()
    {
        return searchTextField.getsearchButton();
    }
    
    public String getSearchText()
    {
        return searchTextField.getSearchText();
    }
}
