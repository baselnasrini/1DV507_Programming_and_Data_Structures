package mn223dn_assign2.randomPanel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RandomMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Random Number");

		RandomPanel ran = new RandomPanel();
		
		Group group = new Group();
		group.getChildren().addAll(ran);
		primaryStage.setScene(new Scene(group, 200,130));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
