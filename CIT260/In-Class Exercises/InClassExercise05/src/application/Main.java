// Name: Christian Rodriguez
// Date: 04/02/2020
// Desc: In-Class Exercise #4 - Practice with JavaFX and GUIs

package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Main extends Application {
	private boolean   isOpen    = true;
	private ImageView imageView = new ImageView();
	
	// Set the door image depending on Main::isOpen
	public void operateDoor() {
		imageView.setImage(new Image("file:Door" + (isOpen ? "Closed" : "Open") + ".jpg"));
		isOpen = !isOpen; // Reset
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create the operate door button
		Button btnOperateDoor = new Button("Click to Operate Door");
		
		// Tie the click event to the Main::operateDoor() method
		btnOperateDoor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operateDoor();
            }
        });
		// Set initial imageView state
		imageView.setPreserveRatio(true);
		imageView.setFitHeight(200);
		imageView.setFitWidth(200);

		// Create a box containing the operate door button
		VBox vBox = new VBox(imageView, btnOperateDoor);
		vBox.setAlignment(Pos.BOTTOM_CENTER);
		
		operateDoor(); // Operate the door at least once to display it

		// Set the scene and display it!
		primaryStage.setScene(new Scene(vBox));
		primaryStage.setTitle("Door Simulator -- My First GUI APP");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}