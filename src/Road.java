import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collection;

public class Road implements GameTile {
    @FXML
    static ImageView imageTest;
    @FXML
    static ImageView imageView2;
    @FXML
    static ImageView imageView3;
    @FXML
    static ImageView imageView4;
    @FXML
    static ImageView imageView5;
    @FXML
    static ImageView imageView6;
    @FXML
    static ImageView imageView7;
    @FXML
    static ImageView imageView8;
    @FXML
    static ImageView imageView9;
    @FXML
    static ImageView imageView10;
    @FXML
    static ImageView imageView11;
    @FXML
    static ImageView imageView12;
    @FXML
    static ImageView imageView13;
    static ArrayList<javafx.scene.image.ImageView> road = new ArrayList<>();
    public static boolean check(ImageView imageView)
    {
        road.add(imageTest);
        road.add(imageView2);
        road.add(imageView3);
        road.add(imageView4);
        road.add(imageView5);
        /*
        road.add(imageView6);
        road.add(imageView7);
        road.add(imageView8);
        road.add(imageView9);
        road.add(imageView10);
        road.add(imageView11);
        road.add(imageView12);
        road.add(imageView13);
        */

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
