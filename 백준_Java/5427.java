import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            char[][] board = new char[n][m];
            for (int i = 0; i < n; i++) {
                String lines = br.readLine();
                for (int j = 0; j < m; j++) {
                    board[i][j] = lines.charAt(j);
                }
            }

            int result = solution(n, m, board);
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
            t--;
        }
    }

    static int solution(int n, int m, char[][] board) {
        int[][] fire = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        Pair start = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '*') {
                    fire[i][j] = 1;
                    q.add(new Pair(i, j));
                }

                if (board[i][j] == '@') {
                    dist[i][j] = 1;
                    start = new Pair(i, j);
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (fire[nx][ny] > 0 || board[nx][ny] == '#') continue;

                fire[nx][ny] = fire[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }

        q.add(start);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    return dist[cur.x][cur.y];
                }
                if (dist[nx][ny] > 0 || board[nx][ny] == '#') continue;
                if (fire[nx][ny] != 0 && dist[cur.x][cur.y] + 1 >= fire[nx][ny]) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
        return -1;
    }

    static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}