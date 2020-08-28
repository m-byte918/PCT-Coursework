// Name: Christian Rodriguez
// Date: 04/19/2020
// Desc: Programming Assignment 03 - Rock, Paper, Scissors game with JavaFX

package application;
import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Main extends Application {
	final int TURNS = 3;

	// Players
	Player player   = new Player(24, 45, false);
	Player computer = new Player(24, 190, true);

	Text playerDecisionText = new Text();

	@Override public void start(Stage primaryStage) throws Exception {
		Group root = new Group();

		// Score keeping
		Text scoreText = new Text();
		scoreText.setX(140);
        scoreText.setY(320);
		root.getChildren().add(scoreText);

		// Display prompt for user
		resetUserDecisionText();
		root.getChildren().add(playerDecisionText);

		// Prepare text for computer decision
		Text computerDecisionText = new Text("The computer chose: ");
        computerDecisionText.setX(140);
        computerDecisionText.setY(180);

	    // Restart button
        Button restart = new Button("Restart?");
        restart.setLayoutX(165);
        restart.setLayoutY(345);
	    restart.setOnAction(new EventHandler<ActionEvent>() {
	       	@Override public void handle(ActionEvent e) {
	       		// Reset player buttons
	       		player.resetWeaponImages();
	       		player.toggleClickableWeapons();

	       		// Reset computer buttons
	       		computer.resetWeaponImages();
	       		computer.removeWeaponsFromGroup(root);

	       		// Reset scores
	       		player.setScore(0);
	       		computer.setScore(0);
	       		scoreText.setText("");

	       		// Reset text and remove restart button
	       		resetUserDecisionText();
	       		root.getChildren().remove(computerDecisionText);
	       		root.getChildren().remove(restart);
	       	}
	    });
		// Display user choices
        player.addWeaponsToGroup(root);

		// Called when player makes a decision
        player.onDecision(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				// Update user decision text
				playerDecisionText.setText("Your choice was: ");
				playerDecisionText.setX(152);

				// Display computer decision text
				if (!root.getChildren().contains(computerDecisionText))
					root.getChildren().add(computerDecisionText);

				// Make random computer decision and display it
				computer.makeDecision(new Random().nextInt(2 + 1));
				computer.addWeaponsToGroup(root);

		        // Determine the winner and display updated scores
				player.checkWinner(computer);
		        scoreText.setText("You: " + player.getScore() + ", Computer: " + computer.getScore());

		        // Winning condition
		        if (player.getScore() == TURNS || computer.getScore() == TURNS) {
		        	root.getChildren().add(restart); // Add restart button
		        	player.toggleClickableWeapons(); // Prevent further turns
		        }
			}
		});
        // Show the game (finally)
		primaryStage.setTitle("Rock, Paper, Scissors");
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root, 396, 400));
		primaryStage.show();
	}
	public void resetUserDecisionText() {
		playerDecisionText.setText("Please choose rock, paper, or scissors");
		playerDecisionText.setX(100);
		playerDecisionText.setY(25);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
