#include<bits/stdc++.h>
using namespace std;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int N, M, G, R, board[51][51], brute[10];
vector<pair<int, int>> cand;
const int EMPTY = 0;
const int GREEN = 1;
const int RED = 2;
const int FLOWER = 3;
int solve() {
    int cnt = 0;
    pair<int, int> state[52][52];

    queue<pair<int, int>> q;
    for (int i = 0; i < cand.size(); i++) {
        if (brute[i] == GREEN || brute[i] == RED) {
            state[cand[i].first][cand[i].second] = {0, brute[i]};
            q.push(cand[i]);
        }
    }

    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        int curtime = state[cur.first][cur.second].first;
        int curcolor = state[cur.first][cur.second].second;
        if (state[cur.first][cur.second].second == FLOWER) continue;
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (board[nx][ny] == 0) continue;
            if (state[nx][ny].second == EMPTY) {
                state[nx][ny] = {curtime + 1, curcolor};
                q.push({nx, ny});
            }
            else if (state[nx][ny].second == RED) {
                if (curcolor == GREEN && state[nx][ny].first == curtime + 1) {
                    cnt++;
                    state[nx][ny].second = FLOWER;
                }
            }
            else if (state[nx][ny].second == GREEN) {
                if (curcolor == RED && state[nx][ny].first == curtime + 1) {
                    cnt++;
                    state[nx][ny].second = FLOWER;
                }
            }
        }
    }
    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M >> G >> R;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];
            if (board[i][j] == 2) cand.push_back({i, j});
        }
    }
    fill(brute + cand.size() - G - R, brute + cand.size() - R, GREEN);
    fill(brute + cand.size() - R, brute + cand.size(), RED);
    int ans = 0;
    do {
        ans = max(ans, solve());
    } while(next_permutation(brute, brute + cand.size()));
    cout << ans;
}