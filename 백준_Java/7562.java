import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    static final int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(solution(n, x1, y1, x2, y2));
            t--;
        }
    }

    static int solution(int n, int x1, int y1, int x2, int y2) {
        int[][] dist = new int[n][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x1, y1));
        dist[x1][y1] = 1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            
            if (cur.x == x2 && cur.y == y2) {
                return dist[cur.x][cur.y] - 1;
            }

            for (int dir = 0; dir < 8; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >=n || ny < 0 || ny >= n) continue;
                if (dist[nx][ny] > 0) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
        return -1;
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