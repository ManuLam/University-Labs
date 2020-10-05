function [output, t] = Gen_cos(Amplitude,fhz,Fs,tdur,phaseShift)
 
Ts=1./Fs;
t=(0:(tdur*Fs)-1).*Ts; %get the time vectorize
output=Amplitude.*cos(2.*pi.*fhz.*t+phaseShift);
endfunction