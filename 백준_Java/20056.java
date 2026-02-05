import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n;
    static List<Fireball>[][] board;
    static List<Fireball> fireballs = new ArrayList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = new ArrayList();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int mm = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, mm, s, d));
        }

        for (int i = 0; i < k; i++) {
            move();
            spread();
        }

        int answer = 0;
        for (Fireball fireball : fireballs) {
            answer += fireball.m;
        }
        System.out.println(answer);
    }

    static void move() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j].clear();
            }
        }
        
        for (Fireball cur : fireballs) {
            int nx = ((cur.x + dx[cur.d] * cur.s) % n + n) % n;;
            int ny = ((cur.y + dy[cur.d] * cur.s) % n + n) % n;
            cur.x = nx;
            cur.y = ny;
            board[nx][ny].add(cur);
        }
    }

    static void spread() {
        List<Fireball> newFireballs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j].size() == 0) {
                    continue;
                }

                if (board[i][j].size() == 1) {
                    newFireballs.add(board[i][j].get(0));
                    continue;
                }                

                int sm = 0;
                int ss = 0;
                int count = board[i][j].size();
                boolean odd = true;
                boolean even = true;

                for (Fireball fireball : board[i][j]) {
                    sm += fireball.m;
                    ss += fireball.s;
                    if (fireball.d % 2 == 0) odd = false;
                    else even = false;
                }

                int nm = sm / 5;
                int ns = ss / count;

                if (nm == 0) continue;

                if (odd || even) {
                    newFireballs.add(new Fireball(i, j, nm, ns, 0));
                    newFireballs.add(new Fireball(i, j, nm, ns, 2));
                    newFireballs.add(new Fireball(i, j, nm, ns, 4));
                    newFireballs.add(new Fireball(i, j, nm, ns, 6));
                } else {
                    newFireballs.add(new Fireball(i, j, nm, ns, 1));
                    newFireballs.add(new Fireball(i, j, nm, ns, 3));
                    newFireballs.add(new Fireball(i, j, nm, ns, 5));
                    newFireballs.add(new Fireball(i, j, nm, ns, 7));
                }
            }
        }
        fireballs = newFireballs;
    }

    static class Fireball {
        int x;
        int y;
        int m;
        int s;
        int d;
        public Fireball(int x, int y,  int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}