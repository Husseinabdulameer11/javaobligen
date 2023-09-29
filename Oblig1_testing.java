import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import shapes.CircleFigur;


public class Oblig1_testing extends Application {
    private enum DrawingMode {
        CIRCLE, LINE, RECTANGLE, TEXT
    }

    private DrawingMode currentMode = DrawingMode.CIRCLE;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox panecontainer = new HBox();


        Scene scene = new Scene(panecontainer,1200,600);

        Pane Buttonpane = new Pane();
        VBox buttoncontainer = new VBox();


        Button cirkelButton = new Button("Cirkel");
        cirkelButton.setOnAction(e->currentMode= DrawingMode.CIRCLE);

        Button lineButton = new Button("Line");
        lineButton.setOnAction(e->currentMode= DrawingMode.LINE);
        Button rectangleButton = new Button("Rectangle");
        rectangleButton.setOnAction(e->currentMode= DrawingMode.RECTANGLE);
        Button textButton = new Button("Text");
        textButton.setOnAction(e->currentMode= DrawingMode.TEXT);
        Label filltext = new Label("fill color");
        ColorPicker VelgFillfarge = new ColorPicker();

        Label Stroketext = new Label("stroke color");
        ColorPicker VelgStrokeFarge = new ColorPicker();

        buttoncontainer.getChildren().addAll( filltext,VelgFillfarge,Stroketext,VelgStrokeFarge,cirkelButton, lineButton, rectangleButton,textButton);
        Buttonpane.getChildren().add(buttoncontainer);
        Buttonpane.setBackground(new Background(new BackgroundFill(Color.PURPLE,CornerRadii.EMPTY,Insets.EMPTY)));
        Buttonpane.setMinWidth(300);
        Pane Canvaspane = new Pane();

        Canvaspane.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
        Canvaspane.setMinWidth(600);

        Pane Descriptionpane = new Pane();
        Label DescriptionTittl = new Label("Beskrivelse");
        Descriptionpane.getChildren().add(DescriptionTittl);
        Descriptionpane.setBackground(new Background(new BackgroundFill(Color.PINK,CornerRadii.EMPTY,Insets.EMPTY)));
        Descriptionpane.setMinWidth(300);

        Canvaspane.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();

            switch (currentMode) {
                case CIRCLE:
                    // Implement circle drawing logic here
                    // Example: create a circle at (x, y)

                    CircleFigur cf = new CircleFigur(x,y,Canvaspane,Descriptionpane,VelgStrokeFarge.getValue(),VelgFillfarge.getValue());

                    break;

                case LINE:
                    // Implement line drawing logic here
                    // Example: create a line starting at (x, y)
                    Line line = new Line(x, y, x + 50, y + 50);
                    line.setStroke(VelgStrokeFarge.getValue());
                    Canvaspane.getChildren().add(line);
                    break;

                case RECTANGLE:
                    // Implement rectangle drawing logic here
                    // Example: create a rectangle starting at (x, y)
                    Rectangle rectangle = new Rectangle(x, y, 50, 30);
                    rectangle.setFill(VelgFillfarge.getValue());
                    rectangle.setStroke(VelgStrokeFarge.getValue());
                    Canvaspane.getChildren().add(rectangle);
                    break;

                case TEXT:
                    // Implement text drawing logic here
                    // Example: create a text element at (x, y)
                    Text text = new Text(x, y, "Your Text");
                    text.setFill(VelgFillfarge.getValue());
                    Canvaspane.getChildren().add(text);
                    break;
            }
        });


        panecontainer.getChildren().addAll(Buttonpane, Canvaspane, Descriptionpane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Paint Program");
        primaryStage.show();
                }
}