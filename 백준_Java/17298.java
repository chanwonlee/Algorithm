import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer[]> stack = new Stack<>();
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            
            while (!stack.isEmpty()) {
                if (stack.peek()[0] < height) {
                    answer[stack.pop()[1]] = height;
                }
                else break;
            }

            stack.push(new Integer[]{height, i});
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()[1]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}