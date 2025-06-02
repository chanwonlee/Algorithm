#include <bits/stdc++.h>
using namespace std;

int d[10005];
int N;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    d[1] = 1;
    d[2] = 2;
    for(int i = 3; i <= N; i++) d[i] = (d[i - 1] + d[i - 2]) % 10007;
    cout << d[N];
}