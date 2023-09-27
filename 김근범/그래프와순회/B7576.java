B7569package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {

    static Queue<Tomato> queue = new LinkedList<>();
    static int[] dirR = {-1, 0, 0, 1};
    static int[] dirC = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] tomatoWareHouse = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                tomatoWareHouse[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoWareHouse[i][j]==1) queue.add(new Tomato(i, j, 0));
            }
        }
        int result = simulateShortestCase(tomatoWareHouse);
        if(hasZero(tomatoWareHouse)) System.out.println(-1);
        else System.out.println(result);
    }

    private static boolean hasZero(int[][] tomatoWareHouse) {
        for(int i=0;i<tomatoWareHouse.length;i++){
            for(int j=0;j<tomatoWareHouse[i].length;j++){
                if(tomatoWareHouse[i][j]==0) return true;
            }
        }
        return false;
    }

    private static boolean isInRange(int nextR, int nextC, int width, int height){
        if(nextR<0 || nextR >= width) return  false;
        if(nextC<0 || nextC >= height) return false;
        return true;
    }

    private static int simulateShortestCase(int[][] tomatoWareHose){
        int result = 0;
        while(!queue.isEmpty()){
            Tomato tomato = queue.poll();
            for(int i=0;i<4;i++){
                int nextR = tomato.r + dirR[i];
                int nextC = tomato.c + dirC[i];
                if(isInRange(nextR, nextC, tomatoWareHose.length, tomatoWareHose[0].length) && tomatoWareHose[nextR][nextC]==0){
                    tomatoWareHose[nextR][nextC] = 1;
                    queue.add(new Tomato(nextR, nextC, tomato.time+1));
                    result = tomato.time+1;
                }
            }
        }
        return result;
    }

    static class Tomato{
        int r;
        int c;
        int time;

        public Tomato(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}
