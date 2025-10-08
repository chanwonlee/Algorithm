import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solution());
    }

    static int solution() {
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        int[][] land = new int[n][n];
        int answer = 1000000;
        int mapNo = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 || land[i][j] != 0) continue;
                land[i][j] = ++mapNo;
                q.add(new Pair(i, j));

                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (board[nx][ny] == 0 || land[nx][ny] != 0) continue;
                        land[nx][ny] = mapNo;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] != 0) {
                    q.add(new Pair(i, j));
                    dist[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                if (land[nx][ny] != 0 && land[nx][ny] != land[cur.x][cur.y]) {
                    answer = Math.min(answer, dist[cur.x][cur.y] + dist[nx][ny]);
                }

                if (dist[nx][ny] > 0 || board[nx][ny] == 1) continue;
                land[nx][ny] = land[cur.x][cur.y];
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }

        return answer - 2;
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