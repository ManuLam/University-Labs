package specG;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.GrayPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.ui.RectangleInsets;

public class plotXYrender {
	private static double series[][];

	// Get the graph (generateGraph will create the JFreeChart graph and add
	public static void makeXYGraph(double[][] input) {
		// the red and blue point on it).
		JFreeChart jFreeChart = generateGraph(input);
		// Put the jFreeChart in a chartPanel
		ChartPanel chartPanel = new ChartPanel(jFreeChart);
		chartPanel.setPreferredSize(new Dimension(800, 600));
		chartPanel.setPopupMenu(null);
		chartPanel.setDomainZoomable(true);
		chartPanel.setRangeZoomable(true);

		JPanel jPanel4 = new JPanel();
		jPanel4.setLayout(new BorderLayout());
		jPanel4.add(chartPanel, BorderLayout.NORTH);
		JFrame frame = new JFrame();
		frame.add(jPanel4);
		frame.pack();
		frame.setVisible(true);

		//JPanel content = new JPanel(new GridLayout());
		//p.setLayout(new FlowLayout());
		//Container content =  
		//Container content = getRootPane();
		//content.setLayout(layout);
		//content.add(chartPanel);
		//content.add(new ChartPanel(generateColorBar(0)));
		//content.validate();			
		//Container content = getRootPane();
		//p.setLayout(layout);
		//p.add(chartPanel);
		//p.add(new ChartPanel(generateColorBar(0)));
		//p.validate();

	}

	public static JFreeChart generateGraph(double[][] input) {
		series=input;
		DefaultXYZDataset dataset = new DefaultXYZDataset();
		dataset.addSeries("", series);
		ValueAxis abscisse = new NumberAxis("Time index");
		ValueAxis ordinate = new NumberAxis("Frequency bin");
		abscisse.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		ordinate.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		XYBlockRenderer renderer = new XYBlockRenderer();
		renderer.setPaintScale(new GrayPaintScale(0, 255));
		XYPlot xyPlot = new XYPlot(dataset, abscisse, ordinate, renderer);
		xyPlot.setAxisOffset(new RectangleInsets());
		JFreeChart jFreeChart = new JFreeChart(xyPlot);
		return jFreeChart;
	}

}


/*
 * 	  try {
	            FileReader reader = new FileReader("C:/Users/Joe/eclipse-workspace/chartExample/src/specApp/series1.txt");
	            BufferedReader bufferedReader = new BufferedReader(reader);
	             String line;
	             int count=0;
	            while ((line = bufferedReader.readLine()) != null) {
	                //System.out.println(count+ " " +line);
	            	double input=Double.valueOf(line);
	            	series[0][count]=Math.round(input*44100.0/128.0);
	            	System.out.println(series[0][count]);
	            	count++;
	            }
	            reader.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  try {
	            FileReader reader = new FileReader("C:/Users/Joe/eclipse-workspace/chartExample/src/specApp/series2.txt");
	            BufferedReader bufferedReader = new BufferedReader(reader);
	             String line;
	             int count=0;
	            while ((line = bufferedReader.readLine()) != null) {
	                //System.out.println(line);
	            	double input=Double.valueOf(line);
	            	series[1][count]=Math.round(256.0*input/44100.0);
	            	count++;
	            }
	            reader.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  try {
	            FileReader reader = new FileReader("C:/Users/Joe/eclipse-workspace/chartExample/src/specApp/series3.txt");
	            BufferedReader bufferedReader = new BufferedReader(reader);
	             String line;
	             int count=0;
	            while ((line = bufferedReader.readLine()) != null) {
	                //System.out.println(line);
	            	double input=Double.valueOf(line);
	            	series[2][count]=Math.round(255.0*(input));

	            	count++;
	            }
	            reader.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
 */
