package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            test(br);
        }
        System.out.print(sb);
    }

    private static void test(BufferedReader br) throws IOException {
        int l = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[l][l];
        int[][] level = new int[l][l];
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int destR = Integer.parseInt(st.nextToken());
        int destC = Integer.parseInt(st.nextToken());
        visited[r][c] = true;
        queue.add(r);
        queue.add(c);
        while (!queue.isEmpty()) {
            int currentR = queue.poll();
            int currentC = queue.poll();
            if (currentR == destR && currentC == destC) {
                sb.append(level[currentR][currentC]).append("\n");
                return;
            }
            if (currentR > 1) {
                if(currentC>0 && !visited[currentR-2][currentC-1]) {
                    visited[currentR-2][currentC-1] = true;
                    level[currentR-2][currentC-1] = level[currentR][currentC] +1;
                    queue.add(currentR-2);
                    queue.add(currentC-1);
                }
                if(currentC<l-1 && !visited[currentR-2][currentC+1]) {
                    visited[currentR-2][currentC+1] = true;
                    level[currentR-2][currentC+1] = level[currentR][currentC] +1;
                    queue.add(currentR-2);
                    queue.add(currentC+1);
                }
            }
            if (currentC > 1) {
                if(currentR>0 && !visited[currentR-1][currentC-2]) {
                    visited[currentR-1][currentC-2] = true;
                    level[currentR-1][currentC-2] = level[currentR][currentC] +1;
                    queue.add(currentR-1);
                    queue.add(currentC-2);
                }
                if(currentR<l-1 && !visited[currentR+1][currentC-2]) {
                    visited[currentR+1][currentC-2] = true;
                    level[currentR+1][currentC-2] = level[currentR][currentC] +1;
                    queue.add(currentR+1);
                    queue.add(currentC-2);
                }
            }
            if(currentR < l-2) {
                if(currentC>0 && !visited[currentR+2][currentC-1]) {
                    visited[currentR+2][currentC-1] = true;
                    level[currentR+2][currentC-1] = level[currentR][currentC] +1;
                    queue.add(currentR+2);
                    queue.add(currentC-1);
                }
                if(currentC<l-1 && !visited[currentR+2][currentC+1]) {
                    visited[currentR+2][currentC+1] = true;
                    level[currentR+2][currentC+1] = level[currentR][currentC] +1;
                    queue.add(currentR+2);
                    queue.add(currentC+1);
                }
            }
            if(currentC < l-2) {
                if(currentR>0 && !visited[currentR-1][currentC+2]) {
                    visited[currentR-1][currentC+2] = true;
                    level[currentR-1][currentC+2] = level[currentR][currentC] +1;
                    queue.add(currentR-1);
                    queue.add(currentC+2);
                }
                if(currentR<l-1 && !visited[currentR+1][currentC+2]) {
                    visited[currentR+1][currentC+2] = true;
                    level[currentR+1][currentC+2] = level[currentR][currentC] +1;
                    queue.add(currentR+1);
                    queue.add(currentC+2);
                }
            }
        }
    }
}
