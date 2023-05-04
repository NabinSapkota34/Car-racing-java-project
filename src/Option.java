import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Option implements ActionListener {
    private JButton play = new JButton("Start");
    private JButton exit = new JButton("Exit");
    public JFrame frame = new JFrame("Car Racing");
    ImageIcon imageIcon = new ImageIcon("background.jpg");
    Image image = imageIcon.getImage().getScaledInstance(360,545,Image.SCALE_SMOOTH);

    JLabel background = new JLabel(new ImageIcon(image));


    public Option(){

        play.setBounds(120,120,100,40);
        exit.setBounds(120,180,100,40);
        play.addActionListener(this::actionPerformed);
        exit.addActionListener(this::actionPerformed);
//        JLabel backgroundImg = new JLabel("", new ImageIcon("background.jpg"),JLabel.CENTER);
        frame.add(background);
        background.setBounds(0,0,360,545);


        frame.setLayout(null);
        frame.add(play);
        frame.add(exit);

        frame.setSize(360,545);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play)
        {
            frame.dispose();
            CarGameGUI carGameGUI = new CarGameGUI();
        }
        if (e.getSource() == exit)
        {
            frame.dispose();
        }

    }
}
