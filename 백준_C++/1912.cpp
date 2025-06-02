#include <bits/stdc++.h>
using namespace std;

int n, a[100001], d[100001];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for (int i = 1; i <= n; i++) cin >> a[i];
    for (int i = 1; i <= n; i++) d[i] = max(0, d[i - 1]) + a[i];
    cout << *max_element(d + 1, d + n + 1);
}