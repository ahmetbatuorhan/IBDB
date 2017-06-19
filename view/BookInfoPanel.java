package view;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @Author Ahmet Batu
 *
 * BookInfoPanel(String name, String author) : This panel extends JPanel and
 * contains informations about Book. This Panel used in BookItemView.
 */

public class BookInfoPanel extends JPanel
{
    // CONSTRUCTOR
    public BookInfoPanel(String name, String author)
    {
        this.setLayout(new BorderLayout());
        this.setBackground(null);
        
        JLabel authorLabel = new JLabel(author, SwingConstants.CENTER);
        
        this.add(authorLabel, BorderLayout.NORTH);
        this.add(new JLabel(name, SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
