close all;
playSoundFlag=0;
Fs=11025; #set the sampling frequency
fhz=1110; #set the frequency in Hertz
tdur=1;  #set the time duration in seconds
Amplitude=1; #amplitude of the wave
phase=0; #Phase shift in radians;

%generate a single sinewave
[output1s,t]=Gen_sine(Amplitude,fhz,Fs,tdur,phase);
figure(1)
plot(t(1:200),output1s(1:200)), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('Single Sinewave')
if (playSoundFlag==1)
soundsc(output1s,Fs)
endif

FFTlength=2048;
FxLen1=fft(output1s,FFTlength);
Magnitude=abs(FxLen1);
Phase=angle(FxLen1);
faxis=0:Fs./FFTlength:Fs-Fs./FFTlength;
figure(2),
subplot(2,1,1),plot(faxis,Magnitude), axis tight
xlabel('Frequency (Hertz)'), ylabel('Magnitude'),title('Magnitude of Frequency Spectrum of Sinewave with FFT length=2048 and Sampling Frequency=11025')
subplot(2,1,2),plot(faxis,Phase), axis tight
xlabel('Frequency (Hertz)'), ylabel('Phase'),title('Phase of Frequency Spectrum of Sinewave with FFT length=2048 and Sampling Frequency=11025')
FreqResolution=num2str(Fs/FFTlength);
message=cstrcat("Frequency Resolution of FFT length=2048 for Fs=11025 is ", FreqResolution,"Hz\n");
printf(message)

FFTlength=8192;
FxLen2=fft(output1s,FFTlength);
Magnitude=abs(FxLen2);
Phase=angle(FxLen2);
faxis=0:Fs./FFTlength:Fs-Fs./FFTlength;
figure(3),
subplot(2,1,1),plot(faxis,Magnitude), axis tight
xlabel('Frequency (Hertz)'), ylabel('Magnitude'),title('Magnitude of Frequency Spectrum of Sinewave with FFT length=2048 and Sampling Frequency=11025')
subplot(2,1,2),plot(faxis,Phase), axis tight
xlabel('Frequency (Hertz)'), ylabel('Phase'),title('Phase of Frequency Spectrum of Sinewave with FFT length=2048 and Sampling Frequency=11025')
FreqResolution=num2str(Fs/FFTlength);
message=cstrcat("Frequency Resolution of FFT length=2048 for Fs=8192 is ", FreqResolution,"Hz\n");
printf(message)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%% demonstrate the meaning of resolution %%%%%%%%%%%%%%%%%%%%%%%%%
Fs=11025;
fhz1=1110; #set the frequency in Hertz
fhz2=1114; #set the frequency in Hertz
tdur=1;  #set the time duration in seconds
Amplitude=0.5; #amplitude of the wave
phase=0; #Phase shift in radians;

%generate a single sinewave
[output1s,t]=Gen_sine(Amplitude,fhz1,Fs,tdur,phase);
[output2s,t]=Gen_sine(Amplitude,fhz2,Fs,tdur,phase);
outputTotal=output1s+output2s;
figure(4)
plot(t(1:200),outputTotal(1:200)), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('Two Sinewaves only 2Hz apart')
if (playSoundFlag==1)
soundsc(outputTotal,Fs)
endif

FFTlength=2048;
FxLen1=fft(outputTotal,FFTlength);
Magnitude=abs(FxLen1);
faxis=0:Fs./FFTlength:Fs-Fs./FFTlength;
figure(5),
subplot(2,1,1),
plot(faxis(1:FFTlength/2),Magnitude(1:FFTlength/2)), axis([1090 1130 0 600])
xlabel('Frequency (Hertz)'), ylabel('Magnitude'),title('Zoomed Magnitude of Frequency Spectrum of two Sinewaves only 4Hz apart with FFT Resolution of 5.4Hz')
FreqResolution=num2str(Fs/FFTlength);
message=cstrcat("When the Frequency Resolution is ", FreqResolution,"Hz only one distinct peak can be seen in the magnitude spectrum\n");
printf(message)

