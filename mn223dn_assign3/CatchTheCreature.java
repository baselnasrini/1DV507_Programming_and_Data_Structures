package mn223dn_assign3;

import java.util.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

public class CatchTheCreature extends Application {

	private int count = 0;

	@Override
	public void start(final Stage primaryStage) {
		primaryStage.setTitle("Fly!");
		Image im = new Image("lnu.jpg", 50, 50, false, false);
		ImageView image = new ImageView(im);
		image.setTranslateX(300);
		image.setTranslateY(300);

		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

		Text tx = new Text();
		tx.setFont(new Font("Arial", 32));
		tx.setEffect(ds);
		tx.setCache(true);

		tx.setTranslateX(200);
		tx.setTranslateY(300);

		Group layout = new Group();
		layout.getChildren().addAll(image, tx);

		Scene scene = new Scene(layout, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();

		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				Random ran = new Random();
				int x = ran.nextInt(651);
				int y = ran.nextInt(651);

				image.setTranslateX(x);
				image.setTranslateY(y);

				scene.setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						count++;
						if (e.getX() >= x && e.getX() <= x + 50 && e.getY() >= y && e.getY() <= y + 50) {
							tx.setText("Win After " + count + " Clicks.");
							t.cancel();
						}
					}
				});
			}
		}, 0, 600);
	}

	public static void main(String[] args) {
		launch(args);
	}

}