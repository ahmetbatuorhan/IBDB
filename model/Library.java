package model;

import java.util.ArrayList;

/**
 *
 * @Author Ahmet Batu
 * 
 */

public class Library 
{
    // PROPERTIES
    private String libraryName;
    private ArrayList<Book> content;
    
    // CONSTRUCOTOR
    public Library(String libraryName) 
    {
        this.libraryName = libraryName;
        content = new ArrayList<Book>();
    }
    
    // METHODS
    private void addBook(Book b) 
    {
        content.add(b);
    }
}
