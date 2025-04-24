#include<bits/stdc++.h>
using namespace std;

int N, M, board[51][51];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    vector<pair<int, int>> chicken;
    vector<pair<int, int>> house;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
            if (board[i][j] == 1) house.push_back({i, j});
            if (board[i][j] == 2) chicken.push_back({i, j});
        }
    }

    vector<int> brute(chicken.size(), 1);
    fill(brute.begin(), brute.begin() + chicken.size() - M, 0);
    int mx = INT_MAX;
    do {
        int dist = 0;
        for (auto h : house) {
            int tmp = INT_MAX;
            for (int i = 0; i < chicken.size(); i++) {
                if (brute[i] == 0) continue;
                tmp = min(tmp, abs(chicken[i].first - h.first) + abs(chicken[i].second - h.second));
            }
            dist += tmp;
        }
        mx = min(mx, dist);
    } while(next_permutation(brute.begin(), brute.end())); 
    cout << mx;
}