// import statements

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import shapes.*;

// decleartion of oblig method
public class Oblig extends Application {
    //defining preview shapes that will be displayed when the mousedragged event method is triggered when the user drags the mouse in the application
    Circle previewCircle;
    Rectangle previewRectangle;
    Line previewLine;
    // selectednode is a variable that will store the data of the node that is selected when the user press a shape in the canvaspane
    private Node selectedNode;

    // x offeset and y offeset are used to define the distance between a shape x and y value and the borders of the pane or application window
    private double xOffset, yOffset;
    // isNodeDragged is a boolean value that is true if a shape/node is dragged in the pane and is false otherwise
    private boolean isNodeDragged = false;
    // when the user draws a shape the startx and starty variables store the x and y position of the mouse when the user clicks on the screen before drawing
    private double startX, startY;
    // diffrent modes the application has, drawing a circle,drawing a line,drawing a rectangle, drawing a text or selecting an object/shape/node
    private enum DrawingMode {
        CIRCLE, LINE, RECTANGLE, TEXT,SELECT
    }
    // the default application mode if the user doesnt select a shape him/her self is a circle
    private DrawingMode currentMode = DrawingMode.CIRCLE;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // hbox is used to contain all application panes
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
        TextField panetextwriter = new TextField();
        Button textButton = new Button("Text");
        Button SelectButton = new Button("Select elements");
        SelectButton.setOnAction(e->currentMode=DrawingMode.SELECT);
        textButton.setOnAction(e->currentMode= DrawingMode.TEXT);
        Label filltext = new Label("fill color");
        ColorPicker VelgFillfarge = new ColorPicker();

        Label Stroketext = new Label("stroke color");
        ColorPicker VelgStrokeFarge = new ColorPicker();

        buttoncontainer.getChildren().addAll( filltext,VelgFillfarge,Stroketext,VelgStrokeFarge,cirkelButton, lineButton, rectangleButton,panetextwriter,textButton,SelectButton);
        Buttonpane.getChildren().add(buttoncontainer);
        Buttonpane.setBackground(new Background(new BackgroundFill(Color.PURPLE,CornerRadii.EMPTY,Insets.EMPTY)));
        Buttonpane.setMinWidth(300);
        Pane Canvaspane = new Pane();

        Canvaspane.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
        Canvaspane.setMinWidth(600);

        Pane Descriptionpane = new Pane();
        Label DescriptionTittl = new Label("Beskrivelse");
        Label FigurDescription = new Label("");
        FigurDescription.setStyle("-fx-padding:20px");
        Descriptionpane.getChildren().addAll(DescriptionTittl, FigurDescription);
        Descriptionpane.setBackground(new Background(new BackgroundFill(Color.PINK,CornerRadii.EMPTY,Insets.EMPTY)));
        Descriptionpane.setMinWidth(300);

