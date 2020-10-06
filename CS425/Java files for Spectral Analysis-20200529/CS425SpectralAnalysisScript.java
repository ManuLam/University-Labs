package Frequency;

import java.util.Random;
import java.util.Scanner;

import signal.plotXYline;
import signal.signalGen;
import signal.stdAudio;

public class CS425SpectralAnalysisScript {
public static int playSoundFlag=1;

	public static void main(String args[]) {
	Scanner scan = new Scanner(System.in);
    System.out.print("Enter the plot number: ");
    int plotNumber = scan.nextInt();
    // Closing Scanner after the use
    scan.close(); 
    
	if (plotNumber==1) { //Sinusoidal signal  frequency = 1110Hz, Fs=11025, and FFTlength=2048 
	signalGen sig_s=new signalGen();
	plotXYline makePlot_s=new plotXYline();
	FFT fourierTransform=new FFT();
	double fhz_s=1110;
	double Fs_s=11025;
	double tdur_s=1;
	double Amplitude_s=1;
	double phaseShift_s=0;
	double[] output1s=sig_s.SineGen(Amplitude_s,fhz_s,Fs_s,tdur_s,phaseShift_s);
	double[] twoPeriodsSignal=makePlot_s.plotTwoPeriodsSignal(output1s, Fs_s, fhz_s);
	double[] twoPeriodsTimeAxis=makePlot_s.plotTimeAxisTwoPeriods(output1s, Fs_s, fhz_s);
	makePlot_s.plotData(twoPeriodsTimeAxis, twoPeriodsSignal, "Single Sinewave", "Time (Sec)", "Amplitude", "Signal Plots");
	
	int FFTlength=2048;
	double[][] frequencySpectrum=new double[2][FFTlength];
	double[] Magnitude=new double[FFTlength];
	double[] Phase=new double[FFTlength];
	double[] faxis=new double[FFTlength];
	
	frequencySpectrum=fourierTransform.doFFT(output1s, FFTlength);
	boolean halfSpectrum=false;
	Magnitude=fourierTransform.SpecMagnitude(frequencySpectrum,halfSpectrum);
	Phase=fourierTransform.SpecPhase(frequencySpectrum,halfSpectrum);
	faxis=fourierTransform.makeFrequencyAxis(Fs_s,FFTlength,halfSpectrum);
	System.out.println(Magnitude.length);
	makePlot_s.plotData(faxis, Magnitude, "Magnitude of Frequency Spectrum of Sinewave with FFT length=2048 and Sampling Frequency=11025", "Frequency (Hz)", "Magnitude", "Spectral Plots");
	makePlot_s.plotData(faxis, Phase, "Phase of Frequency Spectrum of Sinewave with FFT length=2048 and Sampling Frequency=11025", "Frequency (Hz)", "Magnitude", "Spectral Plots");
	
	String FreqResolution=Double.toString(Fs_s/(double) FFTlength);
	String message="Frequency Resolution of FFT length=2048 for Fs=11025 is "+ FreqResolution+"Hz";
	System.out.println(message);

	} else if (plotNumber==2) { //Sinusoidal signal frequency = 1110Hz, Fs=11025, and FFTlength=8192
	signalGen sig_s=new signalGen();
	plotXYline makePlot_s=new plotXYline();
	FFT fourierTransform=new FFT();
	double fhz_s=1110;
	double Fs_s=11025;
	double tdur_s=1;
	double Amplitude_s=1;
	double phaseShift_s=0;
	double[] output1s=sig_s.SineGen(Amplitude_s,fhz_s,Fs_s,tdur_s,phaseShift_s);
	double[] twoPeriodsSignal=makePlot_s.plotTwoPeriodsSignal(output1s, Fs_s, fhz_s);
	double[] twoPeriodsTimeAxis=makePlot_s.plotTimeAxisTwoPeriods(output1s, Fs_s, fhz_s);
	makePlot_s.plotData(twoPeriodsTimeAxis, twoPeriodsSignal, "Single Sinewave", "Time (Sec)", "Amplitude", "Signal Plots");
	
	int FFTlength=8192;
	double[][] frequencySpectrum=new double[2][FFTlength];
	double[] Magnitude=new double[FFTlength];
	double[] Phase=new double[FFTlength];
	double[] faxis=new double[FFTlength];
	
	frequencySpectrum=fourierTransform.doFFT(output1s, FFTlength);
	boolean halfSpectrum=false;
	Magnitude=fourierTransform.SpecMagnitude(frequencySpectrum,halfSpectrum);
	Phase=fourierTransform.SpecPhase(frequencySpectrum,halfSpectrum);
	faxis=fourierTransform.makeFrequencyAxis(Fs_s,FFTlength,halfSpectrum);
	makePlot_s.plotData(faxis, Magnitude, "Magnitude of Frequency Spectrum of Sinewave with FFT length=8192 and Sampling Frequency=11025", "Frequency (Hz)", "Magnitude", "Spectral Plots");
	makePlot_s.plotData(faxis, Phase, "Phase of Frequency Spectrum of Sinewave with FFT length=8192 and Sampling Frequency=11025", "Frequency (Hz)", "Magnitude", "Spectral Plots");
	
	String FreqResolution=Double.toString(Fs_s/(double) FFTlength);
	String message="Frequency Resolution of FFT length=8192 for Fs=11025 is "+ FreqResolution+"Hz";
	System.out.println(message);
	} else if (plotNumber==3) { //Demonstration of Resolution 
		signalGen sig_s=new signalGen();
		plotXYline makePlot_s=new plotXYline();
		FFT fourierTransform=new FFT();
		double fhz1_s=1110;
		double fhz2_s=1114;
		double Fs_s=11025;
		double tdur_s=1;
		double Amplitude_s=0.5;
		double phaseShift_s=0;
		double[] output1s=sig_s.SineGen(Amplitude_s,fhz1_s,Fs_s,tdur_s,phaseShift_s);
		double[] output2s=sig_s.SineGen(Amplitude_s,fhz2_s,Fs_s,tdur_s,phaseShift_s);
		double[] outputTotal=sig_s.addArray(output1s, output2s);
		double[] twoPeriodsSignal=makePlot_s.plotTwoPeriodsSignal(outputTotal, Fs_s, fhz1_s);
		double[] twoPeriodsTimeAxis=makePlot_s.plotTimeAxisTwoPeriods(outputTotal, Fs_s, fhz1_s);
		makePlot_s.plotData(twoPeriodsTimeAxis, twoPeriodsSignal, "Two Sinewaves only 4Hz apart", "Time (Sec)", "Amplitude", "Signal Plots");
				
		int FFTlength_2048=2048;
		double[][] frequencySpectrum_2048=new double[2][FFTlength_2048];
		double[] Magnitude_2048=new double[FFTlength_2048];
		double[] faxis_2048=new double[FFTlength_2048];
		
		frequencySpectrum_2048=fourierTransform.doFFT(output1s, FFTlength_2048);
		boolean halfSpectrum=true;
		Magnitude_2048=fourierTransform.SpecMagnitude(frequencySpectrum_2048,halfSpectrum);
		faxis_2048=fourierTransform.makeFrequencyAxis(Fs_s,FFTlength_2048,halfSpectrum);
		makePlot_s.plotData(faxis_2048, Magnitude_2048, "Magnitude of Frequency Spectrum of Two Sinewaves with FFT length=2048 and Sampling Frequency=11025", "Frequency (Hz)", "Magnitude", "Spectral Plots");
				
		String FreqResolution_2048=Double.toString(Fs_s/(double) FFTlength_2048);
		String message1="Frequency Resolution of FFT length=2048 for Fs=11025 is "+ FreqResolution_2048+"Hz";
		System.out.println(message1);
		
		int FFTlength_8192=8192;
		double[][] frequencySpectrum_8192=new double[2][FFTlength_8192];
		double[] Magnitude_8192=new double[FFTlength_8192];
		double[] faxis_8192=new double[FFTlength_8192];
		
		frequencySpectrum_8192=fourierTransform.doFFT(outputTotal, FFTlength_8192);
		Magnitude_8192=fourierTransform.SpecMagnitude(frequencySpectrum_8192,halfSpectrum);
		faxis_8192=fourierTransform.makeFrequencyAxis(Fs_s,FFTlength_8192,halfSpectrum);
		makePlot_s.plotData(faxis_8192, Magnitude_8192, "Magnitude of Frequency Spectrum of Two Sinewaves with FFT length=8192 and Sampling Frequency=11025", "Frequency (Hz)", "Magnitude", "Spectral Plots");
			
		String FreqResolution_8192=Double.toString(Fs_s/(double) FFTlength_8192);
		String message2="Frequency Resolution of FFT length=8192 for Fs=11025 is "+ FreqResolution_8192+"Hz";
		System.out.println(message2);
		} else if (plotNumber==4) { //dB magnitude analysis
			signalGen sig_s=new signalGen();
			plotXYline makePlot_s=new plotXYline();
			plotXYline makePlot_sdB=new plotXYline();
			FFT fourierTransform=new FFT();
			double fhz_s=1110;
			double Fs_s=11025;
			double tdur_s=1;
			double Amplitude_s=0.5;
			double phaseShift_s=0;
			double[] output1s=sig_s.SineGen(Amplitude_s,fhz_s,Fs_s,tdur_s,phaseShift_s);
					
			int FFTlength=2048;
			double[][] frequencySpectrum=new double[2][FFTlength];
			double[] Magnitude_Lin=new double[FFTlength];
			double[] Magnitude_dB=new double[FFTlength];
			double[] faxis=new double[FFTlength];
			
			frequencySpectrum=fourierTransform.doFFT(output1s, FFTlength);
			boolean halfSpectrum=true;
			Magnitude_Lin=fourierTransform.SpecMagnitude(frequencySpectrum,halfSpectrum);
			Magnitude_dB=fourierTransform.convert2dB(Magnitude_Lin);
			faxis	=fourierTransform.makeFrequencyAxis(Fs_s,FFTlength,halfSpectrum);
			makePlot_s.plotData(faxis, Magnitude_Lin, "Magnitude of Frequency Spectrum of Sinewave with FFT length=2048 and Sampling Frequency=11025", "Frequency (Hz)", "Magnitude", "Spectral Plots");
			
			
			makePlot_sdB.plotData(faxis, Magnitude_dB, "Magnitude in dB of Frequency Spectrum of Sinewave with FFT length=2048 and Sampling Frequency=11025", "Frequency (Hz)", "Magnitude", "Spectral Plots");
			} else if (plotNumber==5) { //Windowing
				signalGen sig_s=new signalGen();
				plotXYline makePlot_s=new plotXYline();
				FFT fourierTransform=new FFT();
				double fhz_s=1110;
				double Fs_s=11025;
				double tdur_s=1;
				double Amplitude_s=0.5;
				double phaseShift_s=0;
				double[] output1s=sig_s.SineGen(Amplitude_s,fhz_s,Fs_s,tdur_s,phaseShift_s);
						
				int FFTlength=2048;
				double[][] frequencySpectrum_Rect=new double[2][FFTlength];
				double[][] frequencySpectrum_Hann=new double[2][FFTlength];
				double[] Magnitude_Lin_Rect=new double[FFTlength];
				double[] Magnitude_Lin_Hann=new double[FFTlength];
				double[] Magnitude_dB_Rect=new double[FFTlength];
				double[] Magnitude_dB_Hann=new double[FFTlength];
				double[] faxis=new double[FFTlength];
				int sigLen=2000;
				double[] rectangular=new double[sigLen];
				double[] winSigRect=new double[sigLen];
				double[] hanning=new double[sigLen];
				double[] winSigHann=new double[sigLen];
				
				rectangular=fourierTransform.rectWindow(sigLen);
				hanning=fourierTransform.hannWindow(sigLen);
				winSigRect=fourierTransform.applyWindow(output1s, rectangular, sigLen);
				winSigHann=fourierTransform.applyWindow(output1s, hanning, sigLen);
				frequencySpectrum_Rect=fourierTransform.doFFT(winSigRect, FFTlength);
				frequencySpectrum_Hann=fourierTransform.doFFT(winSigHann, FFTlength);
				boolean halfSpectrum=true;
				Magnitude_Lin_Rect=fourierTransform.SpecMagnitude(frequencySpectrum_Rect,halfSpectrum);
				Magnitude_Lin_Hann=fourierTransform.SpecMagnitude(frequencySpectrum_Hann,halfSpectrum);
				Magnitude_dB_Rect=fourierTransform.convert2dB(Magnitude_Lin_Rect);
				Magnitude_dB_Hann=fourierTransform.convert2dB(Magnitude_Lin_Hann);
				faxis=fourierTransform.makeFrequencyAxis(Fs_s,FFTlength,halfSpectrum);
				makePlot_s.plotData(faxis, Magnitude_dB_Rect,"Magnitude of Frequency Spectrum of Sinewave with FFT length=2048, Rectangular window", "Frequency (Hz)", "Magnitude", "Spectral Plots");
						
				makePlot_s.plotData(faxis, Magnitude_dB_Hann, "Magnitude of Frequency Spectrum of Sinewave with FFT length=2048, Hanning window", "Frequency (Hz)", "Magnitude", "Spectral Plots");
				} else if (plotNumber==6) { //Windowing a multisine signal
					signalGen sig_s=new signalGen();
					plotXYline makePlot_s=new plotXYline();
					FFT fourierTransform=new FFT();
					
					double Fs_m=11025;
					double[] fhzVect_m= {110.0, 220.0, 330.0,440.0,550.0,660.0};
					double tdur_m=1;
					double[] amplitudeVect_m= {1,0.5,0.333,0.25,0.2,0.167};
					double[] phaseShiftVect_m= {0.0,0.0,0.0,0.0,0.0,0.0};
					double[] output1m=sig_s.MultiSine(amplitudeVect_m,fhzVect_m,Fs_m,tdur_m,phaseShiftVect_m);
												
					int FFTlength=8192;
					double[][] frequencySpectrum_Rect=new double[2][FFTlength];
					double[][] frequencySpectrum_Hann=new double[2][FFTlength];
					double[] Magnitude_Lin_Rect=new double[FFTlength];
					double[] Magnitude_Lin_Hann=new double[FFTlength];
					double[] Magnitude_dB_Rect=new double[FFTlength];
					double[] Magnitude_dB_Hann=new double[FFTlength];
					double[] faxis=new double[FFTlength];
					int sigLen=4000;
					double[] rectangular=new double[sigLen];
					double[] winSigRect=new double[sigLen];
					double[] hanning=new double[sigLen];
					double[] winSigHann=new double[sigLen];
					
					rectangular=fourierTransform.rectWindow(sigLen);
					hanning=fourierTransform.hannWindow(sigLen);
					winSigRect=fourierTransform.applyWindow(output1m, rectangular, sigLen);
					winSigHann=fourierTransform.applyWindow(output1m, hanning, sigLen);
					frequencySpectrum_Rect=fourierTransform.doFFT(winSigRect, FFTlength);
					frequencySpectrum_Hann=fourierTransform.doFFT(winSigHann, FFTlength);
					boolean halfSpectrum=true;
					Magnitude_Lin_Rect=fourierTransform.SpecMagnitude(frequencySpectrum_Rect,halfSpectrum);
					Magnitude_Lin_Hann=fourierTransform.SpecMagnitude(frequencySpectrum_Hann,halfSpectrum);
					Magnitude_dB_Rect=fourierTransform.convert2dB(Magnitude_Lin_Rect);
					Magnitude_dB_Hann=fourierTransform.convert2dB(Magnitude_Lin_Hann);
					faxis=fourierTransform.makeFrequencyAxis(Fs_m,FFTlength,halfSpectrum);
					
					makePlot_s.plotData(faxis, Magnitude_dB_Rect,"Magnitude of Frequency Spectrum of MultiSine with FFT length=8192, Rectangular window", "Frequency (Hz)", "Magnitude", "Spectral Plots");	
					makePlot_s.plotData(faxis, Magnitude_dB_Hann, "Magnitude of Frequency Spectrum of MultiSine with FFT length=8192, Hanning window", "Frequency (Hz)", "Magnitude", "Spectral Plots");
					System.out.println("Using a rectangular window the spectral sidelobes/noise floor is much higher");
					System.out.println("Using a Hanning window the spectral sidelobes/noise floor are lower");
				} else if (plotNumber==7) { //White Noise
					signalGen sig_s=new signalGen();
					plotXYline makePlot_s=new plotXYline();
					FFT fourierTransform=new FFT();
				    
					int sigLen=11025;
					double Fs_w=11025;
					double[] wn=sig_s.whiteNoise(sigLen);
					int FFTlength=4096;
					
					double[][] frequencySpectrum=new double[2][FFTlength];
					double[] Magnitude_Lin=new double[FFTlength];
					double[] Magnitude_dB=new double[FFTlength];
					double[] faxis=new double[FFTlength];
					
					frequencySpectrum=fourierTransform.doFFT(wn, FFTlength);
					boolean halfSpectrum=true;
					Magnitude_Lin=fourierTransform.SpecMagnitude(frequencySpectrum,halfSpectrum);
					Magnitude_dB=fourierTransform.convert2dB(Magnitude_Lin);
					faxis	=fourierTransform.makeFrequencyAxis(Fs_w,FFTlength,halfSpectrum);
					makePlot_s.plotData(faxis, Magnitude_dB, "Magnitude of Frequency Spectrum of White Noise FFT length=4096", "Frequency (Hz)", "Magnitude", "Spectral Plots");
	}
	}	
}
