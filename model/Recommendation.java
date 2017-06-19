package model;

/**
 *
 * @Author Ahmet Batu
 * 
 */

public class Recommendation 
{
    // PROPERTIES
    private User recommender;
    private int rate;
    private String comment;
    
    // CONSTRUCTOR
    public Recommendation(User recommender, int rate, String comment) 
    {
        this.recommender = recommender;
        this.rate = rate;
        this.comment = comment;
    }
    
}
