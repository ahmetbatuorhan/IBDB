package model;

import java.util.ArrayList;

/**
 *
 * @Author Ahmet Batu
 * 
 */

public class User 
{
    // PROPERTIES
    public static String name = "batu";
    private String surname;
    private String username;
    private String password;
    private String email;
    private ArrayList<Book> ownedBooks;
    
    // CONSTRUCTORS
    public User (String name, String surname, String username, String password, String email) 
    {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        ownedBooks = new ArrayList<Book>();
    }
    
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        ownedBooks = new ArrayList<Book>();
    }
    
    public User() 
    {
        this.username = "n/a";
        this.password = "123456";
        ownedBooks = new ArrayList<Book>();
    }
    
    // METHODS
    public void addBook(Book b) 
    {
        ownedBooks.add(b);
    }
    
    public void removeBook(Book b) 
    {
        ownedBooks.remove(b);
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setName( String s)
    {
        username = s;
    }
}
