import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            int min = w.length();
            int max = 0;

            Map<Character, Integer> counter = new HashMap();
            for (char c : w.toCharArray()) {
                counter.put(c, counter.getOrDefault(c, 0) + 1);
            }

            for (char word : counter.keySet()) {
                if (counter.get(word) < k) continue;

                List<Integer> wordIndex = new ArrayList();
                for (int i = 0; i < w.length(); i++) {
                    if (w.charAt(i) == word) wordIndex.add(i);
                }
                
                for (int i = 0; i <= wordIndex.size() - k; i++) {
                    int len = wordIndex.get(i + k - 1) - wordIndex.get(i) + 1;
                    min = Math.min(min, len);
                    max = Math.max(max, len);
                }
            }

            if (max == 0) {
                System.out.println("-1");
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}