import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sc = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(sc.nextToken());
        int a2 = Integer.parseInt(sc.nextToken());
        int[][] A = new int[a1][a2];
        for(int i = 0 ; i < a1; i++){
            sc = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < a2; j++){
                A[i][j] = Integer.parseInt(sc.nextToken());
            }
        }

        sc = new StringTokenizer(br.readLine());
        int b1 = Integer.parseInt(sc.nextToken());
        int b2 = Integer.parseInt(sc.nextToken());
        int[][] B = new int[b1][b2];
        for(int i = 0 ; i < b1; i++){
            sc = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < b2; j++){
                B[i][j] = Integer.parseInt(sc.nextToken());
            }
        }

        int[][] NEW = new int[a1][b2];

        for(int i = 0 ; i < a1; i++){//행
            for(int j = 0 ; j < b2; j++){//열
                for(int k = 0 ; k < a2; k++){
                    NEW[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for(int i = 0 ; i < a1; i++){
            for(int j = 0 ; j < b2; j++){
                System.out.print(NEW[i][j] + " ");
            }
            System.out.println();
        }
    }
}
