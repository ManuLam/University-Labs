pkg load signal;
close all;
playSoundFlag=0;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%% reproduce the spectrogram resolution experiment in the slides %%%%%%%%%%%%%%%%%
fhz1=960; #set the frequency in Hertz
fhz2=1000; #set the frequency in Hertz
Fs=4096;
tdur=0.5;  #set the time duration in seconds
Amplitude=0.5; #amplitude of the wave
phase=0; #Phase shift in radians;

%The second should be zero initially for 100ms, then active for 300ms, and then zero again
%multiply it by a signal [zeros(1,410) ones(1,1228) zeros(1,410)]. For a sampling rate of 
%4096Hz then 100ms has 400 samples

%generate a single sinewave
[output1s,t]=Gen_sine(Amplitude,fhz1,Fs,tdur,phase);
[output2s,t]=Gen_sine(Amplitude,fhz2,Fs,tdur,phase);
outputTotal=output1s+output2s.*[zeros(1,410) ones(1,1228) zeros(1,410)];

figure(1)
FFTlength=128;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(outputTotal,FFTlength,Fs,win,hopSize);colormap jet,
title('Spectrogram of two sinusoids at 960 and 1000Hz, Window Length = 128, Fs=4096Hz')
FreqResolution=num2str(2.*Fs/FFTlength);
message=cstrcat("Frequency Resolution of FFT length=128 for Fs=4096 is ", FreqResolution,"Hz\n");
printf(message)
Ts=1/Fs;
TimeResolution=num2str((Ts)*FFTlength/2);
message=cstrcat("Time Resolution of FFT length=128 for Fs=4096 is ", TimeResolution,"Secs\n");
printf(message)


