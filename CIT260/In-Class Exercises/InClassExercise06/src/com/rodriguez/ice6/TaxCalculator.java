package com.rodriguez.ice6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TaxCalculator extends Application/* to public class Registration*/ {
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFX Tax Calculator");

		// Form layout
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(25, 25, 25, 25));

		// Welcome text
		Text sceneTitle = new Text("Tax Calculator");
		sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL,20));
		pane.add(sceneTitle, 0, 0, 2, 1);

		// Income input
		Label total = new Label("Income:");
		pane.add(total, 0, 1);
		TextField totalField = new TextField();
		pane.add(totalField, 1, 1);

		// Tax input
		Label percent = new Label("% Tax:");
		pane.add(percent, 0, 2);
		TextField percentField = new TextField();
		pane.add(percentField, 1, 2);

		// Text to show the result of the operation
		final Text taxMessage = new Text();
		taxMessage.setId("taxMessage");
		pane.add(taxMessage, 1, 6);

		// Calculate button to DO the operation
		Button calculateButton = new Button("Calculate");
		calculateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Double income = Double.parseDouble(totalField.getText());
                Double tax    = Double.parseDouble(percentField.getText());
                taxMessage.setText("Tax incurred: " + income * tax / 100);
            }
        });
		// Add calculate button to hbox at the bottom right
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		hbox.getChildren().add(calculateButton);
		pane.add(hbox, 1, 4);

		// Add pane to scene and add css
		Scene scene = new Scene(pane, 300, 275);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
		// Show the stage
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
