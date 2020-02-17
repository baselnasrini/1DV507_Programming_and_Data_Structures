package mn223dn_assign2;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.*;

public class OneTwoThree extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		
		
		primaryStage.setTitle("One Two Three!");
		BorderPane root = new BorderPane();
		
		BorderPane up = new BorderPane();
		Label one = new Label("One");
		one.setFont(new Font("Arial", 30));

	    BorderPane.setAlignment(one , Pos.TOP_LEFT);
	    up.setTop(one);
	    up.setStyle("-fx-background-color: rgba(230,230,230,0.7);");	    
		up.setPrefSize(300, 100);
	    
	    BorderPane center = new BorderPane();
		Label two = new Label("Two");
		two.setFont(new Font("Arial", 30));
//	    BorderPane.setAlignment(two , Pos.CENTER);
	    center.setCenter(two);
	    center.setStyle("-fx-background-color: rgba(100,230,230,0.7);");	    
		center.setPrefSize(300, 100);
		
	    BorderPane bottom = new BorderPane();
		Label three = new Label("Three");
		three.setFont(new Font("Arial", 30));
	    BorderPane.setAlignment(three , Pos.BOTTOM_RIGHT);
	    bottom.setBottom(three);
	    bottom.setStyle("-fx-background-color: rgba(200,230,230,0.7);");	    
		bottom.setPrefSize(300, 100);
	    
	    
	    
		root.setTop(up);     
	    root.setCenter(center);
	    root.setBottom(bottom);
        root.setPrefSize(300 , 300);    

		Group group = new Group();
		group.getChildren().addAll(root);
		primaryStage.setScene(new Scene(group, 300,300));
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