figure(2)
FFTlength=512;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(outputTotal,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of two sinusoids at 960 and 1000Hz, Window Length = 512, Fs=4096Hz')
FreqResolution=num2str(2.*Fs/FFTlength);
message=cstrcat("Frequency Resolution of FFT length=512 for Fs=4096 is ", FreqResolution,"Hz\n");
printf(message)
Ts=1/Fs;
TimeResolution=num2str((Ts)*FFTlength/2);
message=cstrcat("Time Resolution of FFT length=512 for Fs=4096 is ", TimeResolution,"Secs\n");
printf(message)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%% Spectrogram Analysis of Multisine signal %%%%%%%%%%%%%%%%%%%%%%%%

Fs=11025; %set the sampling frequency
fhzVect=[440 880 1320 1760 2200 2640]; %set a vector of frequencies in Hertz
tdur=1; %set the time duration in seconds
AmplitudeVect=[1 1/2 1/3 1/4 1/5 1/6]; %set a vector of amplitudes
phaseShiftVect=[0 0 0 0 0 0]; %Set a vector of Phase shifts in radians;

[output2,t]=Gen_MultiSine(AmplitudeVect,fhzVect,Fs,tdur,phaseShiftVect);
FFTlength=2048;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(output2,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of Multisine harmonic signal with fundamental at 440Hz, Window Length = 2048, Fs=11025Hz')


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
dir='C:\Users\Joe\octaveScripts\Sounds\'; %give the directory where the sounds are stored

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
speech='Speech.wav';
fileName=strcat(dir,speech);
[speech,Fs]=audioread(fileName);
len=length(speech);
t=(0:len-1)./Fs;
figure(4)
plot(t,speech), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('speech')
if (playSoundFlag==1)
soundsc(speech,Fs)
endif
figure(5)
FFTlength=128;win=hanning(FFTlength);hopSize=FFTlength/2;
subplot(2,1,1), specgram(speech,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of speech, Window Length = 128, Fs=16000Hz')
FFTlength=512;win=hanning(FFTlength);hopSize=FFTlength/2;
subplot(2,1,2), specgram(speech,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of speech, Window Length = 512, Fs=16000Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%read in wave file with speech2
speech2='Drop.wav';
fileName=strcat(dir,speech2);
[speech2,Fs]=audioread(fileName);
len=length(speech2);
t=(0:len-1)./Fs;
figure(6)
plot(t,speech2), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('speech2')
if (playSoundFlag==1)
soundsc(speech2,Fs)
endif

figure(7)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(7), specgram(speech2,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of speech, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(8), specgram(speech2,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of speech, Window Length = 1024, Fs=44100Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%read in wave file with singing
singing='singingExample.wav';
fileName=strcat(dir,singing);
[singing,Fs]=audioread(fileName);
len=length(singing);
t=(0:len-1)./Fs;
figure(9)
plot(t,singing), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('singing')
if (playSoundFlag==1)
soundsc(singing,Fs)
endif

figure(10)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(singing,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of singing, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(11), 
specgram(singing,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of singing, Window Length = 1024, Fs=44100Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%read in wave file with wood pigeon
woodPigeon='WoodPigeon.wav';
fileName=strcat(dir,woodPigeon);
[pigeon,Fs]=audioread(fileName);
len=length(pigeon);
t=(0:len-1)./Fs;
figure(12)
plot(t,pigeon), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('woodPigeon')
if (playSoundFlag==1)
soundsc(pigeon,Fs)
endif

figure(13)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(pigeon,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of wood pidgeon, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(14), 
specgram(pigeon,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of wood pidgeon, Window Length = 1024, Fs=44100Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%read in wave file with castanets
castanets='Castanets.wav';
fileName=strcat(dir,castanets);
[castanet,Fs]=audioread(fileName);
len=length(castanet);
t=(0:len-1)./Fs;
figure(15)
plot(t,castanet), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('castanets')
if (playSoundFlag==1)
soundsc(castanet,Fs)
endif
figure(16)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(castanet,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of castanets, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(17), 
specgram(castanet,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of castanets, Window Length = 1024, Fs=44100Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%read in wave file with tin whistle roll
tinWhistleRoll='TinWhistleRoll.wav';
fileName=strcat(dir,tinWhistleRoll);
[tinWhistle,Fs]=audioread(fileName);
len=length(tinWhistle);
t=(0:len-1)./Fs;
figure(18)
plot(t,tinWhistle), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('tinWhistleRoll')
if (playSoundFlag==1)
soundsc(tinWhistle,Fs)
endif
figure(19)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(tinWhistle,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of tin whistle, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(20), 
specgram(tinWhistle,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of tin whistle, Window Length = 1024, Fs=44100Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%read in wave file with tamboura
tamboura='Tamboura.wav';
fileName=strcat(dir,tamboura);
[tambour,Fs]=audioread(fileName);
len=length(tambour);
t=(0:len-1)./Fs;
figure(20)
plot(t,tambour), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('tamboura')
if (playSoundFlag==1)
soundsc(tambour,Fs)
endif
figure(21)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(tambour,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of tamboura, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(22), 
specgram(tambour,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of tamboura, Window Length = 1024, Fs=44100Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%read in wave file with agogo
sambaAgogo='SambaAgogo.wav';
fileName=strcat(dir,sambaAgogo);
[agogo,Fs]=audioread(fileName);
len=length(agogo);
t=(0:len-1)./Fs;
figure(23)
plot(t,agogo), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('sambaAgogo')
if (playSoundFlag==1)
soundsc(agogo,Fs)
endif
figure(24)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(agogo,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of agogo, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(25), 
specgram(agogo,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of agogo, Window Length = 1024, Fs=44100Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%read in wave file with chinaFlutePhrase
chinaFlutePhrase='ChinaFlutePhrase.wav';
fileName=strcat(dir,chinaFlutePhrase);
[chinaflute,Fs]=audioread(fileName);
len=length(chinaflute);
t=(0:len-1)./Fs;
figure(25)
plot(t,chinaflute), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('chinaFlutePhrase')
if (playSoundFlag==1)
soundsc(chinaflute,Fs)
endif
figure(26)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(chinaflute,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of china flute, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(27), 
specgram(chinaflute,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of china flute, Window Length = 1024, Fs=44100Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%read in wave file with oud
oudMelody='OudMelody.wav';
fileName=strcat(dir,oudMelody);
[oud,Fs]=audioread(fileName);
len=length(oud);
t=(0:len-1)./Fs;
figure(28)
plot(t,oud), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('oudMelody')
if (playSoundFlag==1)
soundsc(oud,Fs)
endif
figure(29)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(oud,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of oud, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(11), 
specgram(oud,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of oud, Window Length = 1024, Fs=44100Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%read in wave file with choirGlissando
choirGlissando='ChoirGlissando.wav';
fileName=strcat(dir,choirGlissando);
[choir,Fs]=audioread(fileName);
len=length(choir);
t=(0:len-1)./Fs;
figure(30)
plot(t,choir), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('choirGlissando')
if (playSoundFlag==1)
soundsc(choir,Fs)
endif
figure(31)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(choir,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of choir, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(32), 
specgram(choir,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of choir, Window Length = 1024, Fs=44100Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%read in wave file with pedalsteel
pedalSteel='PedalSteelPhrase.wav';
fileName=strcat(dir,pedalSteel);
[pedalSteel,Fs]=audioread(fileName);
len=length(pedalSteel);
t=(0:len-1)./Fs;
figure(33)
plot(t,pedalSteel), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('pedalSteel')
if (playSoundFlag==1)
soundsc(pedalSteel,Fs)
endif
figure(34)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(pedalSteel,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of pedal steel, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(35), 
specgram(pedalSteel,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of pedal steel, Window Length = 1024, Fs=44100Hz')
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
carillion='Carillion.wav';
fileName=strcat(dir,carillion);
[carillion,Fs]=audioread(fileName);
len=length(carillion);
t=(0:len-1)./Fs;
figure(36)
plot(t,carillion), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('carillion')
if (playSoundFlag==1)
soundsc(carillion,Fs)
endif


figure(37)
FFTlength=256;win=hanning(FFTlength);hopSize=FFTlength/2;
specgram(carillion,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of carillion, Window Length = 256, Fs=44100Hz')
FFTlength=1024;win=hanning(FFTlength);hopSize=FFTlength/2;
figure(38), 
specgram(carillion,FFTlength,Fs,win,hopSize);colormap jet
title('Spectrogram of carillion, Window Length = 1024, Fs=44100Hz')
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
