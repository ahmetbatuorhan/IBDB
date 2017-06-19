package ibdb;

import constants.UIColors;
import database.DataBase;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Book;
import view.NewBooksPanel;
import view.TopListPanel;

/**
 *
 * @Author Ahmet Batu ORHAN and �lkim G�VEN
 * 
 */

public class HomePageViewer extends JPanel
{
    // PROPERTIES
    private final JScrollPane     newBooksPanel;
    private final JPanel          topBooksPanel;
    private final ArrayList<Book> book;
    private DataBase db;
    private String username;
    
    // CONSTRUCTOR
    public HomePageViewer( String username)
    {
        this.username = username;
        
        book = new ArrayList<Book>();
        
        for(int i = 1 ; i < db.last() ; i++)
        {
            book.add(new Book(i));
        }
        
        newBooksPanel     = new JScrollPane(new NewBooksPanel(book, 0, db.last(), username));
        topBooksPanel     = new TopListPanel( username);
    
        newBooksPanel.setBackground(UIColors.DARKBLUE);

        this.setLayout( new BorderLayout());
        
        this.add( topBooksPanel, BorderLayout.WEST);
        this.add( newBooksPanel, BorderLayout.CENTER);
    }   
    public void setUsername( String newUsername)
    {
        username = newUsername;
    }
}
