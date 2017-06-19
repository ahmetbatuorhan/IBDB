package model;

import java.util.ArrayList;

import database.DataBase;

/**
 *
 * @Author Ahmet Batu
 * 
 */

public class Book 
{
    //PROPERTIES
    private final String title;
    private final String author;
    private final String description;
    private final String genre;
    private final int    rate;
    private DataBase     db;
    private int          ID;
    
    // CONSTRUCTOR
    public Book( int ID)
    {
    	this.ID          = ID;
    	this.title       = db.BookName(ID);
    	this.author      = db.Author(ID);
        this.description = db.Statement(ID);
        this.genre       = db.genre(ID)+"";
        this.ID          = ID;
        this.rate        = db.rate(ID);        
    }
    
    // METHODS
    
    public String getTitle()
    {
        return title;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public String toString()
    {
        return title;
    }

    public int getID() 
    {
        return ID;
    }
    
    public int getRate()
    {
        return rate;
    }
    
}