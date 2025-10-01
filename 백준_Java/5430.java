import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String input = br.readLine();
            String numbers = input.substring(1, input.length() - 1);

            Deque<Integer> deque = new ArrayDeque<>();
            if (!numbers.isEmpty()) {
                for (String number : numbers.split(",")) {
                    if (!number.isEmpty()) {
                        deque.addLast(Integer.parseInt(number));
                    }
                }
            }
            
            String answer = solution(commands, n, deque);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static String solution(String commands, int n, Deque<Integer> deque) {
        boolean isReverse = false;
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'R') {
                isReverse = !isReverse;
            } else {
                if (deque.isEmpty()) return "error";

                if (isReverse) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append('[');
        if (!deque.isEmpty()) {
            if (isReverse) {
                Iterator<Integer> it = deque.descendingIterator();
                result.append(it.next());
                while (it.hasNext()) result.append(',').append(it.next());
            } else {
                Iterator<Integer> it = deque.iterator();
                result.append(it.next());
                while (it.hasNext()) result.append(',').append(it.next());
            }
        }
        result.append(']');
        return result.toString();
    }
}
