import java.io.*;
import java.util.*;

class Main {
    static int l, c;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    static char[] result = new char[15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);    
        solution(0, 0, 0, 0);
        System.out.print(sb);
    }

    static void solution(int k, int start, int vowel, int consonant) {
        if (k == l) {
            if (vowel < 1 || consonant < 2) return;
            
            for (int i = 0; i < l; i++) {
                sb.append(result[i]);
            }

            sb.append("\n");
            return;
        }

        for (int i = start; i < c; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                result[k] = arr[i];
                solution(k + 1, i + 1, vowel + 1, consonant);
            } else {
                result[k] = arr[i];
                solution(k + 1, i + 1, vowel, consonant + 1);
            }
        }
    }
}