package application;
	
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFX Dice Simulator");
		stage.setResizable(false);

		// Button to roll the dice
		Button rollDice = new Button("Roll Dice");
		rollDice.setLayoutX(115);
		rollDice.setLayoutY(220);

		ImageView mainImage = new ImageView();
		mainImage.setPreserveRatio(true);
		mainImage.setFitHeight(100);
		mainImage.setFitWidth(100);
		mainImage.setX(100);
		mainImage.setY(30);

		// Form layout
		Pane root = new Pane(rollDice, mainImage);

		rollDice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	int choice = new Random().nextInt(6) + 1;
            	mainImage.setImage(new Image("file:" + choice + ".png"));
            }
        });
		// Show the stage
		stage.setScene(new Scene(root, 300, 275));
		stage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
