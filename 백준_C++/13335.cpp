#include <bits/stdc++.h>
using namespace std;

int n, w, l;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> w >> l;
    queue<int> truck;
    queue<int> bridge;
    
    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        truck.push(tmp);
    }

    for (int i = 0; i < w; i++) bridge.push(0);
    int time = 0, sum = 0;

    while (!bridge.empty()) {
        time++;
        sum -= bridge.front();
        bridge.pop();
        if (!truck.empty()) {
            if (sum + truck.front() <= l) {
                bridge.push(truck.front());
                sum += truck.front();
                truck.pop();
            } else bridge.push(0);
        }
    }
    cout << time;
}
