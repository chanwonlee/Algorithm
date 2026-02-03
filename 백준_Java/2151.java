import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] board = new char[n][n];
        int dir = 0;
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == '#') {
                    startX = i;
                    startY = j;
                }
            }
        }
        PriorityQueue<Tuple> q = new PriorityQueue();
        boolean[][][] visited = new boolean[n][n][4];
        for (int i = 0; i < 4; i++) {
            q.add(new Tuple(startX, startY, i ,0));
        }

        while (!q.isEmpty()) {
            Tuple cur = q.poll();
            visited[cur.x][cur.y][cur.dir] = true;
            if (board[cur.x][cur.y] == '#' && !(cur.x == startX && cur.y == startY)) {
                System.out.print(cur.cnt);
                return;
            }

            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (visited[nx][ny][cur.dir]) continue;
            if (board[nx][ny] == '*') continue;
            if (board[nx][ny] == '!') {
                q.add(new Tuple(nx, ny, (cur.dir + 3) % 4, cur.cnt + 1));
                q.add(new Tuple(nx, ny, (cur.dir + 1) % 4, cur.cnt + 1));
            }
            q.add(new Tuple(nx, ny, cur.dir, cur.cnt));
        }
    }

    static class Tuple implements Comparable<Tuple>{
        int x;
        int y;
        int dir;
        int cnt;

        public Tuple(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.cnt - o.cnt;
        }
    }
}