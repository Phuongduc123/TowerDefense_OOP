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
        setImageRange(new Image("AssetsKit_1/shapes/108.png"));
        setImageBase(new Image("AssetsKit_1/shapes/Tower/nB.png"));
        setImageGun( new Image("AssetsKit_1/shapes/Tower/n.png"));
        setImageViewRange( new ImageView(getImageRange()));
        setImageViewBase(new ImageView(getImageBase()));
        setImageViewGun( new ImageView(getImageGun()));

        getImageViewGun().setFitWidth(25);
        getImageViewGun().setFitHeight(40);
        getImageViewBase().setFitWidth(30);
        getImageViewBase().setFitHeight(30);
        getImageViewRange().setFitWidth(140);
        getImageViewRange().setFitHeight(140);
        setSpeed(15);
        setShootingRange(700);
        setPrice(2);
        getImageViewGun().getTransforms().add(getRotate());
        setDame(500);
        getImageViewGun().setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getImageViewRange().setOpacity(1);
            }
        });
        getImageViewGun().setOnMouseExited(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
        getImageViewRange().setOpacity(0);
        }
        });
    }

    @Override
    public double getPosX() {
        return getImageViewBase().getLayoutX() + 15;
    }

    @Override
    public double getPosY() {
        return getImageViewBase().getLayoutY() + 15;
    }

    @Override
    public double getHeight() {
        return 30;
    }

    @Override
    public double getWidth() {
        return 30;
    }
    public ImageView getImageViewGun()
    {
        return super.getImageViewGun();
    }

    public ImageView getImageViewRange() {
        return super.getImageViewRange();
    }

    public ImageView getImageViewBase() {
        return super.getImageViewBase();
    }

}
