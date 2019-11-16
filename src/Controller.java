import javafx.animation.*;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.*;
import javafx.scene.control.Label;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
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
    private ImageView imageTest;
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
    @FXML private Label Levels = new Label("0/30");
    @FXML private Label Livelabel = new Label("Live: 30");
    @FXML private Label healths  = new Label("25");
    @FXML private Label Moneylabel = new Label("Money: 70" );
    final int []Money = {70};
    final int[] Live = {30};
    private ArrayList<Tower> normalTowerArrayList = new ArrayList<>();
    int Level = 0;
    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            for (int i = 0 ; i < normalTowerArrayList.size() ; i ++)
            {
                normalTowerArrayList.get(i).setTime(normalTowerArrayList.get(i).getTime() + 1);
                for (int j = 0; j < nextLevelGame.getNextLevel().get(Level-1).size(); j++)
                {
                    if (nextLevelGame.getNextLevel().get(Level - 1).get(j).imageView.getBoundsInParent().intersects(normalTowerArrayList.get(i).getImageView2().getBoundsInParent()) && pane.getChildren().contains(nextLevelGame.getNextLevel().get(Level-1).get(j).imageView)) {
                        //normalTowerArrayList.get(i).getImageView4().setRotate(Math.atan2(nextLevelgame.getNextlevel().get(Level-1).get(j).getPosY() - ));
                        normalTowerArrayList.get(i).onRotate(nextLevelGame.getNextLevel().get(Level - 1).get(j));
                        if (normalTowerArrayList.get(i).getTime() >= normalTowerArrayList.get(i).getSpeed()) {
                            normalTowerArrayList.get(i).fire(pane, nextLevelGame.getNextLevel().get(Level - 1).get(j), Money, Moneylabel);

                            normalTowerArrayList.get(i).setTime(0);

                        }
                        break;
                    }
                }
            }
            for (int i = 0; i < nextLevelGame.getNextLevel().get(Level-1).size() ; i ++ )
            {
                if (pane.getChildren().contains(nextLevelGame.getNextLevel().get(Level-1).get(i).imageView)&&  ! nextLevelGame.getNextLevel().get(Level - 1).get(i).imageView.getBoundsInParent().intersects(co.getBoundsInParent()))
                {
                    Live[0] -- ;
                    Livelabel.setText("Live:" + Live[0]);
                    pane.getChildren().remove(nextLevelGame.getNextLevel().get(Level-1).get(i).imageView);
                }
            }
        }
    };
    NextLevel nextLevelGame = new NextLevel();

    public void test() {
        System.out.println("test");
    }

    public void play() {
        p1.setDisable(true);
        p1.setOpacity(0);
        p2.setDisable(false);
        p2.setOpacity(1);
    }

    public void setButtonPlay(javafx.event.ActionEvent actionEvent) throws Exception {

        //paneE.setOpacity(0);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //paneE.setOpacity(0);


    }

    public void setButton3(javafx.event.ActionEvent actionEvent) throws Exception {

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

    public void chay1(ImageView imageView, Path path, double X, double Y, double X1, double Y1) {
        MoveTo moveTo = new MoveTo(X, Y);
        LineTo lineTo = new LineTo(X1, Y1);
        LineTo lineTo1 = new LineTo(330, 150);
        LineTo lineTo2 = new LineTo(330, 150);
        path.getElements().addAll(moveTo, lineTo);
    }


    public void taothap(MouseEvent mouseEvent) {
        //final  boolean []check = {true} ;

        NormalTower normalTower = new NormalTower();
        if (Money[0] >= normalTower.getPrice()) {

            ImageView imageView1 = new ImageView(normalTower.getImageView3().getImage());
            imageView1.setFitHeight(21);
            imageView1.setFitWidth(21);
            ImageView imageView2 = new ImageView(normalTower.getImageView4().getImage());
            imageView2.setFitWidth(18);
            imageView2.setFitHeight(25);
            ImageView imageView3 = new ImageView(normalTower.getImageView2().getImage());
            imageView3.setFitWidth(140);
            imageView3.setFitHeight(140);

            pane.getChildren().addAll(imageView1, imageView2, imageView3);

            imageView3.setLayoutX(mouseEvent.getSceneX() - 70);
            imageView3.setLayoutY(mouseEvent.getSceneY() - 70);

            imageView1.setLayoutX(mouseEvent.getSceneX());
            imageView1.setLayoutY(mouseEvent.getSceneY());

            imageView2.setLayoutX(mouseEvent.getSceneX());
            imageView2.setLayoutY(mouseEvent.getSceneY());


            pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    imageView3.setLayoutX(mouseEvent.getSceneX() - 70);
                    imageView3.setLayoutY(mouseEvent.getSceneY() - 70);

                    imageView1.setLayoutX(mouseEvent.getSceneX() - 10.5);
                    imageView1.setLayoutY(mouseEvent.getSceneY() - 10.5);

                    imageView2.setLayoutX(mouseEvent.getSceneX() - 9);
                    imageView2.setLayoutY(mouseEvent.getSceneY() - 16.5);


                }
            });

            pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    MyPath myPath = new MyPath();
                    //boolean check = imageView1.getBoundsInParent().intersects(imageTest.getBoundsInParent());
                    Bounds objA = imageView1.localToScene(imageView1.getBoundsInLocal());
                    Bounds objB = imageTest.localToScene(imageTest.getBoundsInLocal());

                    boolean check = objA.intersects(objB);
                    /*
                    for (int i =0; i < normalTowerArrayList.size(); i++)
                    {
                        //System.out.println(normalTowerArrayList.size());
                        //System.out.println(imageView1.getBoundsInParent().intersects(normalTowerArrayList.get(i).getImageView3().getBoundsInParent()));
                        if (imageView1.getBoundsInParent().intersects(normalTowerArrayList.get(i).getImageView3().getBoundsInParent()))
                        {
                            check = false;
                        }
                    }
                    */

                    //System.out.println(imageView1.intersects(myPath.getBoundsInLocal()));
                    if (!check) {
                        pane.getChildren().addAll(normalTower.getImageView3(), normalTower.getImageView2(), normalTower.getImageView4());
                        normalTower.getImageView2().setLayoutX(mouseEvent.getSceneX() - 70);
                        normalTower.getImageView2().setLayoutY(mouseEvent.getSceneY() - 70);
                        normalTower.getImageView3().setLayoutX(mouseEvent.getSceneX() - 10.5);
                        normalTower.getImageView3().setLayoutY(mouseEvent.getSceneY() - 10.5);
                        normalTower.getImageView4().setLayoutX(mouseEvent.getSceneX() - 9);
                        normalTower.getImageView4().setLayoutY(mouseEvent.getSceneY() - 16.5);
                        normalTower.getImageView2().setOpacity(0);
                        pane.getChildren().removeAll(imageView1, imageView2, imageView3);
                    }
                    //check[0] = true;
                    //pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                      //  @Override
                      //  public void handle(MouseEvent mouseEvent) {

                      //  }
                    //});
                }
            });

            TowerSetImageView(normalTower);
            normalTowerArrayList.add(normalTower);
            Money[0] = Money[0] - normalTower.getPrice();
            Moneylabel.setText("Money: " + Money[0]);
        }

    }

    public void taothapST(MouseEvent mouseEvent) {
        SniperTower sniperTower = new SniperTower();
        if ( Money[0] >= sniperTower.getPrice()) {
            ImageView imageView1 = new ImageView(sniperTower.getImageView3().getImage());
            imageView1.setFitHeight(21);
            imageView1.setFitWidth(21);
            ImageView imageView2 = new ImageView(sniperTower.getImageView4().getImage());
            imageView2.setFitWidth(27);
            imageView2.setFitHeight(13.5);
            ImageView imageView3 = new ImageView(sniperTower.getImageView2().getImage());
            imageView3.setFitWidth(200);
            imageView3.setFitHeight(200);

            pane.getChildren().addAll(imageView1, imageView2, imageView3);
            imageView3.setLayoutX(mouseEvent.getSceneX() - 70);
            imageView3.setLayoutY(mouseEvent.getSceneY() - 70);
            imageView1.setLayoutX(mouseEvent.getSceneX());
            imageView1.setLayoutY(mouseEvent.getSceneY());
            imageView2.setLayoutX(mouseEvent.getSceneX());
            imageView2.setLayoutY(mouseEvent.getSceneY());

            pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    imageView3.setLayoutX(mouseEvent.getSceneX() - 100);
                    imageView3.setLayoutY(mouseEvent.getSceneY() - 100);
                    imageView1.setLayoutX(mouseEvent.getSceneX() - 10.5);
                    imageView1.setLayoutY(mouseEvent.getSceneY() - 10.5);
                    imageView2.setLayoutX(mouseEvent.getSceneX() - 13.5);
                    imageView2.setLayoutY(mouseEvent.getSceneY() - 6.75);

                }
            });

            pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    boolean check = true;
                    for (int i = 0; i < normalTowerArrayList.size(); i++) {
                        if (imageView1.getBoundsInParent().intersects(normalTowerArrayList.get(i).getImageView3().getBoundsInParent())) {
                            check = false;
                        }
                    }
                    if (check) {
                        pane.getChildren().addAll(sniperTower.getImageView3(), sniperTower.getImageView2(), sniperTower.getImageView4());
                        sniperTower.getImageView2().setLayoutX(mouseEvent.getSceneX() - 100);
                        sniperTower.getImageView2().setLayoutY(mouseEvent.getSceneY() - 100);
                        sniperTower.getImageView3().setLayoutX(mouseEvent.getSceneX() - 10.5);
                        sniperTower.getImageView3().setLayoutY(mouseEvent.getSceneY() - 10.5);
                        sniperTower.getImageView4().setLayoutX(mouseEvent.getSceneX() - 13.5);
                        sniperTower.getImageView4().setLayoutY(mouseEvent.getSceneY() - 6.75);
                        sniperTower.getImageView2().setOpacity(0);
                        pane.getChildren().removeAll(imageView1, imageView2, imageView3);
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

    public void taothapMT(MouseEvent mouseEvent) {

        MachineGunTower machineGunTower = new MachineGunTower();
        if ( Money[0] >= machineGunTower.getPrice()) {
            ImageView imageView1 = new ImageView(machineGunTower.getImageView3().getImage());
            imageView1.setFitHeight(21);
            imageView1.setFitWidth(21);
            ImageView imageView2 = new ImageView(machineGunTower.getImageView4().getImage());
            imageView2.setFitWidth(14);
            imageView2.setFitHeight(21.5);
            ImageView imageView3 = new ImageView(machineGunTower.getImageView2().getImage());
            imageView3.setFitWidth(100);
            imageView3.setFitHeight(100);

            pane.getChildren().addAll(imageView1, imageView2, imageView3);
            imageView3.setLayoutX(mouseEvent.getSceneX() - 50);
            imageView3.setLayoutY(mouseEvent.getSceneY() - 50);
            imageView1.setLayoutX(mouseEvent.getSceneX());
            imageView1.setLayoutY(mouseEvent.getSceneY());
            imageView2.setLayoutX(mouseEvent.getSceneX());
            imageView2.setLayoutY(mouseEvent.getSceneY());

            pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    imageView3.setLayoutX(mouseEvent.getSceneX() - 50);
                    imageView3.setLayoutY(mouseEvent.getSceneY() - 50);
                    imageView1.setLayoutX(mouseEvent.getSceneX() - 10.5);
                    imageView1.setLayoutY(mouseEvent.getSceneY() - 10.5);
                    imageView2.setLayoutX(mouseEvent.getSceneX() - 7);
                    imageView2.setLayoutY(mouseEvent.getSceneY() - 13.75);

                }
            });

            pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    boolean check = true;
                    for (int i = 0; i < normalTowerArrayList.size(); i++) {
                        if (imageView1.getBoundsInParent().intersects(normalTowerArrayList.get(i).getImageView3().getBoundsInParent())) {
                            check = false;
                        }
                    }
                    if (check) {
                        pane.getChildren().addAll(machineGunTower.getImageView3(), machineGunTower.getImageView2(), machineGunTower.getImageView4());
                        machineGunTower.getImageView2().setLayoutX(mouseEvent.getSceneX() - 50);
                        machineGunTower.getImageView2().setLayoutY(mouseEvent.getSceneY() - 50);
                        machineGunTower.getImageView3().setLayoutX(mouseEvent.getSceneX() - 10.5);
                        machineGunTower.getImageView3().setLayoutY(mouseEvent.getSceneY() - 10.5);
                        machineGunTower.getImageView4().setLayoutX(mouseEvent.getSceneX() - 7);
                        machineGunTower.getImageView4().setLayoutY(mouseEvent.getSceneY() - 13.75);
                        machineGunTower.getImageView2().setOpacity(0);
                        pane.getChildren().removeAll(imageView1, imageView2, imageView3);
                        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {

                            }
                        });
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
        normalEnemy.imageView.setLayoutX(0);
        normalEnemy.imageView.setLayoutY(0);
        Rotate rotate = new Rotate();
        rotate.setAngle(180);
        rotate.setPivotX(10);
        rotate.setPivotY(21 / (44.0 / 20.0) / 2);
        normalEnemy.imageView.getTransforms().add(rotate);

        MyPath myPath = new MyPath();
        //Path path = new Path();
        //PathTransition pathTransition = new PathTransition();
        /*chay1(normalEnemy.imageView, path,480, 45, 335, 45);
        chay1(normalEnemy.imageView, path,335, 80, 335, 125);
        chay1(normalEnemy.imageView, path,320, 125, 207, 125);
        chay1(normalEnemy.imageView, path,225, 110, 225, 45);
        chay1(normalEnemy.imageView, path,210, 50, 51, 50);
        chay1(normalEnemy.imageView, path,56, 70, 56, 225);
        chay1(normalEnemy.imageView, path, 75, 220, 445, 220);
        chay1(normalEnemy.imageView, path,440, 260, 440, 391);
        chay1(normalEnemy.imageView, path,420, 380, 335, 380);
        chay1(normalEnemy.imageView, path,345, 370, 345, 299);
        chay1(normalEnemy.imageView, path,320, 304, 220, 304);
        chay1(normalEnemy.imageView, path, 225, 330, 225, 390);
        chay1(normalEnemy.imageView, path,205, 375, -30, 375);*/
        /*MoveTo moveTo = new MoveTo(480, 45);
        LineTo lineTo1 = new LineTo(335, 45);
        LineTo lineTo2 = new LineTo(335, 125);
        LineTo lineTo3 = new LineTo(225, 125);
        LineTo lineTo4 = new LineTo(225, 48);
        LineTo lineTo5 = new LineTo(55, 48);
        LineTo lineTo6 = new LineTo(55, 220);
        LineTo lineTo7 = new LineTo(435, 220);
        LineTo lineTo8 = new LineTo(435, 380);
        LineTo lineTo9 = new LineTo(345, 380);
        LineTo lineTo10 = new LineTo(345, 305);
        LineTo lineTo11 = new LineTo(225, 305);
        LineTo lineTo12 = new LineTo(225, 380);
        LineTo lineTo13 = new LineTo(-30, 380);
        path.getElements().addAll(moveTo, lineTo1, lineTo2, lineTo3, lineTo4, lineTo5, lineTo6, lineTo7, lineTo8, lineTo9, lineTo10, lineTo11, lineTo12, lineTo13);*/
        /*pathTransition.setNode(normalEnemy.imageView);
        pathTransition.setDuration(Duration.millis(20000));
        pathTransition.setPath();
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(0);
        pathTransition.setAutoReverse(false);
        pathTransition.play();*/
        Level++;
        final double[] t1 = {0};
        final int[] i1 = {0};
        AnimationTimer animationTimer5 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                t1[0] = t1[0] + 1;
                if (t1[0] >= 30) {
                    pane.getChildren().add(nextLevelGame.getNextLevel().get(Level - 1).get(i1[0]).imageView);
                    nextLevelGame.getNextLevel().get(Level - 1).get(i1[0]).imageView.setLayoutX(0);
                    nextLevelGame.getNextLevel().get(Level - 1).get(i1[0]).imageView.setLayoutY(0);
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
                if (t1[0] >= 30) t1[0] = 0;

            }
        };
        //System.out.println(normalTowerArrayList.size());
        animationTimer5.start();
        animationTimer.start();
        Levels.setText(Level + "/30");

        //final int []i2 = {0};
        /*for ( int i = 0 ;i < normalTowerArrayList.size(); i ++)
        {
            final double[] t = {0};
            int finalI = i;
            AnimationTimer animationTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    t[0] = t[0] + 1;
                        for (int j = 0; j < nextLevelgame.getNextlevel().get(Level - 1).size(); j++) {
                            if (nextLevelgame.getNextlevel().get(Level - 1).get(j).imageView.getBoundsInParent().intersects(normalTowerArrayList.get(finalI).getImageView2().getBoundsInParent()) && pane.getChildren().contains(nextLevelgame.getNextlevel().get(Level-1).get(j).imageView)) {
                                if (t[0] >= 20) {
                                normalTowerArrayList.get(finalI).fire(pane, nextLevelgame.getNextlevel().get(Level - 1).get(j));

                                    t[0] = 0 ;
                            }
                                break;
                        }

                    }
                }
                };
                animationTimer.start();
        }*/

        /*AnimationTimer animationTimer1 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                //System.out.println(i2[0]);

                System.out.println(i2[0]);
                i2[0] ++;
                if ( i2[0] == normalTowerArrayList.size()  )
                {
                    //i2[0] = 0 ;
                    stop();
                }
            }
        };
        animationTimer1.start();*/
        //System.out.println(i2[0]);

        /*final double[] t = {0};
        AnimationTimer animationTimer2 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                t[0] = t[0] + 1000;
                if (t[0] >= 20000) {
                    if (normalEnemy.imageView.getBoundsInParent().intersects(normalTowerArrayList.get(0).getImageView2().getBoundsInParent())) {
                        if (pane.getChildren().contains(normalEnemy.imageView)) {
                            double x1 = normalTowerArrayList.get(0).getPosX();
                            double y1 = normalTowerArrayList.get(0).getPosY();
                            double x2 = normalEnemy.getPosX();
                            double y2 = normalEnemy.getPosY();
                            double s = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                            s = Math.sqrt(s);
                            if (s <= 70) {
                                double vx = x2 - x1;
                                double vy = y2 - y1;
                                double anpha = 0;
                                anpha = (vx * 0 + vy * -1) / (Math.sqrt(vx * vx + vy * vy));
                                //System.out.println(anpha);
                                anpha = Math.acos(anpha);

                                anpha = anpha * 180 / Math.PI;
                                //System.out.println(anpha);
                                if (x2 <= x1) anpha = 360 - anpha;
                                //if (x2 <= x1 && y2 >= y1) anpha = 180 + anpha;
                                System.out.println(anpha);
                                Rotate rotate1 = new Rotate();
                                rotate1.setAngle(anpha);
                                rotate1.setPivotX(normalTowerArrayList.get(0).getPosX() - normalTowerArrayList.get(0).getImageView4().getLayoutX());
                                rotate1.setPivotY(normalTowerArrayList.get(0).getPosY() - normalTowerArrayList.get(0).getImageView4().getLayoutY());
                                normalTowerArrayList.get(0).getImageView4().getTransforms().add(rotate1);
                                NormalBullet normalBullet = new NormalBullet();
                                pane.getChildren().add(normalBullet.imageView);
                                //normalBullet.imageView.setLayoutX(normalTowerArrayList.get(0).getPosX());
                                //normalBullet.imageView.setLayoutY(normalTowerArrayList.get(0).getPosY() - 25);
                                //normalBullet.imageView.getTransforms().add(rotate1);
                                normalBullet.imageView.setLayoutX(normalTowerArrayList.get(0).getPosX() + 25 * Math.sin(anpha * Math.PI / 180));
                                normalBullet.imageView.setLayoutY(normalTowerArrayList.get(0).getPosY() - 25 * Math.cos(anpha * Math.PI / 180));
                                TranslateTransition translateTransition = new TranslateTransition();
                                translateTransition.setDuration(Duration.millis(300));
                                translateTransition.setNode(normalBullet.imageView);
                                translateTransition.setToX((normalEnemy.getPosX() - normalBullet.imageView.getLayoutX()) * 10);
                                translateTransition.setToY((normalEnemy.getPosY() - normalBullet.imageView.getLayoutY()) * 10);
                                translateTransition.play();


                                //pane.getChildren().remove(normalBullet.imageView);
                                AnimationTimer animationTimer3 = new AnimationTimer() {
                                    @Override
                                    public void handle(long l) {
                                        double x = normalBullet.imageView.getTranslateX() + normalBullet.imageView.getLayoutX();
                                        double y = normalBullet.imageView.getTranslateY() + normalBullet.imageView.getLayoutY();
                                        double s = (x - normalTowerArrayList.get(0).getPosX()) * (x - normalTowerArrayList.get(0).getPosX()) + (y - normalTowerArrayList.get(0).getPosY()) * (y - normalTowerArrayList.get(0).getPosY());
                                        s = Math.sqrt(s);
                                        if (normalBullet.imageView.getBoundsInParent().intersects(normalEnemy.imageView.getBoundsInParent()) && pane.getChildren().contains(normalBullet.imageView)) {
                                            pane.getChildren().remove(normalBullet.imageView);
                                            normalEnemy.setHp(normalEnemy.hp - normalBullet.dame + normalEnemy.armor);
                                            normalBullet.dame = 0;
                                            stop();
                                        }
                                        if (s >= 70) {
                                            pane.getChildren().remove(normalBullet.imageView);
                                            stop();
                                        }

                                        if (normalEnemy.hp <= 0) {
                                            pane.getChildren().remove(normalEnemy.imageView);
                                        }
                                    }
                                };

                                animationTimer3.start();

                                // if ( !(normalBullet.imageView.getBoundsInParent().intersects(normalTowerArrayList.get(0).getImageView2().getBoundsInParent())))
                                // {
                                //   pane.getChildren().remove(normalBullet.imageView);
                                // }
                                //Rotate rotate2 = new Rotate();
                                //rotate2.setAngle(360-anpha);
                                //rotate2.setPivotX(normalTowerArrayList.get(0).getPosX()-normalTowerArrayList.get(0).getImageView4().getLayoutX());
                                //rotate2.setPivotY(normalTowerArrayList.get(0).getPosY() - normalTowerArrayList.get(0).getImageView4().getLayoutY());
                                //normalTowerArrayList.get(0).getImageView4().getTransforms().add(rotate2);
                                final double[] t = {0};
                                final double[] finalAnpha = {anpha};
                                AnimationTimer animationTimer4 = new AnimationTimer() {
                                    @Override
                                    public void handle(long l) {
                                        t[0] = t[0] + 1;
                                        if (t[0] >= 10) {
                                            Rotate rotate2 = new Rotate();
                                            rotate2.setAngle(360 - finalAnpha[0]);
                                            rotate2.setPivotX(normalTowerArrayList.get(0).getPosX() - normalTowerArrayList.get(0).getImageView4().getLayoutX());
                                            rotate2.setPivotY(normalTowerArrayList.get(0).getPosY() - normalTowerArrayList.get(0).getImageView4().getLayoutY());
                                            normalTowerArrayList.get(0).getImageView4().getTransforms().add(rotate2);
                                            finalAnpha[0] = 0.0;
                                            stop();
                                        }
                                    }
                                };
                                animationTimer4.start();

                            }

                        }
                    }
                    if (t[0] >= 20000) t[0] = 0;


                }


            }
        };
        animationTimer2.start();
        //System.out.println(normalEnemy.imageView.getTranslateX());
//        System.out.println(imageView.getLayoutX());
        //chay1(normalEnemy.imageView,path,320,30,320,114);
        if (Math.sqrt((normalEnemy.imageView.getTranslateX() - normalTowerArrayList.get(0).getPosX()) * (normalEnemy.imageView.getTranslateX() - normalTowerArrayList.get(0).getPosX()) + (normalEnemy.imageView.getTranslateY() - normalTowerArrayList.get(0).getPosY()) * (normalEnemy.imageView.getTranslateY() - normalTowerArrayList.get(0).getPosY())) < 0) {
            NormalBullet normalBullet = new NormalBullet();
            pane.getChildren().add(normalBullet.imageView);
        }
        if (normalEnemy.imageView.getBoundsInParent().intersects(normalTowerArrayList.get(0).getImageView2().getBoundsInParent())) {
            NormalBullet normalBullet = new NormalBullet();
            pane.getChildren().add(normalBullet.imageView);
            AnimationTimer animationTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    double t = 0;
                    t = t + 0.3;
                    if (t >= 0.3) {
                        double x1 = normalTowerArrayList.get(0).getPosX();
                        double y1 = normalTowerArrayList.get(0).getPosY();
                        double x2 = normalEnemy.getPosX();
                        double y2 = normalEnemy.getPosY();
                        NormalBullet normalBullet = new NormalBullet();
                        pane.getChildren().add(normalBullet.imageView);
                        normalBullet.imageView.setLayoutX(0);
                        normalBullet.imageView.setLayoutY(0);
                        t = 0;
                    }
                }
            };
        }*/
}




    public void TowerSetImageView(Tower tower) {
        tower.getImageView4().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(tower.getPosX());
            }
        });
    }

    public void setPane(MouseEvent mouseEvent)
    {
    }

    private void playAudio() {
        AudioClip note = new AudioClip(this.getClass().getResource(("8_music.mp3")).toString());
        note.play();
    }
}
