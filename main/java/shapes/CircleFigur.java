package shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

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

    public static class LineFigur extends Shape {
        private Line line;

        public LineFigur(double startX, double startY, double endX, double endY, Pane canvasPane, Pane descriptionPane, Color strokeColor) {
            super(startX, startY, canvasPane, descriptionPane, strokeColor, Color.TRANSPARENT);
            createLine(endX, endY);
        }

        private void createLine(double endX, double endY) {
            line = new Line(x, y, endX, endY);
            line.setStroke(StrokeColor);
        }

        public Line getLine() {
            return line;
        }
    }
}