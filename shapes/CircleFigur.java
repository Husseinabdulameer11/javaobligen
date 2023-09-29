package shapes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleFigur extends Shape{
    public CircleFigur(double x, double y, Pane CanvasPane, Pane descriptionPane, Color StrokeColor, Color FillColor,int Radius) {
        super(x, y, CanvasPane, descriptionPane, StrokeColor, FillColor);
        Circle circle = new Circle(x,y,Radius,FillColor);
        circle.setStroke(StrokeColor);
        CanvasPane.getChildren().add(circle);
        
    }


}
