package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @Author Ahmet Batu
 * 
 * TextFormEntryView(String title, int length) : Creates a form entry view with 
 * TitleName and textFiled name.
 */

public class TextFormEntryView extends JPanel
{
    private final JTextField field;
    
    public TextFormEntryView(String title, int length) 
    {
        this.setLayout(new GridLayout(3, 1));
        this.setBackground(null);
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        this.add(titleLabel);
        
        field = new JTextField(length);
        field.setPreferredSize(new Dimension(length * 5, 35));
        field.setBorder(null);
        this.add(field);
    }
    
    // METHODS
    public String getTextEntery()
    {
        return field.getText();
    }
}
