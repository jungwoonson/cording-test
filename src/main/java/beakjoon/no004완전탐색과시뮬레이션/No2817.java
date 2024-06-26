package beakjoon.no004완전탐색과시뮬레이션;

import java.io.*;

public class No2817 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int participant = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        int[] staffs = new int[26];
        boolean[] staffsValid = new boolean[26];
        double[][] result = new double[26][14];

        for (int i = 0; i < count; i++) {
            String[] info = br.readLine().split(" ");
            char name = info[0].charAt(0);
            int vote = Integer.parseInt(info[1]);
            if (vote < participant * 0.05) {
                continue;
            }

            staffsValid[name - 'A'] = true;
            for (int j = 0; j < 14; j++) {
                result[name - 'A'][j] = (double) vote / (double) (j + 1);
            }
        }

        double max = 2500001;

        for (int i = 0; i < 14; i++) {
            double targetScore = 0;
            int targetName = 99;

            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 14; k++) {
                    if (result[j][k] < max && targetScore < result[j][k]) {
                        targetScore = result[j][k];
                        targetName = j;
                    }
                }
            }

            if (targetScore > 0) {
                staffs[targetName]++;
                max = targetScore;
            }
        }

        for (int i = 0; i < staffs.length; i++) {
            if (!staffsValid[i]) {
                continue;
            }

            bw.write((char) (i + 'A'));
            bw.write(" ");
            bw.write(staffs[i] + System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }
}
