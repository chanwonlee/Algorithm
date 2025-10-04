import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String lines = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = lines.charAt(j);
            }
        }

        int answer1 = solution1(n, board);
        int answer2 = solution2(n, board);
        System.out.print(answer1 + " " + answer2);
    }
    
    static int solution1(int n, char[][] board) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) continue;
                q.add(new Pair(i, j));
                vis[i][j] = true;
                answer++;
                
                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (board[nx][ny] != board[cur.x][cur.y] || vis[nx][ny]) continue;
                        
                        q.add(new Pair(nx, ny));
                        vis[nx][ny] = true;
                    }
                }
    
            }
        }
        return answer;
    }


    static int solution2(int n, char[][] board) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) continue;
                q.add(new Pair(i, j));
                vis[i][j] = true;
                answer++;
                
                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (vis[nx][ny]) continue;
                        if (board[cur.x][cur.y] == 'B') {
                            if (board[nx][ny] != 'B') continue;
                        } else {
                            if (board[nx][ny] == 'B') continue;
                        }
                        
                        q.add(new Pair(nx, ny));
                        vis[nx][ny] = true;
                    }
                }
    
            }
        }
        return answer;
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