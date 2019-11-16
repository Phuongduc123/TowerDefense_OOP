import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Bullet implements GameEntity {
    protected double range;
    protected double speed;
    protected double dame ;
    protected Image image ;
    protected javafx.scene.image.ImageView imageView;
    @Override
    public double getPosX() {
        return imageView.getTranslateX();
    }

    @Override
    public double getPosY() {
        return imageView.getTranslateY();
    }

    @Override
    public double getHeight() {
        return 0 ;
    }

    @Override
    public double getWidth() {
        return 0;
    }
    public ImageView getImageView()
    {
        return getImageView();
    }

    public double getSpeed() {
        return speed;
    }

    public double getDame() {
        return dame;
    }

    public double getRange() {
        return range;
    }

    public void setDame(double dame) {
        this.dame = dame;
    }
}
