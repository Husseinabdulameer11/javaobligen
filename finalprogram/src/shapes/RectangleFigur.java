package shapes;

import javafx.scene.control.Label;
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
    // method used to get the shape information
    public Rectangle getRectangle() {
        return rectangle;
    }
    // get x method
    public double getX(){
        return x;
    }
    // get y method
    public double getY(){
        return y;
    }
    // method to geth width of rectangle
    public double getWidth(){
        return width;
    }
    // method to get height of rectangle
    public double getHeight(){
        return height;
    }

    // methods to get colors of rectangle
    public Color getStrokeColor(){
        return (Color) rectangle.getStroke();
    }
    public Color getFillColor(){
        return (Color) rectangle.getFill();
    }

        // method to update the description pane
    public void descriptionupdater(Label Text){
        Text.setText("X value: "+ getX() +"\n"+"Y value: "+getY()+"\n"+"Width: "+getWidth()+"\n"+"Height: "+getHeight()+"\n"+"Fill Color:"+getFillColor()+"\n"+"Stroke Color: "+getStrokeColor()+"\n");
    }
    // methods to update x and y values
    public void setX(double x) {
        this.x = x;
        rectangle.setX(x); // Update the corresponding Rectangle properties
    }

    public void setY(double y) {
        this.y = y;
        rectangle.setY(y); // Update the corresponding Rectangle properties
    }
}
