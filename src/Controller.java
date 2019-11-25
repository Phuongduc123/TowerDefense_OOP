import javafx.animation.*;
import javafx.geometry.Bounds;
import javafx.scene.*;
import javafx.scene.control.Label;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

public class Controller {
    @FXML
    private Button button;
    @FXML
    private AnchorPane p1;
    @FXML
    private AnchorPane p2;
    @FXML
    private Button button1;
    @FXML
    private ImageView imageView;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView imageVieweasy;
    @FXML
    private ImageView imageTest1;
    @FXML
    private ImageView imageTest2;
    @FXML
    private ImageView imageTest3;
    @FXML
    private ImageView imageTest4;
    @FXML
    private ImageView imageTest5;
    @FXML
    private AnchorPane paneE;
    @FXML
    private Button buttonNT;
    @FXML
    private Button nextLevel;
    @FXML
    private Button buttonST;
    @FXML
    private Button buttonMT;
    @FXML ImageView co;

    @FXML private Label Levellabel = new Label("Level");
    @FXML private Label Levels = new Label("0/10");
    @FXML private Label Livelabel = new Label("Live: 10");
    @FXML private Label healths  = new Label("25");
    @FXML private Label Moneylabel = new Label("Money: 70" );

    String src = "MusicGame/sound.mp3";

    Media media = new Media(new File(src).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);

    boolean isPlayed = false;

