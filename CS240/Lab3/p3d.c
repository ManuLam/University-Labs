main()
{
char buffer[10];
int n;
printf("Enter 6 characters\n");
n = read(0, buffer, 6);
printf("%d characters were entered\n", n);
printf("The characters were\n");
write(1, buffer, n);
}
