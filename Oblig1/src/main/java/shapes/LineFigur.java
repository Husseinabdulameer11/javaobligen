package shapes;

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

    public Line getLine() {
        return line;
    }
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
    public Color getStrokeColor(){
        return (Color) line.getStroke();
    }
    public void printproperetys(){
        System.out.println(" start X value: "+ getStartX() +"\n"+"start Y value: "+getStartY()+"\n"+"end X value : "+getEndX()+"\n"+"end Y value:"+getEndY()+"\n"+"Stroke Color: "+getStrokeColor()+"\n");
    }
}