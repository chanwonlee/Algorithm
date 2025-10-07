import java.io.*;
import java.util.*;

class Main {
    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] graph = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(n, graph));
        }
    }

    static int solution(int n, int[] graph) {
        int[] status = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (status[i] == NOT_VISITED) go(i, graph, status);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (status[i] != CYCLE_IN) answer++;
        }
        return answer;
    }

    static void go(int x, int[] graph, int[] status) {
        int cur = x;
        while (true) {
            status[cur] = x;
            cur = graph[cur];
            if (status[cur] == x) {
                while(status[cur] != CYCLE_IN) {
                    status[cur] = CYCLE_IN;
                    cur = graph[cur];
                }
                return;
            } else if (status[cur] != 0) return;
        }
    }
}