import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.File;

public class Tower implements GameTile{
    private double speed;

    private double shootingRange;
    private double dame;
    private int price;
    private int time;
    private Bullet bullet = null;
    private Image imageRange;
    private Image imageBase;
    private Image imageGun;
    private ImageView imageViewRange = new ImageView(imageRange);
    private ImageView imageViewBase = new ImageView(imageBase);
    private ImageView imageViewGun = new ImageView(imageGun);
    private Rotate rotate = new Rotate();
    public Tower()
    {
        setImage();
    }
    private void setImage()
    {
        imageViewGun.getTransforms().add(rotate);
    }

    @Override
    public double getPosX() {
        return imageViewBase.getLayoutX() + 18;
    }

    @Override
    public double getPosY() {
        return imageViewBase.getLayoutY() + 21;
    }

    @Override
    public double getHeight() {
        return 36 ;
    }

    @Override
    public double getWidth() {
        return 43;
    }
    public ImageView getImageViewGun()
    {
        return imageViewGun;
    }

    public ImageView getImageViewRange() {
        return imageViewRange;
    }

    public ImageView getImageViewBase() {
        return imageViewBase;
    }

    public double getDame() {
        return dame;
    }

    public double getSpeed() {
        return speed;
    }

    public double getShootingRange() {
        return shootingRange;
    }

    public int getPrice() {
        return price;
    }

    public Image getImageRange() {
        return imageRange;
    }

    public Image getImageBase() {
        return imageBase;
    }

    public Image getImageGun() {
        return imageGun;
    }

    public void setDame(double dame) {
        this.dame = dame;
    }

    public void setPrice(int gia) {
        this.price = gia;
    }

