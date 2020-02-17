package mn223dn_assign2;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class ColorDisplay extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Color Display");
		BorderPane root = new BorderPane();

		
		BorderPane display = new BorderPane();
		Label a = new Label("Color Display");
		 a.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		display.setPrefSize(300,100);
		display.setStyle(color("192","192","192"));
		BorderPane.setAlignment(a , Pos.CENTER);

		Label error = new Label("Wrong RGB Value");
		error.setFont(Font.font("Arial", FontWeight.BOLD, 15));

		BorderPane.setAlignment(error , Pos.CENTER);
		display.setBottom(error);
		error.setVisible(false);

		
		display.setCenter(a);
		
		
		GridPane grid = new GridPane() ; 
		grid.setPrefSize(300, 100);
		grid.setPadding(new Insets(0, 10, 0, 10));
		
		Text tred = new Text("Red");
		Text tgreen = new Text("Green");
		Text tblue = new Text("Blue");

		TextField red = new TextField();
		TextField green = new TextField();
		TextField blue = new TextField();
		red.setPrefSize(60, 20);
		green.setPrefSize(60, 20);
		blue.setPrefSize(60, 20);
		
        GridPane.setVgrow(tred, Priority.ALWAYS);
        GridPane.setVgrow(red, Priority.ALWAYS);
        GridPane.setHgrow(tred, Priority.ALWAYS);
        GridPane.setHgrow(tgreen, Priority.ALWAYS);
        GridPane.setHgrow(tblue, Priority.ALWAYS);
        GridPane.setHalignment(tred, HPos.CENTER);
        GridPane.setHalignment(tgreen, HPos.CENTER);
        GridPane.setHalignment(tblue, HPos.CENTER);
        grid.setStyle(color("192","192","192"));
        
        grid.add(tred, 0, 0);
		grid.add(tgreen, 1, 0);
		grid.add(tblue, 2, 0);
		grid.add(red, 0, 1);
		grid.add(green, 1, 1);
		grid.add(blue, 2, 1);
		grid.setHgap(30);

		Line up = new Line(0, 100, 300, 100);
		up.setStrokeWidth(3.0);
	    
		Line down = new Line(0, 200, 300, 200);
		down.setStrokeWidth(3.0);
		
		Line left = new Line(100, 100, 100, 200);
		left.setStrokeWidth(3.0);
		
		Line right = new Line(200, 100, 200, 200);
		right.setStrokeWidth(3.0);
		
		
		
		BorderPane button = new BorderPane();
		button.setPrefSize(300, 100);
		
		Button btn = new Button();
		btn.setText(" Display Color");
		button.setCenter(btn);
		BorderPane.setAlignment(btn, Pos.CENTER);
		button.setStyle(color("192","192","192"));

	   
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!rgbCheck(red.getText(),green.getText(),blue.getText())){
					error.setVisible(true);
				}
				else{
					error.setVisible(false);
					display.setStyle(color(red.getText(),green.getText(),blue.getText()));

				}

			}
		});

		 		 
		 
		root.setTop(display);
		root.setCenter(grid);
		root.setBottom(button);
		
        root.setPrefSize(300 , 300);    

		
		
		 Group group = new Group();
			group.getChildren().addAll(root,up,down,left,right);
			primaryStage.setScene(new Scene(group, 300,300));
			primaryStage.show(); 
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private static String color(String r , String g , String b){
		StringBuilder stb = new StringBuilder();
		stb.append("-fx-background-color:  rgba("+r+","+g+","+b+");");
		
		return stb.toString();
	}
	
	
	private static boolean rgbCheck(String r , String g , String b){
		if (Integer.parseInt(r)>=0&&Integer.parseInt(g)>=0&&Integer.parseInt(b)>=0&&Integer.parseInt(r)<=256&&Integer.parseInt(g)<=256&&Integer.parseInt(b)<=256)
			return true;
		else{
			return false;
		}
		
	}
}
