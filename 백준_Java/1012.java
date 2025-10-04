import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            boolean[][] board = new boolean[n][m];
            while (k > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = true;
                k--;
            }
            System.out.println(solution(n, m, board));
            t--;
        }
    }

    static int solution(int n, int m, boolean[][] board) {
        boolean[][] vis = new boolean[n][m];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] && !vis[i][j]) {
                    answer++;
                    bfs(i, j, board, vis);
                }
            }
        }
        return answer;
    }

    static void bfs(int x, int y, boolean[][] board, boolean[][] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        vis[x][y] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (!board[nx][ny] || vis[nx][ny]) continue;

                q.add(new Pair(nx, ny));
                vis[nx][ny] = true;
            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}