FFTlength=8192;
FxLen2=fft(outputTotal,FFTlength);
Magnitude=abs(FxLen2);
faxis=0:Fs./FFTlength:Fs-Fs./FFTlength;
subplot(2,1,2),
%figure(6)
plot(faxis(1:FFTlength/2),Magnitude(1:FFTlength/2)), axis([1090 1130 0 2200])
xlabel('Frequency (Hertz)'), ylabel('Magnitude'),title('Zoomed Magnitude of Frequency Spectrum of two Sinewaves only 2Hz apart with FFT Resolution of 1.3Hz')
FreqResolution=num2str(Fs/FFTlength);
message=cstrcat("When the Frequency Resolution is ", FreqResolution,"Hz two distinct peaks can be seen in the magnitude spectrum\n");
printf(message)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%% dB Analysis%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
Fs=11025; #set the sampling frequency
fhz=1110; #set the frequency in Hertz
tdur=1;  #set the time duration in seconds
Amplitude=1; #amplitude of the wave
phase=0; #Phase shift in radians;

%generate a single sinewave
[output1s,t]=Gen_sine(Amplitude,fhz,Fs,tdur,phase);

FFTlength=2048;
FxLen1=fft(output1s,FFTlength);
Magnitude=abs(FxLen1);
MagnitudedB=20.*log10(Magnitude);

faxis=0:Fs./FFTlength:Fs-Fs./FFTlength;
figure(6),
subplot(2,1,1),plot(faxis(1:FFTlength/2),Magnitude(1:FFTlength/2)), axis tight
xlabel('Frequency (Hertz)'), ylabel('Magnitude'),title('Magnitude of Frequency Spectrum of Sinewave with FFT length=2048 and Sampling Frequency=11025')
subplot(2,1,2),plot(faxis(1:FFTlength/2),MagnitudedB(1:FFTlength/2)), axis tight
xlabel('Frequency (Hertz)'), ylabel('Magnitude (dB)'),title('Magnitude in dB of Frequency Spectrum of Sinewave with FFT length=2048 and Sampling Frequency=11025')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%% windowing %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
pkg load signal;
Fs=11025; #set the sampling frequency
fhz=1110; #set the frequency in Hertz
tdur=1;  #set the time duration in seconds
Amplitude=1; #amplitude of the wave
phase=0; #Phase shift in radians;

%generate a single sinewave
[output1s,t]=Gen_sine(Amplitude,fhz,Fs,tdur,phase);

FFTlength=2048;
sigLen=2000;
win=rectwin(sigLen)';
winSig=output1s(1:sigLen).*win;
FxLen1win=fft(winSig,FFTlength);
Magnitude=abs(FxLen1win);
MagnitudedB=20.*log10(Magnitude);

faxis=0:Fs./FFTlength:Fs-Fs./FFTlength;
figure(7),
subplot(2,1,1),
plot(faxis(1:FFTlength/2),MagnitudedB(1:FFTlength/2)), axis tight
xlabel('Frequency (Hertz)'), ylabel('Magnitude (dB)'),title('Magnitude of Frequency Spectrum of Sinewave with FFT length=2048, Rectangular window')

figure(8),
subplot(2,1,1),plot(faxis(1:FFTlength/2),MagnitudedB(1:FFTlength/2)), axis([1000 2000 -10 60])
xlabel('Frequency (Hertz)'), ylabel('Magnitude (dB)'),title('Zoomed Magnitude of Frequency Spectrum of Sinewave with FFT length=2048, Rectangular window')
message=cstrcat("Using a rectangular window the peak is narrower but the spectral sidelobes are higher\n");
printf(message)

sigLen=2000;
win=hanning(sigLen)';
winSig=output1s(1:sigLen).*win;
FxLen1win=fft(winSig,FFTlength);
Magnitude=abs(FxLen1win);
MagnitudedB=20.*log10(Magnitude);
figure(7)
subplot(2,1,2),plot(faxis(1:FFTlength/2),MagnitudedB(1:FFTlength/2)), axis tight
xlabel('Frequency (Hertz)'), ylabel('Magnitude (dB)'),title('Magnitude in dB of Frequency Spectrum of Sinewave with FFT length=2048, Hanning window')

