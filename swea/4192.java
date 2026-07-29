import java.io.*;
import java.util.*;

class Solution {
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = -1;
				}
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			
			
			Queue<Pair> q = new LinkedList<>();
			q.add(new Pair(start_x, start_y));
			dist[start_x][start_y] = 0;
			while(!q.isEmpty()) {
				Pair cur = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if (board[nx][ny] == 1 || dist[nx][ny] != -1) continue;
					
					dist[nx][ny] = dist[cur.x][cur.y] + 1;
					q.add(new Pair(nx, ny));
				}
			}
			
			if (dist[end_x][end_y] == -1) {
				System.out.println("#" + tc + " " + -1);
			} else {
				System.out.println("#" + tc + " " + dist[end_x][end_y]);
			}
			
		}
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