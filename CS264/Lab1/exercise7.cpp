//Manyiu LAM 16458032
#include <iostream>
using namespace std;

int main() {
  int i,x;
  for(i = 1, x = 1; i < 10; i++) if(i%2 == 0) x*=i;
  cout << x << endl;
  
  return 0;
}