#include <bits/stdc++.h>
using namespace std;

int T, d[20];
int main(void){
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  d[1] = 1; d[2] = 2; d[3] = 4;
  for(int i = 4; i < 11; i++)
    d[i] = d[i-1] + d[i-2] + d[i-3];
  
  cin >> T;
  while(T--){
    int n;
    cin >> n;
    cout << d[n] << '\n';
  }
}