#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main() {
int fdptr[2], n, buffersize=21;
char strbuff[buffersize+1];   
char message[] = "Welcome to Unix pipes";
int pid;

/* Create a new pipe */
pipe(fdptr);
/* fork a process */
pid = fork();

if (pid == 0) { 
    while (true) {
       /* read from the pipe into strbuff */
	   n = read(fdptr[0], strbuff, buffersize);
       strbuff[n] = 0;
       printf("Child read: %s\n", strbuff);
       /* sleep for 5 seconds */
		sleep(5);
       }
   }
else {   
   while (true) {
      printf("Parent writing: %s\n", message);
      /* write message into the pipe */
		write(fdptr[1], message, strlen(message));
      /* sleep for 5 seconds */
		sleep(5);
      }
   }

}
