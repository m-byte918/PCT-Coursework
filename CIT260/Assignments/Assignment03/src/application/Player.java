// Name: Christian Rodriguez
// Date: 04/19/2020
// Desc: Programming Assignment 03 - Rock, Paper, Scissors game with JavaFX

package application;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Player {
	private int score        = 0;
	private int lastDecision = 0; // Default (rock)

	private boolean                   enabled        = false;
	private EventHandler<ActionEvent> buttonCallback = null;

	// Initialize arrays of length 3 with non-null values
	private String[]    weaponNames = { "rock",          "paper",         "scissors"    };
	private Button[]    buttons     = { new Button(),    new Button(),    new Button()    };
	private ImageView[] images      = { new ImageView(), new ImageView(), new ImageView() };

	Player(int x, int y, boolean isComputerPlayer) {
		resetWeaponImages();

		// Initialize rock, paper, and scissors images
		for (int i = 0; i < images.length; ++i, x += 100 + 16) {
			ImageView image  = images[i];
			Button    button = buttons[i];

			image.setPreserveRatio(true);
			image.setFitWidth(100);
			image.setFitHeight(100);

			button.setId("" + i);
			button.setGraphic(image);
			button.setLayoutX(x);
			button.setLayoutY(y);
		}
		if (!isComputerPlayer)
			toggleClickableWeapons();
	}
	
	// Sets the player's score
	void setScore(int newScore) {
		score = newScore;
	}
	// Gets the player's score
	int getScore() {
		return score;
	}
	
	// Adds buttons to the provided group node
	void addWeaponsToGroup(Group root) {
		for (Button button : buttons) {
			if (!root.getChildren().contains(button))
				root.getChildren().add(button);
		}
	}

	// Removes buttons from the provided group node
	void removeWeaponsFromGroup(Group root) {
		for (Button button : buttons)
			root.getChildren().remove(button);
	}

	// Callback for when a player makes a decision
	void onDecision(EventHandler<ActionEvent> event) {
		buttonCallback = event;
	}

	// Enables/disables the ability to click weapons
	void toggleClickableWeapons() {
		EventHandler<ActionEvent> e = (enabled = !enabled) ? new ChangeImage() : null;
		for (Button button : buttons)
			button.setOnAction(e);
	}

	// Resets all button images to their un-altered state
	void resetWeaponImages() {
		for (int i = 0; i < images.length; ++i)
			images[i].setImage(new Image("file:" + weaponNames[i] + ".png"));
	}

	// Determines the winner and increments their score
	void checkWinner(Player other) {
		if (lastDecision == other.lastDecision) {
			return; // Tie
		}
		// Default win state
		Player winner = this;
		Player loser = other;

		// Other player win state
		if ((lastDecision + 1) % 3 == other.lastDecision) {
			winner = other;
			loser = this;
		}
		// Draw X through the loser's decision to show which one lost
		int d = loser.lastDecision;
		loser.images[d].setImage(new Image("file:" + weaponNames[d] + "_x.png"));
		loser.buttons[d].setGraphic(loser.images[d]);
		
		++winner.score;
	}
	
	// Makes decision and sets the appropriate image to its selected counterpart
	void makeDecision(int decision) {
		resetWeaponImages(); // Reset first!

		// Set decision to 'selected' image
		images[decision].setImage(new Image("file:" + weaponNames[decision] + "_selected.png"));
		buttons[decision].setGraphic(images[decision]);
		lastDecision = decision;
	}
	
	// Event that is triggered when a player clicks one of their buttons
	private class ChangeImage implements EventHandler<ActionEvent> {
		@Override public void handle(ActionEvent e) {
			// Make decision based on selected button
			Button button = (Button)e.getSource();
			makeDecision(Integer.parseInt(button.getId()));
			
			// Callback to main class
			buttonCallback.handle(e);
		}
	}
}