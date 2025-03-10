#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin >> t;
    int d[10] = {0};
    while(t>0) {
        d[t%10]++;
        t/=10;
    }
    d[6] = (d[6] + d[9] + 1) / 2;
    cout << *std::max_element(d, d+9);
}