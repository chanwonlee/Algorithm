import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(br.readLine()));
        long answer = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int height = Integer.parseInt(br.readLine());
            
            while (!stack.isEmpty()) {
                if (stack.peek() <= height) {
                    stack.pop();
                }
                else break;
            }

            answer += stack.size();
            stack.push(height);
        }

        System.out.print(answer);
    }
}