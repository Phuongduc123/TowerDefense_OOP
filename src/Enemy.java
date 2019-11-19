import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Enemy implements GameEntity {
    protected double hp;
    protected double speed;
    protected double armor;
    protected int reward;
    protected Image image;
    protected ImageView imageView;
    HealthBar healthBar;
    double healthMax;
    public double getPosX() {
        return imageView.getTranslateX();
    }

    @Override
    public double getPosY() {
        return imageView.getTranslateY();
    }

    @Override
    public double getHeight() {
        return imageView.getFitHeight();
    }

    @Override
    public double getWidth() {
        return imageView.getFitWidth();
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

    public double getRelativeHealth() {
        return getHP() / healthMax;
    }
    public void updateHealthBar() {
        healthBar.setValue(getRelativeHealth());
        healthBar.relocate(this.getPosX() + (imageView.getBoundsInLocal().getWidth() - healthBar.getBoundsInLocal().getWidth()) / 2,
                          this.getPosY() - healthBar.getBoundsInLocal().getHeight() - 4);
        System.out.println(this.getPosX());
    }

}
