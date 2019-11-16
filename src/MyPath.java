import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class MyPath extends Path{
    private Path path;
    public MyPath()
    {
        path = new Path();
        /*
        MoveTo moveTo = new MoveTo(480, 50);
        LineTo lineTo1 = new LineTo(340, 50);
        LineTo lineTo2 = new LineTo(340, 130);
        LineTo lineTo3 = new LineTo(225, 130);
        LineTo lineTo4 = new LineTo(225, 53);
        LineTo lineTo5 = new LineTo(60, 53);
        LineTo lineTo6 = new LineTo(60, 215);
        LineTo lineTo7 = new LineTo(440, 215);
        LineTo lineTo8 = new LineTo(440, 380);
        LineTo lineTo9 = new LineTo(345, 380);
        LineTo lineTo10 = new LineTo(345, 310);
        LineTo lineTo11 = new LineTo(230, 310);
        LineTo lineTo12 = new LineTo(230, 380);
        LineTo lineTo13 = new LineTo(-30, 380);
        //path.getElements().addAll(moveTo, lineTo1, lineTo2, lineTo3, lineTo4, lineTo5, lineTo6, lineTo7, lineTo8, lineTo9, lineTo10, lineTo11, lineTo12, lineTo13);
        */
        MoveTo moveTo = new MoveTo(0, 40);
        LineTo lineTo1 = new LineTo(210, 40);
        LineTo lineTo2 = new LineTo(210, 290);
        LineTo lineTo3 = new LineTo(380, 290);
        LineTo lineTo4 = new LineTo(380, 150);
        LineTo lineTo5 = new LineTo(550, 150);
        path.getElements().addAll(moveTo, lineTo1, lineTo2, lineTo3, lineTo4, lineTo5);
    }

    public Path getPath() {
        return path;
    }
}
