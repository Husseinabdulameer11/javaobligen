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
}