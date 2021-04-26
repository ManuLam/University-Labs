// MASM_FP.cpp : Defines the entry point for the console application.
#include "stdafx.h"
#include <stdio.h>
void test(void); // Function prototype (description)
int _tmain(int argc, _TCHAR* argv[]) {
test();
return 0;
}

void test() {
float SX = 3, SY = 9, C = 0;
unsigned short cntrl=0x3FF,stat;
__asm {
	FINIT           		
	FLDCW		cntrl     	
	
	FLD 		SX   		
    	FMUL		ST,ST(0)   	
	FLD 		SX   		
	    FMUL		ST,ST(1)   	

    FLD 		SY     
	FSQRT
	
	FADD ST,ST(1)		
	
	FSTP C         		
 }

 printf("%3.3f",C); 
} 