import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String lines = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = lines.charAt(j) - '0';
            }
        }

        System.out.print(solution(n, m, board));
    }

    static int solution(int n, int m, int[][] board) {
        int[][] dist = new int[n][m];

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0));
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == 0 || dist[nx][ny] > 0) continue;
                
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
        return dist[n - 1][m - 1];
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