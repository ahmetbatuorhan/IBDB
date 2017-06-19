package view;

import ibdb.BookPageViewer;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Book;

/**
 *
 * @Author Ahmet Batu
 * 
 * public ImagePanel(String imgStr, Book book) : This panel extends JPanel and 
 * contains pictures about Book. This Panel used in BookItemView.
 */

public class ImagePanel extends JPanel implements MouseListener
{
    // PROPERTIES
    private final  JButton   iconButton;
    private final  ImageIcon icon;
    private final  Book      book;
    private String username;
    
    // CONSTRUCTOR
    public ImagePanel(String imgStr, Book book, String username) 
    {
        this.username = username;
        this.book = book;
        this.setLayout(new BorderLayout());
        
        icon = new ImageIcon(imgStr);
        Image img = icon.getImage();
        
        Icon icon_resized = new ImageIcon( getScaledInstance(toBufferedImage(img),
                (int) (img.getWidth(this) / 1.2),
                (int) (img.getHeight(this) / 1.2),
                false));
        
        iconButton = new JButton(icon_resized);
        iconButton.setBorder(null);
        iconButton.setBackground(null);
        iconButton.addMouseListener(this);
        
        this.add(iconButton);
    }
    
    // METHODS
    @Override
    public void mouseEntered(MouseEvent e) 
    {
        if(e.getSource().equals(iconButton))
        {
            iconButton.setIcon(icon);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        if(e.getSource().equals(iconButton))
        {
            Image img = icon.getImage();
            Icon icon_resized = new ImageIcon( getScaledInstance(toBufferedImage(img), (int) (img.getWidth(this) / 1.2), (int) (img.getHeight(this) / 1.2), false));
            iconButton.setIcon(icon_resized);  
        }
    }
    
    // Resizing image without losing quality
    // External : http://stackoverflow.com/questions/7951290/re-sizing-an-image-without-losing-quality
    public BufferedImage getScaledInstance(BufferedImage img,
            int targetWidth,
            int targetHeight,
            boolean higherQuality)
    {
        int type = (img.getTransparency() == Transparency.OPAQUE) ?
                BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = (BufferedImage)img;
        int w, h;
        if (higherQuality)
        {
            // Use multi-step technique: start with original size, then
            // scale down in multiple passes with drawImage()
            // until the target size is reached
            w = img.getWidth();
            h = img.getHeight();
        }
        else
        {
            // Use one-step technique: scale directly from original
            // size to target size with a single drawImage() call
            w = targetWidth;
            h = targetHeight;
        }
        
        do
        {
            if (higherQuality && w > targetWidth)
            {
                w /= 2;
                if (w < targetWidth)
                {
                    w = targetWidth;
                }
            }
            
            if (higherQuality && h > targetHeight)
            {
                h /= 2;
                if (h < targetHeight)
                {
                    h = targetHeight;
                }
            }
            
            BufferedImage tmp = new BufferedImage(w, h, type);
            Graphics2D g2 = tmp.createGraphics();
            
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            
            g2.drawImage(ret, 0, 0, w, h, null);
            g2.dispose();
            
            ret = tmp;
        } while (w != targetWidth || h != targetHeight);
        
        return ret;
    }
    
    // Makes Image to Buffered Image
    // External : http://stackoverflow.com/questions/13605248/java-converting-image-to-bufferedimage
    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }
        
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        
        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        
        // Return the buffered image
        return bimage;
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        new BookPageViewer(book);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}
}
