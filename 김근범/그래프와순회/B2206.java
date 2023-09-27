package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206 {

    static Queue<PlayStatus> queue = new LinkedList<>();
    static int[] dirR = {-1, 0, 0, 1};
    static int[] dirC = {0, -1, 1, 0};

    static boolean[][] visited;
    static boolean[][] visitedBreakWall;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] miro = new boolean[N][M];
        visited = new boolean[N][M];
        visitedBreakWall = new boolean[N][M];
        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                miro[i][j] = line.charAt(j)=='1';
            }
        }
        int result = findShortestPath(miro);
        System.out.println(result);
    }

    private static int findShortestPath(boolean[][] miro){
        int result = -1;
        visited[0][0] = true;
        visitedBreakWall[0][0] = true;
        queue.add(new PlayStatus(0, 0, 1, false));
        while(!queue.isEmpty()){
            PlayStatus status = queue.poll();
            if(status.r == miro.length-1 && status.c == miro[0].length-1){
                result = status.time;
                break;
            }
            for(int i=0;i<4;i++){
                int nextR = status.r + dirR[i];
                int nextC = status.c + dirC[i];
                if(isInRange(nextR, nextC, miro.length, miro[0].length) && !visited[nextR][nextC]){
                    if(status.breakWall) {
                        if(!visitedBreakWall[nextR][nextC] && !miro[nextR][nextC]) {
                            visitedBreakWall[nextR][nextC] = true;
                            queue.add(new PlayStatus(nextR, nextC, status.time+1, true));
                        }
                    } else {
                        visited[nextR][nextC] = true;
                        visitedBreakWall[nextR][nextC] = true;
                        if(!miro[nextR][nextC]) {
                            queue.add(new PlayStatus(nextR, nextC, status.time+1, false));
                        } else {
                            queue.add(new PlayStatus(nextR, nextC, status.time+1, true));
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isInRange(int nextR, int nextC, int width, int height){
        if(nextR < 0 || nextR >= width) return false;
        if(nextC < 0 || nextC >= height) return false;
        return true;
    }

    static class PlayStatus{
        int r;
        int c;
        int time;
        boolean breakWall;
        public PlayStatus(int r, int c, int time, boolean breakWall){
            this.r = r;
            this.c = c;
            this.time = time;
            this.breakWall = breakWall;
        }
    }
}
