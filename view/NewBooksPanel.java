package view;

import database.DataBase;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Book;

/**
 *
 * @Author Ahmet Batu
 * 
 * NewBooksPanel( ArrayList<Book> book, int start, int end) : The Panel which
 * contains list of books. By adding different BookItemView Objects this Object 
 * creates a new Panel with lots of books and their informations 
 */

public class NewBooksPanel extends JPanel implements MouseListener
{
    // PROPERTIES
    private final ArrayList<Book> book;
    private final int             start;
    private final int             end;
    
    private BookItemView bookItemView;
    private DataBase     db;
    private String username;
    
    
    // CONSTRUCTOR
    public NewBooksPanel( ArrayList<Book> book, int start, int end, String username) 
    {
        this.username = username;
        this.book  = book;
        this.start = start;
        this.end   = end;
        
        this.setLayout(new GridLayout(0, 5));
        
        for( int i = 0 ; i < db.getNews().size() ; i++)
        {
            bookItemView = new BookItemView("bookPictures/" + db.getPicture(db.getNews().get(i)) + ".jpg", book.get(db.getNews().get(i) - 1), username);
            bookItemView.addMouseListener(this);
            add(bookItemView);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getSource() instanceof BookItemView) 
        {
            System.out.println(((BookItemView) e.getSource()).getBook());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
