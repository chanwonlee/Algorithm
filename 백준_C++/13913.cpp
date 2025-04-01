#include<bits/stdc++.h>
using namespace std;

int N, K, vis[200001];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    fill(vis, vis + 200001, -1);
    queue<int> Q;
    Q.push(N);
    vis[N] = N;
    while(!Q.empty()) {
        int cur = Q.front(); Q.pop();
        if (cur == K) {
            vector<int> path;
            while(cur != N) {
                path.push_back(cur);
                cur = vis[cur];
            }
            path.push_back(N);
            reverse(path.begin(), path.end());
            cout << path.size() - 1 << "\n";
            for (auto i : path) cout << i << " ";
            break;
        }
        for (auto nxt : {cur - 1, cur + 1, cur * 2}) {
            if (nxt < 0 || nxt >= 200001) continue;
            if (vis[nxt] != -1) continue;
            vis[nxt] = cur;
            Q.push(nxt);
        }
    }
}