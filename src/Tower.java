import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Tower implements GameTile{
    private double speed;

    private double shootingRange;
    private double dame;
    private int price;
    private int time;
    private Bullet bullet = null;
    private Image image2;
    private Image image3;
    private Image image4;
    private ImageView imageView2 = new ImageView(image2);
    private ImageView imageView3 = new ImageView(image3);
    private ImageView imageView4 = new ImageView(image4);
    private Rotate rotate = new Rotate();
    public Tower()
    {
        setImage();
    }
    private void setImage()
    {
        imageView4.getTransforms().add(rotate);
    }

    @Override
    public double getPosX() {
        return imageView3.getLayoutX() + 10.5;
    }

    @Override
    public double getPosY() {
        return imageView3.getLayoutY() + 10.5;
    }

    @Override
    public double getHeight() {
        return 21 ;
    }

    @Override
    public double getWidth() {
        return 21;
    }
    public ImageView getImageView4()
    {
        return imageView4;
    }

    public ImageView getImageView2() {
        return imageView2;
    }

    public ImageView getImageView3() {
        return imageView3;
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

    public Image getImage2() {
        return image2;
    }

    public Image getImage3() {
        return image3;
    }

    public Image getImage4() {
        return image4;
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

    public void setImage2(Image image2) {
        this.image2 = image2;
    }

    public void setImage3(Image image3) {
        this.image3 = image3;
    }

    public void setImage4(Image image4) {
        this.image4 = image4;
    }

    public void setImageView2(ImageView imageView2) {
        this.imageView2 = imageView2;
    }

    public void setImageView3(ImageView imageView3) {
        this.imageView3 = imageView3;
    }

    public void setImageView4(ImageView imageView4) {
        this.imageView4 = imageView4;
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
                    if (enemy.imageView.getBoundsInParent().intersects(getImageView2().getBoundsInParent())) {
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
                                //System.out.println(anpha);
                                anpha = Math.acos(anpha);

                                anpha = anpha * 180 / Math.PI;
                                //System.out.println(anpha);
                                if (x2 <= x1) anpha = 360 - anpha;
                                //if (x2 <= x1 && y2 >= y1) anpha = 180 + anpha;
                                //System.out.println(anpha);
                                //Bullet bullet = null;
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
                                //NormalBullet normalBullet = new NormalBullet();
                                //pane.getChildren().add(bullet.imageView);
                                //normalBullet.imageView.setLayoutX(normalTowerArrayList.get(0).getPosX());
                                //normalBullet.imageView.setLayoutY(normalTowerArrayList.get(0).getPosY() - 25);
                                //normalBullet.imageView.getTransforms().add(rotate1);
                                bullet.imageView.setLayoutX(-50);
                                bullet.imageView.setLayoutY(-50);
                                //bullet.imageView.setLayoutX(getPosX() + 25 * Math.sin(anpha * Math.PI / 180));
                                //bullet.imageView.setLayoutY(getPosY() - 25 * Math.cos(anpha * Math.PI / 180));
                                /*TranslateTransition translateTransition = new TranslateTransition();
                                translateTransition.setDuration(Duration.millis(300));
                                translateTransition.setNode(normalBullet.imageView);
                                translateTransition.setToX((enemy.getPosX() - normalBullet.imageView.getLayoutX()) * 10);
                                translateTransition.setToY((enemy.getPosY() - normalBullet.imageView.getLayoutY()) * 10);
                                translateTransition.play();*/
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
                                            finalBullet.dame = 0;
                                            if (enemy.hp <= 0) {
                                                pane.getChildren().remove(enemy.imageView);
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
                                //System.out.println(money2[0]);
                                //
                                //Moneylabel.setText("Monel: " + Money);


                                // if ( !(normalBullet.imageView.getBoundsInParent().intersects(normalTowerArrayList.get(0).getImageView2().getBoundsInParent())))
                                // {
                                //   pane.getChildren().remove(normalBullet.imageView);
                                // }
                                //Rotate rotate2 = new Rotate();
                                //rotate2.setAngle(360-anpha);
                                //rotate2.setPivotX(normalTowerArrayList.get(0).getPosX()-normalTowerArrayList.get(0).getImageView4().getLayoutX());
                                //rotate2.setPivotY(normalTowerArrayList.get(0).getPosY() - normalTowerArrayList.get(0).getImageView4().getLayoutY());
                                //normalTowerArrayList.get(0).getImageView4().getTransforms().add(rotate2);
                                /*final double[] t = {0};
                                final double[] finalAnpha = {anpha};
                                AnimationTimer animationTimer4 = new AnimationTimer() {
                                    @Override
                                    public void handle(long l) {
                                        t[0] = t[0] + 1;
                                        if (t[0] >= 10) {
                                            Rotate rotate2 = new Rotate();
                                            rotate2.setAngle(360 - finalAnpha[0]);
                                            rotate2.setPivotX(getPosX() - getImageView4().getLayoutX());
                                            rotate2.setPivotY(getPosY() - getImageView4().getLayoutY());
                                            getImageView4().getTransforms().add(rotate2);
                                            finalAnpha[0] = 0.0;
                                            stop();
                                        }
                                    }
                                };
                                //animationTimer4.start();*/

                            }

                        }
                    }
        //Bullet finalBullet = bullet;
        //AnimationTimer animationTimer3 = new AnimationTimer() {
        //@Override
        //public void handle(long l) {
        /*double x = finalBullet.imageView.getTranslateX() + finalBullet.imageView.getLayoutX();
        double y = finalBullet.imageView.getTranslateY() + finalBullet.imageView.getLayoutY();
        double s2 = (x - getPosX()) * (x - getPosX()) + (y - getPosY()) * (y - getPosY());
        s2 = Math.sqrt(s2);
        if (finalBullet.imageView.getBoundsInParent().intersects(enemy.imageView.getBoundsInParent()) && pane.getChildren().contains(finalBullet.imageView)) {
            pane.getChildren().remove(finalBullet.imageView);
            enemy.setHp(enemy.hp - finalBullet.dame + enemy.armor);
            finalBullet.dame = 0;
            //stop();
        }
        if (s2 >= finalBullet.tambay) {
            pane.getChildren().remove(finalBullet.imageView);
            //stop();
        }

        if (enemy.hp <= 0) {
            pane.getChildren().remove(enemy.imageView);
        }
                    /*if (t[0] >= 20000) t[0] = 0;


                }
                if ( enemy.imageView.getBoundsInParent().intersects(getImageView2().getBoundsInParent()) && ! (pane.getChildren().contains(enemy.imageView))) stop();
                //if ( !enemy.imageView.getBoundsInParent().intersects(getImageView2().getBoundsInParent())) stop();


            }


        };
        animationTimer2.start();*/
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
        rotate.setPivotX(getPosX() - getImageView4().getLayoutX());
        rotate.setPivotY(getPosY() - getImageView4().getLayoutY());
        rotate.setAngle(alpha);
    }
}
