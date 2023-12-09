package shapes;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;

public class CircleFigur extends Shape {

    private double radius;
    private Circle circle; // Circle node associated with the CircleFigur

    public CircleFigur(double x, double y, Pane canvasPane, Pane descriptionPane, Color strokeColor, Color fillColor, double radius) {
        super(x, y, canvasPane, descriptionPane, strokeColor, fillColor);
        this.radius = radius;
        createCircle(); // Initialize the Circle node
    }

    // Create the Circle node and set its properties
    private void createCircle() {
        circle = new Circle(x, y, radius);
        circle.setFill(FillColor);
        circle.setStroke(StrokeColor);
        circle.setStrokeWidth(3);
    }

    // method to get circle radius
    public double getRadius() {
        return radius;
    }


    // method used to get the shape information
    public Circle getCircle() {
        return circle;
    }

    // get x value
    public double getX(){
        return x;
    }
    // get y values
    public double getY(){
        return y;
    }
    // get stroke color in hexa
    public Color getStrokeColor(){
        return (Color) circle.getStroke();
    }
    // get fillcolor in hexa
    public Color getFillColor(){
        return (Color) circle.getFill();
    }


        // update the description pane with shape information
    public void descriptionupdater(Label Text){
        Text.setText("X value: "+ getX() +"\n"+"Y value: "+getY()+"\n"+"Radius: "+getRadius()+"\n"+"Fill Color:"+getFillColor()+"\n"+"Stroke Color: "+getStrokeColor()+"\n");
    }
    // get x and y of center of the circle
    public void setCenterX(double x) {
        circle.setCenterX(x);
    }
    public void setCenterY(double y){
        circle.setCenterY(y);
    }
}