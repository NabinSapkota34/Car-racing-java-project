import javax.sound.sampled.*;
public class Main {
    public static void main(String[] args) {
        String sound="backgroundMusic.wav";
        BackgroundMusic music =  new BackgroundMusic();
        music.setFile(sound);
        music.play();
//       CarGameGUI game = new CarGameGUI();
        Option frame = new Option();
    }
}