#include<bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N, M;
    cin >> N >> M;
    deque<int> dq;
    int ans = 0;

    for (int i = 1; i <= N; i++) dq.push_back(i);
    while(M--) {
        int t;
        cin >> t;
        int idx = find(dq.begin(), dq.end(), t) - dq.begin();
        while (dq.front() != t) {
            if (idx < dq.size() - idx) {
                dq.push_back(dq.front());
                dq.pop_front();
            } else {
                dq.push_front(dq.back());
                dq.pop_back();
            }
            ans++;
        }
        dq.pop_front();
    }
    cout << ans;
}