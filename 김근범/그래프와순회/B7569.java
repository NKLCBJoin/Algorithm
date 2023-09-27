package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569 {

    static Queue<Tomato> queue = new LinkedList<>();
    static int[] dirR = {-1, 1, 0, 0, 0, 0};
    static int[] dirC = {0, 0, -1, 1, 0, 0};
    static int[] dirH = {0, 0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] tomatoWareHouse = new int[H][N][M];
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++){
                    tomatoWareHouse[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomatoWareHouse[i][j][k] == 1) queue.add(new Tomato(i, j, k, 0));
                }
            }
        }
        int result = findShortestTime(tomatoWareHouse);
        if(hasZero(tomatoWareHouse)) System.out.println(-1);
        else System.out.println(result);
    }

    private static boolean hasZero(int[][][] tomatoWareHouse){
        for(int i=0;i<tomatoWareHouse.length;i++){
            for(int j=0;j<tomatoWareHouse[i].length;j++){
                for(int k=0;k<tomatoWareHouse[i][j].length;k++){
                    if(tomatoWareHouse[i][j][k]==0) return true;
                }
            }
        }
        return false;
    }

    private static int findShortestTime(int[][][] tomatoWareHose){
        int result = 0;
        while(!queue.isEmpty()){
            Tomato tomato = queue.poll();
            for(int i=0;i<6;i++){
                int nextH = tomato.h + dirH[i];
                int nextR = tomato.r + dirR[i];
                int nextC = tomato.c + dirC[i];
                if(isInRange(nextH, nextR, nextC, tomatoWareHose.length, tomatoWareHose[0].length, tomatoWareHose[0][0].length) && tomatoWareHose[nextH][nextR][nextC]==0){
                    tomatoWareHose[nextH][nextR][nextC] = 1;
                    queue.add(new Tomato(nextH,nextR,nextC,tomato.time+1));
                    result = tomato.time+1;
                }
            }
        }
        return result;
    }

    private static boolean isInRange(int nextH, int nextR, int nextC, int depth, int width, int height){
        if(nextH <0 || nextH >= depth) return false;
        if(nextR <0 || nextR >= width) return false;
        if(nextC <0 || nextC >= height) return false;
        return true;
    }

    static class Tomato{
        int r;
        int c;
        int h;
        int time;

        public Tomato(int h, int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.time = time;
        }
    }
}
