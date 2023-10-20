package shapes;

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
    }

    // Getter for the radius
    public double getRadius() {
        return radius;
    }

    // Getter for the Circle node
    public Circle getCircle() {
        return circle;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public Color getStrokeColor(){
        return (Color) circle.getStroke();
    }
    public Color getFillColor(){
        return (Color) circle.getFill();
    }
    public void printproperetys(){
        System.out.println("X value: "+ getX() +"\n"+"Y value: "+getY()+"\n"+"Radius: "+getRadius()+"\n"+"Fill Color:"+getFillColor()+"\n"+"Stroke Color: "+getStrokeColor()+"\n");
    }

}