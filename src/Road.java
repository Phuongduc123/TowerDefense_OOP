import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collection;

public class Road implements GameTile {
    @FXML
    static ImageView imageTest1;
    @FXML
    static ImageView imageTest2;
    @FXML
    static ImageView imageTest3;
    @FXML
    static ImageView imageTest4;
    @FXML
    static ImageView imageTest5;

    static ArrayList<ImageView> road = new ArrayList<>();
    public static boolean check(ImageView imageView)
    {
        road.add(imageTest1);
        road.add(imageTest2);
        road.add(imageTest3);
        road.add(imageTest4);
        road.add(imageTest5);

        for ( int i = 0 ; i < road.size(); i ++ )
        {
            if (imageView.getBoundsInParent().intersects(road.get(i).getBoundsInParent())) return false;
        }
        return true;
    }
    @Override
    public double getPosX() {
        return 0;
    }

    @Override
    public double getPosY() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 21 ;
    }

    @Override
    public double getWidth() {
        return 21;
    }
}
