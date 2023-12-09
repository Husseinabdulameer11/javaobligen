package shapes;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextFigur extends Shape{
    private Text text;
    public TextFigur(double x, double y, Pane CanvasPane, Pane descriptionPane, Color StrokeColor, Color FillColor) {
        super(x, y, CanvasPane, descriptionPane, StrokeColor, FillColor);
    }
    public void CreateText(double x, double y,String Value, Color StrokeColor){
        text = new Text(x,y,Value);
        text.setFill(StrokeColor);
        text.setFont(new Font(20));
    }
    // methods to get x y and color of text
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public Color getStrokeColor(){
        return (Color) text.getFill();
    }
    // method used to get the shape information
    public Text getText(){
        return text;
    }

    // method to update the description pane
    public void descriptionupdater( Label Text){
        Text.setText("X value: " + getX() + "\n" + "Y value: " + getY() + "\n" + "Stroke Color: " + getStrokeColor() + "\n");
    }

}
