package mn223dn_assign2.randomPanel;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class RandomPanel extends BorderPane {

	public RandomPanel() {

		BorderPane up = new BorderPane();

		BorderPane down = new BorderPane();
		down.setPrefSize(200, 100);

		Random ran = new Random();

		

		Button btn = new Button();
		btn.setText("New Random");
		btn.setMaxWidth(200);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Label num = new Label(Integer.toString(1 + ran.nextInt(100)));
				num.setFont(new Font("Arial", 100));
				down.setCenter(num);

			}
		});

		up.setBottom(btn);
		
		this.setTop(up);
		this.setBottom(down);
	}
}
