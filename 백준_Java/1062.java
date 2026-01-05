import java.io.*;
import java.util.*;

class Main {
    static int n, k;
    static int answer = 0;
    static int[] words; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k < 5) {
            System.out.print(0);
            return;
        }

        if (k == 26) {
            System.out.print(n);
            return;
        }

        words = new int[n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int mask = 0;
            for (int j = 0; j < str.length(); j++) {
                mask |= 1 << (str.charAt(j) - 'a');
            }
            words[i] = mask;
        }

        int startMask = 0;
        startMask |= 1 << ('a' - 'a');
        startMask |= 1 << ('n' - 'a');
        startMask |= 1 << ('t' - 'a');
        startMask |= 1 << ('i' - 'a');
        startMask |= 1 << ('c' - 'a');

        solution(0, 0, startMask);
        System.out.print(answer);
    }

    static void solution(int count, int start, int mask) {
        if (count == k - 5) {
            int result = 0;
            for (int word : words) {
                if ((word & mask) == word) {
                    result++;
                }
            }
            answer = Math.max(answer, result);
            return;
        }

        for (int i = start; i < 26; i++) {
            if ((mask & (1 << i)) == 0) {
                solution(count + 1, i + 1, mask | (1 << i));
            }
        }
    }
}