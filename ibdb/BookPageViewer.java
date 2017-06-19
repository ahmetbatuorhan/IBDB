package ibdb;

import constants.UIColors;
import database.DataBase;
import database.Rate;
import database.readLater;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
import model.Book;
import view.FormButton;
import view.LoginPanel;

/**
 *
 * @Author Ahmet Batu
 */

public class BookPageViewer extends JFrame implements ActionListener
{
    // PROPERTIES
    private Book book;
    
    private JPanel     exteriorPanel;
    private JPanel     interiorPanel;
    private JButton    tumbsUpButton;
    private JButton    tumbsDownButton;
    private FormButton urlButton;
    private FormButton readListButton;
    private DataBase   db;
    private readLater  rl;
    private Rate       rate;
    private JLabel     rateLabel;
    
    // CONSTRUCTOR
    public BookPageViewer( Book book)
    {
        this.book = book;
        //this.username = username;
        this.setLocation(300,100);
        this.setSize(800, 600);
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        
        creatingBookPageViewer();
        this.setVisible(true);
    }
    
    
    // METHODS
    public void creatingBookPageViewer()
    {
        this.setLayout(new GridLayout(1,2));
        this.add(creatingLeftPanel());
        this.add(creatingRightPanel());
    }
    
    // METHODS
    public JPanel creatingRightPanel()
    {
        exteriorPanel = new JPanel();
        interiorPanel = new JPanel();
        
        tumbsUpButton   = new JButton();
        tumbsDownButton = new JButton();
        
        exteriorPanel.setPreferredSize(new Dimension(600, 600));
        exteriorPanel.setBackground(UIColors.NIGHTBLUE);
        
        interiorPanel.setLayout(new GridLayout(8,1));
        interiorPanel.setBackground(UIColors.NIGHTBLUE);
        interiorPanel.setPreferredSize(new Dimension(300, 550));
        
        JLabel signinLabel = new JLabel("BOOK INFORMATION");
        signinLabel.setForeground(Color.WHITE);
        signinLabel.setFont(new Font(signinLabel.getFont().getName(), Font.PLAIN, 18));
        interiorPanel.add(signinLabel);
        
        JLabel title   = new JLabel("TITLE : "  + book.getTitle());
        JLabel author  = new JLabel("Author : " + book.getAuthor());
        JLabel genre   = new JLabel("GENRE : "  + book.getGenre());
        rateLabel      = new JLabel("RATE : "   + book.getRate());
       
        title.setForeground(Color.WHITE);
        author.setForeground(Color.WHITE);
        genre.setForeground(Color.WHITE);
        rateLabel.setForeground(Color.WHITE);
        
        interiorPanel.add(title);
        interiorPanel.add(author);
        interiorPanel.add(genre);
        interiorPanel.add(rateLabel);
        
        // Resizing tumbsUp icon
        ImageIcon iconTumbsUp = new ImageIcon("tumbsUp_icon.png");
        Image imgTumbsUp = iconTumbsUp.getImage();
        Image imgResizedTumbsUp = imgTumbsUp.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
        iconTumbsUp = new ImageIcon(imgResizedTumbsUp);
        
        // Adding tumbsUp icon to the Button
        tumbsUpButton = new JButton(iconTumbsUp);
        tumbsUpButton.setBackground(UIColors.NIGHTBLUE);
        tumbsUpButton.setBorder(null);
        tumbsUpButton.addActionListener(this);
        
        // Resizing tumbsDown icon
        ImageIcon iconDownsUp = new ImageIcon("tumbsDown_icon.png");
        Image imgTumbsDown = iconDownsUp.getImage();
        Image imgResized = imgTumbsDown.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
        iconTumbsUp = new ImageIcon(imgResized);
        
        // Adding tumbsDown icon to the Button
        tumbsDownButton = new JButton(iconTumbsUp);
        tumbsDownButton.setBackground(UIColors.NIGHTBLUE);
        tumbsDownButton.setBorder(null);
        tumbsDownButton.addActionListener(this);
        
        JPanel ratePanel = new JPanel();
        ratePanel.setBackground(UIColors.NIGHTBLUE);
        
        ratePanel.add(tumbsUpButton);
        ratePanel.add(buildMargin(50));
        ratePanel.add(tumbsDownButton);
        interiorPanel.add(ratePanel);
        
        // ReadList Button
        JPanel readListPanel = new JPanel();
        readListButton = new FormButton("ADD TO READ LIST");
        readListButton.setPreferredSize(new Dimension(270, 50));
        readListPanel.add(readListButton);
        readListPanel.setBackground(null);
        readListButton.setPreferredSize(new Dimension(270, 50));
        readListButton.addActionListener(this);
        
        // URL Button
        JPanel urlPanel = new JPanel();
        urlButton = new FormButton("BUY");
        urlButton.setPreferredSize(new Dimension(270, 50));
        urlButton.setPreferredSize(new Dimension(270, 50));
        urlPanel.add(urlButton);
        urlPanel.setBackground(null);
        urlButton.setPreferredSize(new Dimension(270, 50));
        urlButton.addActionListener(this);
        
        // Adding everything to the Panels
        interiorPanel.add(readListPanel);
        interiorPanel.add(urlPanel);
        exteriorPanel.add(interiorPanel);
        
        return exteriorPanel;
    }
    
