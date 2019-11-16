import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NormalEnemy extends Enemy {
    public NormalEnemy()
    {
        image = new Image("AssetsKit_1/shapes/232.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(30);
        imageView.setPreserveRatio(false);
        hp = 80 ;
        speed = 20000;
        armor = 5;
        reward = 4 ;
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
