#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>
using namespace std;

int main() {
  vector<string> arr;
  string s, wordMin, wordMax;
  int x = 0, min = 999, max = 0;

  cout << "Input:" << endl;

  while(cin >> s) 
    arr.push_back(s);
  
  
  for(int i = 0; i < arr.size(); i++) {
    if(arr[i].size() < min) {
      min = arr[i].size();
      wordMin = arr[i];
    }
    if(arr[i].size() > max) {
      max = arr[i].size();
      wordMax = arr[i];
    }
  }
  cout << "smallest word: " <<  wordMin << " of size " << min << endl;
  cout << "largest word: " <<  wordMax << " of size " << max << endl;

  return 0;
}