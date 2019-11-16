import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SmallerEnemy extends Enemy {
    public SmallerEnemy()
    {
        image = new Image("AssetsKit_1/shapes/246.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setPreserveRatio(true);
        hp = 70 ;
        speed = 15000;
        armor = 2;
        reward = 5 ;
    }

    @Override
    public double getWidth() {
        return imageView.getFitWidth();
    }

    @Override
    public double getHeight() {
        return imageView.getFitHeight();
    }
}
