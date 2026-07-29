import java.io.*;
import java.util.*;

class Solution {
    static int[] a = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < 100; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
        
            for (int i = 0; i < n; i++) {
                int max = 0;
                int max_i = 0;
                int min = 101;
                int min_i = 0;

                for (int j = 0; j < 100; j++) {
                    if (max < a[j]) {
                        max = a[j];
                        max_i = j;
                    }

                    if (min > a[j]) {
                        min = a[j];
                        min_i = j;
                    }
                }

                a[max_i] -= 1;
                a[min_i] += 1;
            }

            int max = 0;
            int max_i = 0;
            int min = 101;
            int min_i = 0;

            for (int i = 0; i < 100; i++) {
                if (max < a[i]) {
                    max = a[i];
                    max_i = i;
                }

                if (min > a[i]) {
                    min = a[i];
                    min_i = i;
                }
            }
            System.out.println("#" + tc + " " + (a[max_i] - a[min_i]));
        }
    }
}