package view;

import database.DataBase;
import database.readLater;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Book;
import model.User;

/**
 *
 * @Author Ahmet Batu
 *
 */

public class FutureBooksPanel extends JPanel
{
    
    // PROPERTIES
    private final ArrayList<Book> books;
    private final int             start;
    private final int             end;
    
    private BookItemView     bookItemView;
    private DataBase         db;
    private static readLater rl;
    private String            userName;
    
    // CONSTRUCTOR
    public FutureBooksPanel( ArrayList<Book> books, int start, int end)
    {
        this.books  = books;
        this.start = start;
        this.end = end;
        this.userName = userName;
        
        this.setLayout(new GridLayout(0, 5));
        
        rl = new readLater();
        
        for (int i = start ; i < rl.futureReading(LoginPanel.getUsername()).size(); i++) 
        {
            Book b = new Book(rl.futureReading(LoginPanel.getUsername()).get(i));
            bookItemView = new BookItemView("bookPictures/" + rl.futureReading(LoginPanel.getUsername()).get(i) + ".jpg", b, LoginPanel.getUsername());
            add(bookItemView);
        }
        
    }
}
