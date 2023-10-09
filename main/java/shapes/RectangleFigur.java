package shapes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

public class RectangleFigur extends Shape{
    double width;
    double height;
    Rectangle rectangle;
    public RectangleFigur(double x, double y, Pane CanvasPane, Pane descriptionPane, Color StrokeColor, Color FillColor,double width,double height) {
        super(x, y, CanvasPane, descriptionPane, StrokeColor, FillColor);
        this.width = width;
        this.height = height;
        createRect();

    }
    public void createRect(){
        rectangle = new Rectangle(x,y,width,height);
        rectangle.setFill(FillColor);
        rectangle.setStroke(StrokeColor);
    }
    public Rectangle getRectangle() {
        return rectangle;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
}
