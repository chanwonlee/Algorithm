import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] vis;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !vis[i][j]) {
                    count++;
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n').append(maxArea);
        System.out.print(sb);
    }

    static int bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        vis[x][y] = true;
        q.offer(new int[]{x, y});
        int area = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            area++;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (vis[nx][ny]) continue;
                if (board[nx][ny] == 0) continue;

                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return area;
    }
} 