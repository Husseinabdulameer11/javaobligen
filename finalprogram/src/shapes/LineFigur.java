package shapes;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public  class LineFigur extends Shape {
    private Line line;

    public LineFigur(double startX, double startY, double endX, double endY, Pane canvasPane, Pane descriptionPane, Color strokeColor) {
        super(startX, startY, canvasPane, descriptionPane, strokeColor, Color.TRANSPARENT);
        createLine(endX, endY);
    }

    private void createLine(double endX, double endY) {
        line = new Line(x, y, endX, endY);
        line.setStroke(StrokeColor);
    }

    // method used to get the shape information
    public Line getLine() {
        return line;
    }

    // methods to get x and y of the two points of a line
    public double getStartX(){
        return line.getStartX();
    }
    public double getStartY(){
        return line.getStartY();
    }
    public double getEndX(){
        return line.getEndX();
    }
    public double getEndY(){
        return line.getEndY();
    }
    // method to get color of line
    public Color getStrokeColor(){
        return (Color) line.getStroke();
    }

    // method to update description pane
    public void descriptionupdater(Label Text){
        Text.setText("start X value: "+ getStartX() +"\n"+"start Y value: "+getStartY()+"\n"+"end X value : "+getEndX()+"\n"+"end Y value:"+getEndY()+"\n"+"Stroke Color: "+getStrokeColor()+"\n");
    }

    // methods to update x and y values of line
    public void setStartX(double startX) {
        this.x = startX;
        line.setStartX(startX); // Update the corresponding Line properties
    }

    public void setStartY(double startY) {
        this.y = startY;
        line.setStartY(startY); // Update the corresponding Line properties
    }
}