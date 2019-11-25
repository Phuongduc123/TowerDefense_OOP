import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MachineGunTower extends Tower {

    public MachineGunTower()
    {
        setImage();
    }
    private void setImage()
    {
        setImageRange(new Image("AssetsKit_1/shapes/108.png"));
        setImageBase(new Image("AssetsKit_1/shapes/Tower/mgB.png"));
        setImageGun(  new Image("AssetsKit_1/shapes/Tower/mg.png"));
        setImageViewRange( new ImageView(getImageRange()));
        setImageViewBase(new ImageView(getImageBase()));
        setImageViewGun( new ImageView(getImageGun()));

        getImageViewGun().setFitWidth(25);
        getImageViewGun().setFitHeight(65);
        getImageViewBase().setFitWidth(36);
        getImageViewBase().setFitHeight(43);
        getImageViewRange().setFitWidth(100);
        getImageViewRange().setFitHeight(100);
        setSpeed(20);
        setShootingRange(1000);
        setPrice(40);
        getImageViewGun().getTransforms().add(getRotate());
        setDame(100);
        getImageViewGun().setOnMouseEntered(mouseEvent -> getImageViewRange().setOpacity(1));
        getImageViewGun().setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getImageViewRange().setOpacity(0);
            }
        });


    }

    @Override
    public double getPosX() {
        return getImageViewBase().getLayoutX() + 18;
    }

    @Override
    public double getPosY() {
        return getImageViewBase().getLayoutY() + 21;
    }

    @Override
    public double getHeight() {
        return 36;
    }

    @Override
    public double getWidth() {
        return 43;
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
