#include<bits/stdc++.h>
using namespace std;

int N, a[1001], d[1001];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> a[i];
        d[i] = a[i];
    }

    for (int i = 0; i < N; i++) 
        for (int j = 0; j < i; j++)
            if (a[j] < a[i]) d[i] = max(d[i], d[j] + a[i]);

    cout << *max_element(d, d + N);
}