        Canvaspane.setOnMouseClicked(event -> {

            // if the currentmode variable is circle,line,rectangle then the startx and starty values get the current positon of the mouse other wise the program either draws a text or select a shape depending if its curentmode text or select
            switch (currentMode) {
                case CIRCLE:
                    startX = event.getX();
                    startY = event.getY();


                    break;

                case LINE:
                    startX = event.getX();
                    startY = event.getY();
                    break;

                case RECTANGLE:

                    startX = event.getX();
                    startY = event.getY();

                    break;

                case TEXT:

                    startX = event.getX();
                    startY = event.getY();
                    TextFigur tf = new TextFigur(startX,startY,Canvaspane,Descriptionpane,VelgStrokeFarge.getValue(),VelgFillfarge.getValue());
                    tf.CreateText(startX,startY,panetextwriter.getText(),VelgStrokeFarge.getValue());
                    tf.descriptionupdater(FigurDescription);
                    Canvaspane.getChildren().add(tf.getText());
                    break;
                case SELECT:

                    selectedNode = getSelectedNode(event.getX(), event.getY(), Canvaspane);
                    if (selectedNode != null) {
                        updateDescription(selectedNode, FigurDescription);
                        xOffset = event.getX() - selectedNode.getLayoutX();
                        yOffset = event.getY() - selectedNode.getLayoutY();
                        isNodeDragged = true;
                        selectedNode.toFront();
                    }

                    break;
            }
        });
        // create preview shapes for rectangle, circle or line to see a preview of the shape while the user is drawing
        Canvaspane.setOnMouseDragged(event->{
            switch (currentMode){
                // if currentmode is circle,rectangle or line the a preview of the later drawn shape will appear on the screen so the user can drag the mouse to change the width, heigth of a rectangle, radius of a circle or length of a line
                case CIRCLE :
                    double currentX = event.getX();
                    double currentY = event.getY();

                    double radius = Math.sqrt(Math.pow(currentX - startX, 2) + Math.pow(currentY - startY, 2));
                    if (previewCircle == null) {
                        previewCircle = new Circle(startX, startY, radius);
                        previewCircle.setFill(Color.TRANSPARENT);
                        previewCircle.setStroke(Color.BLUE);

                        Canvaspane.getChildren().add(previewCircle);
                    } else {
                        // Update the existing preview circle
                        previewCircle.setRadius(radius);
                    }
                    break;
                case RECTANGLE:
                    currentX = event.getX();
                    currentY = event.getY();

                    double width = Math.abs(currentX - startX);
                    double height = Math.abs(currentY - startY);

                    if(previewRectangle==null){
                        if(width>height){
                            previewRectangle = new Rectangle(startX, startY, width, height);
                            previewRectangle.setFill(Color.TRANSPARENT);
                            previewRectangle.setStroke(Color.BLUE);
                            Canvaspane.getChildren().add(previewRectangle);
                        }

                    }else{
                        previewRectangle.setWidth(width);
                        previewRectangle.setHeight(height);

                    }

                    break;
                case LINE:
                    currentX = event.getX();
                    currentY = event.getY();

                    if (previewLine == null) {
                        previewLine = new Line(startX, startY, currentX, currentY);
                        previewLine.setStroke(Color.BLUE);

                        Canvaspane.getChildren().add(previewLine);
                    } else {
                        // Update the existing preview line
                        previewLine.setEndX(currentX);
                        previewLine.setEndY(currentY);
                    }
                    break;
                case SELECT:
                    // if a shape is selected and the user is dragging then track the x and y values
                    if (isNodeDragged && selectedNode != null) {
                        double x = event.getX() ;
                        double y = event.getY() ;
                        // check which shape is selected and define cordinates
                        if (selectedNode instanceof Circle) {
                            Circle circle = (Circle) selectedNode;
                            circle.setCenterX(x);
                            circle.setCenterY(y);
                        } else if (selectedNode instanceof Rectangle) {
                            Rectangle rectangle = (Rectangle) selectedNode;
                            rectangle.setX(x);
                            rectangle.setY(y);
                        }
                        else if (selectedNode instanceof Text) {
                            Text text = (Text) selectedNode;
                            text.setX(x);
                            text.setY(y);
                        }
                        else if (selectedNode instanceof Line) {
                            Line line = (Line) selectedNode;
                            double dx = x - startX;
                            double dy = y - startY;

                            line.setStartX(startX + dx);
                            line.setStartY(startY + dy);
                            line.setEndX(line.getEndX() + dx);
                            line.setEndY(line.getEndY() + dy);

                            // Update the starting coordinates for the next drag iteration
                            startX = x;
                            startY = y;
                        }
                    }
                    break;
            }
        });
        Canvaspane.setOnMouseReleased(event -> {
            switch (currentMode){
                case CIRCLE:
                    if (previewCircle != null) {
                        double radius = previewCircle.getRadius();

                        // Create a new CircleFigur and add it to the pane
                        CircleFigur cf = new CircleFigur(startX, startY, Canvaspane, Descriptionpane, VelgStrokeFarge.getValue(),VelgFillfarge.getValue(), radius);
                        cf.descriptionupdater(FigurDescription);
                        Canvaspane.getChildren().add(cf.getCircle());

                        // remove the preview circle and reset properties
                        Canvaspane.getChildren().remove(previewCircle);
                        previewCircle = null;
                    }
                    break;
                case RECTANGLE:
                    if (previewRectangle != null) {
                        double width = previewRectangle.getWidth();
                        double height = previewRectangle.getHeight();

                        // Create a new RectangleFigur shape from our rectangleFigur class and place it in the canvaspane
                        RectangleFigur rf = new RectangleFigur(startX, startY, Canvaspane, Descriptionpane, VelgStrokeFarge.getValue(), VelgFillfarge.getValue(), width, height);

                        // update the description pane part of the application to display the cordinates and color, witdth and height of rectangle
                        rf.descriptionupdater(FigurDescription);
                        Canvaspane.getChildren().add(rf.getRectangle());

                        // remove the preview rectangle from the pane
                        Canvaspane.getChildren().remove(previewRectangle);
                        // reset the previewRectangle so the user is able to draw new rectangles
                        previewRectangle = null;
                    }
                    break;
                case LINE:
                    if (previewLine != null) {
                        double endX = event.getX();
                        double endY = event.getY();

                        // Create a new LineFigur and display it to the pane
                        LineFigur lf = new LineFigur(startX, startY, endX, endY, Canvaspane, Descriptionpane, VelgStrokeFarge.getValue());
                        lf.descriptionupdater(FigurDescription);
                        Canvaspane.getChildren().add(lf.getLine());

                        // remove the line and reset the properties
                        Canvaspane.getChildren().remove(previewLine);
                        previewLine = null;
                    }
                    break;
                case SELECT:
                    // if mouse is released then stop functionality that is responsible of dragging a shape
                    isNodeDragged = false;
            }
        });


        panecontainer.getChildren().addAll(Buttonpane, Canvaspane, Descriptionpane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Paint Program");
        primaryStage.show();

    }
    private Node getSelectedNode(double x, double y, Pane canvas) {
        for (Node node : canvas.getChildren()) {
            if (node.contains(x, y)) {
                return node;
            }
        }
        return null;
    }
    private void updateDescription(Node node, Label descriptionLabel) {
        if (node instanceof Circle) {
            Circle circle = (Circle) node;
            descriptionLabel.setText("Circle: Center X=" + circle.getCenterX() + "\n Center Y=" + circle.getCenterY() + "\n Radius=" + circle.getRadius()+"\n StrokeColor= "+circle.getStroke()+"\n FillColor= "+circle.getFill());
        } else if (node instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) node;
            descriptionLabel.setText("Rectangle: X=" + rectangle.getX() + "\n Y=" + rectangle.getY() + "\n Width=" + rectangle.getWidth() + "\n Height=" + rectangle.getHeight()+"\n StrokeColor= "+rectangle.getStroke()+"\n FillColor= "+rectangle.getFill());
        } else if (node instanceof Line) {
            Line line = (Line) node;
            descriptionLabel.setText("Line: Start X=" + line.getStartX() + "\n Start Y=" + line.getStartY() + "\n End X=" + line.getEndX() + "\n End Y=" + line.getEndY()+"\n Color= "+line.getStroke());
        } else if (node instanceof Text) {
            Text text = (Text) node;
            descriptionLabel.setText("Text: X=" + text.getX() + "\n Y=" + text.getY() + "\n Text=" + text.getText()+"\n Color="+text.getFill());
        }
    }

}