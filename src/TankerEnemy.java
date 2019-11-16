import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TankerEnemy extends Enemy  {
    public TankerEnemy()
    {
        image = new Image("AssetsKit_1/shapes/237.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setPreserveRatio(true);
        hp = 1000 ;
        speed = 40000;
        armor = 15;
        reward = 40 ;
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
