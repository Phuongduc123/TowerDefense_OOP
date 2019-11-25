import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //MusicGame  musicGame = new MusicGame();

        /*
        mediaPlayer = new MediaPlayer(mp3MusicFile);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.5);
        */

        primaryStage.setTitle("Tower Defense");
        Scene scene = new Scene(root);
        //Image image = new Image("sample/AssetsKit_1/shapes/232.png");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
