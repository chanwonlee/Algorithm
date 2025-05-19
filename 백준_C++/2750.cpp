#include <bits/stdc++.h>
using namespace std;

int N ;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    int t;
    vector<bool> arr(2002);
    while(N--) {
        cin >> t;
        arr[t + 1000] = true;
    }
    for (int i = 0; i <= 2000; i++) 
        if (arr[i]) cout << i - 1000 << "\n";
}