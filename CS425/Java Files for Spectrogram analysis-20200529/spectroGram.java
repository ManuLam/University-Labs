package specG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.imageio.ImageIO;
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

import signal.plotXYline;


public class spectroGram {
private static double series[][];
	
		public static double[][] makespecGramArray(double[] input, int framesize, int hopsize){

	        int wavlength = input.length;
	        int totalframes = (wavlength / (hopsize))-1;
	        int framesizehalf=(int) (0.5*framesize+1);
	        int frameIndex=0;
	        
	        
	        double[][] frames = new double[totalframes][framesize];       
	        double[][] windowedframes= new double[totalframes][framesize];
	        double[] onewindowedframe= new double[framesize];
	        double[] window=new double [framesize];
	       FFT findSpec=new FFT();
	       double[][] fftArray;
	       double[] MagSpec=new double [framesize];
	       double MaxMag; //for scaling the specgram output
	       double[][] specgramArray=new double[totalframes][framesize/2+1]; 
	       double[][] specgramArrayT=new double[framesize/2+1][totalframes]; //throw away the upper half of the FFT output
	       
	       window=hannWindow(framesize); //create a window
	       //System.out.println(totalframes);
	       //hop through the data, extract the frames, multiply by the window
	        for(int index1 = 0;index1< totalframes; index1++){
	            for(int index2 = 0; index2 < framesize; index2++){
	            	frameIndex=hopsize*index1+index2;
	            	frames[index1][index2]=input[frameIndex];
	                 windowedframes[index1][index2] = window[index2] * frames[index1][index2];
	                 onewindowedframe[index2]=windowedframes[index1][index2]; //a single windowed frame of data
	            }
	            fftArray=findSpec.doFFT(onewindowedframe, framesize); //take the fft
	            MagSpec=SpecMagnitude(fftArray); //get the magnitude
	                 
	            for(int index3 = 0; index3 < (framesizehalf); index3++){
	            	specgramArrayT[index3][index1]=(MagSpec[index3]); //truncate and put into the output array
	        }
	        }        
	        return specgramArrayT;
	       
	    }
	       
		
		public static double findSpecgramMax(double[][] specGramArray){
			double MaxMag=1;
			int totalframes=specGramArray[0].length;
			int framesizehalf=specGramArray.length	;
		for(int index1 = 0;index1< framesizehalf; index1++){
		    for(int index2 = 0; index2 < totalframes; index2++){
	        	MaxMag=Math.max(MaxMag,specGramArray[index1][index2]);
	    }
		}
		return MaxMag;
		}
	   public static double[][] normaliseSpecGram(double[][] specGramArray, double MaxMag){
			int totalframes=specGramArray[0].length; 
			int framesizehalf=specGramArray.length	;

		   for (int index1=0;index1<framesizehalf;index1++) {
		   for (int index2=0;index2<totalframes;index2++){
				  specGramArray[index1][index2]=specGramArray[index1][index2]/MaxMag;
			   }   
			   }
		   
		   return specGramArray;
	   }

	   public static double[][] normalisedBSpecGram(double[][] input, double MaxMag){
	   	int totalframes = input[0].length;
	    int framesizehalf=input.length;
	    double[][] output=new double[framesizehalf][totalframes];
	    double Bottom;
	    Bottom=-96; //lowest dB value in the spectrogram
		   
			   for (int index1=0;index1<framesizehalf;index1++){
				  for (int index2=0;index2<totalframes;index2++) {
					  output[index1][index2]=20*Math.log10(input[index1][index2]);
					  if (output[index1][index2]<Bottom) {
						  output[index1][index2]=Bottom;
					  }
					  output[index1][index2]=output[index1][index2]/(-Bottom);
					  output[index1][index2]=output[index1][index2]+1;
				   }   
				   }

	    
		return output;
	   }

	   //hanning window
	    public static double[] hannWindow(int wavlength){
	        double[] window = new double[wavlength];
	       
	        double wavlengthD=(double) wavlength;
	        for(int index = 0; index< wavlength; index++){
	            window[index] = 0.5 * (1 - Math.cos(((2*Math.PI)*index) /(wavlength-1)));
	        }
	       
	        return window;
	    }
	    
