package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import model.Book;

/**
 *
 * @Author Ahmet Batu
 * 
 * BookItemView(String img, Book book) : This panel extends JPanel and 
 * contains ImagePanel and BookInfoPanel and makes a new Panel. This new Panel
 * used in NewBooksPanel 
 */

public class BookItemView extends JPanel
{
    // PROPERTIES
    private ImagePanel imgPanel;
    private Book       book;
    private String username;
    
    // CONSTRUCTOR
    public BookItemView(String img, Book book, String username) 
    {
        this.username = username;
        this.book = book;
        
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(100, 300));
        
        imgPanel = new ImagePanel(img, book, username);
        imgPanel.setBackground(Color.WHITE);
        
        this.add(imgPanel, BorderLayout.CENTER);
        this.add(new BookInfoPanel( book.getTitle(), 
                                    book.getAuthor()), 
                                    BorderLayout.SOUTH);
        
        this.setBackground(Color.WHITE);       
    }
    
   public Book getBook() 
   {
       return book;
   }
   
   public ImagePanel getImagePanel() 
   {
       return imgPanel;
   }
}
