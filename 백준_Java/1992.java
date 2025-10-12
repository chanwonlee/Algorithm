import java.io.*;
import java.util.*;

class Main {
    static int[][] board;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        solution(0, 0, n);
        System.out.print(sb);
    }

    static void solution(int x, int y, int n) {
        if (n == 1) {
            sb.append(board[x][y]);
            return;
        }

        if (!check(x, y, n)) {
            int half = n / 2;
            sb.append("(");
            solution(x, y, half);
            solution(x, y + half, half);
            solution(x + half, y , half);
            solution(x + half, y + half, half);
            sb.append(")");
        } else {
            sb.append(board[x][y]);
        }
    }

    static boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[x][y] != board[i][j]) return false;
            }
        }
        return true;
    }
}