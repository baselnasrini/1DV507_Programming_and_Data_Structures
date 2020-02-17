package mn223dn_assign3.bouncingBall;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class BouncingBall extends StackPane {
	public BouncingBall(){
		
		this.setStyle("-fx-background-image: url(ground.jpg); -fx-background-position: center center;");
		
		this.setAlignment(Pos.TOP_LEFT);

	}



	public PathTransition newBall() {
		PathTransition pathTransition = new PathTransition();

		Path newPath = new Path();

		newPath.getElements().add(new MoveTo(50, 150));
		newPath.getElements().add(new LineTo(953, 250));
		newPath.getElements().add(new LineTo(50, 500));
		newPath.getElements().add(new LineTo(500, 650));
		newPath.getElements().add(new LineTo(953, 500));
		newPath.getElements().add(new LineTo(50, 250));
		newPath.getElements().add(new LineTo(953, 200));
		newPath.getElements().add(new LineTo(500, 50));
		newPath.getElements().add(new LineTo(50, 150));
		newPath.setVisible(false);
		
		ImageView i = new ImageView(new Image("ball.png"));
		i.setFitWidth(100.0);
		i.setPreserveRatio(true);
		
		pathTransition.setDuration(Duration.seconds(10));
		pathTransition.setPath(newPath);
		pathTransition.setNode(i);

		pathTransition.setCycleCount(Timeline.INDEFINITE);
		pathTransition.setAutoReverse(true);
		pathTransition.play();
		
		this.getChildren().addAll(newPath,i);


		return pathTransition;

	}

}