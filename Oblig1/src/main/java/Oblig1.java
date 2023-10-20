import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import shapes.CircleFigur;
import shapes.LineFigur;
import shapes.RectangleFigur;


public class Oblig1 extends Application {
  Circle previewCircle;
  Rectangle previewRectangel;
  Line previewLine;
private double startX, startY;

private enum DrawingMode {
    CIRCLE, LINE, REGTANGEL, TEXT
    }

    private DrawingMode currenMode = DrawingMode.CIRCLE;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox panecontainer = new HBox();


        Scene scene = new Scene(panecontainer,1200,600);

        Pane Buttonpane = new Pane();
        VBox buttoncontainer = new VBox();

        Button SelectButton = new Button("SelectButton");
        Button cirkelButton = new Button("Cirkel");
        cirkelButton.setOnAction(actionEvent -> {
            currenMode = DrawingMode.CIRCLE;
        });
        Button lineButton = new Button("Line");
        lineButton.setOnAction(actionEvent -> {
            currenMode = DrawingMode.LINE;
        });
        Button rectangleButton = new Button("Rectangle");
        rectangleButton.setOnAction(actionEvent -> {
            currenMode = DrawingMode.REGTANGEL;
        });
        Button textButton = new Button("Text");
        TextField tf = new TextField();
        textButton.setOnAction(actionEvent -> {
            currenMode = DrawingMode.TEXT;
        });
        ColorPicker Velgfarge = new ColorPicker();
        ColorPicker Strokefarge = new ColorPicker();

        buttoncontainer.getChildren().addAll( Velgfarge,Strokefarge,cirkelButton, lineButton, rectangleButton,tf,textButton, SelectButton);
        buttoncontainer.setMinWidth(300);
        Buttonpane.getChildren().add(buttoncontainer);
        Buttonpane.setBackground(new Background(new BackgroundFill(Color.PURPLE,CornerRadii.EMPTY,Insets.EMPTY)));

        Pane Canvaspane = new Pane();

        Canvaspane.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
        Canvaspane.setMinWidth(600);
        Pane Descriptionpane = new Pane();
        Label DescriptionTittl = new Label("Beskrivelse");
        Descriptionpane.getChildren().add(DescriptionTittl);
        Descriptionpane.setBackground(new Background(new BackgroundFill(Color.PINK,CornerRadii.EMPTY,Insets.EMPTY)));
        Descriptionpane.setMinWidth(300);

        Canvaspane.setOnMouseClicked(mouseEvent -> {
            switch (currenMode) {
                case CIRCLE:
                    startX = mouseEvent.getX();
                    startY = mouseEvent.getY();
                    break;
                case LINE:
                    startX = mouseEvent.getX();
                    startY = mouseEvent.getY();
                    break;
                case REGTANGEL:
                    startX = mouseEvent.getX();
                    startY = mouseEvent.getY();
                    break;
                case TEXT:
                    startX = mouseEvent.getX();
                    startY = mouseEvent.getY();
                    Text text = new Text(startX, startY,tf.getText());
                    text.setFill(Strokefarge.getValue());
                    Canvaspane.getChildren().add(text);
                    break;


            }
        });

        Canvaspane.setOnMouseDragged(mouseEvent -> {
            switch (currenMode){
                case CIRCLE :
                    double currentX = mouseEvent.getX();
                    double currentY = mouseEvent.getY();

                    double radius = Math.sqrt(Math.pow(currentX - startX, 2) + Math.pow(currentY - startY, 2));
                    if (previewCircle == null) {
                        previewCircle = new Circle(startX, startY, radius);
                        previewCircle.setFill(Color.TRANSPARENT);
                        previewCircle.setStroke(Color.BLUE);

                        Canvaspane.getChildren().add(previewCircle);
                         }
                    else {
                        previewCircle.setRadius(radius);

                    }
                    break;

                case LINE:
                    currentX = mouseEvent.getX();
                    currentY = mouseEvent.getY();
                    if(previewLine == null) {
                    previewLine = new Line(startX, startY, currentX, currentY);
                    previewLine.setStroke(Color.BLUE);
                    Canvaspane.getChildren().add(previewLine);
                    }
                    else{
                        previewLine.setEndX(currentX);
                        previewLine.setEndY(currentY);
                    }
                    break;
                case REGTANGEL:
                    currentX = mouseEvent.getX();
                    currentY = mouseEvent.getY();
                    double width = Math.abs(currentX - startX);
                    double heigth = Math.abs(currentY - startY);
                    if(previewRectangel == null){
                        previewRectangel = new Rectangle(startX, startY, width, heigth);
                        previewRectangel.setFill(Color.TRANSPARENT);
                        previewRectangel.setStroke(Color.BLUE);
                        Canvaspane.getChildren().add(previewRectangel);
                    }
                    else{
                        previewRectangel.setWidth(width);
                        previewRectangel.setHeight(heigth);

                    }


            }

            });

        Canvaspane.setOnMouseReleased(mouseEvent -> {
            switch (currenMode) {
                case CIRCLE :
                    if (previewCircle != null) {
                        double radius = previewCircle.getRadius();

                        CircleFigur cf = new CircleFigur(startX, startY, Canvaspane, Descriptionpane,Strokefarge.getValue(),Velgfarge.getValue(), radius);
                        cf.printproperetys();
                        Canvaspane.getChildren().add(cf.getCircle());

                        Canvaspane.getChildren().remove(previewCircle);
                        previewCircle = null;
                    }
                    break;
                case LINE:
                    if (previewLine != null) {
                        double endX = mouseEvent.getX();
                        double endY = mouseEvent.getY();
                        LineFigur lf = new LineFigur(startX, startY, endX, endY,  Canvaspane, Descriptionpane,Strokefarge.getValue());
                        lf.printproperetys();
                        Canvaspane.getChildren().add(lf.getLine());
                        Canvaspane.getChildren().remove(previewLine);
                        previewLine = null;
                    }
                    break;

                case REGTANGEL:
                    if (previewRectangel != null) {
                        double width = previewRectangel.getWidth();
                        double heigth = previewRectangel.getHeight();
                        RectangleFigur rf = new RectangleFigur(startX, startY, Canvaspane, Descriptionpane,Strokefarge.getValue(),Velgfarge.getValue(), width, heigth);
                        rf.printproperetys();
                        Canvaspane.getChildren().add(rf.getRectangle());
                        Canvaspane.getChildren().remove(previewRectangel);
                        previewRectangel = null;
                    }
                    break;
            }
        });

        panecontainer.getChildren().addAll(Buttonpane, Canvaspane, Descriptionpane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Paint Program");
        primaryStage.show();

    }
}

