import java.io.*;
import java.util.*;

class Main {
    static int n, m, k;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;

    static int[] dx = {1, -1 ,0 ,0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visited = new boolean[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int idx, int count, int sum) {
        if (count == k) {
            answer = Math.max(answer, sum);
            return;
        }

        if (idx >= n * m) return;

        for (int i = idx; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (check(x, y)) {
                visited[x][y] = true;
                dfs(i + 1, count + 1, sum + arr[x][y]);
                visited[x][y] = false;
            }
        }
    }

    static boolean check(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (visited[nx][ny]) return false;
        }
        return true;
    }
}