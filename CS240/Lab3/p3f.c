#include <stdio.h>
#include <fcntl.h>
main()
{
char fname[10];
char buffer[10];
int fd, n;
printf("What is your file name?\n");
scanf("%s",fname);

fd = open(fname, O_RDONLY);

	do {
		n = read(fd, buffer, 10); /*Read 10 chars from file*/
		write(1, buffer, n); /*Write chars to text terminal*/
	}

	while (n == 10); /* keep reading until n < 10 */


}
