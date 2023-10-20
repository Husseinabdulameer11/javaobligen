package shapes;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
public class Shape {
    double x;
    double y;
    Pane Canvaspane;
    Pane descriptionPane;
    Color StrokeColor;
    Color FillColor;

    public Shape(double x, double y, Pane CanvasPane, Pane descriptionPane, Color StrokeColor, Color FillColor){
        this.x = x;
        this.y = y;
        this.Canvaspane = CanvasPane;
        this.descriptionPane = descriptionPane;
        this.StrokeColor = StrokeColor;
        this.FillColor = FillColor;
    }


}
