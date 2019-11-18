import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BossEnemy extends Enemy {
    public BossEnemy() {
        image = new Image("AssetsKit_1/shapes/boss.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(70);
        imageView.setPreserveRatio(true);
        hp = 1000;
        speed = 5000;
        armor = 50;
        reward = 50;
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