figure(8),
subplot(2,1,2),plot(faxis(1:FFTlength/2),MagnitudedB(1:FFTlength/2)), axis([1000 2000 -10 60])
xlabel('Frequency (Hertz)'), ylabel('Magnitude (dB)'),title('Zoomed Magnitude of Frequency Spectrum of Sinewave with FFT length=2048, Hannign window')
message=cstrcat("Using a Hanning window the peak is broader but the spectral sidelobes are lower\n");
printf(message)

figure(9)
subplot(2,1,1), plot([zeros(128,1);rectwin(2048);zeros(128,1)] ), axis([0 2304 0 1.5]);
xlabel('Sample number'),title('Rectangular Window')
subplot(2,1,2), plot([zeros(128,1); hanning(2048);zeros(128,1)]), axis([0 2304 0 1.5]);
xlabel('SAmple number'),title('Hanning Window')


%%% windowing of a wave with multiple sines
Fs=11025; %set the sampling frequency
fhzVect=[110 220 330 440 550 660]; %set a vector of frequencies in Hertz
tdur=1; %set the time duration in seconds
AmplitudeVect=[1 1/2 1/3 1/4 1/5 1/6]; %set a vector of amplitudes
phaseShiftVect=[0 0 0 0 0 0]; %Set a vector of Phase shifts in radians;
[output2,t]=Gen_MultiSine(AmplitudeVect,fhzVect,Fs,tdur,phaseShiftVect);
FFTlength=8192;
sigLen=4000;
win=rectwin(sigLen)';
winSig=output2(1:sigLen).*win;
FxLen1win=fft(winSig,FFTlength);
Magnitude=abs(FxLen1win);
MagnitudedB=20.*log10(Magnitude);

faxis=0:Fs./FFTlength:Fs-Fs./FFTlength;
figure(10),
subplot(2,1,1),plot(faxis(1:FFTlength/2),MagnitudedB(1:FFTlength/2)), axis([0 1500 -20 70]) 
xlabel('Frequency (Hertz)'), ylabel('Magnitude (dB)'),title('Magnitude of Frequency Spectrum of MultiSine with FFT length=8192, Rectangular window')
message=cstrcat("Using a rectangular window the spectral sidelobes/noise floor is much higher\n");
figure(11),
subplot(2,1,1),plot(faxis(1:FFTlength/2),MagnitudedB(1:FFTlength/2)), axis([0 800 20 70])
xlabel('Frequency (Hertz)'), ylabel('Magnitude (dB)'),title('Magnitude of Frequency Spectrum of MultiSine with FFT length=8192, Rectangular window')
sigLen=4000;
win=hanning(sigLen)';
winSig=output2(1:sigLen).*win;
FxLen1win=fft(winSig,FFTlength);
Magnitude=abs(FxLen1win);
MagnitudedB=20.*log10(Magnitude);
figure(10)
subplot(2,1,2),plot(faxis(1:FFTlength/2),MagnitudedB(1:FFTlength/2)), axis([0 1500 -20 70]) 
xlabel('Frequency (Hertz)'), ylabel('Magnitude (dB)'),title('Magnitude in dB of Frequency Spectrum of MultiSine with FFT length=8192, Hanning window')
figure(11)
subplot(2,1,2),plot(faxis(1:FFTlength/2),MagnitudedB(1:FFTlength/2)), axis([0 800 20 70]) 
xlabel('Frequency (Hertz)'), ylabel('Magnitude (dB)'),title('Magnitude in dB of Frequency Spectrum of MultiSine with FFT length=8192, Hanning window')

message=cstrcat("Using a Hanning window the spectral sidelobes/noise floor are lower\n");

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%5 Spectral Analysis of Noise %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Generate Noise
Fs=11025;
wn=randn(1,11025);
FFTlength=4096;
FxLenWn=fft(wn,FFTlength);
MagnitudeWn=abs(FxLenWn);
MagnitudeWndB=20.*log10(abs(FxLenWn));
faxis=0:Fs./FFTlength:Fs-Fs./FFTlength;
figure(12),
plot(faxis(1:FFTlength/2),MagnitudeWndB(1:FFTlength/2)), axis tight
xlabel('Frequency (Hertz)'), ylabel('Magnitude (dB)'),title('Magnitude of Frequency Spectrum of White Noise FFT length=4096')
message=cstrcat("Note of the flat spectrum of White Noise\n");

