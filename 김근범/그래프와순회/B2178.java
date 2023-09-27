package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class B2178 {

    static boolean[][] visited;

    static int[] dirR = {-1, 0, 0, 1};
    static int[] dirC = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<input.length();j++){
                visited[i][j] = input.charAt(j) == '0';
            }
        }
        System.out.println(findPath(N, M));
    }

    private static int findPath(int N , int M) {
        int result = 0;
        visited[0][0] = true;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0,0,1));
        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(point.r==N-1 && point.c == M-1) {
                result = point.level;
                break;
            }
            for(int i=0;i<4;i++){
                int nextR = point.r + dirR[i];
                int nextC = point.c + dirC[i];
                if(isInRange(nextR,nextC,N,M) && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.add(new Point(nextR,nextC, point.level+1));
                }
            }
        }
        return result;
    }

    private static boolean isInRange(int nextR, int nextC, int N, int M) {
        if(nextR <0 || nextR>=N) return false;
        if(nextC <0 || nextC>=M) return false;
        return true;
    }

    static class Point{
        int r;
        int c;
        int level;

        public Point(int r, int c, int level){
            this.r = r;
            this.c = c;
            this.level = level;
        }
    }
}