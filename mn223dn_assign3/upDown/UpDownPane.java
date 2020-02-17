package mn223dn_assign3.upDown;

import java.util.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class UpDownPane extends GridPane {

	public UpDownPane() {
		Image lnu = new Image("lnu.jpg", 100, 100, false, false);
		ImageView image = new ImageView(lnu);

		sizing(this);

		this.add(image, 3, 3);

		image.setOnMouseClicked(e -> {

			Random ra = new Random();
			int move = 1 + ra.nextInt(4);
			

			if (move == 1) {
				int x = (int) image.getLayoutX() / 100 + 1;
				int y = (int) image.getLayoutY() / 100;

				if (x == 7)
					x = 0;

				this.getChildren().remove(image);
				this.add(image, x, y);

			}

			if (move == 2) {
				int x = (int) image.getLayoutX() / 100 - 1;
				int y = (int) image.getLayoutY() / 100;

				if (x == -1)
					x = 6;

				this.getChildren().remove(image);
				this.add(image, x, y);
			}
			if (move == 3) {
				int x = (int) image.getLayoutX() / 100;
				int y = (int) image.getLayoutY() / 100 + 1;

				if (y == 7) {
					y = 0;
				}

				this.getChildren().remove(image);
				this.add(image, x, y);

			}
			if (move == 4) {
				int x = (int) image.getLayoutX() / 100;
				int y = (int) image.getLayoutY() / 100 - 1;

				if (y == -1)
					y = 6;

				this.getChildren().remove(image);
				this.add(image, x, y);
			}
		});

	//	this.setGridLinesVisible(true);

	}

	private static void sizing(GridPane p) {
		
		for (int rowIndex = 0; rowIndex < 7; rowIndex++) {
			RowConstraints rc = new RowConstraints(100);
			rc.setVgrow(Priority.ALWAYS);
			rc.setFillHeight(true);

			p.getRowConstraints().add(rc);
		}
		
		for (int colIndex = 0; colIndex < 7; colIndex++) {
			
			ColumnConstraints cc = new ColumnConstraints(100);
			cc.setHgrow(Priority.ALWAYS);
			cc.setFillWidth(true);

			p.getColumnConstraints().add(cc);
		}
	}

}
