import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy implements GameEntity {
    protected double hp;
    protected double speed;
    protected double armor;
    protected int reward;
    protected Image image;
    protected ImageView imageView;
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

    public double getHP() {
        return hp;
    }

    public double getArmor() {
        return armor;
    }

    public double getSpeed() {
        return speed;
    }

    public int getReward() {
        return reward;
    }

    public void setHP(double hp) {
        this.hp = hp;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
}
