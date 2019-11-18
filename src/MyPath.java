import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class MyPath extends Path{
    private Path path;
    public MyPath()
    {
        path = new Path();

        MoveTo moveTo = new MoveTo(0, 60);
        LineTo lineTo1 = new LineTo(410, 60);
        LineTo lineTo2 = new LineTo(410, 440);
        LineTo lineTo3 = new LineTo(750, 440);
        LineTo lineTo4 = new LineTo(750, 220);
        LineTo lineTo5 = new LineTo(1300, 220);
        path.getElements().addAll(moveTo, lineTo1, lineTo2, lineTo3, lineTo4, lineTo5);
    }

    public Path getPath() {
        return path;
    }
}
