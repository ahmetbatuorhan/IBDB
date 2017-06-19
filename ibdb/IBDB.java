package ibdb;

import static java.awt.Frame.MAXIMIZED_BOTH;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @Author Ahmet Batu ORHAN and Ýlkim GÜVEN
 * 
 */

public class IBDB {
 
    public static void main(String[] args) 
    {
        // VARIABLES
        FrameViewer frame;
        
        // PROGRAM
        frame = new FrameViewer("");
        
        frame.setExtendedState(MAXIMIZED_BOTH); 
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
