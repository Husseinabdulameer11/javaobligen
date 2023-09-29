import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Sh extends Application {
    private double startX, startY;
    private double endX, endY;
    private ShapeType currentShape = ShapeType.NONE;
    private List<Shape> shapes = new ArrayList<>();

    enum ShapeType {
        NONE, CIRCLE, SQUARE, TRIANGLE, LINE
    }

    class Shape {
        private ShapeType type;
        private double startX, startY, endX, endY;

        public Shape(ShapeType type, double startX, double startY, double endX, double endY) {
            this.type = type;
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public ShapeType getType() {
            return type;
        }

        public double getStartX() {
            return startX;
        }

        public double getStartY() {
            return startY;
        }

        public double getEndX() {
            return endX;
        }

        public double getEndY() {
            return endY;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        HBox buttonBox = new HBox(10);
        Button circleButton = new Button("Circle");
        Button squareButton = new Button("Square");
        Button triangleButton = new Button("Triangle");
        Button lineButton = new Button("Line");

        circleButton.setOnAction(e -> setCurrentShape(ShapeType.CIRCLE));
        squareButton.setOnAction(e -> setCurrentShape(ShapeType.SQUARE));
        triangleButton.setOnAction(e -> setCurrentShape(ShapeType.TRIANGLE));
        lineButton.setOnAction(e -> setCurrentShape(ShapeType.LINE));

        buttonBox.getChildren().addAll(circleButton, squareButton, triangleButton, lineButton);
        root.setTop(buttonBox);

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            startX = event.getX();
            startY = event.getY();
        });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            endX = event.getX();
            endY = event.getY();
            drawPreview(gc);
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            endX = event.getX();
            endY = event.getY();
            drawShape(gc);
        });

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Shape Persistence App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setCurrentShape(ShapeType shapeType) {
        currentShape = shapeType;
    }

    private void drawPreview(GraphicsContext gc) {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        gc.setStroke(Color.BLACK);

        for (Shape shape : shapes) {
            drawShape(gc);
        }

        if (currentShape != ShapeType.NONE) {
            drawShape(gc);
        }
    }

    private void drawShape(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);

        switch (currentShape) {
            case CIRCLE:
                double radius = Math.hypot(endX - startX, endY - startY);
                gc.fillOval(startX - radius, startY - radius, radius * 2, radius * 2);
                break;
            case SQUARE:
                double width = Math.abs(endX - startX);
                double height = Math.abs(endY - startY);
                double x = Math.min(startX, endX);
                double y = Math.min(startY, endY);
                gc.fillRect(x, y, width, height);
                break;
            case TRIANGLE:
                // Implement your triangle drawing logic here
                break;
            case LINE:
                gc.strokeLine(startX, startY, endX, endY);
                break;
            default:
                break;
        }

        // Add the drawn shape to the list for persistence
        if (currentShape != ShapeType.NONE) {
            shapes.add(new Shape(currentShape, startX, startY, endX, endY));
        }
    }

}
