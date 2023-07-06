import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Over {
    JFrame frame = new JFrame("2D Car Game");
    JLabel text = new JLabel("GameOver");
    JButton button = new JButton("Replay");
    int previousScore, compare;
    char[] t= new char[50];

    public Over(int score){
        try {
//            FileReader fileReader = new FileReader("Sudarshan.txt");
//            fileReader.read(t);
//            previousScore = Integer.parseInt(String.valueOf(t));
//            fileReader.close();
//            if(previousScore<score){
                FileWriter fileWriter = new FileWriter("Sudarshan.txt");
                fileWriter.write(score);
                fileWriter.close();
                previousScore = score;
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        text.setForeground(Color.RED);
        text.setFont(new Font("Arial", Font.BOLD, 40));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setBounds(0, 150, 360, 40);

        JLabel highScore = new JLabel("Highscore: "+previousScore);
        highScore.setForeground(Color.RED);
        highScore.setFont(new Font("Arial", Font.BOLD,40));
        highScore.setHorizontalAlignment(SwingConstants.CENTER);
        highScore.setVerticalAlignment(SwingConstants.CENTER);
        highScore.setBounds(0,230,360,40);

        JLabel currentScore = new JLabel("Your score: "+score);
        currentScore.setForeground(Color.RED);
        currentScore.setFont(new Font("Arial", Font.BOLD, 40));
        currentScore.setHorizontalAlignment(SwingConstants.CENTER);
        currentScore.setVerticalAlignment(SwingConstants.CENTER);
        currentScore.setBounds(0, 190, 360, 40);

        button.setBounds(120, 270, 120, 30);
        button.setFocusable(false);
        button.addActionListener(e -> {
            Option obj = new Option();
            frame.setVisible(false);
            frame.dispose();
        });

        frame.setLayout(null);
        frame.add(currentScore);
        frame.add(text);
        frame.add(highScore);
        frame.add(button);
        frame.setSize(360,545);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
