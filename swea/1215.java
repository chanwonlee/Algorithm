import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());

            char[][] board = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String line = br.readLine();
                for (int j = 0; j < 8; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            int count = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - n; j++) {
                    if (checkX(board, i, j, n)) {
                        count++;
                    }
                }
            }

            for (int j = 0; j < 8; j++) {
                for (int i = 0; i <= 8 - n; i++) {
                    if (checkY(board, i, j, n)) {
                        count++;
                    }
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }

    static boolean checkX(char[][] board, int x, int y, int n) {
        int left = y;
        int right = y + n - 1;

        while (left < right) {
            if (board[x][left] != board[x][right]) return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean checkY(char[][] board, int x, int y, int n) {
        int left = x;
        int right = x + n - 1;

        while (left < right) {
            if (board[left][y] != board[right][y]) return false;
            left++;
            right--;
        }
        return true;
    }
}