import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int answer;
    static boolean[] vis;
    static int[] checked = new int[7];
    static char[][] board = new char[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        
        solution(0, 0, 0);
        System.out.print(answer);
    }

    static void solution(int k, int start, int s) {
        if (k - s > 3) return;

        if (k == 7) {
            vis = new boolean[7];
            bfs(checked[0] / 5, checked[0] % 5);
            return;
        }

        for (int i = start; i < 25; i++) {
            checked[k] = i;
            if (board[i / 5][i % 5] == 'S') {
                solution(k + 1, i + 1, s + 1);
            } else {
                solution(k + 1, i + 1, s);
            }
        }
    }

    static void bfs(int i, int j) {
        int count = 1;
        vis[0] = true;
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                for (int k = 0; k < 7; k++) {
                    if (!vis[k] && checked[k] == nx * 5 + ny) {
                        q.add(new Pair(nx, ny));
                        vis[k] = true;
                        count++;
                    }    
                }
            }
        }
        if (count == 7) answer++;
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