package view;

import constants.UIColors;
import database.DataBase;
import ibdb.BookPageViewer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import model.Book;

/**
 *
 * @Author Ahmet Batu
 *
 * TopListPanel() : Creates a Top-List Panel with 4 different category.
 */

public class TopListPanel extends JPanel implements ActionListener
{
    // PROPERTIES
    private DefaultListModel defaultListModel;
    private FormButton       formButton1;
    private FormButton       formButton2;
    private FormButton       formButton3;
    private FormButton       formButton4;    
    private JLabel           headerLabel;
    private JLabel           statusLabel;
    private JPanel           categoryPanel;
    private JButton          showButton;
    private JList            bookList;
    private Book             book;
    private DataBase         db;
    private String username;
    
    private ArrayList<Integer> cat1List;
    private ArrayList<Integer> cat2List;
    private ArrayList<Integer> cat3List;
    private ArrayList<Integer> cat4List;
    
    //CONSTRUCTOR
    public TopListPanel(String username)
    {
        this.username = username;
        prepareGUI();
        showList();
    }
    
    // METHODS
    private void prepareGUI()
    {
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        
        statusLabel.setSize(200, 1000);
        
        setBackground(UIColors.NIGHTBLUE);
    }
    
    private void showList()
    {
        setLayout(new BorderLayout());
        headerLabel.setText("Control in action: JList");
        
        defaultListModel = new DefaultListModel();
        
        formButton1 = new FormButton("Novel");
        formButton2 = new FormButton("Science Fiction");
        formButton3 = new FormButton("Kids");
        formButton4 = new FormButton("Others");
        
        formButton1.setBackground(UIColors.NIGHTBLUE);
        formButton2.setBackground(UIColors.NIGHTBLUE);
        formButton3.setBackground(UIColors.NIGHTBLUE);
        formButton4.setBackground(UIColors.NIGHTBLUE);
        
        formButton1.addActionListener( this);
        formButton2.addActionListener( this);
        formButton3.addActionListener( this);
        formButton4.addActionListener( this);
        
        bookList = new JList( defaultListModel);
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bookList.setSelectedIndex(0);
        
        cat1List = (db.getAllGenre(formButton1.getText()));
        cat2List = (db.getAllGenre(formButton2.getText()));
        cat3List = (db.getAllGenre(formButton3.getText()));
        cat4List = (db.getAllGenre(formButton4.getText()));
        
        if (defaultListModel.size() > 20)
        {
            bookList.setVisibleRowCount(20);
        }
        else
        {
            bookList.setVisibleRowCount(defaultListModel.size());
        }
        
        JScrollPane bookListScrollPane = new JScrollPane(bookList);
        
        showButton = new FormButton("Show");
        showButton.setBackground(UIColors.NIGHTBLUE);
        showButton.setPreferredSize(new Dimension(200, 100));
        
        showButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource().equals( showButton))
                {
                    new BookPageViewer( (Book) bookList.getSelectedValue());
                }
            }
        });
        
        categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(2, 2));
        
        categoryPanel.add(formButton1);
        categoryPanel.add(formButton2);
        categoryPanel.add(formButton3);
        categoryPanel.add(formButton4);
        
        categoryPanel.setPreferredSize(new Dimension(300, 120));
        
        add(categoryPanel, BorderLayout.NORTH);
        add(bookListScrollPane, BorderLayout.CENTER);
        add(showButton, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource().equals(formButton1))
        {
            formButton1.setFont(new Font(null, 1, 15));
            formButton2.setFont(new Font(null, 1, 12));
            formButton3.setFont(new Font(null, 1, 12));
            formButton4.setFont(new Font(null, 1, 12));
            
            defaultListModel.removeAllElements();
            
            for(int i = 0 ; i < cat1List.size() ; i++)
            {
                book = new Book( cat1List.get(i));
                defaultListModel.addElement( book);
            }
        }
        else if ( e.getSource().equals(formButton2))
        {
            formButton2.setFont(new Font(null, 1, 15));
            formButton1.setFont(new Font(null, 1, 12));
            formButton3.setFont(new Font(null, 1, 12));
            formButton4.setFont(new Font(null, 1, 12));
            
            defaultListModel.removeAllElements();
            
            for(int i = 0 ; i < cat2List.size() ; i++)
            {
                book = new Book( cat2List.get(i));
                defaultListModel.addElement( book);
            }
        }
        else if ( e.getSource().equals(formButton3))
        {
            formButton3.setFont(new Font(null, 1, 15));
            formButton2.setFont(new Font(null, 1, 12));
            formButton1.setFont(new Font(null, 1, 12));
            formButton4.setFont(new Font(null, 1, 12));
            
            defaultListModel.removeAllElements();
            
            for(int i = 0 ; i < cat3List.size() ; i++)
            {
                book = new Book( cat3List.get(i));
                defaultListModel.addElement( book);
            }
        }
        else if ( e.getSource().equals(formButton4))
        {
            formButton4.setFont(new Font(null, 1,15));
            formButton1.setFont(new Font(null, 1, 12));
            formButton3.setFont(new Font(null, 1, 12));
            formButton2.setFont(new Font(null, 1, 12));
            
            defaultListModel.removeAllElements();
            
            for(int i = 0 ; i < cat4List.size() ; i++)
            {
                book = new Book( cat4List.get(i));
                defaultListModel.addElement( book);
            }
        }
    }
    public JButton getShowButton()
    {
        return showButton;
    }
    
    public Book getSelectedBookValue()
    {
        return (Book) bookList.getSelectedValue();
    }
    
    public void setUsername( String newUsername)
    {
        username = newUsername;
    }
}