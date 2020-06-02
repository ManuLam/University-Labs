//Manyiu LAM 16458032
#include <iostream>
#include <string>
using namespace std;

void square(int x) {
  cout << string(x,'+') << endl;
  for(int i = 0; i < (x-2); i++)  cout << "+" + string((x-2),' ') + "+" << endl;
  cout << string(x,'+') << endl << endl;
}

void rectangle(int x, int y) {
  cout << string(x,'+') << endl;
  for(int i = 0; i < (y-2); i++)  cout << "+" + string((x-2),' ') + "+" << endl;
  cout << string(x,'+') << endl << endl;
}

void triangle(int x) {
  int z = 1;

  for (int i = 0; i < x; i++) {
    for (int j = x; j > i; j--) {
      cout << " "; 
    }
    cout << "+";  

    if (i != 0) {
      for (int k = 1; k <= z; k++) {
        cout << " ";
      }

      cout << "+";
      z += 2;
    }
    cout << endl;
  }
  
  cout << string(z+2, '+') << endl;
}

int main() {
  square(4);
  rectangle(4,10);
  triangle(100);
  return 0;
}