    public JPanel creatingLeftPanel()
    {
        JPanel leftPanel     = new JPanel();
        JTextPane textPane = new JTextPane();
        JLabel topLeftLabel = new JLabel();
        JPanel topLeftPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(textPane);
        
        topLeftLabel.setBackground(UIColors.NIGHTBLUE);
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(new ImageIcon("bookPictures/" + book.getID() + ".jpg"));
        
        //ImageIcon icon = new ImageIcon(image)
        
        //topLeftLabel.add( imgLabel);
        topLeftPanel.add(imgLabel);
        topLeftPanel.setBackground(UIColors.NIGHTBLUE);
        
        textPane.setBackground(UIColors.NIGHTBLUE);
        textPane.setFont(new Font(textPane.getFont().getName(), Font.PLAIN, 18));
        scrollPane.setForeground(Color.WHITE);
        textPane.setForeground(Color.WHITE);
        
        //textPane.insertIcon(new ImageIcon("bookPictures.1.jpg"));
        textPane.setText("\n" + "     SUMMARY : " + "\n" + "\n" + "   " + db.Statement(book.getID()));
        textPane.setFont(new Font(textPane.getFont().getName(), Font.ITALIC, 16));
        textPane.setEditable(false);
        textPane.setCaretPosition(0);
        
        leftPanel.setLayout( new GridLayout(2,1));
        
        scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize( new Dimension(10,10));
        
        leftPanel.add(topLeftPanel);
        leftPanel.add(scrollPane);
        return leftPanel;
    }    
    
     public static JPanel buildMargin(int x) 
    {
        JPanel marginPanel = new JPanel();
        marginPanel.setPreferredSize(new Dimension(x, 40));
        marginPanel.setBackground(null);
        marginPanel.setBorder(null);
        return marginPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource().equals( tumbsUpButton))
        {
            rate.RatePlus( book.getID());
            rateLabel.setText("RATE : "   + ( book.getRate() + 1)); 
            revalidate();
            repaint();
            
        }
        else if(e.getSource().equals( tumbsDownButton))
        {
            rate.RateMinus( book.getID());
            rateLabel.setText("RATE : "   + ( book.getRate() - 1)); 
            revalidate();
            repaint();
        }
        else if(e.getSource().equals(urlButton))
        {
            try {
                openWebpage(new URL(db.getLink(book.getID())));
            } catch (MalformedURLException ex) {
                Logger.getLogger(BookPageViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource().equals(readListButton))
        {
        	
        	System.out.println(LoginPanel.getUsername());
        	System.out.println(book.getID());
            //System.out.println(username + " + " + book.getID());
            rl.readBookLater(LoginPanel.getUsername(), book.getID());
        }
    }
    
    // External : http://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // External : http://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button
    public static void openWebpage(URL url)
    {
        try 
        {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) 
        {
            e.printStackTrace();
        }
    }
    
    public JButton getReadListButton()
    {
        return readListButton;
    }
    
    public void changeBook(Book b)
    {
        this.book = b;
    }
}
