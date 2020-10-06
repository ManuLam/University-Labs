package signal;

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
public static double[][] doFFT(double[] input, int N){
	double[] realPart=new double[N];
	double[] imagPart=new double[N];
	double[] spectrum=new double[N];
	double[][] fftArray=new double[2][N];

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
public static double[] SpecMagnitude(double[][] dftArray){
	int Len=dftArray[0].length;
	double[] SpecMag=new double[Len];
	for(int k=0;k<Len;k++){
		SpecMag[k]=Math.sqrt(Math.pow(dftArray[0][k], 2)+Math.pow(dftArray[1][k], 2));
	}
	
	return SpecMag;
}

//Find the Spectral Phase
public static double[] SpecPhase(double[][] dftArray){
	int Len=dftArray[0].length;
	double[] SpecPhase=new double[Len];
	for(int k=0;k<Len;k++){
		SpecPhase[k]=Math.atan2(dftArray[1][k],dftArray[0][k]); //(imaginary part/real part)
	}
	
	return SpecPhase;
}

//Create the frequency axis for the plot
public static double[] makeFrequencyAxis(double Fs, int N){
	double[] freqAxis=new double[N];
	double ND=(double) N;
	freqAxis[0]=0;
	for(int index=1;index<N;index++){
		double indexD=(double) index;
		freqAxis[index]=freqAxis[index-1]+(1/ND)*Fs;
		//System.out.println(freqAxis[index]);
	}
	return freqAxis;
}

}

