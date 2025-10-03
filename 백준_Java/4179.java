import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String lines = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = lines.charAt(j);
            }
        }

        int result = solution(n, m, board);

        if (result == -1) {
            System.out.print("IMPOSSIBLE");
        } else {
            System.out.print(result);
        }
    }

    static int solution(int n, int m, char[][] board) {
        int[][] fire = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        Pair start = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'F') {
                    q.add(new Pair(i, j));
                    fire[i][j] = 1;
                }

                if (board[i][j] == 'J') {
                    start = new Pair(i, j);
                    dist[i][j] = 1;
                }
            }
        }

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '#' || fire[nx][ny] > 0) continue;
                fire[nx][ny] = fire[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }

        q.add(start);
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    return dist[cur.x][cur.y];
                }
                if (board[nx][ny] == '#' || dist[nx][ny] > 0) continue;
                if (fire[nx][ny] != 0 && fire[nx][ny] <= dist[cur.x][cur.y] + 1) continue;
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