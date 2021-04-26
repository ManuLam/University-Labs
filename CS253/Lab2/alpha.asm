.MODEL medium
 .STACK ; Stack default size 1024 bytes
 .DATA ; Data segment (for variables)
 .CODE ; Run-able code goes in code segment
.STARTUP ; Handover code from OS call to typer.exe

nextc: mov ah,8 ; Call int21 with ah=8 returns with
 int 021h ; al equal to the ASCII character pressed
 mov dl,al ; dl is assigned value in al, dl=al

 mov ah,02h ; Call int21 with ah=2 prints ASCII
 int 021h ; character represented by value in dl
 
 cmp dl,27 ; compare dl with ASCII ‘esc’
 jz done ; if key pressed is q, finish
 
 cmp dl,'a'	; if not greater than 'a' in ascii then proceed to print
 jc print	; print
 
 cmp dl,'z'+1 ; if not less than 'z' in ascii then proceed to print
 jnc print	; print
 
 sub dl,32	; subtract 32 to form capital for a-z
 
 print:
 mov ah,02h		; store the dl value into ah
 int 021h;		; print the dl value
 
 jmp nextc		; back to start

 done: nop
 .EXIT ; Terminate and return control to OS
 END ; End of file (for compiler) 
