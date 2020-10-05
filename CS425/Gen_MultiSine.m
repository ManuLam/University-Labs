function [output,t]=Gen_MultiSine(AmplitudeVect,fhzVect,Fs,tdur,phaseShiftVect);
  
  lenSig=(tdur*Fs);
  output=zeros(1,lenSig);
  len=length(AmplitudeVect);
  for i=1:len
  [partial,t]=Gen_sine(AmplitudeVect(i),fhzVect(i),Fs,tdur,phaseShiftVect(i));
  output=output+partial;
  end
  
  endfunction

