.MODEL medium
 .STACK ; Stack default size 1024 bytes
 .DATA ; Data segment (for variables)
 .CODE ; Run-able code goes in code segment
.STARTUP ; Handover code from OS call to typer.exe

nextc: mov ah,8 ; Call int21 with ah=8 returns with
 int 021h ; al equal to the ASCII character pressed
 mov dl,al ; dl is assigned value in al, dl=al

 mov ah,02h ; Call int21 with ah=2 prints ASCII
 int 021 ; character represented by value in dl
 
 cmp dl,'q' ; compare dl with ASCII ‘q’=
 jz done ; if key pressed is q, finish
 
 cmp dl,'0'	; if greater than 0 in ascii then proceed to p2
 jnc p2
 
 p2: cmp dl,'9'+1 ; if not less than 10 in ascii then restart
 jnc nextc	; back to start

 mov ah,02h		; store the dl value into ah
 int 021h;		; print the dl value
 
 jmp nextc		; back to start

 done: nop
 .EXIT ; Terminate and return control to OS
 END ; End of file (for compiler) 
