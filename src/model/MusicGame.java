package model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

    public class MusicGame {
        String musicFile1 = "MusicGame/check.wav";
        String musicFile2 = "MusicGame/8_music.mp3";     // For example

        Media sound1 = new Media(new File(musicFile1).toURI().toString());
        Media sound2 = new Media(new File(musicFile2).toURI().toString());

        MediaPlayer mediaPlayer1 = new MediaPlayer(sound1);
        MediaPlayer mediaPlayer2 = new MediaPlayer(sound1);
        public MusicGame() {
            mediaPlayer1.play();
        }
        //MediaPlayer audio = new MediaPlayer(new Media(new File("file.mp3").toURI().toString()));
        public void MusicScene2(){
            mediaPlayer1.stop();
            mediaPlayer2.play();
        }
    }
