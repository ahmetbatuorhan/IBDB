package view;

import constants.UIColors;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @Author Ahmet Batu
 * 
 * FormButton(String name) : The Button with a fixed Borders and Colors for the 
 * purpose of using this button in lots of place.
 */

public class FormButton extends JButton 
{
    // CONSTRUCTOR
    public FormButton(String name) 
    {
        super(name);
        this.setBorder(null);
        this.setBackground(UIColors.DARKBLUE);
        this.setForeground(Color.WHITE);
    }
}
