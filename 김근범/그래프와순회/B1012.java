package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            boolean[][] land = new boolean[N][M];
            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                land[y][x] = true;
            }
            int result = findAdjacentArea(land);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static int findAdjacentArea(boolean[][] land) {
        int count = 0;
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[i].length;j++){
                if(land[i][j]) {
                    count++;
                    removeAdjacentArea(land, i, j);
                }
            }
        }
        return count;
    }

    private static void removeAdjacentArea(boolean[][] land, int r, int c) {
        if(land[r][c]) land[r][c] = false;
        else return;
        if(c>0 && land[r][c-1]) removeAdjacentArea(land, r, c-1);
        if(r>0 && land[r-1][c]) removeAdjacentArea(land, r-1, c);
        if(c<land[r].length-1 && land[r][c+1]) removeAdjacentArea(land, r, c+1);
        if(r<land.length-1 && land[r+1][c]) removeAdjacentArea(land, r+1, c);
    }
}
