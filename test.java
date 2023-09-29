import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region; // Import Region
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class test extends Application {

    private ArrayList<Circle> circles = new ArrayList<>();
    private ArrayList<Rectangle> rectangles = new ArrayList<>();
    private String tool = "draw";
    private Rectangle currentRectangle;
    private final int canvasWidth = 1200;
    private final int canvasHeight = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Pane canvasPane = new Pane(canvas); // Use a Pane to hold the Canvas

        Button newCanvasButton = new Button("New Canvas");
        Button pencilButton = new Button("Pencil");
        Button eraserButton = new Button("Eraser");
        Button circleButton = new Button("Circle");
        Button rectangleButton = new Button("rectangle");

        ColorPicker colorPicker = new ColorPicker();
        HBox buttons = new HBox(newCanvasButton, pencilButton, eraserButton, colorPicker, circleButton,rectangleButton);

        // Create a Region to hold the buttons and specify its width
        Region buttonRegion = new Region();
        buttonRegion.setMinWidth(canvasWidth);

        VBox root = new VBox(buttons, buttonRegion, canvasPane); // Add the Pane to the VBox

        canvas.setOnMousePressed(e -> handleMousePressed(e, gc, colorPicker, canvasPane));
        canvas.setOnMouseDragged(e -> handleMouseDragged(e, gc, colorPicker, canvasPane));

        newCanvasButton.setOnAction(e -> {
            // Clear the canvas
            gc.clearRect(0, 0, canvasWidth, canvasHeight);

            // Remove all circles from the canvasPane
            canvasPane.getChildren().removeAll(circles);
            canvasPane.getChildren().removeAll(rectangles);

            // Clear the circles arraylist
            circles.clear();
            rectangles.clear();
        });


        pencilButton.setOnAction(e -> {
            tool = "draw";
        });

        eraserButton.setOnAction(e -> {
            tool = "erase";
        });

        circleButton.setOnAction(e -> {
            tool = "circle";
        });
        rectangleButton.setOnAction(e->{
            tool = "rectangle";
        });

        Scene scene = new Scene(root, canvasWidth, canvasHeight + buttons.getHeight()); // Adjust Scene height
        stage.setTitle("Painting Program");
        stage.setScene(scene);
        stage.show();
    }

    public void handleMousePressed(MouseEvent event, GraphicsContext gc, ColorPicker colorPicker, Pane canvasPane) {
        switch (tool) {
            case "draw":
                gc.setStroke(colorPicker.getValue());
                gc.beginPath();
                gc.lineTo(event.getX(), event.getY());
                gc.stroke();
                break;
            case "erase":
                gc.clearRect(event.getX() - 10, event.getY() - 10, 20, 20);
                break;
            case "circle":
                Circle newCircle = new Circle(event.getX(), event.getY(), 20);
                newCircle.setFill(Color.TRANSPARENT);
                newCircle.setStroke(colorPicker.getValue());
                circles.add(newCircle);
                canvasPane.getChildren().add(newCircle); // Add the circle to the Pane
                break;
            case "rectangle":
                currentRectangle = new Rectangle(event.getX(), event.getY(), 0, 0);
                currentRectangle.setFill(Color.TRANSPARENT);
                currentRectangle.setStroke(colorPicker.getValue());
                rectangles.add(currentRectangle);
                canvasPane.getChildren().add(currentRectangle);
                break;

        }
    }

    private void handleMouseDragged(MouseEvent event, GraphicsContext gc, ColorPicker colorPicker, Pane canvasPane) {
        switch (tool) {
            case "draw":
                gc.setStroke(colorPicker.getValue());
                gc.lineTo(event.getX(), event.getY());
                gc.stroke();
                break;
            case "erase":
                gc.clearRect(event.getX() - 10, event.getY() - 10, 20, 20);
                break;
            case "circle":
                Circle resizedCircle = circles.get(circles.size() - 1);

                double centerX = resizedCircle.getCenterX();
                double centerY = resizedCircle.getCenterY();

                double deltaX = event.getX() - centerX;
                double deltaY = event.getY() - centerY;

                double newRadius = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

                resizedCircle.setRadius(newRadius);
                resizedCircle.setStroke(colorPicker.getValue());
                break;
            case "rectangle":
                if (currentRectangle != null) {
                    double newWidth = event.getX() - currentRectangle.getX();
                    double newHeight = event.getY() - currentRectangle.getY();

                    currentRectangle.setWidth(newWidth);
                    currentRectangle.setHeight(newHeight);
                }
                break;
        }
    }





}
