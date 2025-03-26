#include <bits/stdc++.h>
using namespace std;

int F, S, G, U, D;
int dist[1000002];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> F >> S >> G >> U >> D;
    fill(dist, dist + F + 1, -1);
    dist[S] = 0;
    queue<int> Q;
    Q.push(S);
    while(!Q.empty()) {
        int cur = Q.front(); Q.pop();
        if (cur == G) {
            cout << dist[cur];
            return 0;
        }

        for (auto nxt : {cur + U, cur - D}) {
            if (nxt < 1 || nxt > F || dist[nxt] >= 0) continue;
            dist[nxt] = dist[cur] + 1;
            Q.push(nxt);
        }
    }
    cout << "use the stairs";
}