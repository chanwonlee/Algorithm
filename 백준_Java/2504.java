import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.print(solution(s));
    }

    static int solution(String s) {
        Deque<Pair> deque = new ArrayDeque<>();
        int result = 0;
        deque.addLast(new Pair(' ', 0));
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[') {
                deque.addLast(new Pair(ch, 0));
            }
            
            if (ch == ')') {
                if (deque.isEmpty() || deque.getLast().ch != '(') return 0;
                int temp = (deque.getLast().sum == 0) ? 2 : deque.getLast().sum * 2;
                deque.pollLast();
                if (deque.isEmpty()) return 0;
                deque.getLast().sum += temp;
            }

            if (ch == ']') {
                if (deque.isEmpty() || deque.getLast().ch != '[') return 0;
                int temp = (deque.getLast().sum == 0) ? 3 : deque.getLast().sum * 3;
                deque.pollLast();
                if (deque.isEmpty()) return 0;
                deque.getLast().sum += temp;
            }
        }

        if (deque.size() != 1) return 0;
        return deque.getLast().sum;
    }

    static class Pair {
        char ch;
        int sum;
        Pair(char ch, int sum) {
            this.ch = ch;
            this.sum = sum;
        }
    }
}