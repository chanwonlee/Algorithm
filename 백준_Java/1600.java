import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static final int[] dxk = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] dyk = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solution(k, n, m, board));
    }

    static int solution(int k, int n, int m, int[][] board) {
        int[][][] dist = new int[n][m][k + 1];
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 0, 0));
        while (!q.isEmpty()) {
            Tuple cur = q.poll();
            if (cur.x == n - 1 && cur.y == m - 1) return dist[cur.x][cur.y][cur.count];
            if (cur.count < k) {
                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur.x + dxk[dir];
                    int ny = cur.y + dyk[dir];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (dist[nx][ny][cur.count + 1] != 0 || board[nx][ny] == 1) continue;
                    dist[nx][ny][cur.count + 1] = dist[cur.x][cur.y][cur.count] + 1;
                    q.add(new Tuple(nx, ny, cur.count + 1));
                }
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist[nx][ny][cur.count] != 0 || board[nx][ny] == 1) continue;
                dist[nx][ny][cur.count] = dist[cur.x][cur.y][cur.count] + 1;
                q.add(new Tuple(nx, ny, cur.count));
            }
        }
        return - 1;
    }

    static class Tuple {
        int x;
        int y;
        int count;
        public Tuple(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}