#include<bits/stdc++.h>
using namespace std;

int N, K, vis[200001], dist[200001];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    fill(dist, dist + 200001, -1);
    deque<int> DQ;
    DQ.push_back(N);
    dist[N] = 0;

    while(!DQ.empty()) {
        auto cur = DQ.front(); DQ.pop_front();

        if (cur == K) {
            cout << dist[cur];
            break;
        }

        if (cur * 2 <= 100000 && dist[cur * 2] == -1) {
            dist[cur * 2] = dist[cur];
            DQ.push_front(cur * 2);
        }

        for (int nxt : {cur - 1, cur + 1}) {
            if (nxt < 0 || nxt > 100000) continue;
            if (dist[nxt] != -1) continue;
            dist[nxt] = dist[cur] + 1;
            DQ.push_back(nxt);
        }
    }
}