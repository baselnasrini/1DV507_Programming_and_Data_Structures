package mn223dn_assign3;

import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.chart.*;
import javafx.stage.*;

public class Histogram extends Application {

	@Override
	public void start(final Stage primaryStage) {

		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);

		primaryStage.setTitle("Number Range");
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		BarChart<String, Number> prgLang = new BarChart<>(xAxis, yAxis);
		prgLang.setTitle("Number Range");
		xAxis.setLabel("Range");
		yAxis.setLabel("Value");

		XYChart.Series<String, Number> value = null;
		try {
			value = barHistogram(1, 100, 10, readFile(selectedFile.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		prgLang.getData().add(value);
		Scene scene = new Scene(prgLang, 700, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) throws IOException {
		launch(args);
	}

	public static XYChart.Series<String, Number> barHistogram(int from, int to, int range, ArrayList<Integer> arr) {

		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Range");
		yAxis.setLabel("Value");

		XYChart.Series<String, Number> values = new XYChart.Series<>();

		// newArr have the numbers inside the range
		ArrayList<Integer> newArr = new ArrayList<Integer>();
		for (int j = 0; j < arr.size(); j++) {
			if (arr.get(j) >= from && arr.get(j) <= to)
				newArr.add(arr.get(j));
		}

		int i = 0;
		int[] histo = new int[to / range];

		while (i != to / range) {
			int count = 0;
			for (int j = 0; j < newArr.size(); j++) {
				if (newArr.get(j) >= from && newArr.get(j) <= from + (range - 1)) {

					count++;
					histo[i] = count;
				}
			}
			i++;
			from += range;
		}

		for (int n = 0; n < histo.length; n++) {
			int z = n;
			String a = Integer.toString(z * range + range);
			values.getData().add(new XYChart.Data<String, Number>(a, histo[n]));

		}

		return values;
	}

	private static ArrayList<Integer> readFile(String Path) throws IOException {
		ArrayList<Integer> arr = new ArrayList<Integer>();

		Scanner sc = new Scanner(new File(Path));
		while (sc.hasNextLine()) {
			arr.add(sc.nextInt());
		}
	
		sc.close();

		return arr;
	}
}