	    public static double[] SpecMagnitude(double[][] dftArray){
			int Len=dftArray[0].length;
			double[] SpecMag=new double[Len];
			for(int k=0;k<Len;k++){
				SpecMag[k]=Math.sqrt(Math.pow(dftArray[0][k], 2)+Math.pow(dftArray[1][k], 2));
			}
			
			return SpecMag;
		}
	   
	//math operation to flip array around
	    public static double[][] flipArray(double[][] input){
			int totalframes=input[0].length; 
			int framesizehalf=input.length	;
	        double[][] output=new double[framesizehalf][totalframes];
	 	   
	 		   for (int index1=0;index1<framesizehalf;index1++){
	 			  for (int index2=0;index2<totalframes;index2++) {
	 				  output[framesizehalf-index1-1][index2]=input[index1][index2];
	 			   }   
	 			   }
	 
	        
	    	return output;
	    }
	    public static void plotSpecGramAsImage(double[][] specGramArray,double Fs){
	    	int totalframes = specGramArray[0].length; //HEIGHT
	        int framesizehalf=specGramArray.length; //WIDTH	
	        double[] timeAxis=makeTimeAxis(Fs, totalframes, framesizehalf);
	        double[] freqAxis=makeFrequencyAxis(Fs, framesizehalf);
	        
	        int totalPoints=totalframes*framesizehalf;
	        

	        double[][] specgramPlot=new double[3][totalPoints];
	        int frameIndex=0;
	        	for(int index1=0;index1<totalframes;index1++) {
	        		for(int index2=0;index2<framesizehalf;index2++) {
	        			frameIndex=framesizehalf*index1+index2;
	        			
	        			specgramPlot[0][frameIndex]=index1;
	        			specgramPlot[1][frameIndex]=index2;
	        			specgramPlot[2][frameIndex]=Math.round(255.0*(specGramArray[index2][index1]));
	        	}
	        	}
	        	
	        	plotXYrender.makeXYGraph(specgramPlot);
	        	}
	      
	    
	    	
	    
	    
	    public static double[] makeFrequencyAxis(double Fs, int N){
			double[] freqAxis=new double[N];
			double ND=(double) 2.0*(N-1);
			freqAxis[0]=0.0;
			for(int index=1;index<N;index++){
				double indexD=(double) index;
				freqAxis[index]=indexD*Math.pow(ND,-1)*Fs;
			}
			return freqAxis;
		}
	    
	    public static double[] makeTimeAxis(double Fs, int N, int framesizeHalf){
			double[] timeAxis=new double[N];
			double ND=(double) N;
			double Tf=(double) (framesizeHalf-1)/Fs;
			timeAxis[0]= 0.0;
			for(int index=1;index<N;index++){
				double indexD=(double) index;
				timeAxis[index]=indexD*Tf;
				}
			
			return timeAxis;
		}
	    public static JFreeChart generateGraph() {
			DefaultXYZDataset dataset = new DefaultXYZDataset();
			dataset.addSeries("", series);
			ValueAxis abscisse = new NumberAxis("Time");
			ValueAxis ordinate = new NumberAxis("Frequency");
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
	    public static void plotSpecGramAsImage(double[][] specGramArray){
			
	    	int totalframes = specGramArray[0].length; //HEIGHT
	        int framesizehalf=specGramArray.length; //WIDTH
	        
	        int WIDTH=framesizehalf;int HEIGHT=totalframes;
	        double[][] specGram=new double[framesizehalf][totalframes];
	    	//specGram=flipArray(specGramArray);
	    	
	    	//for(int index=0;index<framesizehalf;index++){
	    	//System.out.println(specGramArray[index][10]);
	    	//}
	        //System.out.println(specGramArray.length); 1025
	        
	        final BufferedImage img = new BufferedImage(totalframes, framesizehalf,BufferedImage.TYPE_INT_RGB);
	        Graphics2D g = (Graphics2D)img.getGraphics();
	        
	        for(int i = 0; i < totalframes; i++) {
	            for(int j = 0; j < framesizehalf; j++) {
	                float c = (float) specGramArray[framesizehalf-1-j][i];
	                g.setColor(new Color(c, c, c));
	                g.fillRect(i, j,1, 1);

	            }
	        }
	        
	        JFrame frame = new JFrame("Spectrogram");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        JPanel panel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                Graphics2D g2d = (Graphics2D)g;
	                g2d.clearRect(0, 0, getWidth(), getHeight());
	                g2d.setRenderingHint(
	                        RenderingHints.KEY_INTERPOLATION,
	                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	                        // Or _BICUBIC
	                
	                g2d.scale(1, 1);
	                g2d.drawImage(img, 0, 0, this);
	             
	              	            }
	        };
	        int X=(int) (scaleX*(double)totalframes);
	        int Y=(int) (scaleY*(double)framesizehalf);
	        panel.setPreferredSize(new Dimension(X,Y));
	        frame.getContentPane().add(panel);
	        frame.pack();
	        frame.setVisible(true);
	    }

