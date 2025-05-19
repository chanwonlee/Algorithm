#include <bits/stdc++.h>
using namespace std;

int N, t;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<int> arr(2000002);
    cin >> N;
    while(N--) {
        cin >> t;
        arr[t + 1000000]++;
    }
    for (int i = 0; i <= 2000000; i++) 
        while (arr[i]--) cout << i - 1000000 << '\n';
}