#include <bits/stdc++.h>
using namespace std;

int students[2][7];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N, K;
    cin >> N >> K;

    for (int i=0; i<N; i++) {
        int a, b;
        cin >> a >> b;
        students[a][b]++;
    }

    int answer = 0;
    for (int i=0; i<=1; i++) {
        for (int j=1; j<=6; j++) {
            answer += students[i][j] / K;
            if (students[i][j] % K) answer++;
        }
    }
    cout << answer;
}