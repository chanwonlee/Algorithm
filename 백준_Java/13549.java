import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.print(solution(n, k));
        sc.close();
    }

    static int solution(int n, int k) {
        int[] dist = new int[100001];
        Arrays.fill(dist, -1);

        Deque<Integer> dq = new ArrayDeque<>();
        dist[n] = 0;
        dq.add(n);

        while (!dq.isEmpty()) {
            int cur = dq.poll();
            if (cur == k) return dist[cur];

            int nx = cur * 2;
            if (nx <= 100000 && dist[nx] == -1) {
                dist[nx] = dist[cur];
                dq.addFirst(nx);
            }

            for (int next : new int[]{cur - 1, cur + 1}) {
                if (next >= 0 && next <= 100000 && dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    dq.addLast(next);
                }
            }
        }
        return -1;
    }
}