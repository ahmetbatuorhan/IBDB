package ibdb;

import database.CheckUser;
import database.DataBase;
import database.SignUp;
import database.readLater;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Book;
import model.User;
import view.FutureBooksPanel;
import view.LoginPanel;
import view.SettingsPanel;
import view.SignupPanel;
import view.TopListPanel;

/**
 *
 * @Author Ahmet Batu
 * 
 */

public class IBDBActionListener implements ActionListener 
{
    // PROPERTIES
    private final TopFixedPanelViewer topFixedPanel;
    private final HomePageViewer      homePageViewer;
    private final FrameViewer         frameViewer;
    private final LoginPanel          loginPanel;
    private final SettingsPanel       settingsPanel;
    private final TopListPanel        topListPanel;
    private final SignupPanel         signupPanel;
    private FutureBooksPanel          futureBooksPanel;
    
    
    private Book      book;
    private DataBase  db;
    private readLater rl;
    private CheckUser cu;
    private SignUp    su;
    private User      user;
    
    // CONSTRUCTOR
    public IBDBActionListener( FrameViewer frameViewer,
                               HomePageViewer  homePageViewer,
                               TopFixedPanelViewer topFixedPanel, 
                               TopListPanel topListPanel,
                               LoginPanel loginPanel,
                               SettingsPanel settingsPanel,
                               SignupPanel signupPanel)
    {  
        this.frameViewer    = frameViewer;
        this.homePageViewer = homePageViewer;
        this.topFixedPanel  = topFixedPanel;
        this.topListPanel   = topListPanel;
        this.loginPanel     = loginPanel;
        this.settingsPanel  = settingsPanel;
        this.signupPanel    = signupPanel;
        
        (topFixedPanel.getFutureReadingsButton()).addActionListener( this);
        (topFixedPanel.getIBDBButton()).addActionListener( this);
        (topFixedPanel.getLogoutButton()).addActionListener( this);
        (topFixedPanel.getSearchButton()).addActionListener(this);
        
        (loginPanel.getLoginButton()).addActionListener( this);
        (loginPanel.getSignInButton()).addActionListener( this);
        
        (signupPanel.getbackToLogInButton()).addActionListener( this);
        (signupPanel.getSignupButton()).addActionListener( this);
        
        (topListPanel.getShowButton()).addActionListener( this);
        
        loginPanel  = this.frameViewer.getLoginPanel();
        signupPanel = this.frameViewer.getSignupPanel();
        
        
    }
    
    // METHODS
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Open FutureReadings
        if( e.getSource().equals(topFixedPanel.getFutureReadingsButton()))
        {
            ArrayList<Book> books = new ArrayList<Book>();
            for ( int i = 0 ; i < rl.futureReading( LoginPanel.getUsername()).size() ; i++)
            {
                book = new Book((rl.futureReading( LoginPanel.getUsername())).get(i));
                books.add( book);
            }
            futureBooksPanel = new FutureBooksPanel(books, 0, (rl.futureReading( LoginPanel.getUsername())).size());
            frameViewer.remove();
            frameViewer.add(futureBooksPanel);
        }
        // Return Homepage
        else if( e.getSource().equals(topFixedPanel.getIBDBButton()))
        {
            frameViewer.remove();
            frameViewer.add( homePageViewer);
        }
        // Settings
        else if( e.getSource().equals(topFixedPanel.getLogoutButton()))
        {
            frameViewer.removeAll();
            frameViewer.add(loginPanel);
        }
        // Login Check
        else if( e.getSource().equals(loginPanel.getLoginButton()))
        {
            if ( ! cu.passCheck(loginPanel.getUsername(),loginPanel.getUserPassword()))
            {
                ImageIcon icon = new ImageIcon("logo.png");
                Image img = icon.getImage();
                Image imgResized = img.getScaledInstance(120, 50, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(imgResized);
                
                JOptionPane.showMessageDialog( new JFrame(),
                        "User ID and Pasword did not match",
                        "ID - PASSWORD MISSMATCH",
                        JOptionPane.ERROR_MESSAGE,
                        icon);
            }
            else
            {
                user = new User(loginPanel.getUsername(),loginPanel.getUserPassword());
                frameViewer.setUsername( user.getUsername() + "");
                homePageViewer.setUsername(user.getUsername() + "");
                topListPanel.setUsername(user.getUsername() + "");
                
                frameViewer.remove();
                frameViewer.add( topFixedPanel, BorderLayout.NORTH);
                frameViewer.add( homePageViewer);
            }
        }
        // Login page to Signin page
        else if( e.getSource().equals( loginPanel.getSignInButton()))
        {
            frameViewer.remove();
            frameViewer.add( signupPanel);
        }
        // Get back to login page from Signup page
        else if(e.getSource().equals( signupPanel.getbackToLogInButton()))
        {
            frameViewer.remove();
            frameViewer.add( loginPanel);
        }
        // Searching
        else if(e.getSource().equals( topFixedPanel.getSearchButton()))
        {
            for ( int i = 0 ; i < 15 ; i++)
            {
                System.out.println("for");
                if ( db.BookName(i + 1).equals(topFixedPanel.getSearchText()))
                {
                    System.out.println("if");
                    book= new Book(i + 1);
                    new BookPageViewer( book );
                }
            }
        }
        //Signin new user
        else if( e.getSource().equals(signupPanel.getSignupButton()))
        {
            if ( signupPanel.getTextEntryName().equals("")        ||
                    signupPanel.getTextEntrySurname().equals("")  ||
                    signupPanel.getTextEntryUsername().equals("") ||
                    signupPanel.getTextEntryPassword().equals("") ||
                    signupPanel.getTextEntryEmail().equals(""))
            {
                ImageIcon icon = new ImageIcon("logo.png");
                Image img = icon.getImage();
                Image imgResized = img.getScaledInstance(120, 50, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(imgResized);
                
                JOptionPane.showMessageDialog( new JFrame(),
                        "There are some empty fields. Please fill all of them",
                        "EMPTY FIELDS",
                        JOptionPane.ERROR_MESSAGE,
                        icon);
            }
            else
            {
                System.out.println(signupPanel.getTextEntryName() + "+" +
                        signupPanel.getTextEntrySurname()  + "+" +
                        signupPanel.getTextEntryUsername() +"+"+
                        signupPanel.getTextEntryPassword() +"+"+
                        signupPanel.getTextEntryEmail());
                
                su.SignUps(signupPanel.getTextEntryName(),
                        signupPanel.getTextEntrySurname(),
                        signupPanel.getTextEntryUsername(),
                        signupPanel.getTextEntryPassword(),
                        signupPanel.getTextEntryEmail());
                frameViewer.remove();
                frameViewer.add( loginPanel);
            }
        }
    }
    
    public User getUser()
    {
        return user;
    }
}
