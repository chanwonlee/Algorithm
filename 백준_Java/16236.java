import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {-1, 0, 0, 1};
    static final int[] dy = {0, 1, -1, 0};
    static int sharkX;
    static int sharkY;
    static int size;
    static int[][] board;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        sharkX = 0;
        sharkY = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());            
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    board[i][j] = 0;
                }
            }
        }
        
        int answer = 0;
        size = 2;
        int eat = 0;        
        
        while (true) {
            int dist = bfs();

            if (dist == 0) {
                break;
            }

            answer += dist;
            eat++;

            if (eat == size) {
                size++;
                eat = 0;
            }

            board[sharkX][sharkY] = 0;
        }

        System.out.print(answer);
    }

    static int bfs() {
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<Pair> q = new LinkedList();
        q.offer(new Pair(sharkX, sharkY));
        dist[sharkX][sharkY] = 0;
        List<Pair> candidates = new ArrayList<>();

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (dist[nx][ny] != -1 || board[nx][ny] > size) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                
                if (board[nx][ny] > 0 && board[nx][ny] < size) {
                    candidates.add(new Pair(nx, ny, dist[nx][ny]));
                }

                q.offer(new Pair(nx, ny));
            }
        }

        if (candidates.isEmpty()) {
            return 0;
        }

        Collections.sort(candidates, (a, b) -> {
            if (a.d != b.d) return a.d - b.d;
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });

        Pair temp = candidates.get(0);
        sharkX = temp.x;
        sharkY = temp.y;
        return temp.d;
    }

    static class Pair {
        int x;
        int y;
        int d;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}