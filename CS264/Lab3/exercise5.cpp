//Manyiu LAM 16458032
#include <iostream>
#include <algorithm>
#include <vector>
#include <iomanip>
#include <ctime>
using namespace std;

vector<int> insertSort(vector<int> v) {
  int temp;
  for(int i = 0; i < v.size()-1; i++) {
    for(int j = i; j < v.size(); j++) {
      if(v[i] > v[j]) {
        temp = v[i];
        v[i] = v[j];
        v[j] = temp;
      }
    }
  }
  return v;
}

int main() {
  clock_t start, stop;
  vector<int> v;

  for(int i = 999; i >= 0; i--) v.push_back(i);

  start = clock();
  v = insertSort(v);
  stop = clock();

  cout << fixed << (double)(stop - start)/(double)CLOCKS_PER_SEC << " secs" << endl;

  for(int i = 0; i < v.size(); i++) cout << v[i] << " ";

  start = clock();
  sort(v.begin(), v.end());
  stop = clock();

  cout << fixed << "\n" << (double)(stop - start)/(double)CLOCKS_PER_SEC << " secs" << endl;

  return 0;
}
