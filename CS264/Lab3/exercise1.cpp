//Manyiu LAM 16458032
#include <iostream>
#include <string>
using namespace std;

void square(int x) {
  cout << string(x,'+') << endl;
  for(int i = 0; i < (x-2); i++)  cout << "+" + string((x-2),'+') + "+" << endl;
  cout << string(x,'+') << endl << endl;
}

void rectangle(int x, int y) {
  cout << string(x,'+') << endl;
  for(int i = 0; i < (y-2); i++)  cout << "+" + string((x-2),'+') + "+" << endl;
  cout << string(x,'+') << endl << endl;
}

void triangle(int x) {
  for (int i = 0; i < x+1; i++) {
    for (int j = 0; j < i; j++) {
      cout << "+"; 
    }
    cout << endl;
  }
}

int main() {
  square(4);
  rectangle(4,10);
  triangle(5);
  return 0;
}