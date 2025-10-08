import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solution());
    }

    static int solution() {
        int result = 0;
        while (true) {
            int count = check();
            if (count == 0) return 0;
            if (count > 1) break;
            melt();
            result++;
        }
        return result;
    }

    static int check() {
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || vis[i][j]) continue;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, j));
                vis[i][j] = true;
                count++;
                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (board[nx][ny] == 0 || vis[nx][ny]) continue;
                        vis[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
        return count;
    }

    static void melt() {
        int[][] newBoard = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) continue;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if (board[nx][ny] == 0 && newBoard[i][j] > 0) newBoard[i][j]--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(newBoard[i], 0, board[i], 0, m);
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