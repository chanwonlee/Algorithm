import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }

    static int solution(String s) {
        boolean razer = false;
        int n = 0;
        int answer = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                n++;
                razer = true;
            }
            else {
                if(razer == true) {
                    n--;
                    answer += n;
                    razer = false;
                } else {
                    n--;
                    answer++;
                }
            }
        }
        return answer;
    }
}