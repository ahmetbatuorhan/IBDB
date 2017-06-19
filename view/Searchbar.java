package view;

import javax.swing.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import database.DataBase;
import model.Book;
import java.awt.*;

/**
 *
 * @Author Ahmet Batu
 * 
 * Searchbar() : External class which creates searchBar.
 */

public class Searchbar extends JComboBox
{
    // PROPERTIES
    AutoCompleteDecorator decorator;
    private Object[] books = new Object[12]; 
    private DataBase db;
    
    // CONSTRUCTOR
    public Searchbar() 
    {
    	super( returnAllBooks(DataBase.last()));
        AutoCompleteDecorator.decorate(this);
        this.setPreferredSize(new Dimension(500, 40));
    }
    
    // METHODS
    private static Object[] returnAllBooks( int x)
    {
        Object[] books = new Object[x];
        DataBase db    = new DataBase();
        Book book;
        
        for ( int i = 0 ; i < x ; i++)
        {
            book = new Book( i);
            books[i] = book.getTitle();
        }
        return books; 
    }
}