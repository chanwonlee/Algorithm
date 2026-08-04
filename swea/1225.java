import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int[] arr = new int[8];
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int n = 1;
            int cur = 0;
            while (true) {
                arr[cur] -= n;
                if (arr[cur] <= 0) {
                    arr[cur] = 0;
                    cur = (cur + 1) % 8;
                    break;
                } 
                n = n % 5 + 1;
                cur = (cur + 1) % 8;
            }

            StringBuilder sb = new StringBuilder();
            for (int t = 0; t < 8; t++) {
                sb.append(" ").append(arr[cur]);
                cur = (cur + 1) % 8;
            }

            System.out.println("#" + tc + sb);
        }
    }
    
}
