package mn223dn_assign1.XChart;

import java.util.*;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;

public class SinMain {
	public static void main(String[] args) {
	    // Create and Customize Chart
	    XYChart chart = new XYChartBuilder().width(800).height(600).build();
	    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
	    chart.getStyler().setChartTitleVisible(true);
	    chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
	    chart.getStyler().setMarkerSize(4);

	    // Generate data
	    List<Double> xData = new ArrayList <Double>();
	    List<Double> yData = new ArrayList <Double>();
	    Random random = new Random();
	    int size = 6000;
	    for (int i = 0; i < size; i++) {
	    	double x = random.nextDouble() * (2*Math.PI) ;
	        xData.add(x);
	        yData.add((1 + x/Math.PI)*Math.cos(x)*Math.cos(40*x));
	    }
			    
	    // Display scatter plot
	    chart.addSeries("Gaussian Blob", xData, yData);
	    new SwingWrapper<XYChart>(chart).displayChart();
	}
}
