import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.print(solution(n, m, board));
    }

    static int solution(int n, int m, int[][]board) {
        int[][][] dist = new int[n][m][2];
        Queue<Tuple> q = new LinkedList<>();
        
        dist[0][0][0] = 1;
        q.add(new Tuple(0, 0, 0));

        while (!q.isEmpty()) {
            Tuple cur = q.poll();

            if (cur.x == n -1 && cur.y == m - 1) return dist[cur.x][cur.y][cur.broke];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                int broke = cur.broke;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == 1) {
                    if (broke == 1) continue;
                    if (dist[nx][ny][1] == 0) {
                        dist[nx][ny][1] = dist[cur.x][cur.y][0] + 1;
                        q.add(new Tuple(nx, ny, 1));
                    }
                } else {
                    if (broke == 0 && dist[nx][ny][0] == 0) {
                        dist[nx][ny][0] = dist[cur.x][cur.y][0] + 1;
                        q.add(new Tuple(nx, ny, 0));
                    } else if (broke == 1 && dist[nx][ny][1] == 0) {
                        dist[nx][ny][1] = dist[cur.x][cur.y][1] + 1;
                        q.add(new Tuple(nx, ny, 1));
                    }

                }
            }
        }
        return -1;
    }

    static class Tuple{
        int x;
        int y;
        int broke;
        public Tuple(int x, int y, int broke) {
            this.x = x;
            this.y = y;
            this.broke = broke;
        }
    }
}