package Frequency;

import edu.emory.mathcs.jtransforms.fft.DoubleFFT_1D;

public class FFT {


	public  static double[] evenRealarrange(double[] spectrum){
		int N=spectrum.length;
		double[] realPart=new double[N];
		for (int k=0;k<N/2;k++) {
			realPart[k]=spectrum[2*k];
		}
		realPart[N/2]=spectrum[1];
		for (int k=N/2-1;k>0;k--) {
			//	System.out.println(N/2+k  + " " +  (N/2-k));
			realPart[N/2+k]=realPart[N/2-k];
		}
		return realPart;
	}


	public static double[] evenImagarrange(double[] spectrum){
		int N=spectrum.length;
		double[] imagPart=new double[N];
		for (int k=0;k<N/2;k++) {
			imagPart[k]=spectrum[2*k+1];
		}
		for (int k=N/2-1;k>0;k--) {
			//		System.out.println(N/2+k  + " " +  (N/2-k));
			imagPart[N/2+k]=-imagPart[N/2-k];
		}
		return imagPart;
	}

	public static double[] oddRealarrange(double[] spectrum){
		int N=spectrum.length;
		double[] realPart=new double[N];
		for (int k=0;k<(N+1)/2;k++) {
			realPart[k]=spectrum[2*k];
		}

		for (int k=(N)/2-1;k>0;k--) {
			//System.out.println((N)/2+k  + " " +  ((N)/2-k));
			realPart[(N)/2+k]=realPart[(N+1)/2-k];
		}
		return realPart;
	}


	public static double[] oddImagarrange(double[] spectrum){
		int N=spectrum.length;
		double[] imagPart=new double[N];
		for (int k=0;k<(N-1)/2;k++) {
			imagPart[k]=spectrum[2*k+1];
		}
		imagPart[(N-1)/2]=spectrum[1];
		for (int k=(N-1)/2-1;k>0;k--) {
			//	System.out.println((N-1)/2+k  + " " +  ((N-1)/2-k));
			imagPart[(N-1)/2+k]=-imagPart[(N-1)/2-k];
		}
		return imagPart;
	}
	public static double[][] doFFT(double[] ftInput, int N){
		double[] realPart=new double[N];
		double[] imagPart=new double[N];
		double[] spectrum=new double[N];
		double[][] fftArray=new double[2][N];
		
		double[] input=new double[N];
		int ipLen=ftInput.length;
		int len;
		if (ipLen<N) len=ipLen; else len=N; 
		
		for (int n=0;n<len;n++) {
			input[n]=ftInput[n];
		}

		DoubleFFT_1D dft=new DoubleFFT_1D(N);
		dft.realForward(input);	

		if (N%2==0){  //if the length of the fft is even
			realPart=evenRealarrange(input);
			imagPart=evenImagarrange(input);
		} else {      // else if the length of the fft is odd
			realPart=oddRealarrange(input);
			imagPart=oddImagarrange(input);
		}
		for (int k=0;k<N;k++) {
			fftArray[0][k]=realPart[k];
			fftArray[1][k]=imagPart[k];
		}

		/*
//print out the real and imaginary part for comparison with matlab
	for (int k=0;k<N;k++) {
		System.out.println(realPart[k]+" "+imagPart[k]+";");	
	}	
		 */
		return fftArray;

	}	

	//Find the spectral Magnitude
	public static double[] SpecMagnitude(double[][] dftArray,boolean halfSpectrum){
		int Len=dftArray[0].length;
		double[] SpecMag=null;
		double[] SpecMagFull=new double[Len];
		double[] SpecMagHalf=new double[Len/2];
		for(int k=0;k<Len;k++){
			SpecMagFull[k]=Math.sqrt(Math.pow(dftArray[0][k], 2)+Math.pow(dftArray[1][k], 2));
		}
		if (halfSpectrum) {
			for(int k=0;k<Len/2;k++){
				SpecMagHalf[k]=SpecMagFull[k];
			}	
		SpecMag=SpecMagHalf; 
	}	else {
		SpecMag=SpecMagFull;
	}
//System.out.println(SpecMag.length + "M");
		return SpecMag;
	}
	
	public static double[] convert2dB(double[] input) {
		int Len=input.length;
		double[] output=new double[Len];
		for (int i=0;i<Len;i++) {
			output[i]=20*Math.log10(input[i]);
		}
		return output;
	}

	//Find the Spectral Phase
	public static double[] SpecPhase(double[][] dftArray,boolean halfSpectrum){
		int Len=dftArray[0].length;
		double[] SpecPhase=null;
		double[] SpecPhaseFull=new double[Len];
		double[] SpecPhaseHalf=new double[Len/2];
		for(int k=0;k<Len;k++){
			SpecPhaseFull[k]=Math.atan2(dftArray[1][k],dftArray[0][k]); //(imaginary part/real part)
		}
		
		if (halfSpectrum) {
			for(int k=0;k<Len/2;k++){
			SpecPhaseHalf[k]=SpecPhaseFull[k];
			}	
		SpecPhase=SpecPhaseHalf; 
	}	else 
		SpecPhase=SpecPhaseFull;

		return SpecPhase;
	}

	//Create the frequency axis for the plot
	public static double[] makeFrequencyAxis(double Fs, int N,boolean halfSpectrum){
		double[] freqAxis=null;
		double[] freqAxisFull=new double[N];
		double[] freqAxisHalf=new double[N/2];
		double ND=(double) N;
		freqAxisFull[0]=0;
		for(int index=1;index<N;index++){
			double indexD=(double) index;
			freqAxisFull[index]=freqAxisFull[index-1]+(1/ND)*Fs;
			//System.out.println(freqAxis[index]);
		}
		if (halfSpectrum) {
			for(int k=0;k<N/2;k++){
				freqAxisHalf[k]=freqAxisFull[k];
			}	
		freqAxis=freqAxisHalf;
		//System.out.println(freqAxis.length);
		} else {
			freqAxis=freqAxisFull;
		}
		return freqAxis;
	}
	
	public static double[] rectWindow(int wavlength){
        double[] window = new double[wavlength];
       
        double wavlengthD=(double) wavlength;
        for(int index = 0; index< wavlength; index++){
            window[index] = 1.0;
        }
       
        return window;
    }
	public static double[] hannWindow(int wavlength){
        double[] window = new double[wavlength];
       
        double wavlengthD=(double) wavlength;
        for(int index = 0; index< wavlength; index++){
            window[index] = 0.5 * (1 - Math.cos(((2*Math.PI)*index) /(wavlength-1)));
        }
       
        return window;
    }
	//Apply Window
		public static double[] applyWindow(double[] x, double[] y,int winLength){
			double[] z=new double[winLength];
			for (int index=0;index<winLength;index++){
				z[index]=x[index]*y[index];
			}
			return z;
		}
}

