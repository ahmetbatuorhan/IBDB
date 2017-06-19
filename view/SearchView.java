package view;

import constants.UIColors;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @Author Ahmet Batu
 * 
 * SearchView() : Basically creates searchbar by using Searchbar() with search 
 * button
 */

public class SearchView extends JPanel
{

    private Searchbar searchbar;
    private JButton searchButton;
    
    public SearchView() 
    {
        searchbar = new Searchbar();
        
        // Resizing Image
        ImageIcon icon = new ImageIcon("search_icon.png");
        Image img = icon.getImage();
        Image imgResized = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(imgResized);
        
        // SearchButton
        searchButton = new JButton(icon);
        searchButton.setBackground(null);
        searchButton.setBorder(null);
        searchButton.setPreferredSize(new Dimension(40, 40));
        
        this.setBackground(UIColors.NIGHTBLUE);
        this.add(searchbar);
        this.add(searchButton);
    }
    
    // METHODS
    public JButton getsearchButton()
    {
        return searchButton;
    }
    
    public String getSearchText()
    {
        System.out.println(searchbar.getSelectedItem().toString());
        return searchbar.getSelectedItem().toString();
    }
    
}
