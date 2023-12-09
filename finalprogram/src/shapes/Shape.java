package shapes;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
public class Shape {

    // a class that is used to define the x,y values of a shape,defines the colors of the stroke and fill and also  defines the canvaspane where a shape is drawn, defines the pane where the shape information will be displayed
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
