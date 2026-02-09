import java.io.*;
import java.util.*;

class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n;
    static int m;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        while (true) {
            // 청소
            if (board[r][c] == 0) {
                board[r][c] = 2;
                answer++;
            }
            
            if (check(r, c)) {
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (board[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                }
            } else {
                int nr = r - dr[d];
                int nc = c - dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr][nc] == 1) break;
                r = nr;
                c = nc;
            }
        }
        System.out.println(answer);
    }

    static boolean check(int r, int c) {
        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (board[nr][nc] == 0) return true;
        }
        return false;
    }
}