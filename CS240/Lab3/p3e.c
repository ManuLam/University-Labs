#include <stdio.h>
#include <fcntl.h>
main()
{
char buffer[10];
int fd, n;
fd = open("p3a.c",O_RDONLY);
n = read(fd, buffer, 6);
close(fd);
printf("%d characters were read from file p3a.c\n", n);
printf("The characters were\n");
write(1, buffer, n);
printf("\n");
}
