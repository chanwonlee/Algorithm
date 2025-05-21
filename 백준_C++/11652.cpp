#include <bits/stdc++.h>
using namespace std;

int N;
long long a[100005];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) cin >> a[i];
    sort(a, a + N);
    int cnt = 0;
    long long mxval = LLONG_MAX;
    int mxcnt = 0;
    for (int i = 0; i < N; i++) {
        if (i == 0 || a[i - 1] == a[i]) cnt++;
        else {
            if (cnt > mxcnt) {
                mxcnt = cnt;
                mxval = a[i - 1];
            }
            cnt = 1;
        }
    }
    if (cnt > mxcnt) mxval = a[N - 1];
    cout << mxval;
}