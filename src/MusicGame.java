import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MusicGame {
    private Media media;
    public MediaPlayer mediaPlayer;
    /*
    private String path;

    public void setPath(String path) {
        this.path = path;
    }
    */
    public MusicGame(String path) {
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
    }
    //mediaPlayerOpen.play();
    public void playMusic(){
        mediaPlayer.play();
    }
    public void stopMusic(){
        mediaPlayer.stop();
    }
}
