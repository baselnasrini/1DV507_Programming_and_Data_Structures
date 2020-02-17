package mn223dn_assign3.bouncingBall;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class BouncingBallMain extends Application {

	@Override
	public void start(final Stage primaryStage) {
		primaryStage.setTitle("Bouncing Ball");

		BouncingBall root = new BouncingBall();

		root.newBall();

		Button btn = new Button();
		btn.setText("New Ball");

		BouncingBall.setAlignment(btn, Pos.CENTER);
		root.getChildren().add(btn);

		btn.setOnAction(e -> {
			root.newBall();
		});

		primaryStage.setScene(new Scene(root, 1000, 700));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}