	    public void render(double[][] specgramArray) {
			// get the spectrogram data
			double[][] spectrogram = specgramArray;
			System.out.println(spectrogram[0].length);
			// get the image size
			int width = spectrogram.length; //frequency bins
			int height = spectrogram[0].length; //totalframes
			
			 //Picture picture = new Picture(picture);
		        
			//for(int i = 0; i < height; i++) {
	         //   for(int j = 0; j < width; j++) {
	            	try {
	            	    BufferedImage image = null;
	            	    System.out.println(height + " " +width);
	            	    for(int i=0; i<width; i++) {
	            	    		for(int j=0; j<height; j++) {
	            	            //int a = (int) (255.0* spectrogram[i][j]);
	            	    			System.out.println(i + " " +j);
	            	            //Color newColor = new Color(a,a,a);
	            	            //image.setRGB(j,i,newColor.getRGB());
	            	        }
	            	        
	            	    }
	            	    File output = new File("GrayScale.jpg");
	            	    
	            	    ImageIO.write(image, "jpg", output);
	            	}

	            	catch(Exception e) {}
	            }
	        
		
		
public static void setImageScaleValues(double x, double y) {
	scaleX=x; scaleY=y;
}
	  */
/*
	    try {
    	  	FileWriter writer = new FileWriter("series1.txt",true);
    	  		for(int index22=0;index22<totalPoints;index22++) {
        			//System.out.println("series=[0]["+index22+"]="+specgramPlot[0][index22]);
        			//writer.write("series[0]["+index22+"]="+specgramPlot[0][index22]+"\r\n");
        			writer.write(specgramPlot[0][index22]+"\r\n");
        		}    writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	 
    	try {
    	  	FileWriter writer = new FileWriter("series2.txt",true);
    	  		for(int index22=0;index22<totalPoints;index22++) {
        			//System.out.println("series=[0]["+index22+"]="+specgramPlot[0][index22]);
        			//writer.write("series[0]["+index22+"]="+specgramPlot[0][index22]+"\r\n");
        			writer.write(specgramPlot[1][index22]+"\r\n");
        		}    writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	try {
    	  	FileWriter writer = new FileWriter("series3.txt",true);
    	  		for(int index22=0;index22<totalPoints;index22++) {
        			//System.out.println("series=[0]["+index22+"]="+specgramPlot[0][index22]);
        			//writer.write("series[0]["+index22+"]="+specgramPlot[0][index22]+"\r\n");
        			writer.write(specgramPlot[2][index22]+"\r\n");
        		}    writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	/*
    			for(int index22=0;index22<1032;index22++) {
        			System.out.println("series[1]["+index22+"]="+specgramPlot[1][index22]);
        			//writer.write("series[1]["+index22+"]="+specgramPlot[1][index22]+"\r\n");
        			writer.write(specgramPlot[1][index22]+"\r\n");
        		} 
    			for(int index22=0;index22<1032;index22++) {
        			System.out.println("series[2]["+index22+"]="+specgramPlot[2][index22]);
        			//writer.write("series[2]["+index22+"]="+specgramPlot[2][index22]+"\r\n");
        			writer.write(specgramPlot[2][index22]+"\r\n");
        		}
    		*/

