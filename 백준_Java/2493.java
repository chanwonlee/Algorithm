import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{100000001, 0});

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (stack.peek()[0] < height) {
                stack.pop();
            }

            sb.append(stack.peek()[1]).append(" ");
            stack.push(new int[]{height, i});
        }
        
        System.out.println(sb.toString());
    }
}