import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static int row;
    static int col;
    static int[][] box;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sc = new StringTokenizer(br.readLine());
        col = Integer.parseInt(sc.nextToken());
        row = Integer.parseInt(sc.nextToken());
        box = new int[row][col];

        for(int i = 0 ; i < row; i++){
            sc = new StringTokenizer(br.readLine());
            for (int j = 0 ; j  < col; j++){
                box[i][j] = Integer.parseInt(sc.nextToken());
                if(box[i][j] == 1){
                    int[] tmp = {i,j};
                    queue.offer(tmp);
                }
            }
        }

        int day = DFS();

        if (checkAllRipe())
            System.out.println(day);
        else
            System.out.println(-1);

    }

    //0이 남아있다! => BFS를 다 돌았는데도 0이 있다 -> 불가능하다
    private static boolean checkAllRipe() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int DFS() {
        int cnt = -1;
        while (!queue.isEmpty()) {
            int  curSize = queue.size();
            for(int j = 0 ; j < curSize; j++){
                int[] coordinate = queue.poll();
                int x = coordinate[0];
                int y = coordinate[1];

                //좌표 이동
                for(int i = 0 ; i < 4; i++){
                    int moveX = x + dx[i];
                    int moveY = y + dy[i];

                    if(moveX >= 0 && moveX < row && moveY >= 0 && moveY < col && box[moveX][moveY] == 0){
                        box[moveX][moveY] = 1;

                        int[] tmp = {moveX,moveY};
                        queue.offer(tmp);
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}
