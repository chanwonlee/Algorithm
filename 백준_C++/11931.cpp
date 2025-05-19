#include <bits/stdc++.h>
using namespace std;

int N;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    int t;
    vector<bool> arr(2000002);
    while(N--) {
        cin >> t;
        arr[t + 1000000] = true;
    }
    for (int i = 2000000; i >= 0; i--) 
        if (arr[i]) cout << i - 1000000 << "\n";
}