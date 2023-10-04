import java.io.*;
import java.util.*;

public class Main {
    static int[][] img;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        img = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();

            for(int j = 0; j < N; j++) {
                img[i][j] = str.charAt(j) - '0';
            }
        }

        QuadTree(0,0,N);
    }

    public static void  QuadTree(int x, int y, int len){
        //4분할 + 한 개로만 이루어져있는가
        //일단 처음부터 끝까지가 하나로만 이루어져있는가를 체크..
        //그 다음에 아닌 걸 안다면? => 4분할 반복문?..
        //종료 조건은 처음부터 끝까지 하나로 이루어져있는가?!

        // 압축이 가능할 경우 하나의 색상으로 압축해준다.
        if(isPossible(x, y, len)) {
            System.out.print(img[x][y]);
            return;
        }

        System.out.print('(');

        QuadTree(x,y,len/2);
        QuadTree(x,y+len/2,len/2);
        QuadTree(x+len/2, y, len/2);
        QuadTree(x+len/2,y+len/2,len/2);

        System.out.print(')');
    }

    public static boolean isPossible(int x, int y, int size) {
        int value = img[x][y];

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(value != img[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
