package mn223dn_assign3.upDown;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UpDownMain extends Application {


		@Override
		public void start(Stage primaryStage) {
			primaryStage.setTitle("Up Down Pane");

			
			UpDownPane ud = new UpDownPane ();
			
			Group group = new Group();
			group.getChildren().addAll(ud);
			primaryStage.setScene(new Scene(group, 700 , 700));
			primaryStage.show();
			
	}
		
		
		public static void main(String[] args) {
			launch(args);
		}

}
