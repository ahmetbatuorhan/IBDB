package view;

import constants.UIColors;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @Author Ahmet Batu
 * 
 * MenuButton(String name) : Fixed Menu Button for using in program.
 */

public class MenuButton extends JButton 
{
    public MenuButton(String name) 
    {
        super(name);
        this.setBorder(null);
        this.setBackground(UIColors.DARKBLUE);
        this.setForeground(Color.WHITE);
        this.setPreferredSize(new Dimension(200, 50));
    }
}