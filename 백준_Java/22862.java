import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] s = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        int count = 0;
        int answer = 0;
        
        for (int start = 0; start < n; start++) {
            while (end < n) {
                if (count == k && s[end] % 2 == 1) {
                    break;
                }
                
                if (s[end] % 2 == 1) { 
                    count++;
                }
                end++;
            }
            
            answer = Math.max(answer, (end - start) - count);
            
            if (s[start] % 2 == 1) {
                count--;
            }
        }

        System.out.print(answer);
    }
}