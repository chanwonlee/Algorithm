import java.io.*;
import java.util.*;

class Main {
    static int[] result = new int[3]; // -1, 0, 1
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
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }

    static void solution(int x, int y, int n) {
        if (n == 1) {
            result[board[x][y] + 1]++;
            return;
        }

        if (check(x, y, n)) {
            result[board[x][y] + 1]++;
            return;
        } else {
            int step = n / 3;
            solution(x, y, step);
            solution(x, y + step, step);
            solution(x, y + step * 2, step);
            
            solution(x + step, y, step);
            solution(x + step, y + step, step);
            solution(x + step, y + step * 2, step);

            solution(x + step * 2, y, step);
            solution(x + step * 2, y + step, step);
            solution(x + step * 2, y + step * 2, step);
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