import java.io.*;
import java.util.*;

class Main {
    static int[] result = new int[2];
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, n);
        System.out.print(result[0] + "\n" + result[1]);
    }

    static void solution(int x, int y, int n) {
        if (n == 1) {
            result[board[x][y]]++;
            return;
        }

        if (check(x, y, n)) {
            result[board[x][y]]++;
            return;
        } else {
            int step = n / 2;
            solution(x, y, step);
            solution(x + step, y, step);
            solution(x, y + step, step);            
            solution(x + step, y + step, step);
        }
    }

    static boolean check(int x, int y, int n) {
        int flag = board[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[i][j] != flag) return false;
            }
        }
        return true;
    }
}