#include <bits/stdc++.h>
using namespace std;

int N, M, A[1000001], B[1000001], result[2000001];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N >> M;
    for (int i = 0; i < N; i++) cin >> A[i];
    for (int i = 0; i < M; i++) cin >> B[i];

    int a_idx = 0, b_idx = 0;
    for (int i = 0; i < N + M; i++) {
        if (a_idx == N) result[i] = B[b_idx++];
        else if (b_idx == M) result[i] = A[a_idx++];
        else if (A[a_idx] < B[b_idx]) result[i] = A[a_idx++];
        else result[i] = B[b_idx++];
    }
    for (int i = 0; i < N + M; i++) cout << result[i] << " ";
}