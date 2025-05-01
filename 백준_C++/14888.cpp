#include <bits/stdc++.h>
using namespace std;

int N, A[12], op[4];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) cin >> A[i];
    for (int i = 0; i < 4; i++) cin >> op[i];
    vector<int> brute;
    for (int i = 0; i < 4; i++) {
        while(op[i] > 0) {
            brute.push_back(i);
            op[i]--;
        }
    }
    int mx = INT_MIN;
    int mn = INT_MAX;
    do {
        int s = A[0];
        for (int i = 0; i < brute.size(); i++) {
            if (brute[i] == 0) s += A[i + 1];
            if (brute[i] == 1) s -= A[i + 1];
            if (brute[i] == 2) s *= A[i + 1];
            if (brute[i] == 3) s /= A[i + 1];
        }
        mx = max(mx, s);
        mn = min(mn, s);
    } while(next_permutation(brute.begin(), brute.end()));
    cout << mx << "\n" << mn;
}