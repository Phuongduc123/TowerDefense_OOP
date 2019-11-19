import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

public class HealthBar extends Pane {
    Rectangle outerHealthRect;
    Rectangle innerHealthRect;
    //final Enemy enemy;

    public HealthBar(Enemy e) {
        double height = 10;

        double outerWidth = 60;
        double innerWidth = 40;
        //double x = 100.0;
        //double y = 100.0;


        outerHealthRect = new Rectangle(e.getPosX(), e.getPosY(), outerWidth, height);
        outerHealthRect.setStroke(Color.BLACK);
        outerHealthRect.setStrokeWidth(2);
        outerHealthRect.setStrokeType(StrokeType.OUTSIDE);
        outerHealthRect.setFill(Color.RED);

        innerHealthRect = new Rectangle(e.getPosX(), e.getPosY(), innerWidth, height);
        innerHealthRect.setStrokeType(StrokeType.OUTSIDE);
        innerHealthRect.setFill(Color.LIMEGREEN);

        getChildren().addAll(outerHealthRect, innerHealthRect);
    }

    public void setValue(double value) {
        innerHealthRect.setWidth(outerHealthRect.getWidth() * value);
    }
}