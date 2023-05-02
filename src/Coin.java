import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Coin extends JPanel {

    private int size = 20;

    public Coin() {
        setOpaque(false);
        setPreferredSize(new Dimension(size + 10, size + 10));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillOval(5, 5, size, size);
    }
}
