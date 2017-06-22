import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class JTable extends JLabel implements Observer {
    private ArrayList<JKulka> kulksArray = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g) {
        for (JKulka kulka : kulksArray) {
            g.drawArc(kulka.getX(), kulka.getY(), kulka.getRadius(), kulka.getRadius(), 0, 360);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    public void update(Observable o, Object val) {
        kulksArray = (ArrayList<JKulka>) val;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

}