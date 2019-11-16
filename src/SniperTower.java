import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SniperTower extends Tower {
    public SniperTower() {
        setImage();
    }
    private void setImage()
    {
        setImage2(new Image("AssetsKit_1/shapes/108.png"));
        setImage3(new Image("AssetsKit_1/shapes/103.png"));
        setImage4(new Image("AssetsKit_1/shapes/74.png"));
        setImageView2(new ImageView(getImage2()));
        setImageView3(new ImageView(getImage3()));
        setImageView4(new ImageView(getImage4()));

        getImageView4().setFitWidth(27);
        getImageView4().setFitHeight(13.5);
        getImageView3().setFitWidth(10.5*2);
        getImageView3().setFitHeight(10.5*2);
        getImageView2().setFitWidth(200);
        getImageView2().setFitHeight(200);
        setSpeed(40);
        setShootingRange(100);
        setPrice(50);
        getImageView4().getTransforms().add(getRotate());
        setDame(55);
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