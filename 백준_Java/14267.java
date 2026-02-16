import java.io.*;
import java.util.*;

class Main {
    static int[] answer;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 1; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            graph[temp].add(i + 1);
        }

        answer = new int[n + 1];
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            answer[i] += w;
        }
        dfs(1);

        for (int i = 1; i <=n; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    static void dfs(int cur) {
        for (int nxt : graph[cur]) {
            answer[nxt] += answer[cur];
            dfs(nxt);
        }
    }
}