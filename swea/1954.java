import java.util.Scanner;
   
class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	for (int tc = 1; tc <= t; tc++) {
    		int n = sc.nextInt();
    		int[][] board = new int[n][n];
    		
    		int x = 0;
    		int y = 0;
    		int step = 0;
    		
    		for (int i = 1; i <= n * n; i++) {
    			board[x][y] = i;
    			if (x == step + 1 && y == step) {
    				step++;
    				y++;
    			} else if (x == step && y != n - step - 1) {
    				y++;
    			} else if (y == n - step - 1 && x != n - step - 1) {
    				x++;
    			} else if (x == n - step - 1 && y != step) {
    				y--;
    			} else if (y == step && x != step) {
    				x--;
    			}
    		}
    		
    		// 출력
    		System.out.println("#" + tc);
    		for (int i = 0; i < n; i++) {
    			for (int j = 0; j < n; j++) {
    				System.out.print(board[i][j] + " ");
    			}
    			System.out.println();
    		}
    	}
    }
}