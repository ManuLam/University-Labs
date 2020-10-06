package Frequency;

import java.util.Random;

import signal.stdAudio;

public class signalGen {
	//Generate a simple sinusoidal test signal
	public static double[] SineGen(double Amplitude, double fhz, double Fs, double tdur, double phaseShift){
		int Len=(int) (tdur*Fs);
		double[] signal=new double[Len];
		double pi=Math.PI;

		for (int n=0;n<Len;n++){
			signal[n]=Amplitude*Math.sin(2*pi*n*fhz/Fs+phaseShift);	
		}
		return signal;	
	}

	//Generate a simple cosinusoidal test signal
	public static double[] CosineGen(double Amplitude, double fhz, double Fs, double tdur, double phaseShift){
		int Len=(int) (tdur*Fs);
		double[] signal=new double[Len];
		double pi=Math.PI;

		for (int n=0;n<Len;n++){
			signal[n]=Amplitude*Math.cos(2*pi*n*fhz/Fs+phaseShift);	
		}
		return signal;	
	}

	public static double[] MultiSine(double[] amplitudeVect, double[] fhzVect, double Fs, double tdur, double[] phaseShiftVect){
		int Len=(int) (tdur*Fs);
		double[] signal=new double[Len];
		double[] partial=new double[Len];
		double pi=Math.PI;

		for (int partialNumber=0;partialNumber<amplitudeVect.length;partialNumber++){
			double amp=amplitudeVect[partialNumber];
			double freq=fhzVect[partialNumber];
			double phase=phaseShiftVect[partialNumber];
			for (int n=0;n<Len;n++){
				partial[n]=amp*Math.sin(2*pi* n*freq/Fs+phase);	
									}
			signal=addArray(signal,partial);
					}
		return signal;	
	}
	
	public static double[] whiteNoise(int noiseLength)  { //White Noise
		Random r = new Random();
		double[] wn=new double[noiseLength];
		for(int i=0;i<noiseLength;i++) {
			double val = r.nextGaussian();
			wn[i]=val;
		}
		return wn;
	}
	//Reads a wav file
	public static double[] readInput(String filename){
		double[] input=null;

		input=stdAudio.read(filename);
		return input;
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
	//add two arrays together
	public static double[] addArray(double[] x, double[] y){
		int Len=x.length;
		double[] z=new double[Len];
		for (int index=0;index<Len;index++){
			z[index]=x[index]+y[index];
		}
		return z;
	}
	//multiply two arrays together
	public static double[] mulArray(double[] x, double[] y){
		int Len=x.length;
		double[] z=new double[Len];
		for (int index=0;index<Len;index++){
			z[index]=x[index]*y[index];
		}
		return z;
	}

}
