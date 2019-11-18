import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TankerEnemy extends Enemy  {
    public TankerEnemy()
    {
        image = new Image("AssetsKit_1/shapes/te.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(60);
        imageView.setPreserveRatio(true);
        hp = 300;
        speed = 20000;
        armor = 25;
        reward = 30;
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
