package mn223dn_assign1.XChart;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.LegendPosition;

public class Histogram {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		
// C:\\temp\\numbers.txt
		
		try {
			System.out.print("Insert the txt file path: ");
			Scanner sca = new Scanner(System.in);
			File input = new File(sca.nextLine());
			Scanner sc = new Scanner(input);
			while (sc.hasNextLine()) {
				arr.add(sc.nextInt());
			}
			
			
			pieHistogram(1,100,10,arr);
			
			barHistogram(1,100,10,arr);

			
			sc.close();
			sca.close();
		}
		
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("as");
		}
		
		 
		
	}

	/* choose numbers from integer array list between the values @form to @to
	*  show them in a pie histogram divided by the range @range
	**/
	public static void pieHistogram(int from, int to, int range, ArrayList<Integer> arr) {
		PieChart chart = new PieChartBuilder().height(600).width(600).build();

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

			String ran = Integer.toString(from)+"-"+Integer.toString(from + (range - 1));
			chart.addSeries(ran, count);
			
			i++;
			from += range;
		}
		
		new SwingWrapper<PieChart>(chart).displayChart();
	}
	
	/* choose numbers from integer array list between the values @form to @to
	*  show them in a bar histogram divided by the range @range
	**/
	public static void barHistogram(int from, int to, int range, ArrayList<Integer> arr) {
	    
		CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Number Range").xAxisTitle("Range").yAxisTitle("Value").build();
	    chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
	    chart.getStyler().setHasAnnotations(true);
	    
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
	    
	    int[] ran = new int[to/range];
	    int ra = range ;
	    
	    for (int f=0 ; f<ran.length ; f++){
	    	ran[f]= range;
	    	range = range +ra ;
	    }
	    for (int s : ran)
			System.out.print( s + " ");
		chart.addSeries("Range",ran, histo);

	    new SwingWrapper<CategoryChart> (chart).displayChart();
	}

}