import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class NormalTower extends Tower {
    public NormalTower()
    {
        setImage();
    }
    private void setImage()
    {
        setImage2(new Image("AssetsKit_1/shapes/108.png"));
        setImage3(new Image("AssetsKit_1/shapes/Gun_01_B.png"));
        setImage4( new Image("AssetsKit_1/shapes/Gun_06.png"));
        setImageView2( new ImageView(getImage2()));
        setImageView3 (new ImageView(getImage3()));
        setImageView4( new ImageView(getImage4()));

        getImageView4().setFitWidth(18);
        getImageView4().setFitHeight(25);
        getImageView3().setFitWidth(10.5*2);
        getImageView3().setFitHeight(10.5*2);
        getImageView2().setFitWidth(140);
        getImageView2().setFitHeight(140);
        setSpeed(20);
        setShootingRange(70);
        setPrice(20);
        getImageView4().getTransforms().add(getRotate());
        setDame(35);
        getImageView4().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getImageView2().setOpacity(1);
            }
        });
        getImageView4().setOnMouseExited(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
        getImageView2().setOpacity(0);
        }
        });
    }

    @Override
    public double getPosX() {
        return getImageView3().getLayoutX() + 10.5;
    }

    @Override
    public double getPosY() {
        return getImageView3().getLayoutY() + 10.5;
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
        return super.getImageView4();
    }

    public ImageView getImageView2() {
        return super.getImageView2();
    }

    public ImageView getImageView3() {
        return super.getImageView3();
    }

}
