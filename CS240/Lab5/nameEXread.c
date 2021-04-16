#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>
#include <sys/stat.h>

int main(int argc, char *argv[]) {
	int namedpipe;
	int max_size = 20;
	char message[max_size+1];
	char buffer[max_size+1];
	bool paramerror= false;

/* Check for existence of named pipe and create it if it doesn't exist */

	if(access("fifo", F_OK) == -1) /*doesn’t exist */
		if(mknod("fifo", 010600, 0) == 0)	printf("Named Pipe created successfully \n");
		else {
			printf("Failed to create Named Pipe \n");
			exit(0); /* Program terminates */
		}
	else	printf("Using existing named pipe \n");


	open("fifo", RD_ONLY);

	for(i=1; i<=10; i++) {
	/* Reader will read 10 times from pipe */
		int n = read(namedpipe, buffer, max_size);
		buffer[n]=0;
		printf("reader: Read message <%s> %d characters \n",buffer,n);
	}
	close(1);
	
	
	//close(namedpipe);

 return 0;
}

