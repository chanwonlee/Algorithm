#include<bits/stdc++.h>
using namespace std;

int t[20], p[20], d[20];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    for (int i = 1; i <= N; i++) cin >> t[i] >> p[i];

    for (int i = 1; i <= N; i++) {
        d[i + 1] = max(d[i + 1], d[i]);
        
        if (i + t[i] - 1 <= N) {
            d[i + t[i]] = max(d[i + t[i]], d[i] + p[i]);
        }
    }

    cout << *max_element(d, d + N + 2);
}