    public void setShootingRange(double shootingRange) {
        this.shootingRange = shootingRange;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setImageRange(Image imageRange) {
        this.imageRange = imageRange;
    }

    public void setImageBase(Image imageBase) {
        this.imageBase = imageBase;
    }

    public void setImageGun(Image imageGun) {
        this.imageGun = imageGun;
    }

    public void setImageViewRange(ImageView imageView2) {
        this.imageViewRange = imageView2;
    }

    public void setImageViewBase(ImageView imageViewBase) {
        this.imageViewBase = imageViewBase;
    }

    public void setImageViewGun(ImageView imageViewGun) {
        this.imageViewGun = imageViewGun;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    public Rotate getRotate()
    {
        return  rotate;
    }

    public void fire(AnchorPane pane, Enemy enemy, int []Money, Label moneyLabel)
    {
        Tower tower = this;
        /*final double[] t = {0};
        AnimationTimer animationTimer2 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                t[0] = t[0] + 1000;
                if (t[0] >= 20000) {*/
                    if (enemy.imageView.getBoundsInParent().intersects(getImageViewRange().getBoundsInParent())) {
                        if (pane.getChildren().contains(enemy.imageView)) {
                            double x1 = getPosX();
                            double y1 = getPosY();
                            double x2 = enemy.getPosX();
                            double y2 = enemy.getPosY();
                            double s = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                            s = Math.sqrt(s);
                            if (s <= tower.getShootingRange()) {
                                double vx = x2 - x1;
                                double vy = y2 - y1;
                                double anpha = 0;
                                anpha = (vx * 0 + vy * -1) / (Math.sqrt(vx * vx + vy * vy));
                                anpha = Math.acos(anpha);

                                anpha = anpha * 180 / Math.PI;
                                if (x2 <= x1) anpha = 360 - anpha;
                                if (tower instanceof NormalTower)
                                {
                                    bullet = new NormalBullet();
                                    bullet.setDame(tower.getDame());
                                }
                                if (tower instanceof  SniperTower)
                                {
                                     bullet = new SniperBullet();
                                     bullet.setDame(tower.getDame());
                                }
                                if (tower instanceof MachineGunTower) {
                                    bullet = new MachineGunBullet();
                                    bullet.setDame(tower.getDame());
                                }

                                bullet.imageView.setLayoutX(-50);
                                bullet.imageView.setLayoutY(-50);

                                PathTransition pathTransition = new PathTransition();
                                pathTransition.setDuration(Duration.millis(200));
                                pathTransition.setNode(bullet.imageView);
                                Path path = new Path();
                                MoveTo moveTo = new MoveTo(getPosX() + 25 * Math.sin(anpha * Math.PI / 180) + 50,getPosY() - 25 * Math.cos(anpha * Math.PI / 180) + 50);
                                //LineTo lineTo = new LineTo((enemy.getPosX() - bullet.imageView.getLayoutX()) ,(enemy.getPosY() - bullet.imageView.getLayoutY()) );
                                LineTo lineTo = new LineTo(getPosX() + bullet.range*1.5 * Math.sin(anpha * Math.PI / 180) + 50,getPosY() - bullet.range*1.5 * Math.cos(anpha * Math.PI / 180) + 50);
                                path.getElements().addAll(moveTo,lineTo);
                                pathTransition.setPath(path);
                                pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                                pathTransition.play();
                                pane.getChildren().add(bullet.imageView);

                                //pane.getChildren().remove(normalBullet.imageView);
                                Bullet finalBullet = bullet;
                                AnimationTimer animationTimer3 = new AnimationTimer() {
                                    @Override
                                    public void handle(long l) {
                                        double x = finalBullet.imageView.getTranslateX() + finalBullet.imageView.getLayoutX();
                                        double y = finalBullet.imageView.getTranslateY() + finalBullet.imageView.getLayoutY();
                                        double s = (x - getPosX()) * (x - getPosX()) + (y - getPosY()) * (y - getPosY());
                                        s = Math.sqrt(s);
                                        if (finalBullet.imageView.getBoundsInParent().intersects(enemy.imageView.getBoundsInParent()) && pane.getChildren().contains(finalBullet.imageView)) {
                                            pane.getChildren().remove(finalBullet.imageView);
                                            enemy.setHP(enemy.hp - finalBullet.dame + enemy.armor);
                                            //enemy.updateHealthBar();
                                            finalBullet.dame = 0;
                                            if (enemy.hp <= 0) {
                                                String src = "src/MusicGame/gun1.mp3";
                                                Media soundLose = new Media(new File(src).toURI().toString());
                                                MediaPlayer mediaPlayer = new MediaPlayer(soundLose);
                                                mediaPlayer.play();

                                                pane.getChildren().remove(enemy.imageView);
                                                pane.getChildren().remove(enemy.healthBar);
                                                //Money = Money + enemy.getPhanthuong();
                                                Money[0]= Money[0] + enemy.getReward();
                                                enemy.setReward(0);
                                                moneyLabel.setText("Money:" + Money[0]);
                                                //stop();
                                            }
                                            stop();
                                        }
                                        if (s >= finalBullet.range) {
                                            pane.getChildren().remove(finalBullet.imageView);
                                            stop();
                                        }

                                    }
                                };

                                animationTimer3.start();
                            }
                        }
                    }
    }
    public void onRotate(Enemy enemy)
    {
        double x1 = getPosX();
        double y1 = getPosY();
        double x2 = enemy.getPosX();
        double y2 = enemy.getPosY();
        double vx = x2 - x1;
        double vy = y2 - y1;
        double alpha = 0;
        alpha = (vx * 0 + vy * -1) / (Math.sqrt(vx * vx + vy * vy));
        alpha = Math.acos(alpha);

        alpha = alpha * 180 / Math.PI;
        if (x2 <= x1) alpha = 360 - alpha;
        rotate.setPivotX(getPosX() - getImageViewGun().getLayoutX());
        rotate.setPivotY(getPosY() - getImageViewGun().getLayoutY());
        rotate.setAngle(alpha);
    }
}
