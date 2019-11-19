import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class NormalEnemy extends Enemy {
    public NormalEnemy()
    {
        image = new Image("AssetsKit_1/shapes/ne.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);
        hp = 100;
        speed = 15000;
        armor = 10;
        reward = 10;
        healthMax = 80;
        healthBar = new HealthBar(this);

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
