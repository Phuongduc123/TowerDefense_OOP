import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SmallerEnemy extends Enemy {
    public SmallerEnemy()
    {
        image = new Image("AssetsKit_1/shapes/se.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(30);
        imageView.setPreserveRatio(true);
        hp = 50;
        speed = 10000;
        armor = 20;
        reward = 5;
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
