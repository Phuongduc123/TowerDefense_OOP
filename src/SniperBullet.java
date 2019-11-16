import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SniperBullet extends Bullet {
    public SniperBullet()
    {
        dame = 55 ;
        range = 100 ;
        speed = 800;
        image = new Image("AssetsKit_1/shapes/150.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(5);
        imageView.setFitWidth(21);
    }
    public double getHeight() {
        return imageView.getFitHeight();
    }

    @Override
    public double getWidth() {
        return imageView.getFitWidth();
    }
}
