#include <stdio.h>
main()
{
char buffer[14]="Hello World\n\n";
write(1, buffer, 13);
}
