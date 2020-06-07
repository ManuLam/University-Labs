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
  
  //we see, we count, we pop
  cout << "Output:" << endl;
  
  for(int i = 0; i < arr.size(); i++) {
    int count = 1;
    for(int j = i+1; j < arr.size()-1; j++) {
      if(arr[i] == arr[j]) {
        count++;
        arr.erase(arr.begin()+j);
      }
    }
    cout << arr[i] << " appears " << count << " times" << endl;
  }

  return 0;
}