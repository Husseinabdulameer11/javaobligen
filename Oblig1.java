import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Oblig1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox panecontainer = new HBox();


        Scene scene = new Scene(panecontainer,600,600);

        Pane Buttonpane = new Pane();
        VBox buttoncontainer = new VBox();


        Button cirkelButton = new Button("Cirkel");

        Button lineButton = new Button("Line");
        Button rectangleButton = new Button("Rectangle");
        Button textButton = new Button("Text");
        ColorPicker Velgfarge = new ColorPicker();

        buttoncontainer.getChildren().addAll( Velgfarge,cirkelButton, lineButton, rectangleButton,textButton);
        Buttonpane.getChildren().add(buttoncontainer);
        Buttonpane.setBackground(new Background(new BackgroundFill(Color.PURPLE,CornerRadii.EMPTY,Insets.EMPTY)));

        Pane Canvaspane = new Pane();
        
        Canvaspane.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));

        Pane Descriptionpane = new Pane();
        Label DescriptionTittl = new Label("Beskrivelse");
        Descriptionpane.getChildren().add(DescriptionTittl);
        Descriptionpane.setBackground(new Background(new BackgroundFill(Color.PINK,CornerRadii.EMPTY,Insets.EMPTY)));


        panecontainer.getChildren().addAll(Buttonpane, Canvaspane, Descriptionpane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Paint Program");
        primaryStage.show();

    }
}
