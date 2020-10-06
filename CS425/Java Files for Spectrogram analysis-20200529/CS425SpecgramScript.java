package specG;

import java.util.Scanner;

import Frequency.FFT;
import signal.plotXYline;
import signal.signalGen;

public class CS425SpecgramScript {
	static double scaleX;static double scaleY;
	public static void main(String args[]){
		int framesize = 1024; //default value
		int hopsize = 512;  //default value
		double MaxMag;
		double[] input=null;
		double[][] specGramArray=null;
		double[][] specGramArrayN=null;
		double[][] specGramArrayNdB=null;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the plot number: ");
		int plotNumber = scan.nextInt();

		System.out.print("Enter the Window Size: ");
		framesize = scan.nextInt();
		hopsize=framesize/2;
		//System.out.print("Enter the Hop Size: ");
		//hopsize = scan.nextInt();
		// Closing Scanner after the use
		scan.close();

		
		if (plotNumber==1) { //Sinusoidal signal	
			signalGen sig_s=new signalGen();
			spectroGram sgram=new spectroGram();
			//sgram.setImageScaleValues(scaleX,scaleY);
			double fhz1_s=960;
			double fhz2_s=1000;
			double Fs_s=4096;
			double tdur_s=0.5;
			double Amplitude_s=0.5;
			double phaseShift_s=0;
			double[] output1s=sig_s.SineGen(Amplitude_s,fhz1_s,Fs_s,tdur_s,phaseShift_s);
			double[] output2s=sig_s.SineGen(Amplitude_s,fhz2_s,Fs_s,tdur_s,phaseShift_s);
			double[] output2sMultipler=new double[output2s.length];
			for (int i=0;i<output2s.length;i++) {
				if (i>=411 && i<=(1228+411)) {
					output2sMultipler[i]=1;
				} else {
					output2sMultipler[i]=0;
				}
			}
			double[] output2sM=sig_s.mulArray(output2s, output2sMultipler);
			double[] outputTotal=sig_s.addArray(output1s, output2sM);

			specGramArray=sgram.makespecGramArray(outputTotal, framesize, hopsize);
			MaxMag=sgram.findSpecgramMax(specGramArray);
			specGramArrayN=sgram.normaliseSpecGram(specGramArray, MaxMag);
			specGramArrayNdB=sgram.normalisedBSpecGram(specGramArrayN,MaxMag); 
			sgram.plotSpecGramAsImage(specGramArrayNdB,Fs_s);
		} if (plotNumber==2) { //Wav file
			signalGen sig_s=new signalGen();
			String filename="Speech.wav";
			input=sig_s.readInput(filename);
			double Fs_s=16000;
			spectroGram sgram=new spectroGram();
			//sgram.setImageScaleValues(scaleX,scaleY);
			specGramArray=sgram.makespecGramArray(input, framesize, hopsize);
			MaxMag=sgram.findSpecgramMax(specGramArray);
			specGramArrayN=sgram.normaliseSpecGram(specGramArray, MaxMag);
			specGramArrayNdB=sgram.normalisedBSpecGram(specGramArrayN,MaxMag); 
			sgram.plotSpecGramAsImage(specGramArrayNdB,Fs_s);
		} if (plotNumber==3) { //Wav file
			signalGen sig_s=new signalGen();
			String filename="Speech244100.wav";
			input=sig_s.readInput(filename);
			double Fs_s=44100;
			spectroGram sgram=new spectroGram();
			specGramArray=sgram.makespecGramArray(input, framesize, hopsize);
			MaxMag=sgram.findSpecgramMax(specGramArray);
			specGramArrayN=sgram.normaliseSpecGram(specGramArray, MaxMag);
			specGramArrayNdB=sgram.normalisedBSpecGram(specGramArrayN,MaxMag); 
			sgram.plotSpecGramAsImage(specGramArrayNdB,Fs_s);
		} if (plotNumber==4) { //Wav file
			signalGen sig_s=new signalGen();
			String filename="singingExample.wav";
			input=sig_s.readInput(filename);
			double Fs_s=44100;
			spectroGram sgram=new spectroGram();
			specGramArray=sgram.makespecGramArray(input, framesize, hopsize);
			MaxMag=sgram.findSpecgramMax(specGramArray);
			specGramArrayN=sgram.normaliseSpecGram(specGramArray, MaxMag);
			specGramArrayNdB=sgram.normalisedBSpecGram(specGramArrayN,MaxMag); 
			sgram.plotSpecGramAsImage(specGramArrayNdB,Fs_s);
		} if (plotNumber==5) { //Wav file
			signalGen sig_s=new signalGen();
			String filename="singingExample.wav";
			input=sig_s.readInput(filename);
			double Fs_s=44100;
			spectroGram sgram=new spectroGram();
			specGramArray=sgram.makespecGramArray(input, framesize, hopsize);
			MaxMag=sgram.findSpecgramMax(specGramArray);
			specGramArrayN=sgram.normaliseSpecGram(specGramArray, MaxMag);
			specGramArrayNdB=sgram.normalisedBSpecGram(specGramArrayN,MaxMag); 
			sgram.plotSpecGramAsImage(specGramArrayNdB,Fs_s);
		} if (plotNumber==6) { //Wav file
			signalGen sig_s=new signalGen();
			String filename="WoodPigeonV1.wav";
			input=sig_s.readInput(filename);
			double Fs_s=44100;
			spectroGram sgram=new spectroGram();
			specGramArray=sgram.makespecGramArray(input, framesize, hopsize);
			MaxMag=sgram.findSpecgramMax(specGramArray);
			specGramArrayN=sgram.normaliseSpecGram(specGramArray, MaxMag);
			specGramArrayNdB=sgram.normalisedBSpecGram(specGramArrayN,MaxMag); 
			sgram.plotSpecGramAsImage(specGramArrayNdB,Fs_s);
		} if (plotNumber==7) { //Wav file
			signalGen sig_s=new signalGen();
			String filename="TinWhistleRoll.wav";
			input=sig_s.readInput(filename);
			double Fs_s=44100;
			spectroGram sgram=new spectroGram();
			specGramArray=sgram.makespecGramArray(input, framesize, hopsize);
			MaxMag=sgram.findSpecgramMax(specGramArray);
			specGramArrayN=sgram.normaliseSpecGram(specGramArray, MaxMag);
			specGramArrayNdB=sgram.normalisedBSpecGram(specGramArrayN,MaxMag); 
			sgram.plotSpecGramAsImage(specGramArrayNdB,Fs_s);
		}
	}

}


//String filename="SINGER_C08.wav";
//String filename="speechExample.wav";
//String filename="Skylark.wav";


/*
if (framesize==256)  {
	scaleX=5;scaleY=4;
}	else if (framesize==512) {
	scaleX=10; scaleY=2;//related to  signal length
} else if (framesize==1024) {
	scaleX=20;scaleY=1;
} else if (framesize==2048) {
	scaleX=40;scaleY=0.5; 
} else if (framesize==4096)
	scaleX=50;scaleY=0.25;
*/
