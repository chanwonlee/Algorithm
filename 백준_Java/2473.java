import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] liquid = new long[n];
        
        for (int i = 0; i < n; i++) {
            liquid[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(liquid);
        
        long[] result = new long[3];
        long min = Long.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;

            while (start < end) {
                long sum = liquid[start] + liquid[end] + liquid[i];

                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    result[0] = liquid[i];
                    result[1] = liquid[start];
                    result[2] = liquid[end];
                }

                if (sum == 0) {
                System.out.println(result[0] + " " + result[1] + " " + result[2]);
                return;
                }

                if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}