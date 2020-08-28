// Name: Christian Rodriguez
// Date: 04/25/2020
// Desc: In-Class Exercise #7 - Practice with JavaFX and playing video

package application;

import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		String filePath = "C:\\Users\\Christian Rodriguez\\Downloads\\videoTest.mp4";

		// Load the video
		Media media = new Media(new File(filePath).toURI().toString());
		
		// Load the player
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		
		// Add it to the scene
		MediaView mediaView = new MediaView(mediaPlayer);
		Group root = new Group(mediaView);  
		Scene scene = new Scene(root, 500,400);
		
		// Display it!
		primaryStage.setScene(scene);  
		primaryStage.setTitle("Playing video");  
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
