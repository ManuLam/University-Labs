package signal;
import java.util.*;



public class CS425SignalScripts {
public static int playSoundFlag=1;	

public static void main(String args[]) {
	Scanner scan = new Scanner(System.in);
    System.out.print("Enter the plot number: ");
    // This method reads the number provided using keyboard
    int plotNumber = scan.nextInt();
    // Closing Scanner after the use
    scan.close(); 
    
	if (plotNumber==1) { //Sinusoidal signal
	signalGen sig_s=new signalGen();
	plotXYline makePlot_s=new plotXYline();
	double fhz_s=110;
	double Fs_s=44100;
	double tdur_s=1;
	double Amplitude_s=1;
	double phaseShift_s=0;
	double[] output1s=sig_s.SineGen(Amplitude_s,fhz_s,Fs_s,tdur_s,phaseShift_s);
	if (playSoundFlag==1) stdAudio.play(output1s);
	double[] twoPeriodsSignal=makePlot_s.plotTwoPeriodsSignal(output1s, Fs_s, fhz_s);
	double[] twoPeriodsTimeAxis=makePlot_s.plotTimeAxisTwoPeriods(output1s, Fs_s, fhz_s);
	makePlot_s.plotData(twoPeriodsTimeAxis, twoPeriodsSignal, "Single Sinewave", "Time (Sec)", "Amplitude", "Signal Plots");    
	} else if (plotNumber==2) { //Cosinusoidal signal
		signalGen sigC=new signalGen();
	plotXYline makePlotC=new plotXYline();
	double fhz_c=110;
	double Fs_c=44100;
	double tdur_c=1;
	double Amplitude_c=1;
	double phaseShift_c=0;
	double[] output1c=sigC.CosineGen(Amplitude_c,fhz_c,Fs_c,tdur_c,phaseShift_c);
	if (playSoundFlag==1) stdAudio.play(output1c);
	double[] twoPeriodsSignal_c=makePlotC.plotTwoPeriodsSignal(output1c, Fs_c, fhz_c);
	double[] twoPeriodsTimeAxis_c=makePlotC.plotTimeAxisTwoPeriods(output1c, Fs_c, fhz_c);
	makePlotC.plotData(twoPeriodsTimeAxis_c, twoPeriodsSignal_c, "Single Cosinewave", "Time (Sec)", "Amplitude", "Signal Plots");
	} else if (plotNumber==3) { //Multisine signal
	signalGen sigM=new signalGen();
	plotXYline makePlotM=new plotXYline();
	double[] fhzVect_m= {110.0, 220.0, 330.0,440.0,550.0,660.0};
	double Fs_m=44100;
	double tdur_m=1;
	double[] amplitudeVect_m= {1,0.5,0.333,0.25,0.2,0.167};
	double[] phaseShiftVect_m= {0.0,0.0,0.0,0.0,0.0,0.0};
	double[] output2=sigM.MultiSine(amplitudeVect_m,fhzVect_m,Fs_m,tdur_m,phaseShiftVect_m);
	if (playSoundFlag==1) stdAudio.play(output2);
	double[] twoPeriodsSignal_m=makePlotM.plotTwoPeriodsSignal(output2, Fs_m, fhzVect_m[0]);
	double[] twoPeriodsTimeAxis_m=makePlotM.plotTimeAxisTwoPeriods(output2, Fs_m, fhzVect_m[0]);
	makePlotM.plotData(twoPeriodsTimeAxis_m, twoPeriodsSignal_m, "Multiple Sinewaves - harmonic signal, pitch 110Hz", "Time (Sec)", "Amplitude", "Signal Plots");
	} else if (plotNumber==4) { //White Noise
	Random r = new Random();
	plotXYline makePlotW=new plotXYline();
	int Fs_w=44100;
	double[] wn=new double[Fs_w];
	double[] wnPlot=new double[1000];
	double[] timeAxis=new double[1000];
	for(int i=0;i<Fs_w;i++) {
		double val = r.nextGaussian();
		wn[i]=val;
	}
	if (playSoundFlag==1) stdAudio.play(wn);
	for(int i=0;i<1000;i++) {
		double Ts=1/(double) Fs_w;
		timeAxis[i]=(double) i* Ts;
		wnPlot[i]=wn[i];
	}
		makePlotW.plotData(timeAxis, wnPlot, "White Noise", "Time (Sec)", "Amplitude", "Signal Plots");
		
	}  else if (plotNumber==5) { //wav file
		signalGen sigF=new signalGen();
		plotXYline makePlotF1=new plotXYline();
		String fileName="Speech44100.wav";
		double[] soundFile=null;
		soundFile=sigF.readInput(fileName);
		int Fs_f=44100;
		if (playSoundFlag==1) stdAudio.play(soundFile);
		double[] timeAxis=null;
		timeAxis=makePlotF1.makeTimeAxis(soundFile.length,Fs_f);
		makePlotF1.plotData(timeAxis, soundFile, "Speech File", "Time (Sec)", "Amplitude", "Signal Plots");
	} else if (plotNumber==6) { //wav file
		signalGen sigF=new signalGen();
		plotXYline makePlotF1=new plotXYline();
		String fileName="Speech244100.wav";
		double[] soundFile=null;
		soundFile=sigF.readInput(fileName);
		int Fs_f=44100;
		if (playSoundFlag==1) stdAudio.play(soundFile);
		double[] timeAxis=null;
		timeAxis=makePlotF1.makeTimeAxis(soundFile.length,Fs_f);
		makePlotF1.plotData(timeAxis, soundFile, "Speech File 2", "Time (Sec)", "Amplitude", "Signal Plots");
	} else if (plotNumber==7) { //wav file
		signalGen sigF=new signalGen();
		plotXYline makePlotF1=new plotXYline();
		String fileName="singingExample.wav";
		double[] soundFile=null;
		soundFile=sigF.readInput(fileName);
		int Fs_f=44100;
		if (playSoundFlag==1) stdAudio.play(soundFile);
		double[] timeAxis=null;
		timeAxis=makePlotF1.makeTimeAxis(soundFile.length,Fs_f);
		makePlotF1.plotData(timeAxis, soundFile, "Singing Example", "Time (Sec)", "Amplitude", "Signal Plots");
	}
	}
}


