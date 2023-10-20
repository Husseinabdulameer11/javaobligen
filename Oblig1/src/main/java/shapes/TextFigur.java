package shapes;


import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class TextFigur extends Shape {
    private Text text;

    public TextFigur (double x, double y, Pane CanvasPane, Pane descriptionPane, Color StrokeColor, Color FilColor){
        super(x,y, CanvasPane, descriptionPane, StrokeColor, FilColor);

    }
    public void CreatText (double x, double y, String Value, Color StrokeColor) {
        text = new Text(x ,y, Value);
        text.setFill(StrokeColor);
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public Color getStrokeColor(){
        return (Color) text.getFill();
    }
    public void printproperetys() {
        System.out.println("X value: " + getX() + "\n" + "Y value: " + getY() + "\n" + "Stroke Color: " + getStrokeColor() + "\n");
    }
    public Text getText() {
        return text;
    }
    public void descriptionupdater(Label Text){
       Text.setText("X value: " + getX() + "\n" + "Y value: " + getY() + "\n" + "Stroke Color: " + getStrokeColor() + "\n");
    }

}