    final int []Money = {70};
    final int[] Live = {10};
    private ArrayList<Tower> normalTowerArrayList = new ArrayList<>();
    int Level = 0;
    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            for (int i = 0; i < normalTowerArrayList.size(); i++)
            {
                normalTowerArrayList.get(i).setTime(normalTowerArrayList.get(i).getTime() + 1);
                for (int j = 0; j < nextLevelGame.getNextLevel().get(Level-1).size(); j++)
                {
                    if (nextLevelGame.getNextLevel().get(Level - 1).get(j).imageView.getBoundsInParent().intersects(normalTowerArrayList.get(i).getImageViewRange().getBoundsInParent()) && pane.getChildren().contains(nextLevelGame.getNextLevel().get(Level-1).get(j).imageView)) {
                        //normalTowerArrayList.get(i).getImageView4().setRotate(Math.atan2(nextLevelgame.getNextlevel().get(Level-1).get(j).getPosY() - ));
                        normalTowerArrayList.get(i).onRotate(nextLevelGame.getNextLevel().get(Level - 1).get(j));
                        if (normalTowerArrayList.get(i).getTime() >= normalTowerArrayList.get(i).getSpeed()) {
                            normalTowerArrayList.get(i).fire(pane, nextLevelGame.getNextLevel().get(Level - 1).get(j), Money, Moneylabel);
                            normalTowerArrayList.get(i).setTime(0);
                        }
                        break;
                    }
                    if (Level == 10) {
                        Win();
                        break;
                    }
                }
            }
            for (int i = 0; i < nextLevelGame.getNextLevel().get(Level-1).size() ; i ++ )
            {
                if (pane.getChildren().contains(nextLevelGame.getNextLevel().get(Level-1).get(i).imageView) && !nextLevelGame.getNextLevel().get(Level - 1).get(i).imageView.getBoundsInParent().intersects(paneE.getBoundsInParent()))
                {
                    Live[0]-- ;
                    Livelabel.setText("Live: " + Live[0]);
                    pane.getChildren().remove(nextLevelGame.getNextLevel().get(Level-1).get(i).imageView);
                }
                if (Live[0] <= 0) {
                    GameOver();
                    break;
                }
            }


        }
    };

    NextLevel nextLevelGame = new NextLevel();

    public void setButtonPlay(javafx.event.ActionEvent actionEvent) throws Exception {

        //paneE.setOpacity(0);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        isPlayed = true;
        //paneE.setOpacity(0);

    }

    public void setButton1(javafx.event.ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        //imageView.setLayoutX(331);
        //imageView.setLayoutY(38);
        Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
        //imageView.setLayoutX(331);
        //imageView.setLayoutY(38);

        Image image = new Image("AssetsKit_1/shapes/232.png");
        ImageView imageView = new ImageView(image);

        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
        imageView.setFitWidth(20);
        imageView.setPreserveRatio(true);
        //imageView.setFitHeight(0);
        //imageView.setFitWidth(0);
        Rotate rotate = new Rotate();
        rotate.setAngle(180);
        rotate.setPivotX(0);
        rotate.setPivotY(0);
        imageView.getTransforms().add(rotate);


        Group group = new Group();
        group.getChildren().add(root);

        Scene scene = new Scene(group);
        stage.setScene(scene);

    }

    public void createNormalTower(MouseEvent mouseEvent) {
        //final  boolean []check = {true} ;

        NormalTower normalTower = new NormalTower();
        if (Money[0] >= normalTower.getPrice()) {

            ImageView imageViewBase = new ImageView(normalTower.getImageViewBase().getImage());
            imageViewBase.setFitWidth(36);
            imageViewBase.setFitHeight(43);
            ImageView imageViewGun = new ImageView(normalTower.getImageViewGun().getImage());
            imageViewGun.setFitWidth(25);
            imageViewGun.setFitHeight(65);
            ImageView imageViewRange = new ImageView(normalTower.getImageViewRange().getImage());
            imageViewRange.setFitWidth(140);
            imageViewRange.setFitHeight(140);

            pane.getChildren().addAll(imageViewBase, imageViewGun, imageViewRange);

            imageViewRange.setLayoutX(mouseEvent.getSceneX() - 70);
            imageViewRange.setLayoutY(mouseEvent.getSceneY() - 70);

            imageViewBase.setLayoutX(mouseEvent.getSceneX() - 36);
            imageViewBase.setLayoutY(mouseEvent.getSceneY() - 43);

            imageViewGun.setLayoutX(mouseEvent.getSceneX() - 30);
            imageViewGun.setLayoutY(mouseEvent.getSceneY() - 70);

            pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    imageViewRange.setLayoutX(mouseEvent.getSceneX() - 70);
                    imageViewRange.setLayoutY(mouseEvent.getSceneY() - 70);

                    imageViewBase.setLayoutX(mouseEvent.getSceneX() - 36);
                    imageViewBase.setLayoutY(mouseEvent.getSceneY() - 43);

                    imageViewGun.setLayoutX(mouseEvent.getSceneX() - 30);
                    imageViewGun.setLayoutY(mouseEvent.getSceneY() - 70);

                }
            });

            pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //boolean check = imageViewBase.getBoundsInParent().intersects(imageTest.getBoundsInParent());
                    /*
                    Bounds objA = imageViewBase.localToScene(imageViewBase.getBoundsInLocal());
                    Bounds objB = imageTest3.localToScene(imageTest3.getBoundsInLocal());

                    boolean check = objA.intersects(objB);
                    */
                    if (checkLocationCanCreate(imageViewBase)) {
                        pane.getChildren().addAll(normalTower.getImageViewBase(), normalTower.getImageViewRange(), normalTower.getImageViewGun());
                        normalTower.getImageViewRange().setLayoutX(mouseEvent.getSceneX() - 70);
                        normalTower.getImageViewRange().setLayoutY(mouseEvent.getSceneY() - 70);
                        normalTower.getImageViewBase().setLayoutX(mouseEvent.getSceneX() - 36);
                        normalTower.getImageViewBase().setLayoutY(mouseEvent.getSceneY() - 43);
                        normalTower.getImageViewGun().setLayoutX(mouseEvent.getSceneX() - 30);
                        normalTower.getImageViewGun().setLayoutY(mouseEvent.getSceneY() - 70);
                        normalTower.getImageViewRange().setOpacity(0);
                        pane.getChildren().removeAll(imageViewBase, imageViewGun, imageViewRange);
                    }
                }
            });

            TowerSetImageView(normalTower);
            normalTowerArrayList.add(normalTower);
            Money[0] = Money[0] - normalTower.getPrice();
            Moneylabel.setText("Money: " + Money[0]);
        }
    }

    public void createSniperTower(MouseEvent mouseEvent) {
        SniperTower sniperTower = new SniperTower();
        if ( Money[0] >= sniperTower.getPrice()) {
            ImageView imageViewBase = new ImageView(sniperTower.getImageViewBase().getImage());
            imageViewBase.setFitHeight(36);
            imageViewBase.setFitWidth(43);
            ImageView imageViewGun = new ImageView(sniperTower.getImageViewGun().getImage());
            imageViewGun.setFitWidth(25);
            imageViewGun.setFitHeight(65);
            ImageView imageViewRange = new ImageView(sniperTower.getImageViewRange().getImage());
            imageViewRange.setFitWidth(200);
            imageViewRange.setFitHeight(200);

            pane.getChildren().addAll(imageViewBase, imageViewGun, imageViewRange);
            imageViewRange.setLayoutX(mouseEvent.getSceneX() - 70);
            imageViewRange.setLayoutY(mouseEvent.getSceneY() - 70);
            imageViewBase.setLayoutX(mouseEvent.getSceneX() - 36);
            imageViewBase.setLayoutY(mouseEvent.getSceneY() - 43);
            imageViewGun.setLayoutX(mouseEvent.getSceneX() - 30);
            imageViewGun.setLayoutY(mouseEvent.getSceneY() - 70);

            pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    imageViewRange.setLayoutX(mouseEvent.getSceneX() - 100);
                    imageViewRange.setLayoutY(mouseEvent.getSceneY() - 100);
                    imageViewBase.setLayoutX(mouseEvent.getSceneX() - 36);
                    imageViewBase.setLayoutY(mouseEvent.getSceneY() - 43);
                    imageViewGun.setLayoutX(mouseEvent.getSceneX() - 30);
                    imageViewGun.setLayoutY(mouseEvent.getSceneY() - 70);

                }
            });

            pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (checkLocationCanCreate(imageViewBase)) {
                        pane.getChildren().addAll(sniperTower.getImageViewBase(), sniperTower.getImageViewRange(), sniperTower.getImageViewGun());
                        sniperTower.getImageViewRange().setLayoutX(mouseEvent.getSceneX() - 100);
                        sniperTower.getImageViewRange().setLayoutY(mouseEvent.getSceneY() - 100);
                        sniperTower.getImageViewBase().setLayoutX(mouseEvent.getSceneX() - 36);
                        sniperTower.getImageViewBase().setLayoutY(mouseEvent.getSceneY() - 43);
                        sniperTower.getImageViewGun().setLayoutX(mouseEvent.getSceneX() - 30);
                        sniperTower.getImageViewGun().setLayoutY(mouseEvent.getSceneY() - 70);
                        sniperTower.getImageViewRange().setOpacity(0);
                        pane.getChildren().removeAll(imageViewBase, imageViewGun, imageViewRange);
                        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                            }
                        });
                    }
                }
            });
            normalTowerArrayList.add(sniperTower);
            Money[0] = Money[0] - sniperTower.getPrice();
            Moneylabel.setText("Money: " + Money[0]);
        }
    }

    public void createMachineGunTower(MouseEvent mouseEvent) {

        MachineGunTower machineGunTower = new MachineGunTower();
        if ( Money[0] >= machineGunTower.getPrice()) {
            ImageView imageViewBase = new ImageView(machineGunTower.getImageViewBase().getImage());
            imageViewBase.setFitHeight(36);
            imageViewBase.setFitWidth(43);
            ImageView imageViewGun = new ImageView(machineGunTower.getImageViewGun().getImage());
            imageViewGun.setFitWidth(25);
            imageViewGun.setFitHeight(65);
            ImageView imageViewRange = new ImageView(machineGunTower.getImageViewRange().getImage());
            imageViewRange.setFitWidth(100);
            imageViewRange.setFitHeight(100);

            pane.getChildren().addAll(imageViewBase, imageViewGun, imageViewRange);
            imageViewRange.setLayoutX(mouseEvent.getSceneX() - 50);
            imageViewRange.setLayoutY(mouseEvent.getSceneY() - 50);
            imageViewBase.setLayoutX(mouseEvent.getSceneX() - 36);
            imageViewBase.setLayoutY(mouseEvent.getSceneY() - 43);
            imageViewGun.setLayoutX(mouseEvent.getSceneX() - 30);
            imageViewGun.setLayoutY(mouseEvent.getSceneY() - 70);

            pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    imageViewRange.setLayoutX(mouseEvent.getSceneX() - 50);
                    imageViewRange.setLayoutY(mouseEvent.getSceneY() - 50);
                    imageViewBase.setLayoutX(mouseEvent.getSceneX() - 36);
                    imageViewBase.setLayoutY(mouseEvent.getSceneY() - 43);
                    imageViewGun.setLayoutX(mouseEvent.getSceneX() - 30);
                    imageViewGun.setLayoutY(mouseEvent.getSceneY() - 70);

                }
            });

            pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (checkLocationCanCreate(imageViewBase)) {
                        pane.getChildren().addAll(machineGunTower.getImageViewBase(), machineGunTower.getImageViewRange(), machineGunTower.getImageViewGun());
                        machineGunTower.getImageViewRange().setLayoutX(mouseEvent.getSceneX() - 50);
                        machineGunTower.getImageViewRange().setLayoutY(mouseEvent.getSceneY() - 50);
                        machineGunTower.getImageViewBase().setLayoutX(mouseEvent.getSceneX() - 36);
                        machineGunTower.getImageViewBase().setLayoutY(mouseEvent.getSceneY() - 43);
                        machineGunTower.getImageViewGun().setLayoutX(mouseEvent.getSceneX() - 30);
                        machineGunTower.getImageViewGun().setLayoutY(mouseEvent.getSceneY() - 70);
                        machineGunTower.getImageViewRange().setOpacity(0);
                        pane.getChildren().removeAll(imageViewBase, imageViewGun, imageViewRange);
                    }
                }
            });
            Money[0] = Money[0] - machineGunTower.getPrice();
            Moneylabel.setText("Money: " + Money[0]);
            normalTowerArrayList.add(machineGunTower);
        }

    }

    public void nextLevel() {
        NormalEnemy normalEnemy = new NormalEnemy();
        pane.getChildren().add(normalEnemy.imageView);
        //pane.getChildren().add(normalEnemy.healthBar);
        normalEnemy.imageView.setLayoutX(0);
        normalEnemy.imageView.setLayoutY(0);

        Rotate rotate = new Rotate();
        rotate.setAngle(180);
        rotate.setPivotX(20);
        rotate.setPivotY(21 / (44.0 / 20.0) / 2);
        normalEnemy.imageView.getTransforms().add(rotate);

        MyPath myPath = new MyPath();

        Level++;
        final double[] t1 = {0};
        final int[] i1 = {0};
        AnimationTimer animationTimer5 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                t1[0] = t1[0] + 1;
                if (t1[0] >= 100) {
                    pane.getChildren().add(nextLevelGame.getNextLevel().get(Level - 1).get(i1[0]).imageView);
                    nextLevelGame.getNextLevel().get(Level - 1).get(i1[0]).imageView.setLayoutX(0);
                    nextLevelGame.getNextLevel().get(Level - 1).get(i1[0]).imageView.setLayoutY(0);

                    //nextLevelGame.getNextLevel().get(Level - 1).get(i1[0]).updateHealthBar();

                    PathTransition pathTransition = new PathTransition();
                    pathTransition.setNode(nextLevelGame.getNextLevel().get(Level - 1).get(i1[0]).imageView);
                    pathTransition.setDuration(Duration.millis(nextLevelGame.getNextLevel().get(Level-1).get(i1[0]).speed));
                    pathTransition.setPath(myPath.getPath());
                    pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                    pathTransition.setCycleCount(0);
                    pathTransition.setAutoReverse(false);
                    pathTransition.play();

                    i1[0]++;
                }

                if (i1[0] == nextLevelGame.getNextLevel().get(Level - 1).size()) {
                    stop();
                }
                if (t1[0] >= 100)
                    t1[0] = 0;

            }
        };
        animationTimer5.start();
        animationTimer.start();
        Levels.setText(Level + "/10");
}

    public void TowerSetImageView(Tower tower) {
        tower.getImageViewGun().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(tower.getPosX());
            }
        });
    }

    @FXML
    private void playSound() {
        mediaPlayer.play();
        if (isPlayed) {
            stopSound();
        }
        //mediaPlayer.setAutoPlay(true);
    }
    @FXML
    private void stopSound() {
        mediaPlayer.stop();
    }

    public void GameOver() {
        String src = "src/MusicGame/soundLose.mp3";
        Media soundLose = new Media(new File(src).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(soundLose);
        mediaPlayer.play();

        Image imageGO = new Image("AssetsKit_1/shapes/Test/GO.png");
        ImageView imageViewGO = new ImageView(imageGO);
        imageViewGO.setFitWidth(1280);
        imageViewGO.setFitHeight(720);
        pane.getChildren().add(imageViewGO);
    }

    public void Win() {
        Image imageGO = new Image("AssetsKit_1/shapes/Test/win.png");
        ImageView imageViewWin = new ImageView(imageGO);
        imageViewWin.setFitWidth(1280);
        imageViewWin.setFitHeight(720);
        pane.getChildren().add(imageViewWin);

        String src = "src/MusicGame/soundWin.mp3";
        Media soundWin = new Media(new File(src).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(soundWin);
        mediaPlayer.play();
    }

    boolean checkLocationCanCreate(ImageView imageView) {
        ArrayList<ImageView> road = new ArrayList<>();

        road.add(imageTest1);
        road.add(imageTest2);
        road.add(imageTest3);
        road.add(imageTest4);
        road.add(imageTest5);

        for ( int i = 0 ; i < road.size(); i ++ )
        {
            Bounds objA = imageView.localToScene(imageView.getBoundsInLocal());
            Bounds objB = road.get(i).localToScene(road.get(i).getBoundsInLocal());

            if (objA.intersects(objB)) return false;
        }

        for (int i = 0; i < normalTowerArrayList.size(); i++) {
            if (imageView.getBoundsInParent().intersects(normalTowerArrayList.get(i).getImageViewBase().getBoundsInParent())) {
                return false;
            }
        }
        return true;
    }
    @FXML
    public void Pause() {
        animationTimer.stop();
    }
    @FXML
    public void Start() {
        animationTimer.start();
    }

}
