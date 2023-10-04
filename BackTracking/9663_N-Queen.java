import java.io.*;
import java.util.*;
import static java.lang.System.exit;

/*
 * 서로 공격할 수 없는 N퀸
 * 2차원 배열로 진행하지 않고 1차원 배열 형태로 진행한다!
 *
 * 반복
 * 1.종료조건인지 파악한다(depth)
 * 2.현재 열에서 봤을 때 놓을 수 있는 지!
 * 2.이 전 대각선에 비해서 놓을 수 있는 지?
 *
 * */
public class Main {
    static int cnt = 0;
    static int N;
    static int[]board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        DFS(0);
        System.out.print(cnt);
    }

    private static void DFS(int depth) {
        if(depth == N) {
            cnt++;
            return;
        }

        //가능한 지 탐색
        for(int i = 0; i < N; i++){
            board[depth] = i;

            //이 전 것들을 모두 고려해서 놓을 수 있는 위치를 찾자!
            if(isPossible(depth)){
                DFS(depth+1);
            }
        }
    }

    private static boolean isPossible(int col) {
        //지금까지 둔 N퀸의 위치를 생각해서 놓을 수 있는 위치를 찾자!
        for(int i = 0 ; i < col; i++){
            //가로 세로가 가능한 위치인지?
            if(board[i] == board[col]){
                return false;
            }
            //대각선에 해당하는 위치인지?
            else if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }

        return true;
    }
}
