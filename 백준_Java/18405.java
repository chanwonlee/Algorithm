import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        List<Virus> viruses = new ArrayList();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0) {
                    viruses.add(new Virus(board[i][j], i, j, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        Collections.sort(viruses, (a, b) -> a.n - b.n);
        Queue<Virus> q = new LinkedList<>(viruses);

        while (!q.isEmpty()) {
            Virus cur = q.poll();
            if (cur.s == s) break;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] != 0) continue;
                board[nx][ny] = cur.n;
                q.add(new Virus(cur.n, nx, ny, cur.s + 1));
            }
        }
        System.out.print(board[x - 1][y - 1]);
    }

    static class Virus {
        int n;
        int x;
        int y;
        int s;
        
        public Virus(int n, int x, int y, int s) {
            this.n = n;
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }
}