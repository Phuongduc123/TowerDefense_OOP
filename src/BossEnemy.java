import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BossEnemy extends Enemy {
    public BossEnemy() {
        image = new Image("AssetsKit_1/shapes/249.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(30);
        imageView.setPreserveRatio(true);
        hp = 2000 ;
        speed = 50000;
        armor = 20;
        reward = 110 ;
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
