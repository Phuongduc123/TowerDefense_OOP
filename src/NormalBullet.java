import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class NormalBullet extends Bullet {
    public NormalBullet()
    {
        dame = 35;
        range = 70;
        speed = 400;
        image = new Image("AssetsKit_1/shapes/Tower/nBullet.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
    }
    public double getHeight() {
        return imageView.getFitHeight();
    }

    @Override
    public double getWidth() {
        return imageView.getFitWidth();
    }
}
