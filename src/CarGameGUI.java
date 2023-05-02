import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CarGameGUI {
    JFrame fr = new JFrame("Car racing");
    JPanel controlPanel = new JPanel();
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");

    JPanel carPanel = new JPanel();
    JLabel coin = new JLabel();
    CarHandler hnd = new CarHandler(this);
    int speed;
    int width;
    int height;
    int score = 0;
    Timer coinTimer;
    CarGameGUI(){
           speed = 20;
           width= 360;
           height = 545;
        initGUI();
    }
    public void initGUI(){

        carPanel.setOpaque(false);
        carPanel.setSize(100,200);
        fr.setLayout(null);
        //adding image and creating a label
        JLabel car = new JLabel(new ImageIcon(new ImageIcon("carr.png").getImage().getScaledInstance(95, 130, Image.SCALE_DEFAULT)));
        JLabel background = new JLabel("", new ImageIcon("back.gif"),JLabel.CENTER);
        fr.add(background);
        background.setBounds(0,0,width,height);
        carPanel.add(car);
        carPanel.setLocation(220,350);
//        carPanel.setBackground(Color.red);
        Color carBg = Color.decode("#414141");
        carPanel.setBackground(carBg);
        background.add(carPanel);
        // set up coin
        coin.setSize(30, 30);
        coin.setBackground(Color.YELLOW);
        coin.setOpaque(true);
        coin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        coin.setLocation((int) (Math.random() * (width - coin.getWidth())), 50);
        background.add(coin);

        // set up timer to generate coin
        // set up timer to generate coin
        coinTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int coinY = rand.nextInt(400) + 50;
                coin.setLocation((int) (Math.random() * (width - coin.getWidth())), coinY);
                coin.setVisible(true);
            }
        });
        coinTimer.start();


        // add collision detection for coin and car
// add collision detection for coin and car
        JLabel scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scoreLabel.setBounds(10, 10, 100, 20);
        background.add(scoreLabel);

        // add collision detection for coin and car
// add collision detection for coin and car
        // add collision detection for coin and car
        Timer collisionTimer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle carBounds = carPanel.getBounds();
                Rectangle coinBounds = coin.getBounds();
                if (carBounds.intersects(coinBounds)) {
                    score++;
                    scoreLabel.setText("Score: " + score); // update score label
                    System.out.println("Score: " + score);
                    coin.setVisible(false);
                    coin.setLocation(-100, -100); // set coin location offscreen
                }
            }
        });
        collisionTimer.start();




        fr.setSize(width,height);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(hnd);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
