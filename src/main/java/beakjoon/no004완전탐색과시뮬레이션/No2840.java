package beakjoon.no004완전탐색과시뮬레이션;

import java.io.*;

public class No2840 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        char[] wheel = new char[n];
        int index = 0;

        for (int i = 0; i < k; i++) {
            String[] line = br.readLine().split(" ");
            int count = Integer.parseInt(line[0]);
            char spell = line[1].charAt(0);

            index = turn(index, count, n);
            if (wheel[index] != 0 && wheel[index] != spell) {
                bw.write("!");
                bw.flush();
                bw.close();
                return;
            }
            wheel[index] = spell;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = n; i > 0; i--) {
            char value = wheel[turn(index, i, n)];
            if (value == 0) {
                answer.append("?");
                continue;
            }

            if (answer.toString().contains(String.valueOf(value))) {
                bw.write("!");
                bw.flush();
                bw.close();
                return;
            }

            answer.append(value);
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    public static int turn(int index, int count, int n) {
        return (index + count) % n;
    }
}
