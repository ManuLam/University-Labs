//Manyiu LAM 16458032
#include <iostream>
#include <string>
using namespace std;

void formatName(string name) {

  string greeting = "Hello, " + name + "!";
  string spaces(greeting.size(), ' ');

  string second = "* " + spaces + " *";
  string first(second.size(), '*');

  cout << first << endl;
  cout << second << endl;

  cout << "* " << greeting << " *" << endl;

  cout << second << endl;
  cout << first << endl;
}


int main() {
  string name;
  cin >> name;
  formatName(name);

  return 0;
}