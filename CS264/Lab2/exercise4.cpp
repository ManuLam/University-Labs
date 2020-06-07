#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  vector<string> arr;
  string s;
  cout << "Input:" << endl;

  while(cin >> s) 
    arr.push_back(s);

  sort(arr.begin(), arr.end());
  reverse(arr.begin(), arr.end());

  cout << "Output:" << endl;
  
  for(int i = 0; i < arr.size(); i++) 
    cout << arr[i] << " of size: " << arr[i].size() << endl;

  return 0;
}