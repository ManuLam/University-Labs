addpath("C:/Users/Lam/octaveScripts");
playSoundFlag=1; %change this value to 1 to hear the sound for each wav file
Fs=44100; #set the sampling frequency
fhz=500; #set the frequency in Hertz
tdur=1;  #set the time duration in seconds
Amplitude=1; #amplitude of the wave
phase=0; #Phase shift in radians;

%generate a single sinewave
[output1s,t]=Gen_sine(Amplitude,fhz,Fs,tdur,phase);
figure(1)
subplot(2,1,1),plot(t(1:1000),output1s(1:1000)), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('Single Sinewave')
if (playSoundFlag==1)
soundsc(output1s,Fs)
endif

BREAK
%generate a single sinewave
[output1c,t]=Gen_cos(Amplitude,fhz,Fs,tdur,phase);
figure(1)
subplot(2,1,2),plot(t(1:1000),output1c(1:1000)), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('Single Cosinewave')
if (playSoundFlag==1)
soundsc(output1c,Fs)
endif

%Generating multiple sinewaves in Octave
Fs=44100; %set the sampling frequency
fhzVect=[110 220 330 440 550 660]; %set a vector of frequencies in Hertz
tdur=1; %set the time duration in seconds
AmplitudeVect=[1 1/2 1/3 1/4 1/5 1/6]; %set a vector of amplitudes
phaseShiftVect=[0 0 0 0 0 0]; %Set a vector of Phase shifts in radians;

[output2,t]=Gen_MultiSine(AmplitudeVect,fhzVect,Fs,tdur,phaseShiftVect);
figure(2)
plot(t(1:1000),output2(1:1000))
xlabel('Time (Sec)'), ylabel('Amplitude'),title('Multiple Sinewaves - harmonic signal, pitch 110Hz'), axis tight
if (playSoundFlag==1)
soundsc(output2,Fs)
endif

%Generate Noise
wn=randn(1,44100);
if (playSoundFlag==1)
soundsc(wn,Fs)
endif
figure(3)
plot(t(1:1000),wn(1:1000)), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('White Noise')

%%%%%%%%%%%%%5 Wave files %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
dir='\Users\Lam\octaveScripts\Sounds\'; %give the directory where the sounds are stored
carillion='Carillion.wav';
castanets='Castanets.wav';
chinaFlutePhrase='ChinaFlutePhrase.wav';
choirGlissando='ChoirGlissando.wav';
speech2='Drop.wav';
oudMelody='OudMelody.wav';
pedalSteel='PedalSteelPhrase.wav';
sambaAgogo='SambaAgogo.wav';
singing='singingExample.wav';
speech='Speech.wav';
tamboura='Tamboura.wav';
tinWhistleRoll='TinWhistleRoll.wav';
woodPigeon='WoodPigeon.wav';


%read in wave file with speech
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

%read in wave file with speech2
fileName=strcat(dir,speech2);
[speech2,Fs]=audioread(fileName);
len=length(speech2);
t=(0:len-1)./Fs;
figure(5)
plot(t,speech2), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('speech2')
if (playSoundFlag==1)
soundsc(speech2,Fs)
endif


%read in wave file with singing
fileName=strcat(dir,singing);
[singing,Fs]=audioread(fileName);
len=length(singing);
t=(0:len-1)./Fs;
figure(6)
plot(t,singing), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('singing')
if (playSoundFlag==1)
soundsc(singing,Fs)
endif

%read in wave file with wood pigeon
fileName=strcat(dir,woodPigeon);
[pigeon,Fs]=audioread(fileName);
len=length(pigeon);
t=(0:len-1)./Fs;
figure(7)
plot(t,pigeon), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('woodPigeon')
if (playSoundFlag==1)
soundsc(pigeon,Fs)
endif


%read in wave file with castanets
fileName=strcat(dir,castanets);
[castanet,Fs]=audioread(fileName);
len=length(castanet);
t=(0:len-1)./Fs;
figure(8)
plot(t,castanet), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('castanets')
if (playSoundFlag==1)
soundsc(castanet,Fs)
endif

%read in wave file with tin whistle roll
fileName=strcat(dir,tinWhistleRoll);
[tinWhistle,Fs]=audioread(fileName);
len=length(tinWhistle);
t=(0:len-1)./Fs;
figure(9)
plot(t,tinWhistle), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('tinWhistleRoll')
if (playSoundFlag==1)
soundsc(tinWhistle,Fs)
endif


