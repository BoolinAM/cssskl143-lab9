import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyWindow extends JFrame implements MouseListener {

    public MyWindow() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(this); // Add the mouse listener to the frame
    }
    public static void main(String[] args) {
        MyWindow window = new MyWindow();
    }
    // Implementing MouseListener methods
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked");
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
    }
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited");
    }
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
    }
}