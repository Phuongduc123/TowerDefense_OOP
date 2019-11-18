import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class NormalEnemy extends Enemy {
    public NormalEnemy()
    {
        image = new Image("AssetsKit_1/shapes/232.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(30);
        imageView.setPreserveRatio(true);
        hp = 80;
        speed = 20000;
        armor = 5;
        reward = 4;
        healthMax = 80;
        healthBar = new HealthBar();

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