%read in wave file with tamboura
fileName=strcat(dir,tamboura);
[tambour,Fs]=audioread(fileName);
len=length(tambour);
t=(0:len-1)./Fs;
figure(10)
plot(t,tambour), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('tamboura')
if (playSoundFlag==1)
soundsc(tambour,Fs)
endif


%read in wave file with agogo
fileName=strcat(dir,sambaAgogo);
[agogo,Fs]=audioread(fileName);
len=length(agogo);
t=(0:len-1)./Fs;
figure(11)
plot(t,agogo), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('sambaAgogo'), axis tight
if (playSoundFlag==1)
soundsc(agogo,Fs)
endif

%read in wave file with chinaFlutePhrase
fileName=strcat(dir,chinaFlutePhrase);
[chinaflute,Fs]=audioread(fileName);
len=length(chinaflute);
t=(0:len-1)./Fs;
figure(12)
plot(t,chinaflute)
xlabel('Time (Sec)'), ylabel('Amplitude'),title('chinaFlutePhrase')
if (playSoundFlag==1)
soundsc(chinaflute,Fs)
endif

%read in wave file with oud
fileName=strcat(dir,oudMelody);
[oud,Fs]=audioread(fileName);
len=length(oud);
t=(0:len-1)./Fs;
figure(13)
plot(t,oud), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('oudMelody')
if (playSoundFlag==1)
soundsc(oud,Fs)
endif

%read in wave file with choirGlissando
fileName=strcat(dir,choirGlissando);
[choir,Fs]=audioread(fileName);
len=length(choir);
t=(0:len-1)./Fs;
figure(14)
plot(t,choir), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('choirGlissando')
if (playSoundFlag==1)
soundsc(choir,Fs)
endif

%read in wave file with pedalsteel
fileName=strcat(dir,pedalSteel);
[pedalsteel,Fs]=audioread(fileName);
len=length(pedalsteel);
t=(0:len-1)./Fs;
figure(15)
plot(t,pedalsteel), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('pedalSteel')
if (playSoundFlag==1)
soundsc(pedalsteel,Fs)
endif

%read in wave file with carillion
fileName=strcat(dir,carillion);
[carillion,Fs]=audioread(fileName);
len=length(carillion);
t=(0:len-1)./Fs;
figure(16)
plot(t,carillion), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('carillion')
if (playSoundFlag==1)
soundsc(carillion,Fs)
endif

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%% inharmonic signal %%%%%%%%%%%%%%
Fs=44100; %set the sampling frequency
fhzVect=[123 272 471 486 695 803]; %set a vector of frequencies in Hertz
tdur=1; %set the time duration in seconds
AmplitudeVect=[1 1/2 1/3 1/3 1/2 1]; %set a vector of amplitudes
phaseShiftVect=[0 0 0 0 0 0]; %Set a vector of Phase shifts in radians;

[output3,t]=Gen_MultiSine(AmplitudeVect,fhzVect,Fs,tdur,phaseShiftVect);
figure(17)
plot(t(1:1000),output3(1:1000)), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('Multiple Sinewaves - inharmonic signal, non-integer frequency relationship'), axis tight
message("The frequency components are located at 123Hz 272Hz 471Hz 486Hz 695Hz 803Hz\n");
if (playSoundFlag==1)
soundsc(output3,Fs)
endif

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%% missing fundamental signal %%%%%%%%%%%%%%
%Generating multiple sinewaves in Octave

Fs=44100; %set the sampling frequency
fhzVect=[0 220 330 440 550 660]; %set a vector of frequencies in Hertz
tdur=1; %set the time duration in seconds
AmplitudeVect=[1 1/2 1/3 1/4 1/5 1/6]; %set a vector of amplitudes
phaseShiftVect=[0 0 0 0 0 0]; %Set a vector of Phase shifts in radians;

[output4,t]=Gen_MultiSine(AmplitudeVect,fhzVect,Fs,tdur,phaseShiftVect);
figure(18)
plot(t(1:1000),output4(1:1000)), axis tight
xlabel('Time (Sec)'), ylabel('Amplitude'),title('Multiple Sinewaves - missing fundamental, perceived pitch is 110Hz'), axis tight
if (playSoundFlag==1)
soundsc(output4,Fs)
[output5,t]=Gen_sine(1,110,Fs,tdur,phase);
soundsc(output5,Fs)
message("The missing fundamental sound followed by a sinewave at 110Hz, their perceived pitch is the same\n");
endif


