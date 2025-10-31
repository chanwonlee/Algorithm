import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] power = new boolean[101];
        
        st = new StringTokenizer(br.readLine());
        int[] a = new int[k];
        
        int count = 0;
        int answer = 0;
        
        for (int i = 0; i < k; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            int cur = a[i];
            if (power[cur]) continue;

            if (count < n) {
                power[cur] = true;
                count++;
            } else {
                int remove = -1;
                int max = -1;
                for (int x = 1; x <= 100; x++) {
                    if (!power[x]) continue;

                    int next = Integer.MAX_VALUE;
                    for (int j = i + 1; j < k; j++) {
                        if (a[j] == x) {
                            next = j;
                            break;
                        }
                    }

                    if (next > max) {
                        max = next;
                        remove = x;
                    }
                }

                power[remove] = false;
                power[cur] = true;
                answer++;
            }
        }

        System.out.print(answer);
    }
}