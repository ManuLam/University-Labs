package Frequency;

import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.*;
import org.jfree.data.*;

public class plotXYline {

	double[] plotTwoPeriodsSignal(double[] signal, double Fs, double pitch){
		double TwoPeriod=2*(Fs/pitch);
		double[] SignalTwoPeriod=new double[(int) TwoPeriod];
		SignalTwoPeriod=getTwoPeriod(signal,Fs, TwoPeriod);
		return SignalTwoPeriod;
	}

	double[] plotTimeAxisTwoPeriods(double[] signal, double Fs, double pitch){
		int durSamps=signal.length;
		double[] timeAxis=new double[durSamps];
		double TwoPeriod=2*(Fs/pitch);
		double[] timeAxisTwoPeriod=new double[(int) TwoPeriod];

		for (int index=1;index<durSamps;index++){
			timeAxis[index]=index/Fs;
		}
		timeAxisTwoPeriod=getTwoPeriod(timeAxis,Fs, TwoPeriod);
		return timeAxisTwoPeriod;
	}


	double[] getTwoPeriod(double[] input,double Fs, double TwoPeriodF){
		int TwoPeriod=(int) TwoPeriodF;
		double[] output=new double[TwoPeriod];
		for (int index=0;index<TwoPeriod;index++){
			output[index]=input[index];
		}
		return output;
	}

	public void plotData(double[] x, double[] y, String titleText, String xLabel, String yLabel, String FrameName){
		XYSeries series = new XYSeries("");
		int N=x.length;
		for (int k=0;k<N;k++){
			series.add(x[k], y[k]);   
		}

		XYDataset xyDataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart
				(titleText, xLabel, yLabel,
						xyDataset, PlotOrientation.VERTICAL, false, true, false);
		//ChartFrame frame1=new ChartFrame(FrameName,chart);
		//frame1.setVisible(true);
		//frame1.setSize(600,600);
		//frame1..setDomainZoomable(true);

		ChartPanel chartpanel = new ChartPanel(chart);
		chartpanel.setDomainZoomable(true);
		chartpanel.setRangeZoomable(true);

		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new BorderLayout());
		jPanel1.add(chartpanel, BorderLayout.NORTH);

		JFrame frame = new JFrame();
		frame.add(jPanel1);
		frame.pack();
		frame.setVisible(true);

		double[] yBounds=getYBound(y);
		chart.getXYPlot().getRangeAxis().setLowerBound(yBounds[0]);
		chart.getXYPlot().getRangeAxis().setUpperBound(yBounds[1]);
		chart.getXYPlot().getDomainAxis().setLowerBound(0);
		double xfinal=getxBound(x);
		chart.getXYPlot().getDomainAxis().setUpperBound(xfinal);


	}
	public static double[] makeTimeAxis(int length,double Fs) {
		double[] timeAxis=new double[length];
		for(int i=0;i<length;i++) {
			timeAxis[i]=(double) i/Fs;
		}
		return timeAxis;
	}
	public static double getxBound(double[] x) {
		int N=x.length;
		double xfinal=x[N-1];
		return xfinal;
	}
	public static double[] getYBound(double[] y) {
		int N=y.length;
		double[] yBounds=new double[2];
		Arrays.sort(y);
		double Minimum =y[0];
		double Maximum=y[N-1];
		yBounds[0]=1.5*Minimum;
		yBounds[1]=1.5*Maximum;
		return yBounds;
	}

}

